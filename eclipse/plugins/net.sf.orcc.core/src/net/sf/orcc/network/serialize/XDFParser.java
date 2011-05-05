/*
 * Copyright (c) 2009, IETR/INSA of Rennes
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 *   * Redistributions of source code must retain the above copyright notice,
 *     this list of conditions and the following disclaimer.
 *   * Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *   * Neither the name of the IETR/INSA of Rennes nor the names of its
 *     contributors may be used to endorse or promote products derived from this
 *     software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY
 * WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 */
package net.sf.orcc.network.serialize;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.orcc.OrccException;
import net.sf.orcc.ir.Expression;
import net.sf.orcc.ir.IrFactory;
import net.sf.orcc.ir.OpBinary;
import net.sf.orcc.ir.OpUnary;
import net.sf.orcc.ir.Port;
import net.sf.orcc.ir.Type;
import net.sf.orcc.ir.TypeBool;
import net.sf.orcc.ir.TypeInt;
import net.sf.orcc.ir.TypeList;
import net.sf.orcc.ir.TypeString;
import net.sf.orcc.ir.TypeUint;
import net.sf.orcc.ir.Var;
import net.sf.orcc.ir.util.Entry;
import net.sf.orcc.ir.util.ExpressionEvaluator;
import net.sf.orcc.network.Connection;
import net.sf.orcc.network.Instance;
import net.sf.orcc.network.Network;
import net.sf.orcc.network.Vertex;
import net.sf.orcc.network.attributes.CustomAttribute;
import net.sf.orcc.network.attributes.FlagAttribute;
import net.sf.orcc.network.attributes.IAttribute;
import net.sf.orcc.network.attributes.ICustomAttribute;
import net.sf.orcc.network.attributes.IFlagAttribute;
import net.sf.orcc.network.attributes.IStringAttribute;
import net.sf.orcc.network.attributes.ITypeAttribute;
import net.sf.orcc.network.attributes.IValueAttribute;
import net.sf.orcc.network.attributes.StringAttribute;
import net.sf.orcc.network.attributes.TypeAttribute;
import net.sf.orcc.network.attributes.ValueAttribute;
import net.sf.orcc.util.BinOpSeqParser;
import net.sf.orcc.util.DomUtil;
import net.sf.orcc.util.OrccUtil;
import net.sf.orcc.util.OrderedMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * This class defines an XDF network parser.
 * 
 * @author Matthieu Wipliez
 * 
 */
public class XDFParser {

	/**
	 * This class defines a parser of XDF expressions.
	 * 
	 * @author Matthieu Wipliez
	 * 
	 */
	private class ExprParser {

		/**
		 * Parses the given node as an expression and returns the matching
		 * Expression expression.
		 * 
		 * @param node
		 *            a node whose expected to be, or whose sibling is expected
		 *            to be, a DOM element named "Expr".
		 * @return an expression
		 * @throws OrccException
		 *             if the given node or its siblings could not be parsed as
		 *             an expression
		 */
		public Expression parseExpr(Node node) throws OrccException {
			ParseContinuation<Expression> cont = parseExprCont(node);
			Expression expr = cont.getResult();
			if (expr == null) {
				throw new OrccException("Expected an Expr element");
			} else {
				return expr;
			}
		}

		/**
		 * Parses the given node as a binary operator and returns a parse
		 * continuation with the operator parsed.
		 * 
		 * @param node
		 *            a node that is expected, or whose sibling is expected, to
		 *            be a DOM element named "Op".
		 * @return a parse continuation with the operator parsed
		 * @throws OrccException
		 *             if the binary operator could not be parsed
		 */
		private ParseContinuation<OpBinary> parseExprBinaryOp(Node node)
				throws OrccException {
			while (node != null) {
				if (node.getNodeName().equals("Op")) {
					Element op = (Element) node;
					String name = op.getAttribute("name");
					return new ParseContinuation<OpBinary>(node,
							OpBinary.getOperator(name));
				}

				node = node.getNextSibling();
			}

			return new ParseContinuation<OpBinary>(node, null);
		}

		/**
		 * Parses the given node and its siblings as a sequence of binary
		 * operations, aka "BinOpSeq". A BinOpSeq is a sequence of expr, op,
		 * expr, op, expr...
		 * 
		 * @param node
		 *            the first child node of a Expr kind="BinOpSeq" element
		 * @return a parse continuation with a BinaryExpr
		 * @throws OrccException
		 *             if something goes wrong
		 */
		private ParseContinuation<Expression> parseExprBinOpSeq(Node node)
				throws OrccException {
			List<Expression> expressions = new ArrayList<Expression>();
			List<OpBinary> operators = new ArrayList<OpBinary>();

			ParseContinuation<Expression> contE = parseExprCont(node);
			expressions.add(contE.getResult());
			node = contE.getNode();
			while (node != null) {
				ParseContinuation<OpBinary> contO = parseExprBinaryOp(node);
				OpBinary op = contO.getResult();
				node = contO.getNode();
				if (op != null) {
					operators.add(op);

					contE = parseExprCont(node);
					Expression expr = contE.getResult();
					if (expr == null) {
						throw new OrccException("Expected an Expr element");
					}

					expressions.add(expr);
					node = contE.getNode();
				}
			}

			Expression expr = BinOpSeqParser.parse(expressions, operators);
			return new ParseContinuation<Expression>(node, expr);
		}

		/**
		 * Parses the given node as an expression and returns the matching
		 * Expression expression.
		 * 
		 * @param node
		 *            a node whose sibling is expected to be a DOM element named
		 *            "Expr".
		 * @return an expression
		 * @throws OrccException
		 *             if the given node or its siblings could not be parsed as
		 *             an expression
		 */
		private ParseContinuation<Expression> parseExprCont(Node node)
				throws OrccException {
			Expression expr = null;
			while (node != null) {
				if (node.getNodeName().equals("Expr")) {
					Element elt = (Element) node;
					String kind = elt.getAttribute("kind");
					if (kind.equals("BinOpSeq")) {
						return parseExprBinOpSeq(elt.getFirstChild());
					} else if (kind.equals("Literal")) {
						expr = parseExprLiteral(elt);
						break;
					} else if (kind.equals("List")) {
						List<Expression> exprs = parseExprs(node
								.getFirstChild());
						expr = IrFactory.eINSTANCE.createExprList(exprs);
						break;
					} else if (kind.equals("UnaryOp")) {
						ParseContinuation<OpUnary> cont = parseExprUnaryOp(node
								.getFirstChild());
						OpUnary op = cont.getResult();
						Expression unaryExpr = parseExpr(cont.getNode());
						expr = IrFactory.eINSTANCE.createExprUnary(op,
								unaryExpr, null);
						break;
					} else if (kind.equals("Var")) {
						String name = elt.getAttribute("name");
						// look up variable, in variables scope, and if not
						// found in parameters scope
						Var var = network.getVariables().get(name);
						if (var == null) {
							throw new OrccException("In network \""
									+ network.getName() + "\" defined in \""
									+ file + "\": unknown variable: \"" + name
									+ "\"");
						}
						expr = IrFactory.eINSTANCE.createExprVar(var);
						break;
					} else {
						throw new OrccException("In network \""
								+ network.getName() + "\" defined in \"" + file
								+ "\": Unsupported Expr kind: \"" + kind + "\"");
					}
				}

				node = node.getNextSibling();
			}

			return new ParseContinuation<Expression>(node, expr);
		}

		/**
		 * Parses the given "Expr" element as a literal and returns the matching
		 * Expression expression.
		 * 
		 * @param elt
		 *            a DOM element named "Expr"
		 * @return an expression
		 * @throws OrccException
		 *             if the literal could not be parsed
		 */
		private Expression parseExprLiteral(Element elt) throws OrccException {
			String kind = elt.getAttribute("literal-kind");
			String value = elt.getAttribute("value");
			if (kind.equals("Boolean")) {
				return IrFactory.eINSTANCE.createExprBool(Boolean
						.parseBoolean(value));
			} else if (kind.equals("Character")) {
				throw new OrccException("Characters not supported yet");
			} else if (kind.equals("Integer")) {
				return IrFactory.eINSTANCE.createExprInt(Long.parseLong(value));
			} else if (kind.equals("Real")) {
				return IrFactory.eINSTANCE.createExprFloat(Float
						.parseFloat(value));
			} else if (kind.equals("String")) {
				return IrFactory.eINSTANCE.createExprString(value);
			} else {
				throw new OrccException("Unsupported Expr "
						+ "literal kind: \"" + kind + "\"");
			}
		}

		private List<Expression> parseExprs(Node node) throws OrccException {
			List<Expression> exprs = new ArrayList<Expression>();
			while (node != null) {
				if (node.getNodeName().equals("Expr")) {
					exprs.add(parseExpr(node));
				}

				node = node.getNextSibling();
			}

			return exprs;
		}

		/**
		 * Parses the given node as a unary operator and returns a parse
		 * continuation with the operator parsed.
		 * 
		 * @param node
		 *            a node that is expected, or whose sibling is expected, to
		 *            be a DOM element named "Op".
		 * @return a parse continuation with the operator parsed
		 * @throws OrccException
		 *             if the unary operator could not be parsed
		 */
		private ParseContinuation<OpUnary> parseExprUnaryOp(Node node)
				throws OrccException {
			while (node != null) {
				if (node.getNodeName().equals("Op")) {
					Element op = (Element) node;
					String name = op.getAttribute("name");
					return new ParseContinuation<OpUnary>(node,
							OpUnary.getOperator(name));
				}

				node = node.getNextSibling();
			}

			throw new OrccException("Expected an Op element");
		}

	}

	/**
	 * This class defines a parser of XDF types.
	 * 
	 * @author Matthieu Wipliez
	 * 
	 */
	public class TypeParser {

		/**
		 * Default size of an signed/unsigned integer.
		 */
		private static final int defaultSize = 32;

		/**
		 * Parses the given node as an Type.
		 * 
		 * @param node
		 *            the node to parse as a type.
		 * @return a type
		 * @throws OrccException
		 *             if the node could not be parsed as a type
		 */
		public ParseContinuation<Type> parseType(Node node)
				throws OrccException {
			while (node != null) {
				if (node.getNodeName().equals("Type")) {
					Element eltType = (Element) node;
					String name = eltType.getAttribute("name");
					if (name.equals(TypeBool.NAME)) {
						return new ParseContinuation<Type>(node,
								IrFactory.eINSTANCE.createTypeBool());
					} else if (name.equals(TypeInt.NAME)) {
						Map<String, Entry> entries = parseTypeEntries(node
								.getFirstChild());
						Expression expr = parseTypeSize(entries);
						int size = new ExpressionEvaluator()
								.evaluateAsInteger(expr);
						return new ParseContinuation<Type>(node,
								IrFactory.eINSTANCE.createTypeInt(size));
					} else if (name.equals(TypeList.NAME)) {
						return new ParseContinuation<Type>(node,
								parseTypeList(node));
					} else if (name.equals(TypeString.NAME)) {
						return new ParseContinuation<Type>(node,
								IrFactory.eINSTANCE.createTypeString());
					} else if (name.equals(TypeUint.NAME)) {
						Map<String, Entry> entries = parseTypeEntries(node
								.getFirstChild());
						Expression expr = parseTypeSize(entries);
						int size = new ExpressionEvaluator()
								.evaluateAsInteger(expr);

						TypeUint type = IrFactory.eINSTANCE.createTypeUint();
						type.setSize(size);
						return new ParseContinuation<Type>(node, type);
					} else {
						throw new OrccException("unknown type name: \"" + name
								+ "\"");
					}
				}

				node = node.getNextSibling();
			}

			throw new OrccException("Expected a Type element");
		}

		/**
		 * Parses the node and its siblings as type entries, and returns a map
		 * of entry names to contents.
		 * 
		 * @param node
		 *            The first node susceptible to be an entry, or
		 *            <code>null</code>.
		 * @return A map of entry names to contents.
		 * @throws OrccException
		 *             if something goes wrong
		 */
		private Map<String, Entry> parseTypeEntries(Node node)
				throws OrccException {
			Map<String, Entry> entries = new HashMap<String, Entry>();
			while (node != null) {
				if (node.getNodeName().equals("Entry")) {
					Element element = (Element) node;
					String name = element.getAttribute("name");
					String kind = element.getAttribute("kind");

					Entry entry = null;
					if (kind.equals("Expr")) {
						Expression expr = exprParser.parseExpr(node
								.getFirstChild());
						entry = new Entry(expr);
					} else if (kind.equals("Type")) {
						entry = new Entry(parseType(node.getFirstChild())
								.getResult());
					} else {
						throw new OrccException("unsupported entry type: \""
								+ kind + "\"");
					}

					entries.put(name, entry);
				}

				node = node.getNextSibling();
			}

			return entries;
		}

		/**
		 * Parses a List type.
		 * 
		 * @param node
		 *            the Type node where this List is defined
		 * @return a ListType
		 * @throws OrccException
		 *             if something is wrong, like a missing entry
		 */
		private Type parseTypeList(Node node) throws OrccException {
			Map<String, Entry> entries = parseTypeEntries(node.getFirstChild());
			Entry entry = entries.get("size");
			if (entry == null) {
				throw new OrccException("List type must have a \"size\" entry");
			}
			Expression expr = entry.getEntryAsExpr();

			entry = entries.get("type");
			if (entry == null) {
				throw new OrccException("List type must have a \"type\" entry");
			}
			Type type = entry.getEntryAsType();

			int size = new ExpressionEvaluator().evaluateAsInteger(expr);
			return IrFactory.eINSTANCE.createTypeList(size, type);
		}

		/**
		 * Gets a "size" entry from the given entry map, if found return its
		 * value, otherwise return {@link #defaultSize}.
		 * 
		 * @param entries
		 *            a map of entries
		 * @return an expression
		 * @throws OrccException
		 *             if the "size" entry does not contain an expression
		 */
		private Expression parseTypeSize(Map<String, Entry> entries)
				throws OrccException {
			Entry entry = entries.get("size");
			if (entry == null) {
				return IrFactory.eINSTANCE.createExprInt(defaultSize);
			} else {
				return entry.getEntryAsExpr();
			}
		}

	}

	/**
	 * XDF expression parser.
	 */
	private final ExprParser exprParser;

	/**
	 * absolute file name of the XDF file
	 */
	private final IFile file;

	private Map<String, Instance> instances;

	private Network network;

	private Instance parent;

	/**
	 * XDF type parser.
	 */
	private final TypeParser typeParser;

	/**
	 * Creates a new network parser.
	 * 
	 * @param fileName
	 *            absolute file name of an XDF file
	 */
	public XDFParser(IFile file) {
		this.file = file;
		exprParser = new ExprParser();
		typeParser = new TypeParser();
	}

	/**
	 * 
	 * @param fileName
	 * @param parent
	 */
	private XDFParser(IFile file, Instance parent) {
		this(file);
		this.parent = parent;
	}

	/**
	 * If vertexName is not empty, returns a new Port whose name is set to
	 * portName.
	 * 
	 * @param vertexName
	 *            the name of a vertex
	 * @param portName
	 *            the name of a port
	 * @return a port, or <code>null</code> if no port should be returned
	 */
	private Port getPort(String vertexName, String portName) {
		if (vertexName.isEmpty()) {
			return null;
		} else {
			return IrFactory.eINSTANCE.createPort(null, portName);
		}
	}

	/**
	 * If vertexName is empty, returns a new Vertex that contains a port from
	 * the ports map that has the name portName. If vertexName is not empty,
	 * returns a new Vertex that contains an instance from the instances map.
	 * 
	 * @param vertexName
	 *            the name of a vertex
	 * @param portName
	 *            the name of a port
	 * @param ports
	 *            a map of input ports "exclusive or" output ports
	 * @return a vertex that contains a port or an instance
	 */
	private Vertex getVertex(String vertexName, String portName, String kind,
			OrderedMap<String, Port> ports) throws OrccException {
		if (vertexName.isEmpty()) {
			Port port = ports.get(portName);
			if (port == null) {
				throw new OrccException("An Connection element has an invalid"
						+ " \"src-port\" " + "attribute");
			}

			return new Vertex(kind, port);
		} else {
			Instance instance = instances.get(vertexName);
			if (instance == null) {
				throw new OrccException("An Connection element has an invalid"
						+ " \"src-port\" " + "attribute");
			}

			return new Vertex(instance);
		}
	}

	/**
	 * Returns a map of attribute names -> values by parsing the "Attribute"
	 * nodes.
	 * 
	 * @param node
	 *            the first node of a node list, or <code>null</code> if the
	 *            caller had no children.
	 * @return a (possibly empty) map of attributes
	 * @throws OrccException
	 *             if an attribute could not be parsed
	 */
	private Map<String, IAttribute> parseAttributes(Node node)
			throws OrccException {
		Map<String, IAttribute> attributes = new HashMap<String, IAttribute>();

		while (node != null) {
			// only parses Attribute nodes, other nodes are ignored.
			if (node.getNodeName().equals("Attribute")) {
				Element attribute = (Element) node;
				String kind = attribute.getAttribute("kind");
				String attrName = attribute.getAttribute("name");

				IAttribute attr;
				if (kind.equals(ICustomAttribute.NAME)) {
					attr = new CustomAttribute(attribute.getChildNodes());
				} else if (kind.equals(IFlagAttribute.NAME)) {
					attr = new FlagAttribute();
				} else if (kind.equals(IStringAttribute.NAME)) {
					String value = attribute.getAttribute("value");
					attr = new StringAttribute(value);
				} else if (kind.equals(ITypeAttribute.NAME)) {
					Type type = typeParser.parseType(attribute.getFirstChild())
							.getResult();
					attr = new TypeAttribute(type);
				} else if (kind.equals(IValueAttribute.NAME)) {
					Expression expr = exprParser
							.parseExpr(node.getFirstChild());
					attr = new ValueAttribute(expr);
				} else {
					throw new OrccException("unsupported attribute kind: \""
							+ kind + "\"");
				}

				attributes.put(attrName, attr);
			}

			node = node.getNextSibling();
		}

		return attributes;
	}

	/**
	 * Parses the body of the XDF document. The body can contain any element
	 * among the supported elements. Supported elements are: Connection, Decl
	 * (kind=Param or kind=Var), Instance, Package, Port.
	 * 
	 * @param root
	 * @throws OrccException
	 */
	private void parseBody(Element root) throws OrccException {
		Node node = root.getFirstChild();
		while (node != null) {
			// this test allows us to skip #text nodes
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				String name = node.getNodeName();
				if (name.equals("Connection")) {
					parseConnection(element);
				} else if (name.equals("Decl")) {
					parseDecl(element);
				} else if (name.equals("Instance")) {
					Instance instance = parseInstance(element);
					instances.put(instance.getId(), instance);
					network.getGraph().addVertex(new Vertex(instance));
				} else if (name.equals("Package")) {
					throw new OrccException(
							"Package elements are not supported by Orcc yet");
				} else if (name.equals("Port")) {
					parsePort(element);
				} else {
					throw new OrccException("invalid node \"" + name + "\"");
				}
			}

			node = node.getNextSibling();
		}
	}

	/**
	 * Parses the given DOM element as a connection, and adds a matching
	 * Connection to the graph of the network being parsed.
	 * 
	 * @param connection
	 *            a DOM element named "Connection"
	 * @throws OrccException
	 */
	private void parseConnection(Element connection) throws OrccException {
		String src = connection.getAttribute("src");
		String src_port = connection.getAttribute("src-port");
		String dst = connection.getAttribute("dst");
		String dst_port = connection.getAttribute("dst-port");

		Vertex source = getVertex(src, src_port, "Input", network.getInputs());
		Port srcPort = getPort(src, src_port);
		Vertex target = getVertex(dst, dst_port, "Output", network.getOutputs());
		Port dstPort = getPort(dst, dst_port);

		Node child = connection.getFirstChild();
		Map<String, IAttribute> attributes = parseAttributes(child);
		Connection conn = new Connection(srcPort, dstPort, attributes);
		network.getGraph().addEdge(source, target, conn);
	}

	private void parseDecl(Element decl) throws OrccException {
		String kind = decl.getAttribute("kind");
		String name = decl.getAttribute("name");
		if (name.isEmpty()) {
			throw new OrccException("Decl has an empty name");
		}

		if (kind.equals("Param")) {
			ParseContinuation<Type> cont = typeParser.parseType(decl
					.getFirstChild());
			Type type = cont.getResult();
			Var var = IrFactory.eINSTANCE.createVar(0, type, name, true, false);
			network.getParameters().put(name, var);
		} else if (kind.equals("Variable")) {
			ParseContinuation<Type> cont = typeParser.parseType(decl
					.getFirstChild());
			Type type = cont.getResult();
			Expression expr = exprParser.parseExpr(cont.getNode());
			Var var = IrFactory.eINSTANCE.createVar(0, type, name, false, expr);
			network.getVariables().put(name, var);
		} else {
			throw new OrccException("unsupported Decl kind: \"" + kind + "\"");
		}
	}

	/**
	 * Parses an "Instance" element and returns an {@link Instance}.
	 * 
	 * @param instance
	 *            a DOM element named "Instance".
	 * @return an instance
	 * @throws OrccException
	 *             if the instance is not well-formed
	 */
	private Instance parseInstance(Element instance) throws OrccException {
		// instance id
		String id = instance.getAttribute("id");
		if (id.isEmpty()) {
			throw new OrccException("An Instance element "
					+ "must have a valid \"id\" attribute");
		}

		// instance class
		String clasz = null;
		Node child = instance.getFirstChild();
		while (child != null) {
			if (child.getNodeName().equals("Class")) {
				clasz = ((Element) child).getAttribute("name");
				break;
			} else {
				child = child.getNextSibling();
			}
		}

		if (clasz == null || clasz.isEmpty()) {
			throw new OrccException("An Instance element "
					+ "must have a valid \"Class\" child.");
		}

		// instance parameters and attributes
		Map<String, Expression> parameters = parseParameters(child);
		Map<String, IAttribute> attributes = parseAttributes(child);

		// create instance
		Instance newInst = new Instance(id, clasz);
		if (parent == null) {
			Instance parentInst = new Instance(network.getName(),
					network.getName());
			parentInst.setContents(network);
			newInst.setParent(parentInst);
		} else {
			newInst.setParent(parent);
		}
		newInst.getAttributes().putAll(attributes);
		newInst.getParameters().putAll(parameters);

		// try to find network with the given name
		IProject project = file.getProject();
		IFile networkFile = OrccUtil.getNetwork(project, clasz);

		// if found, parse and set contents
		if (networkFile != null) {
			XDFParser parser = new XDFParser(networkFile, newInst);
			Network network = parser.parseNetwork();
			newInst.setContents(network);
		}

		return newInst;
	}

	/**
	 * Parses the file given to the constructor of this class.
	 * 
	 * @return a network
	 * @throws OrccException
	 *             if the file could not be parsed
	 */
	public Network parseNetwork() throws OrccException {
		InputStream is;

		try {
			is = file.getContents();
		} catch (CoreException e) {
			throw new OrccException("I/O error when parsing network", e);
		}

		try {
			// input
			Document document = DomUtil.parseDocument(is);

			// parse the input, return the network
			parseXDF(document);
			return network;
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				throw new OrccException("I/O error when parsing network", e);
			}
		}
	}

	private Map<String, Expression> parseParameters(Node node)
			throws OrccException {
		Map<String, Expression> parameters = new HashMap<String, Expression>();
		while (node != null) {
			if (node.getNodeName().equals("Parameter")) {
				String name = ((Element) node).getAttribute("name");
				if (name.isEmpty()) {
					throw new OrccException("A Parameter element "
							+ "must have a valid \"name\" attribute");
				}

				Expression expr = exprParser.parseExpr(node.getFirstChild());
				parameters.put(name, expr);
			}

			node = node.getNextSibling();
		}

		return parameters;
	}

	/**
	 * Parses a port, and adds it to {@link #inputs} or {@link #outputs},
	 * depending on the port's kind attribute.
	 * 
	 * @param eltPort
	 *            a DOM element named "Port"
	 * @throws OrccException
	 */
	private void parsePort(Element eltPort) throws OrccException {
		Type type = typeParser.parseType(eltPort.getFirstChild()).getResult();
		String name = eltPort.getAttribute("name");
		if (name.isEmpty()) {
			throw new OrccException("Port has an empty name");
		}

		// creates a port
		Port port = IrFactory.eINSTANCE.createPort(type, name);

		// adds the port to inputs or outputs depending on its kind
		String kind = eltPort.getAttribute("kind");
		if (kind.equals("Input")) {
			network.getInputs().put(name, port);
		} else if (kind.equals("Output")) {
			network.getOutputs().put(name, port);
		} else {
			throw new OrccException("Port \"" + name + "\", invalid kind: \""
					+ kind + "\"");
		}

		network.getGraph().addVertex(new Vertex(kind, port));
	}

	/**
	 * Parses the given document as an XDF network.
	 * 
	 * @param doc
	 *            a DOM document that supposedly represent an XDF network
	 * @throws OrccException
	 *             if the DOM document is not a well-formed XDF network
	 */
	private void parseXDF(Document doc) throws OrccException {
		Element root = doc.getDocumentElement();
		if (!root.getNodeName().equals("XDF")) {
			throw new OrccException("Expected \"XDF\" start element");
		}

		String name = root.getAttribute("name");
		if (name.isEmpty()) {
			throw new OrccException("Expected a \"name\" attribute");
		}

		this.network = new Network(file.getFullPath().toString());
		instances = new HashMap<String, Instance>();
		network.setName(name);

		parseBody(root);

		if (network.getInstances().isEmpty()) {
			throw new OrccException(
					"A valid network must contain at least one instance");
		}
	}

}

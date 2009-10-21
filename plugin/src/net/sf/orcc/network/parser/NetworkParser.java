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
package net.sf.orcc.network.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.orcc.OrccException;
import net.sf.orcc.common.GlobalVariable;
import net.sf.orcc.common.Location;
import net.sf.orcc.common.Port;
import net.sf.orcc.common.Use;
import net.sf.orcc.common.Variable;
import net.sf.orcc.ir.expr.BinaryOp;
import net.sf.orcc.ir.expr.BooleanExpr;
import net.sf.orcc.ir.expr.IExpr;
import net.sf.orcc.ir.expr.IntExpr;
import net.sf.orcc.ir.expr.ListExpr;
import net.sf.orcc.ir.expr.StringExpr;
import net.sf.orcc.ir.expr.UnaryExpr;
import net.sf.orcc.ir.expr.UnaryOp;
import net.sf.orcc.ir.expr.VarExpr;
import net.sf.orcc.ir.type.BoolType;
import net.sf.orcc.ir.type.Entry;
import net.sf.orcc.ir.type.IType;
import net.sf.orcc.ir.type.IntType;
import net.sf.orcc.ir.type.ListType;
import net.sf.orcc.ir.type.StringType;
import net.sf.orcc.ir.type.UintType;
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
import net.sf.orcc.util.OrderedMap;
import net.sf.orcc.util.Scope;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DirectedMultigraph;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSParser;

/**
 * This class defines an XDF network parser.
 * 
 * @author Matthieu Wipliez
 * 
 */
public class NetworkParser {

	/**
	 * This class defines a parser of XDF expressions.
	 * 
	 * @author Matthieu Wipliez
	 * 
	 */
	private class ExprParser {

		/**
		 * Parses the given node as an expression and returns the matching IExpr
		 * expression.
		 * 
		 * @param node
		 *            a node whose expected to be, or whose sibling is expected
		 *            to be, a DOM element named "Expr".
		 * @return an expression
		 * @throws OrccException
		 *             if the given node or its siblings could not be parsed as
		 *             an expression
		 */
		public IExpr parseExpr(Node node) throws OrccException {
			ParseContinuation<IExpr> cont = parseExprCont(node);
			IExpr expr = cont.getResult();
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
		private ParseContinuation<BinaryOp> parseExprBinaryOp(Node node)
				throws OrccException {
			while (node != null) {
				if (node.getNodeName().equals("Op")) {
					Element op = (Element) node;
					String name = op.getAttribute("name");
					if (name.equals("and")) {
						return new ParseContinuation<BinaryOp>(node,
								BinaryOp.LAND);
					} else if (name.equals("/")) {
						return new ParseContinuation<BinaryOp>(node,
								BinaryOp.DIV);
					} else if (name.equals("div")) {
						return new ParseContinuation<BinaryOp>(node,
								BinaryOp.DIV_INT);
					} else if (name.equals("=")) {
						return new ParseContinuation<BinaryOp>(node,
								BinaryOp.EQ);
					} else if (name.equals("^")) {
						return new ParseContinuation<BinaryOp>(node,
								BinaryOp.EXP);
					} else if (name.equals(">=")) {
						return new ParseContinuation<BinaryOp>(node,
								BinaryOp.GE);
					} else if (name.equals(">")) {
						return new ParseContinuation<BinaryOp>(node,
								BinaryOp.GT);
					} else if (name.equals("<=")) {
						return new ParseContinuation<BinaryOp>(node,
								BinaryOp.LE);
					} else if (name.equals("<")) {
						return new ParseContinuation<BinaryOp>(node,
								BinaryOp.LT);
					} else if (name.equals("-")) {
						return new ParseContinuation<BinaryOp>(node,
								BinaryOp.MINUS);
					} else if (name.equals("mod")) {
						return new ParseContinuation<BinaryOp>(node,
								BinaryOp.MOD);
					} else if (name.equals("!=")) {
						return new ParseContinuation<BinaryOp>(node,
								BinaryOp.NE);
					} else if (name.equals("or")) {
						return new ParseContinuation<BinaryOp>(node,
								BinaryOp.LOR);
					} else if (name.equals("+")) {
						return new ParseContinuation<BinaryOp>(node,
								BinaryOp.PLUS);
					} else if (name.equals("*")) {
						return new ParseContinuation<BinaryOp>(node,
								BinaryOp.TIMES);
					} else {
						throw new OrccException("Unknown binary operator \""
								+ name + "\"");
					}
				}

				node = node.getNextSibling();
			}

			return new ParseContinuation<BinaryOp>(node, null);
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
		private ParseContinuation<IExpr> parseExprBinOpSeq(Node node)
				throws OrccException {
			List<IExpr> expressions = new ArrayList<IExpr>();
			List<BinaryOp> operators = new ArrayList<BinaryOp>();

			ParseContinuation<IExpr> contE = parseExprCont(node);
			expressions.add(contE.getResult());
			node = contE.getNode();
			while (node != null) {
				ParseContinuation<BinaryOp> contO = parseExprBinaryOp(node);
				BinaryOp op = contO.getResult();
				node = contO.getNode();
				if (op != null) {
					operators.add(op);

					contE = parseExprCont(node);
					IExpr expr = contE.getResult();
					if (expr == null) {
						throw new OrccException("Expected an Expr element");
					}

					expressions.add(expr);
					node = contE.getNode();
				}
			}

			IExpr expr = BinOpSeqParser.parse(expressions, operators);
			return new ParseContinuation<IExpr>(node, expr);
		}

		/**
		 * Parses the given node as an expression and returns the matching IExpr
		 * expression.
		 * 
		 * @param node
		 *            a node whose sibling is expected to be a DOM element named
		 *            "Expr".
		 * @return an expression
		 * @throws OrccException
		 *             if the given node or its siblings could not be parsed as
		 *             an expression
		 */
		private ParseContinuation<IExpr> parseExprCont(Node node)
				throws OrccException {
			IExpr expr = null;
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
						List<IExpr> exprs = parseExprs(node.getFirstChild());
						expr = new ListExpr(new Location(), exprs);
						break;
					} else if (kind.equals("UnaryOp")) {
						ParseContinuation<UnaryOp> cont = parseExprUnaryOp(node
								.getFirstChild());
						UnaryOp op = cont.getResult();
						IExpr unaryExpr = parseExpr(cont.getNode());
						expr = new UnaryExpr(new Location(), op, unaryExpr,
								null);
						break;
					} else if (kind.equals("Var")) {
						String name = elt.getAttribute("name");
						// look up variable, in variables scope, and if not
						// found in parameters scope
						Variable variable = variables.get(name);
						Use use = new Use(variable);
						expr = new VarExpr(new Location(), use);
						break;
					} else {
						throw new OrccException("Unsupported Expr kind: \""
								+ kind + "\"");
					}
				}

				node = node.getNextSibling();
			}

			return new ParseContinuation<IExpr>(node, expr);
		}

		/**
		 * Parses the given "Expr" element as a literal and returns the matching
		 * IExpr expression.
		 * 
		 * @param elt
		 *            a DOM element named "Expr"
		 * @return an expression
		 * @throws OrccException
		 *             if the literal could not be parsed
		 */
		private IExpr parseExprLiteral(Element elt) throws OrccException {
			String kind = elt.getAttribute("literal-kind");
			String value = elt.getAttribute("value");
			if (kind.equals("Boolean")) {
				return new BooleanExpr(new Location(), Boolean
						.parseBoolean(value));
			} else if (kind.equals("Character")) {
				throw new OrccException("Characters not supported yet");
			} else if (kind.equals("Integer")) {
				return new IntExpr(new Location(), Integer.parseInt(value));
			} else if (kind.equals("Real")) {
				throw new OrccException("Reals not supported yet");
			} else if (kind.equals("String")) {
				return new StringExpr(new Location(), value);
			} else {
				throw new OrccException("Unsupported Expr "
						+ "literal kind: \"" + kind + "\"");
			}
		}

		private List<IExpr> parseExprs(Node node) throws OrccException {
			List<IExpr> exprs = new ArrayList<IExpr>();
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
		private ParseContinuation<UnaryOp> parseExprUnaryOp(Node node)
				throws OrccException {
			while (node != null) {
				if (node.getNodeName().equals("Op")) {
					Element op = (Element) node;
					String name = op.getAttribute("name");
					if (name.equals("#")) {
						return new ParseContinuation<UnaryOp>(node,
								UnaryOp.NUM_ELTS);
					} else if (name.equals("not")) {
						return new ParseContinuation<UnaryOp>(node,
								UnaryOp.LNOT);
					} else if (name.equals("-")) {
						return new ParseContinuation<UnaryOp>(node,
								UnaryOp.MINUS);
					} else {
						throw new OrccException("Unknown unary operator \""
								+ name + "\"");
					}
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
		 * Parses the given node as an IType.
		 * 
		 * @param node
		 *            the node to parse as a type.
		 * @return a type
		 * @throws OrccException
		 *             if the node could not be parsed as a type
		 */
		public ParseContinuation<IType> parseType(Node node)
				throws OrccException {
			while (node != null) {
				if (node.getNodeName().equals("Type")) {
					Element eltType = (Element) node;
					String name = eltType.getAttribute("name");
					if (name.equals(BoolType.NAME)) {
						return new ParseContinuation<IType>(node,
								new BoolType());
					} else if (name.equals(IntType.NAME)) {
						Map<String, Entry> entries = parseTypeEntries(node
								.getFirstChild());
						IExpr size = parseTypeSize(entries);
						return new ParseContinuation<IType>(node, new IntType(
								size));
					} else if (name.equals(ListType.NAME)) {
						return new ParseContinuation<IType>(node,
								parseTypeList(node));
					} else if (name.equals(StringType.NAME)) {
						return new ParseContinuation<IType>(node,
								new StringType());
					} else if (name.equals(UintType.NAME)) {
						Map<String, Entry> entries = parseTypeEntries(node
								.getFirstChild());
						IExpr size = parseTypeSize(entries);
						return new ParseContinuation<IType>(node, new UintType(
								size));
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
						IExpr expr = exprParser.parseExpr(node.getFirstChild());
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
		private IType parseTypeList(Node node) throws OrccException {
			Map<String, Entry> entries = parseTypeEntries(node.getFirstChild());
			Entry entry = entries.get("size");
			if (entry == null) {
				throw new OrccException("List type must have a \"size\" entry");
			}
			IExpr size = entry.getEntryAsExpr();

			entry = entries.get("type");
			if (entry == null) {
				throw new OrccException("List type must have a \"type\" entry");
			}
			IType type = entry.getEntryAsType();

			return new ListType(size, type);
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
		private IExpr parseTypeSize(Map<String, Entry> entries)
				throws OrccException {
			Entry entry = entries.get("size");
			if (entry == null) {
				return new IntExpr(defaultSize);
			} else {
				return entry.getEntryAsExpr();
			}
		}

	}

	/**
	 * Calls the parser with args[0] as the file name.
	 * 
	 * @param args
	 *            arguments
	 * @throws OrccException
	 *             if the file could not be parsed
	 */
	public static void main(String[] args) throws OrccException {
		if (args.length == 1) {
			new NetworkParser(args[0]).parseNetwork();
		} else {
			System.err.println("Usage: NetworkParser "
					+ "<absolute path of top-level XDF network>");
		}
	}

	/**
	 * XDF expression parser.
	 */
	private final ExprParser exprParser;

	/**
	 * absolute file name of the XDF file
	 */
	private final File file;

	/**
	 * the graph representing the network we are parsing
	 */
	private DirectedGraph<Vertex, Connection> graph;

	/**
	 * list of input ports
	 */
	private OrderedMap<Port> inputs;

	/**
	 * map of string -> instances
	 */
	private Map<String, Instance> instances;

	/**
	 * list of output ports
	 */
	private OrderedMap<Port> outputs;

	/**
	 * list of parameters
	 */
	private Scope<GlobalVariable> parameters;

	/**
	 * parent path of {@link #file}
	 */
	private final String path;

	/**
	 * XDF type parser.
	 */
	private final TypeParser typeParser;

	/**
	 * list of variables
	 */
	private Scope<GlobalVariable> variables;

	/**
	 * Creates a new network parser.
	 * 
	 * @param fileName
	 *            absolute file name of an XDF file
	 */
	public NetworkParser(String fileName) {
		file = new File(fileName);
		path = file.getParent();
		exprParser = new ExprParser();
		typeParser = new TypeParser();
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
			return new Port(new Location(), null, portName);
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
			OrderedMap<Port> ports) throws OrccException {
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
					IType type = typeParser
							.parseType(attribute.getFirstChild()).getResult();
					attr = new TypeAttribute(type);
				} else if (kind.equals(IValueAttribute.NAME)) {
					IExpr expr = exprParser.parseExpr(node.getFirstChild());
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
					graph.addVertex(new Vertex(instance));
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

		Vertex source = getVertex(src, src_port, "Input", inputs);
		Port srcPort = getPort(src, src_port);
		Vertex target = getVertex(dst, dst_port, "Output", outputs);
		Port dstPort = getPort(dst, dst_port);

		Node child = connection.getFirstChild();
		Map<String, IAttribute> attributes = parseAttributes(child);
		Connection conn = new Connection(srcPort, dstPort, attributes);
		graph.addEdge(source, target, conn);
	}

	private void parseDecl(Element decl) throws OrccException {
		String kind = decl.getAttribute("kind");
		String name = decl.getAttribute("name");
		if (name.isEmpty()) {
			throw new OrccException("Decl has an empty name");
		}

		Location location = new Location();
		if (kind.equals("Param")) {
			ParseContinuation<IType> cont = typeParser.parseType(decl
					.getFirstChild());
			IType type = cont.getResult();
			GlobalVariable var = new GlobalVariable(location, type, name);
			parameters.register(file.getAbsolutePath(), location, name, var);
		} else if (kind.equals("Variable")) {
			ParseContinuation<IType> cont = typeParser.parseType(decl
					.getFirstChild());
			IType type = cont.getResult();
			IExpr expr = exprParser.parseExpr(cont.getNode());
			GlobalVariable var = new GlobalVariable(location, type, name, expr);
			parameters.register(file.getAbsolutePath(), location, name, var);
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
		Map<String, IExpr> parameters = parseParameters(child);
		Map<String, IAttribute> attributes = parseAttributes(child);

		return new Instance(path, id, clasz, parameters, attributes);
	}

	/**
	 * Parses the file given to the constructor of this class.
	 * 
	 * @return a network
	 * @throws OrccException
	 *             if the file could not be parsed
	 */
	public Network parseNetwork() throws OrccException {
		try {
			// input
			DOMImplementationRegistry registry = DOMImplementationRegistry
					.newInstance();
			DOMImplementationLS impl = (DOMImplementationLS) registry
					.getDOMImplementation("Core 3.0 XML 3.0 LS");
			LSInput input = impl.createLSInput();
			input.setByteStream(new FileInputStream(file));

			// parse without comments and whitespace
			LSParser builder = impl.createLSParser(
					DOMImplementationLS.MODE_SYNCHRONOUS, null);
			DOMConfiguration config = builder.getDomConfig();
			config.setParameter("comments", false);
			config.setParameter("element-content-whitespace", false);

			// returns the document parsed from the input
			return parseXDF(builder.parse(input));
		} catch (FileNotFoundException e) {
			throw new OrccException("I/O error when parsing network", e);
		} catch (ClassCastException e) {
			throw new OrccException("could not initialize DOM parser", e);
		} catch (ClassNotFoundException e) {
			throw new OrccException("could not initialize DOM parser", e);
		} catch (InstantiationException e) {
			throw new OrccException("could not initialize DOM parser", e);
		} catch (IllegalAccessException e) {
			throw new OrccException("could not initialize DOM parser", e);
		}
	}

	private Map<String, IExpr> parseParameters(Node node) throws OrccException {
		Map<String, IExpr> parameters = new HashMap<String, IExpr>();
		while (node != null) {
			if (node.getNodeName().equals("Parameter")) {
				String name = ((Element) node).getAttribute("name");
				if (name.isEmpty()) {
					throw new OrccException("A Parameter element "
							+ "must have a valid \"name\" attribute");
				}

				IExpr expr = exprParser.parseExpr(node.getFirstChild());
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
		Location location = new Location();
		IType type = typeParser.parseType(eltPort.getFirstChild()).getResult();
		String name = eltPort.getAttribute("name");
		if (name.isEmpty()) {
			throw new OrccException("Port has an empty name");
		}

		// creates a port
		Port port = new Port(location, type, name);

		// adds the port to inputs or outputs depending on its kind
		String kind = eltPort.getAttribute("kind");
		if (kind.equals("Input")) {
			inputs.register(file.toString(), location, name, port);
		} else if (kind.equals("Output")) {
			outputs.register(file.toString(), location, name, port);
		} else {
			throw new OrccException("Port \"" + name + "\", invalid kind: \""
					+ kind + "\"");
		}

		graph.addVertex(new Vertex(kind, port));
	}

	/**
	 * Parses the given document as an XDF network.
	 * 
	 * @param doc
	 *            a DOM document that supposedly represent an XDF network
	 * @return a Network
	 * @throws OrccException
	 *             if the DOM document is not a well-formed XDF network
	 */
	private Network parseXDF(Document doc) throws OrccException {
		Element root = doc.getDocumentElement();
		if (!root.getNodeName().equals("XDF")) {
			throw new OrccException("Expected \"XDF\" start element");
		}

		String name = root.getAttribute("name");
		if (name.isEmpty()) {
			throw new OrccException("Expected a \"name\" attribute");
		}

		graph = new DirectedMultigraph<Vertex, Connection>(Connection.class);
		inputs = new OrderedMap<Port>();
		instances = new HashMap<String, Instance>();
		outputs = new OrderedMap<Port>();
		parameters = new Scope<GlobalVariable>();
		variables = new Scope<GlobalVariable>(parameters);

		parseBody(root);

		if (instances.isEmpty()) {
			throw new OrccException(
					"A valid network must contain at least one instance");
		}

		return new Network(name, inputs, outputs, parameters, variables, graph);
	}

}

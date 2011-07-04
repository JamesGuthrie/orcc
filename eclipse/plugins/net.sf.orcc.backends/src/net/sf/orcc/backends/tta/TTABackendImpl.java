/*
 * Copyright (c) 2011, IRISA
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
package net.sf.orcc.backends.tta;

import static net.sf.orcc.OrccLaunchConstants.DEBUG_MODE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.orcc.OrccException;
import net.sf.orcc.backends.AbstractBackend;
import net.sf.orcc.backends.InstancePrinter;
import net.sf.orcc.backends.NetworkPrinter;
import net.sf.orcc.backends.llvm.LLVMExpressionPrinter;
import net.sf.orcc.backends.llvm.LLVMTypePrinter;
import net.sf.orcc.backends.llvm.transformations.BoolToIntTransformation;
import net.sf.orcc.backends.llvm.transformations.GetElementPtrAdder;
import net.sf.orcc.backends.llvm.transformations.PrintlnTransformation;
import net.sf.orcc.backends.transformations.CastAdder;
import net.sf.orcc.backends.transformations.tac.TacTransformation;
import net.sf.orcc.backends.tta.architecture.ArchitectureFactory;
import net.sf.orcc.backends.tta.architecture.TTA;
import net.sf.orcc.backends.tta.architecture.util.ArchitecturePrinter;
import net.sf.orcc.backends.tta.transformations.TtaTypeResizer;
import net.sf.orcc.backends.xlim.transformations.InstPhiTransformation;
import net.sf.orcc.ir.Actor;
import net.sf.orcc.ir.transformations.BlockCombine;
import net.sf.orcc.ir.transformations.BuildCFG;
import net.sf.orcc.ir.transformations.RenameTransformation;
import net.sf.orcc.ir.transformations.SSATransformation;
import net.sf.orcc.ir.util.ActorVisitor;
import net.sf.orcc.network.Instance;
import net.sf.orcc.network.Network;
import net.sf.orcc.network.transformations.BroadcastAdder;
import net.sf.orcc.util.OrccUtil;

import org.eclipse.core.resources.IFile;

/**
 * TTA back-end.
 * 
 * @author Herve Yviquel
 * 
 */
public class TTABackendImpl extends AbstractBackend {

	/**
	 * Backend options
	 */
	private boolean debugMode;

	private final Map<String, String> transformations;

	/**
	 * Creates a new instance of the TTA back-end. Initializes the
	 * transformation hash map.
	 */
	public TTABackendImpl() {
		transformations = new HashMap<String, String>();
		transformations.put("abs", "abs_");
		transformations.put("getw", "getw_");
		transformations.put("index", "index_");
		transformations.put("min", "min_");
		transformations.put("max", "max_");
		transformations.put("select", "select_");
	}

	@Override
	public void doInitializeOptions() {
		debugMode = getAttribute(DEBUG_MODE, false);
	}

	@Override
	protected void doTransformActor(Actor actor) throws OrccException {

		ActorVisitor<?>[] transformations = { new SSATransformation(),
				new TtaTypeResizer(), new BoolToIntTransformation(),
				new PrintlnTransformation(),
				new RenameTransformation(this.transformations),
				new TacTransformation(true), new InstPhiTransformation(),
				new GetElementPtrAdder(), new CastAdder(true, false),
				new BlockCombine(), new BuildCFG() };

		for (ActorVisitor<?> transformation : transformations) {
			transformation.doSwitch(actor);
		}

		actor.setTemplateData(new TTAActorTemplateData(actor));
	}

	private void doTransformNetwork(Network network) throws OrccException {
		network.flatten();
		new BroadcastAdder().transform(network);
	}

	@Override
	protected void doVtlCodeGeneration(List<IFile> files) throws OrccException {
		// do not generate a VTL
	}

	@Override
	protected void doXdfCodeGeneration(Network network) throws OrccException {
		doTransformNetwork(network);

		transformActors(network.getActors());
		printInstances(network);

		network.computeTemplateMaps();
		printNetwork(network);
	}

	@Override
	protected boolean printInstance(Instance instance) throws OrccException {
		InstancePrinter printer = new InstancePrinter("TTA_actor", !debugMode,
				true);
		printer.setExpressionPrinter(new LLVMExpressionPrinter());
		printer.setTypePrinter(new LLVMTypePrinter());

		String instancePath = OrccUtil.createFolder(path, instance.getId());
		if (!(instance.isActor() && instance.getActor().isNative())) {
			printProcessor(instance, instancePath);
		}
		return printer.print(instance.getId() + ".ll", instancePath, instance,
				"instance");
	}

	private void printNetwork(Network network) {
		NetworkPrinter networkPrinter = new NetworkPrinter("TTA_network");
		NetworkPrinter scriptPrinter = new NetworkPrinter("TTA_script");
		networkPrinter.print(network.getName() + ".vhd", path, network,
				"network");
		scriptPrinter.print("informations.py", path, network, "script");
		OrccUtil.createFile(path, "__init__.py");
	}

	private void printProcessor(Instance instance, String instancePath) {
		TTA simpleTTA = ArchitectureFactory.eINSTANCE.createTTASpecialized(
				instance.getId(), instance);

		InstancePrinter vhdlPrinter = new InstancePrinter("TTA_processor_vhdl",
				!debugMode, true);
		ArchitecturePrinter adfPrinter = new ArchitecturePrinter(
				"TTA_processor_adf");
		ArchitecturePrinter idfPrinter = new ArchitecturePrinter(
				"TTA_processor_idf");

		vhdlPrinter.print("processor_" + instance.getId() + ".vhd",
				instancePath, instance, "processor");
		adfPrinter.print("processor_" + instance.getId() + ".adf",
				instancePath, simpleTTA, "tta");
		idfPrinter.print("processor_" + instance.getId() + ".idf",
				instancePath, simpleTTA, "tta");

	}

}

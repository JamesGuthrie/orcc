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
import static net.sf.orcc.OrccLaunchConstants.FIFO_SIZE;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.dftools.util.util.EcoreHelper;
import net.sf.orcc.OrccException;
import net.sf.orcc.backends.AbstractBackend;
import net.sf.orcc.backends.CustomPrinter;
import net.sf.orcc.backends.StandardPrinter;
import net.sf.orcc.backends.llvm.LLVMExpressionPrinter;
import net.sf.orcc.backends.llvm.LLVMTypePrinter;
import net.sf.orcc.backends.llvm.transformations.BoolToIntTransformation;
import net.sf.orcc.backends.llvm.transformations.GetElementPtrAdder;
import net.sf.orcc.backends.llvm.transformations.StringTransformation;
import net.sf.orcc.backends.transformations.CastAdder;
import net.sf.orcc.backends.transformations.EmptyNodeRemover;
import net.sf.orcc.backends.transformations.InstPhiTransformation;
import net.sf.orcc.backends.transformations.TypeResizer;
import net.sf.orcc.backends.transformations.UnitImporter;
import net.sf.orcc.backends.transformations.ssa.ConstantPropagator;
import net.sf.orcc.backends.transformations.ssa.CopyPropagator;
import net.sf.orcc.backends.tta.architecture.ArchitectureFactory;
import net.sf.orcc.backends.tta.architecture.Processor;
import net.sf.orcc.backends.tta.architecture.util.ArchitectureMemoryStats;
import net.sf.orcc.backends.tta.transformations.SlowOperationDetector;
import net.sf.orcc.backends.util.FPGA;
import net.sf.orcc.df.Actor;
import net.sf.orcc.df.Instance;
import net.sf.orcc.df.Network;
import net.sf.orcc.df.transformations.BroadcastAdder;
import net.sf.orcc.df.transformations.Instantiator;
import net.sf.orcc.df.transformations.NetworkFlattener;
import net.sf.orcc.df.util.DfSwitch;
import net.sf.orcc.ir.transformations.BlockCombine;
import net.sf.orcc.ir.transformations.CfgBuilder;
import net.sf.orcc.ir.transformations.RenameTransformation;
import net.sf.orcc.ir.transformations.SSATransformation;
import net.sf.orcc.ir.transformations.TacTransformation;
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
	private boolean debug;
	private boolean finalize;
	private FPGA fpga;
	private String libPath;
	private int fifoWidthu;

	private final Map<String, String> transformations;
	private final List<String> processorIntensiveActors;

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
		processorIntensiveActors = new ArrayList<String>();
		// processorIntensiveActors.add("org.mpeg4.part2.motion.Algo_Add");
		// processorIntensiveActors.add("com.ericsson.Algo_Interpolation_halfpel");
		// processorIntensiveActors.add("org.sc29.wg11.mpeg4.part2.texture.Algo_IDCT2D_ISOIEC_23002_1");
		// processorIntensiveActors.add("fi.oulu.ee.mvg.Framebuffer");
		// processorIntensiveActors.add("com.xilinx.Mgnt_Merger");
		// processorIntensiveActors.add("org.mpeg4.part2.texture.Algo_Inversequant");

		// processorIntensiveActors.add("fi.oulu.ee.mvg.Algo_IAP_multi");
		// processorIntensiveActors.add("org.mpeg4.part2.parser.Algo_Synp_MPEG_4");
	}

	@Override
	public void doInitializeOptions() {
		debug = getAttribute(DEBUG_MODE, true);
		finalize = getAttribute("net.sf.orcc.backends.tta.finalizeGeneration",
				false);
		fpga = FPGA.builder(getAttribute("net.sf.orcc.backends.tta.fpga",
				"Stratix III (EP3SL150F1152C2)"));
		// Set default FIFO size to 256
		fifoSize = getAttribute(FIFO_SIZE, 256);
		fifoWidthu = (int) Math.ceil(Math.log(fifoSize) / Math.log(2));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.orcc.backends.AbstractBackend#exportRuntimeLibrary()
	 */
	@Override
	public boolean exportRuntimeLibrary() throws OrccException {
		libPath = path + File.separator + "libs";
		write("Export library files into " + libPath + "... ");
		if (copyFolderToFileSystem("/runtime/TTA", libPath)) {
			write("OK" + "\n");
			new File(libPath + File.separator + "generate").setExecutable(true);
			return true;
		} else {
			write("Error" + "\n");
			return false;
		}
	}

	@Override
	protected void doTransformActor(Actor actor) throws OrccException {
		DfSwitch<?>[] transformations = { new UnitImporter(),
				new SlowOperationDetector(getWriteListener()),
				new SSATransformation(), new BoolToIntTransformation(),
				new TypeResizer(true, true, false, true),
				new StringTransformation(),
				new RenameTransformation(this.transformations),
				new TacTransformation(), new CopyPropagator(),
				new ConstantPropagator(), new InstPhiTransformation(),
				new GetElementPtrAdder(), new CastAdder(false),
				new EmptyNodeRemover(), new BlockCombine(), new CfgBuilder() };

		for (DfSwitch<?> transformation : transformations) {
			transformation.doSwitch(actor);
		}

		actor.setTemplateData(new TTAActorTemplateData(actor));
	}

	private Network doTransformNetwork(Network network) throws OrccException {
		write("Instantiating...\n");
		network = new Instantiator(fifoSize).doSwitch(network);
		write("Flattening...\n");
		new NetworkFlattener().doSwitch(network);

		new BroadcastAdder().doSwitch(network);

		return network;
	}

	@Override
	protected void doVtlCodeGeneration(List<IFile> files) throws OrccException {
		// do not generate a VTL
	}

	@Override
	protected void doXdfCodeGeneration(Network network) throws OrccException {
		network = doTransformNetwork(network);

		transformActors(network.getAllActors());
		printInstances(network);

		network.computeTemplateMaps();
		printNetwork(network);

		if (finalize) {
			runPythonScript();
		}
	}

	private int getAluNb(Instance instance) {
		if (instance.isActor()
				&& processorIntensiveActors.contains(instance.getActor()
						.getName())) {
			return 4;
		}
		return 1;
	}

	private int getBusNb(Instance instance) {
		if (instance.isActor()
				&& processorIntensiveActors.contains(instance.getActor()
						.getName())) {
			return 6;
		}
		return 2;
	}

	private int getRegNb(Instance instance) {
		if (instance.isActor()
				&& processorIntensiveActors.contains(instance.getActor()
						.getName())) {
			return 4;
		}
		return 2;
	}

	@Override
	protected boolean printInstance(Instance instance) throws OrccException {
		StandardPrinter printer = new StandardPrinter(
				"net/sf/orcc/backends/tta/LLVM_Actor.stg", !debug, false);
		printer.setExpressionPrinter(new LLVMExpressionPrinter());
		printer.setTypePrinter(new LLVMTypePrinter());

		String instancePath = null;
		if (!(instance.isActor() && instance.getActor().isNative())) {
			instancePath = OrccUtil
					.createFolder(path, instance.getSimpleName());
			printProcessor(instance, instancePath);

			// ModelSim
			String simPath = OrccUtil.createFolder(instancePath, "simulation");
			StandardPrinter tbPrinter = new StandardPrinter(
					"net/sf/orcc/backends/tta/VHDL_Testbench.stg", !debug,
					false);
			tbPrinter.getOptions().put("fifoSize", fifoSize);
			tbPrinter.getOptions().put("fpga", fpga);
			StandardPrinter tclPrinter = new StandardPrinter(
					"net/sf/orcc/backends/tta/ModelSim_Script.stg");
			tclPrinter.getOptions().put("fpga", fpga);
			StandardPrinter wavePrinter = new StandardPrinter(
					"net/sf/orcc/backends/tta/ModelSim_Wave.stg");
			tbPrinter.print(instance.getSimpleName() + "_tb.vhd", simPath,
					instance);
			tclPrinter.print(instance.getSimpleName() + ".tcl", instancePath,
					instance);
			wavePrinter.print("wave.do", simPath, instance);
		}

		return printer.print(instance.getSimpleName() + ".ll", instancePath,
				instance);
	}

	private void printNetwork(Network network) {
		// VHDL Network of TTA processors
		StandardPrinter networkPrinter = new StandardPrinter(
				"net/sf/orcc/backends/tta/VHDL_Network.stg");
		networkPrinter.setExpressionPrinter(new LLVMExpressionPrinter());
		networkPrinter.getOptions().put("fifoWidthu", fifoWidthu);
		networkPrinter.getOptions().put("fpga", fpga);
		networkPrinter.print("top.vhd", path, network);

		// Python package
		String pythonPath = OrccUtil.createFolder(path, "informations_");
		StandardPrinter pythonPrinter = new StandardPrinter(
				"net/sf/orcc/backends/tta/Python_Network.stg");
		pythonPrinter.getOptions().put("fpga", fpga);
		pythonPrinter.print("informations.py", pythonPath, network);
		OrccUtil.createFile(pythonPath, "__init__.py");

		if (fpga.isAltera()) {
			// Quartus
			CustomPrinter projectQsfPrinter = new CustomPrinter(
					"net/sf/orcc/backends/tta/Quartus_Project.stg");
			CustomPrinter projectQpfPrinter = new CustomPrinter(
					"net/sf/orcc/backends/tta/Quartus_Project.stg");
			projectQsfPrinter.print("top.qsf", path, "qsfNetwork", "network",
					network);
			projectQpfPrinter.print("top.qpf", path, "qpfNetwork", "network",
					network);
		} else if (fpga.isXilinx()) {
			// ISE
			CustomPrinter projectXisePrinter = new CustomPrinter(
					"net/sf/orcc/backends/tta/ISE_Project.stg");
			projectXisePrinter.print("top.xise", path, "xiseNetwork",
					"network", network);
			projectXisePrinter.print("top.ucf", path, "ucfNetwork", "network",
					network);
		}

		// ModelSim
		StandardPrinter tclPrinter = new StandardPrinter(
				"net/sf/orcc/backends/tta/ModelSim_Script.stg");
		tclPrinter.getOptions().put("fpga", fpga);
		StandardPrinter tbPrinter = new StandardPrinter(
				"net/sf/orcc/backends/tta/VHDL_Testbench.stg");
		tbPrinter.getOptions().put("fifoSize", fifoSize);
		StandardPrinter wavePrinter = new StandardPrinter(
				"net/sf/orcc/backends/tta/ModelSim_Wave.stg");
		wavePrinter.setExpressionPrinter(new LLVMExpressionPrinter());
		tclPrinter.print("top.tcl", path, network);
		tbPrinter.print("top_tb.vhd", path, network);
		wavePrinter.print("wave.do", path, network);
	}

	private void printProcessor(Instance instance, String instancePath) {
		int ramSize = instance.isActor() ? ArchitectureMemoryStats
				.computeNeededMemorySize(instance.getActor()) : 1;

		Processor tta = ArchitectureFactory.eINSTANCE.createProcessor(
				instance.getSimpleName(), getBusNb(instance),
				getRegNb(instance), 12, 2, getAluNb(instance), 1, 1, 1,
				EcoreHelper.getList(instance.getEntity(), "inputs").size(),
				EcoreHelper.getList(instance.getEntity(), "outputs").size(),
				ramSize);

		/*
		 * Processor tta = ArchitectureFactory.eINSTANCE.createHugeProcessor(
		 * instance.getSimpleName(), instance.getEntity().getInputs() .size(),
		 * instance.getEntity().getOutputs().size(), ramSize);
		 */

		CustomPrinter adfPrinter = new CustomPrinter(
				"net/sf/orcc/backends/tta/TCE_Processor_ADF.stg");
		CustomPrinter idfPrinter = new CustomPrinter(
				"net/sf/orcc/backends/tta/TCE_Processor_IDF.stg");

		adfPrinter.print("processor_" + instance.getSimpleName() + ".adf",
				instancePath, "printTTA", "tta", tta);
		idfPrinter.print("processor_" + instance.getSimpleName() + ".idf",
				instancePath, "printTTA", "tta", tta);
	}

	private void runPythonScript() throws OrccException {
		List<String> cmdList = new ArrayList<String>();
		cmdList.add(libPath + File.separator + "generate");
		cmdList.add("-cg");
		if (debug) {
			cmdList.add("--debug");
		}
		cmdList.add(path);

		String[] cmd = cmdList.toArray(new String[] {});
		try {
			write("Generating design...\n");
			long t0 = System.currentTimeMillis();
			final Process process = Runtime.getRuntime().exec(cmd);
			process.waitFor();
			long t1 = System.currentTimeMillis();
			write("Done in " + ((float) (t1 - t0) / (float) 1000) + "s\n");
		} catch (IOException e) {
			System.err.println("TCE error: ");
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

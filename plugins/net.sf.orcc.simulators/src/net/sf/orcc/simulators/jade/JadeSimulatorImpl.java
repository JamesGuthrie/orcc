/*
 * Copyright (c) 2010, IETR/INSA of Rennes
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
package net.sf.orcc.simulators.jade;

import static net.sf.orcc.OrccLaunchConstants.DEFAULT_FIFO_SIZE;
import static net.sf.orcc.OrccLaunchConstants.FIFO_SIZE;
import static net.sf.orcc.OrccLaunchConstants.INPUT_STIMULUS;
import static net.sf.orcc.OrccLaunchConstants.TOOLS_FOLDER;
import static net.sf.orcc.OrccLaunchConstants.TRACES_FOLDER;
import static net.sf.orcc.OrccLaunchConstants.VTL_FOLDER;
import static net.sf.orcc.OrccLaunchConstants.XDF_FILE;
import static net.sf.orcc.preferences.PreferenceConstants.P_JADE;

import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import net.sf.orcc.OrccRuntimeException;
import net.sf.orcc.debug.model.OrccProcess;
import net.sf.orcc.plugins.simulators.Simulator;
import net.sf.orcc.ui.OrccActivator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunchConfiguration;

public class JadeSimulatorImpl implements Simulator {

	/**
	 * Indicate to the simulator implementation the we are in debug mode.
	 */
	protected boolean debugMode;

	/**
	 * Path of Jade executable
	 */
	protected String execJade;

	/**
	 * default FIFO size.
	 */
	protected int fifoSize;

	/**
	 * Monitor associated to the simulator execution. Used for user
	 * cancellation.
	 */
	protected IProgressMonitor monitor = null;

	/**
	 * Master caller associated process for console I/O access.
	 */
	protected OrccProcess orccProcess;

	/**
	 * Input stimulus file name
	 */
	protected String stimulusFile;

	/**
	 * Folder where the Jade Tools are placed
	 */
	protected String toolsFolder;

	/**
	 * Traces folder
	 */
	protected String tracesFolder;

	/**
	 * Folder where the VTL is
	 */
	protected String vtlFolder;

	/**
	 * input XDF network file name
	 */
	protected String xdfFile;

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {

	}

	@Override
	public void configure(OrccProcess process, IProgressMonitor monitor,
			boolean debugMode) {
		this.orccProcess = process;
		this.monitor = monitor;
		this.debugMode = debugMode;
	}

	@Override
	public String getActorName(String instanceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getActorsInstanceIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNetworkName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SimulatorState getSimulatorState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DebugStackFrame getStackFrame(String instanceID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isStepping() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void message(SimulatorEvent event, Object[] data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		List<String> cmdList = new ArrayList<String>();
		cmdList.add(execJade);
		cmdList.add("-xdf");
		cmdList.add(xdfFile);
		cmdList.add("-i");
		cmdList.add(stimulusFile);
		cmdList.add("-L");
		cmdList.add(vtlFolder);
		cmdList.add("-T");
		cmdList.add(toolsFolder);

		if (!tracesFolder.equals("")) {
			cmdList.add("-w");
			cmdList.add(tracesFolder);
		}
		String[] cmd = cmdList.toArray(new String[] {});

		Runtime run = Runtime.getRuntime();

		try {
			final Process process = run.exec(cmd);
		
			// Output application message
			new Thread() {
				@Override
				public void run() {
					try {
						BufferedReader reader = new BufferedReader(
								new InputStreamReader(process.getInputStream()));
						try {
							String line = reader.readLine();
							if (line != null) {
								orccProcess.write(line+ "\n");
							}
						} finally {
							reader.close();
						}
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
				}
			}.start();
			
			// Output error message
			new Thread() {
				@Override
				public void run() {
					try {
						BufferedReader reader = new BufferedReader(
								new InputStreamReader(process.getErrorStream()));
						try {
							String line = reader.readLine();
							if (line != null) {
								orccProcess.write("Generation error :" + line
										+ "\n");
							}
						} finally {
							reader.close();
						}
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
				}
			}.start();

			process.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void setLaunchConfiguration(ILaunchConfiguration configuration) {
		try {
			// Get configuration attributes
			stimulusFile = configuration.getAttribute(INPUT_STIMULUS, "");
			vtlFolder = configuration.getAttribute(VTL_FOLDER, "");
			fifoSize = configuration.getAttribute(FIFO_SIZE, DEFAULT_FIFO_SIZE);
			xdfFile = configuration.getAttribute(XDF_FILE, "");
			toolsFolder = configuration.getAttribute(TOOLS_FOLDER, "");
			tracesFolder = configuration.getAttribute(TRACES_FOLDER, "");
			execJade = OrccActivator.getDefault().getPreferenceStore().getString(P_JADE);

			// Jade location has not been set
			if (execJade.equals("")) {
				throw new OrccRuntimeException(
						"Jade path must first be set in window->Preference->Orcc");
			}

			// Verify that the file is executable
			File file = new File(execJade);

			if (!file.canExecute()) {
				throw new OrccRuntimeException(
						"Wrong Jade location in Orcc Preference");
			}
		} catch (CoreException e) {
			throw new OrccRuntimeException(e.getMessage());
		}

	}

}

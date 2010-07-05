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
package net.sf.orcc.plugins;

/**
 * This interface defines an option of a plugin.
 * 
 * @author J�r�me Gorin
 * @author Matthieu Wipliez
 * 
 */
public interface BrowseFileOption extends PluginOption {

	/**
	 * Returns the extension that this "input file" should have.
	 * 
	 * @return the extension that this "input file" should have
	 */
	String getExtension();

	/**
	 * Returns whether we should select a folder or a regular file.
	 * 
	 * @return whether we should select a folder or a regular file
	 */
	boolean isFolder();

	/**
	 * Returns whether we should browse the workspace or the file system.
	 * 
	 * @return whether we should browse the workspace or the file system
	 */
	boolean isWorkspace();

	/**
	 * Sets the extension that this "input file" should have.
	 * 
	 * @param extension
	 *            the extension that this "input file" should have
	 */
	void setExtension(String extension);

	/**
	 * Sets whether we should select a folder or a regular file.
	 * 
	 * @param folder
	 *            whether we should select a folder or a regular file
	 */
	void setFolder(boolean folder);

	/**
	 * Sets whether we should browse the workspace or the file system.
	 * 
	 * @param workspace
	 *            whether we should browse the workspace or the file system
	 */
	void setWorkspace(boolean workspace);
}

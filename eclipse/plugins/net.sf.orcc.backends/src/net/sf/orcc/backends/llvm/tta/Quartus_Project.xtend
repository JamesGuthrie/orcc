/*
 * Copyright (c) 2012, IRISA
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
 *   * Neither the name of IRISA nor the names of its
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
package net.sf.orcc.backends.llvm.tta

import java.io.File
import net.sf.orcc.backends.llvm.tta.architecture.Design
import net.sf.orcc.backends.llvm.tta.architecture.Processor
import net.sf.orcc.backends.util.FPGA

class Quartus_Project extends TTATemplate {
	
	private FPGA fpga;
	
	new(FPGA fpga) {
		this.fpga = fpga;
	}
	
	def print(Design design, String targetFolder) {
		val qpfFile = new File(targetFolder + File::separator + "top.qpf")
		val qcfFile = new File(targetFolder + File::separator + "top.qsf")
		printFile(getQpf, qpfFile)
		printFile(design.project, qcfFile)
	}
	
	def private getProject(Design design) 
		'''
		# Quartus II Project
		# Generated by Orcc
		
		# Board informations
		set_global_assignment -name FAMILY "«fpga.family»"
		set_global_assignment -name DEVICE «fpga.device»
		set_global_assignment -name TOP_LEVEL_ENTITY top
		
		# Network
		set_global_assignment -name VHDL_FILE top.vhd
		
		«FOR processor:design.processors»
			«processor.project»
		«ENDFOR»
		
		# Shared components
		set_global_assignment -name VHDL_FILE share/vhdl/util_pkg.vhdl
		set_global_assignment -name VHDL_FILE share/vhdl/tce_util_pkg.vhdl
		set_global_assignment -name VHDL_FILE share/vhdl/rf_1wr_1rd_always_1_guarded_0.vhd
		set_global_assignment -name VHDL_FILE share/vhdl/mul.vhdl
		set_global_assignment -name VHDL_FILE share/vhdl/ldh_ldhu_ldq_ldqu_ldw_sth_stq_stw.vhdl
		set_global_assignment -name VHDL_FILE share/vhdl/and_ior_xor.vhdl
		set_global_assignment -name VHDL_FILE share/vhdl/add_and_eq_gt_gtu_ior_shl_shr_shru_sub_sxhw_sxqw_xor.vhdl
		set_global_assignment -name VHDL_FILE share/vhdl/stratix3_led_io_always_1.vhd
		
		# Other components
		set_global_assignment -name VHDL_FILE wrapper/altera_ram_1p.vhd
		set_global_assignment -name VHDL_FILE wrapper/altera_ram_2p.vhd
		set_global_assignment -name VHDL_FILE wrapper/altera_rom.vhd
		set_global_assignment -name VHDL_FILE interface/counter.vhd
		set_global_assignment -name VHDL_FILE interface/fps_eval.vhd
		set_global_assignment -name VHDL_FILE interface/segment_display_conv.vhd
		set_global_assignment -name VHDL_FILE interface/segment_display_sel.vhd
		
		# Pin assignments
		set_location_assignment PIN_F21 -to leds[0]
		set_location_assignment PIN_C23 -to leds[1]
		set_location_assignment PIN_B23 -to leds[2]
		set_location_assignment PIN_A23 -to leds[3]
		set_location_assignment PIN_D19 -to leds[4]
		set_location_assignment PIN_C19 -to leds[5]
		set_location_assignment PIN_F19 -to leds[6]
		set_location_assignment PIN_E19 -to leds[7]
		set_location_assignment PIN_AP5 -to rst_n
		set_location_assignment PIN_T33 -to clk
		
		set_location_assignment PIN_AE10 -to segment7[0]
		set_location_assignment PIN_AL5  -to segment7[1]
		set_location_assignment PIN_AC12 -to segment7[2]
		set_location_assignment PIN_AM5  -to segment7[3]
		set_location_assignment PIN_AF11 -to segment7[4]
		set_location_assignment PIN_AM6  -to segment7[5]
		set_location_assignment PIN_AP3  -to segment7[6]
		set_location_assignment PIN_AM4  -to segment7_sel[0]
		set_location_assignment PIN_AE12 -to segment7_sel[1]
		set_location_assignment PIN_AL4  -to segment7_sel[2]
		set_location_assignment PIN_AH8  -to segment7_sel[3]
		'''
		
	def private getProject(Processor processor)
		'''
		# Processor «processor.name»
		set_global_assignment -name VHDL_FILE «processor.name»/tta/vhdl/«processor.name»_tl_params_pkg.vhdl
		set_global_assignment -name VHDL_FILE «processor.name»/tta/vhdl/«processor.name»_tl.vhdl
		set_global_assignment -name VHDL_FILE «processor.name»/tta/vhdl/«processor.name»_tl_globals_pkg.vhdl
		set_global_assignment -name VHDL_FILE «processor.name»/tta/vhdl/«processor.name»_mem_constants_pkg.vhd
		set_global_assignment -name VHDL_FILE «processor.name»/tta/vhdl/«processor.name».vhd
		set_global_assignment -name VHDL_FILE «processor.name»/tta/vhdl/imem_mau_pkg.vhdl
		set_global_assignment -name VHDL_FILE «processor.name»/tta/gcu_ic/output_socket_«processor.buses.size»_1.vhdl
		set_global_assignment -name VHDL_FILE «processor.name»/tta/gcu_ic/output_socket_1_1.vhdl
		set_global_assignment -name VHDL_FILE «processor.name»/tta/gcu_ic/input_socket_«processor.buses.size».vhdl
		set_global_assignment -name VHDL_FILE «processor.name»/tta/gcu_ic/ifetch.vhdl
		set_global_assignment -name VHDL_FILE «processor.name»/tta/gcu_ic/idecompressor.vhdl
		set_global_assignment -name VHDL_FILE «processor.name»/tta/gcu_ic/ic.vhdl
		set_global_assignment -name VHDL_FILE «processor.name»/tta/gcu_ic/gcu_opcodes_pkg.vhdl
		set_global_assignment -name VHDL_FILE «processor.name»/tta/gcu_ic/decoder.vhdl
		'''
	
	def private getQpf()
		'''
		# Quartus II Project
		# Generated by Orcc
		
		PROJECT_REVISION = "top"
		'''
}
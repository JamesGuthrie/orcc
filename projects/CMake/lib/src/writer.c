/*
 * Author : Endri Bezati (endri.bezati@epfl.ch)
 * Copyright (c) 2009, EPFL SCI-STI-MM
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
#include <stdio.h>
#include <stdlib.h>

#include "orcc.h"
#include "orcc_fifo.h"
#include "orcc_util.h"

// from APR
/* Ignore Microsoft's interpretation of secure development
 * and the POSIX string handling API
 */
#if defined(_MSC_VER) && _MSC_VER >= 1400
#ifndef _CRT_SECURE_NO_DEPRECATE
#define _CRT_SECURE_NO_DEPRECATE
#endif
#pragma warning(disable: 4996)
#endif

static FILE *F = NULL;
static int cnt = 0;

// Called before any *_scheduler function.
void writer_initialize() {
	if (write_file == NULL) {
		print_usage();
		fprintf(stderr, "No write file given!\n");
		wait_for_key();
		exit(1);
	}

	F = fopen(write_file, "w");
	if (F == NULL) {
		if (write_file == NULL) {
			write_file = "<null>";
		}

		fprintf(stderr, "could not open file \"%s\"\n", write_file);
		wait_for_key();
		exit(1);
	}else{
		fseek(F,0,SEEK_SET);
		cnt++;	
	}
}

extern struct fifo_u8_s *writer_In;


void writer_scheduler(struct schedinfo_s *si) {
	int i = 0;
	u8 In_buf[1];
	u8 *In;
	u8 wr;

	while (1) {
		if (fifo_u8_has_tokens(writer_In, 1)) {
			In = fifo_u8_read(writer_In, In_buf, 1);
			wr = In[0];
	
			if (cnt != 0){
				F = fopen(write_file,"a+");
			}
	
			
			fseek(F,sizeof(u8)*cnt,SEEK_SET);
			fwrite(&wr,sizeof(u8),1,F);
			
			
			i++;
			fclose(F);
			fifo_u8_read_end(writer_In, 1);
			
		} else {
			si->num_firings = i;
			si->reason = starved;
			si->ports = 0x01;
			break;
		}
	}
}


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
#ifndef SCHEDULER_H
#define SCHEDULER_H

struct conn_s {
	struct fifo_s *fifo;
	struct actor_s *source;
	struct actor_s *target;
};

struct actor_s {
	char *name;
	void (*sched_func)(struct schedinfo_s *);
	int num_inputs;
	int num_outputs;
	int num_predecessors;
	int num_successors;
	struct conn_s **inputs;
	struct conn_s **outputs;
	struct actor_s **predecessors;
	struct actor_s **successors;

	int in_list; /** set to 1 when the actor is in the schedulable list. Used by add_schedulable to do the membership test in O(1). */
};

struct list_s {
	struct list_s *prev, *next;
	void *payload;
};

struct scheduler_s {
	int num_actors;
	struct actor_s **actors;
	struct list_s schedulable;
	struct list_s scheduled;
};

/**
 * Initializes the given scheduler.
 */
void sched_init(struct scheduler_s *sched, int num_actors, struct actor_s **actors);

/**
 * add the actor to the schedulable list
 */
void sched_add_schedulable(struct scheduler_s *sched, struct actor_s *actor);

/**
 * add the actor to the scheduled list
 */
void sched_add_scheduled(struct scheduler_s *sched, struct actor_s *actor);

/**
 * returns the next schedulable actor
 */
struct actor_s *sched_get_next_schedulable(struct scheduler_s *sched);

/**
 * returns true if this actor is schedulable
 */
int sched_is_schedulable(struct actor_s *actor);

void sched_add_predecessors(struct scheduler_s *sched, struct actor_s *actor);

void sched_add_successors(struct scheduler_s *sched, struct actor_s *actor);

#endif

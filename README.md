# Date September 5, 2015

# Job Scheduling Algorithms

Implement efficient process (job) scheduling algorithms.

First Come First Served: Whichever job arrives first is processed first. If two jobs arrive at the same
time, the one with the lower job ID is processed first.

Shortest Job First: Whichever job has the least time left to process is processed first. If two jobs have the
same time left, the lower job ID is processed first.

Priority Scheduling: The job with the highest priority is processed first. If two jobs have the same
priority, the lower job ID is processed first.

Round-Robin Scheduling: The job that has been waiting the longest is processed first. Once a job is
processed for one cycle, the wait time for the job is reset to zero. If two jobs have the same wait time,
the one with the lower job ID is processed first.

Also two more algorithms of my own design to improve upon:

• average delay for all jobs.

• average delay*priority for all jobs.


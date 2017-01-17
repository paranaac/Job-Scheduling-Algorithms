/*
Programmer: Alejandro Parana

The job that has been waiting the longest is processed first. Once a job is processed for one cycle, 
the wait time for the job is reset to zero. 
If two jobs have the same wait time, the one with the lower job ID is processed first.
*/
public class Robin
{
	public static void main(String[] args)
	{
		Jobs myJobs = new Jobs();
		System.out.println(myJobs);
		int[] waitingQueue = new int[10000];
		while (!myJobs.done())
		{
			int[][] jobs = myJobs.getJobs();
			System.out.println("Clock: "+myJobs.getClock());
			System.out.println("\tJob Count: "+jobs.length);

			if (jobs.length > 0)
			{
				int size = jobs.length, maxWait = 0, oldestJob = 0;

				for(int i = 0; i < size; i++)
					waitingQueue[jobs[i][0]] += 1;

				for (int i = 0; i < waitingQueue.length; i++)
				{
					if (waitingQueue[i] > maxWait)
					{
						oldestJob = i;
						maxWait = waitingQueue[i];
					}
				}

				for(int j = 0; j < size; j++)
			   		System.out.println("\t\t--> Job: "+ jobs[j][0] + " Duration: " + jobs[j][1] + " Priority: " + jobs[j][2]);
				System.out.println("\t(Working on Job "+ oldestJob + ")");

				myJobs.cycle(oldestJob);
				
				waitingQueue[oldestJob] = 0; 
				
			}	
			else
			{
				myJobs.cycle();
			}
		}
		System.out.println(myJobs.report());
	}
}
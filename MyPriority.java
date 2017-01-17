import java.util.*;
/*
	Programmer: Alejandro Parana
	The first algorithm should minimize average delay for all jobs.
*/
public class MyPriority
{
	public static void main(String[] args)
	{
		Jobs myJobs = new Jobs();
		System.out.println(myJobs);
		
		while (!myJobs.done())
		{
			int[][] jobs = myJobs.getJobs();

			System.out.println("Clock: "+myJobs.getClock());
			System.out.println("\tJob Count: "+jobs.length);

			if (jobs.length > 0)
			{
				int currentPriority = jobs[0][2];
				int first = 0;

				for(int i = 0; i < jobs.length; i++)
				{
					if (jobs[i][2] > currentPriority)
					{
						currentPriority = jobs[i][2];
						first = i;
					}
				}

				for(int j=0; j<jobs.length; j++)
			   		System.out.println("\t\t--> Job: "+jobs[j][0]+" Duration: "+jobs[j][1]+" Priority: "+jobs[j][2]);
				System.out.println("\t(Working on Job "+jobs[first][0]+")");
				
				myJobs.cycle(jobs[first][0]);
			}

			else
			{
				myJobs.cycle();
			}
		}

		System.out.println(myJobs.report());
	}
}
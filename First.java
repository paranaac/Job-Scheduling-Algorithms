/*
	Programmer: Alejandro Parana

	Whichever job arrives first is processed first. 
	If two jobs arrive at the same time, the one with the lower job ID is processed first.
*/

public class First
{
	public static void main(String[] args)
	{
		Jobs jobsource = new Jobs();
		System.out.println(jobsource);
		
		while(!jobsource.done())
		{
			int[][] jobs = jobsource.getJobs();
			
			System.out.println("Clock: "+jobsource.getClock());
			System.out.println("\tJob Count: "+jobs.length);
			
			if(jobs.length > 0)
			{
				for(int j=0; j<jobs.length; j++)
					System.out.println("\t\tJob:"+jobs[j][0]+" Duration:"+jobs[j][1]+" Priority:"+jobs[j][2]);

				System.out.println("\t(Working on Job " + jobs[0][0]+")");
				
				jobsource.cycle(jobs[0][0]);
			}

			else
			{
				jobsource.cycle();
			}
		}
		
		System.out.println(jobsource.report());
	}
}
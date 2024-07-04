package io.ytong.stanfordalgorithm.c3w1;

import java.util.Arrays;

public class JobSchedulerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jobFile = "c3w1/jobs.txt";
		JobSchedulerHelper jobScheudlerHelper = new JobSchedulerHelper(jobFile);	
		Job[] jobs = jobScheudlerHelper.getJobs();
		
		// sort by greedy algorithm one
		Arrays.sort(jobs, new JobComparator());
		
		// calculate total weighted completion time
		int completionTime = 0;
		long totalWeightedCompletionTime = 0;
		for (int i=0; i<jobs.length; i++) {
			completionTime += jobs[i].getLength();
			totalWeightedCompletionTime += jobs[i].getWeight() * completionTime;
		}
		System.out.println(String.format("Total weighted completion time : %s", totalWeightedCompletionTime));
	}

}

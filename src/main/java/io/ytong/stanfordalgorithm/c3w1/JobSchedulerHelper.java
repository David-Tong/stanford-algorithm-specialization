package io.ytong.stanfordalgorithm.c3w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class JobSchedulerHelper {
	private String jobFile;
	
	public JobSchedulerHelper(String jobFile) {
		this.jobFile = jobFile;
	}
	
	public Job[] getJobs() {
		Job[] jobs = null;
		try (
			InputStream inputStream = getFileFromResourceAsStream();
			InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
			BufferedReader reader = new BufferedReader(streamReader)) {
				String line;
				int index = 0;
				while((line = reader.readLine()) != null) {
					String[] tuples = line.split("\\s+");
					if (index == 0) {
						Integer jobNumber = Integer.parseInt(tuples[0]);
						jobs = new Job[jobNumber];
					} else {
						Integer weight = Integer.parseInt(tuples[0]);
						Integer length = Integer.parseInt(tuples[1]); 
						jobs[index - 1] = new Job(weight, length);
					}	
					index += 1;
				}		
		} catch (IOException e) {
	        e.printStackTrace();
	    }
		
		if (jobs == null) {
			throw new NullPointerException();
		}
		
		return jobs;
	}
	
	private InputStream getFileFromResourceAsStream() {
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(this.jobFile);
		
		if (inputStream == null) {
			throw new IllegalArgumentException("file not found!" + this.jobFile);
		} else {
			return inputStream;
		}
	}
}

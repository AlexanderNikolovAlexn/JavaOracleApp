package com.samodeika.JavaOracleApp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
	public static void main(String[] args) {

		int tasks = 1000;
		
		ExecutorService executor = Executors.newFixedThreadPool(8);

		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < tasks; i++) {
			executor.submit(new MultiProcessor(i));
		}

		executor.shutdown();

		System.out.println("All tasks submitted");

		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();

		System.out.println("All tasks completed in " + (double)((endTime - startTime) / 1000.0) + " seconds");
		// 4  Threads -> 18.603 seconds
		// 8  Threads -> 18.145 seconds
		// 16 Threads -> 18.345 seconds
		// 1  Thread  -> 4.321 seconds
	}
}

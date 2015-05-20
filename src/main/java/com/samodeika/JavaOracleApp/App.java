package com.samodeika.JavaOracleApp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
	public static void main(String[] args) {

		int tasks = 50;
		
		ExecutorService executor = Executors.newFixedThreadPool(5);

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

		System.out.println("All tasks completed");

	}
}

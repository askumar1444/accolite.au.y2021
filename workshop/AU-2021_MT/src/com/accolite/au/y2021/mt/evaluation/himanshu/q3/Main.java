package com.accolite.au.y2021.mt.evaluation.himanshu.q3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Review: Sree - Use separate source files for each classes.
// Review: Sree - Use Proper names for classes.

class Deadlock {
	static final String Resource1 = "Resouce1";
	static final String Resource2 = "Resouce2";

	public static class Thread1 implements Callable<String> {
		@Override
		public String call() throws Exception {
			synchronized (Resource1) {
				System.out.println("Thread 1: Locked Resource 1");
				try {
					Thread.sleep(100);
				} catch (Exception e) {
				}
				synchronized (Resource2) {
					System.out.println("Thread 1: Locked Resource 2");
				}
			}
			return "grbg";

		}
	}

	public static class Thread2 implements Callable<String> {
		@Override
		public String call() throws Exception {
			synchronized (Resource2) {
				System.out.println("Thread 2: Locked Resource 2");
				try {
					Thread.sleep(100);
				} catch (Exception e) {
				}
				synchronized (Resource1) {
					System.out.println("Thread 2: Locked Resource 1");
				}
			}
			return "grbg";
		}
	}
}

public class Main {
	public static void main(String[] args) {
		Deadlock.Thread1 t1 = new Deadlock.Thread1();
		Deadlock.Thread2 t2 = new Deadlock.Thread2();
		ExecutorService ex = Executors.newFixedThreadPool(2);
		Future<String> f1 = ex.submit(t1);
		Future<String> f2 = ex.submit(t2);
		System.out.println(f1);
		System.out.println(f2);
	}
}
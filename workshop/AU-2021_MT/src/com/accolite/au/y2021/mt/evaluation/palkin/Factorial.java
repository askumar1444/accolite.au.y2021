package com.accolite.au.y2021.mt.evaluation.Palkin.q4;
import java.util.*;

//q-4
//Print Factorial series.
//	- Each number in the series should be printed by a unique thread.
//	- Do not use anything from the concurrent package. 
//	- After the series is printed, a report should be printed displaying which thread(name) printed which number.

class Assignment {
	
	private long fact;
	private String threadName;
	private int threadActive;
	
	public Assignment(long fact , String threadName , int threadActive) {
		this.fact = fact;
		this.threadName = threadName;
		this.threadActive = threadActive;
	}
	
	
	public long getFact() {
		return fact;
	}
	
	public String getThreadName() {
		return threadName;
	}

	// setter and  getter of threadActive
	public int getThreadActive() {
		return threadActive;
	}
	
	public void setThreadActive(int threadActive) {
		this.threadActive = threadActive;
	}
	
	
	
}

public class Factorial implements Runnable {
	
	public static ArrayList<Assignment> assign = new ArrayList<Assignment>();
	private static int count;
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("N: ");
		int num = sc.nextInt();
		
		count = num;
		
		Factorial f = new Factorial();
		f.series(num);
		
		for(Assignment ass : assign) {
			if(ass.getFact() == 1) {
				System.out.print(ass.getFact());
			}
			else {
				System.out.print(ass.getFact() + "*");
			}
		}
		
		System.out.println();
		System.out.println("Palkin");
		
		for(Assignment ass : assign) {
			System.out.println(ass.getFact() + " printed by " + ass.getThreadName() + " " + ass.getThreadActive());
		}
		
		sc.close();
	}
	public void series(int num) throws Exception{
		for(int i=0;i<num;i++) {
			Thread th = new Thread(new Factorial());
			th.start();
		}
	}
	
	public synchronized void generate() throws Exception{
		ThreadGroup tg = Thread.currentThread().getThreadGroup();
		assign.add(new Assignment(count-- , Thread.currentThread().getName(),tg.activeCount()));
	}
	
	
	@Override 
	public void run() {
		synchronized (this) {
			try {
				generate();
				notify();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			try {
				wait();
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	public static int getCount() {
		return count;
	}
	
	public static void setCount(int count) {
		Factorial.count = count;
	}
}



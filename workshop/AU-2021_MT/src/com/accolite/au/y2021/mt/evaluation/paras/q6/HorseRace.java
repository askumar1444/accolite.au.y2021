package com.accolite.au.y2021.mt.evaluation.paras.q6;

import java.util.*;

class HorseRace extends Thread {
	Horse horse;
	Result rs;
	int gap;
	static int num;
	static int distance;

	HorseRace(Horse h, Result rs, int gap) {
		this.horse = h;
		this.rs = rs;
		this.gap = gap;

	}

	/* Review Sree: Program should print total distance covered by each horses.
	 * 
	 */
	
	public void run() {
		do {
			synchronized (this) {
				Thread race = Thread.currentThread();
				if (horse.distanceCovered >= distance) {
					rs.list.add(horse);
					rs.count++;
					break;
				}
				/* Review Sree: Ideally there should be only 1 instance of this thread & the same should get started along with the Horses.
				 * Make sure all the speed changes including the initial speed are assigned to horses are by this thread.
				 * Also, make sure no threads are assigned speed concurrently - only 1 at a time.
				 */
				SpeedSetter ss = new SpeedSetter(horse);
				ss.start();
				try {
					ss.join();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				/* Review Sree: Ideally there should be only 1 instance of this thread & the same should get started along with the Horses.
				 */
				Statics s = new Statics(horse, race.getName(), gap);
				s.start();

			}
		} while (true);
		if (rs.count == num) {
			System.out.println("Race Finish...............");
			for (int i = 1; i <= rs.list.size(); i++) {
				Horse horse = rs.list.get(i - 1);
				if (i == 1)
					System.out.println(horse.name + "->" + "is at position " + i + "\n" + "Top speed during race" + "->"
							+ horse.topSpeed + "m/s" + "\n" + "Lowest Speed During Race" + "->" + horse.lowSpeed + "m/s"
							+ "\n" + "Average Speed was" + "->" + horse.averageSpeed + "m/s" + "\n"
							+ "Speed Transition History" + "->"
							+ horse.speedHistory.substring(0, horse.speedHistory.length() - 2) + "\n"
							+ "time taken to complete the race ->" + horse.timeTaken + "s" + "\n");

				else {
					System.out.println(horse.name + "->" + "is at position " + i + "\n" + "Top speed during race" + "->"
							+ horse.topSpeed + "m/s" + "\n" + "Lowest Speed During Race" + "->" + horse.lowSpeed + "m/s"
							+ "\n" + "Average Speed was" + "->" + horse.averageSpeed + "m/s" + "\n"
							+ "Speed Transition History" + "->"
							+ horse.speedHistory.substring(0, horse.speedHistory.length() - 2) + "\n"
							+ "time taken to complete the race ->" + horse.timeTaken + "s" + "\n");
				}
				System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			}
		}
	}

	public static void main(String[] args) {
		java.util.Scanner scn = new Scanner(System.in);
		System.out.println("input Number Of Horses:");
		num = scn.nextInt();
		System.out.println("input Speed Change Gap:");
		int gap = scn.nextInt();
		System.out.println("input Distance To Be Covered in meters ex 1000,5000 etc:");
		distance = scn.nextInt();

		Result rs = new Result();
		for (int i = 0; i < num; i++) {
			HorseRace h1 = new HorseRace(new Horse("horse" + i), rs, gap);
			h1.start();

		}
		scn.close();
	}
}

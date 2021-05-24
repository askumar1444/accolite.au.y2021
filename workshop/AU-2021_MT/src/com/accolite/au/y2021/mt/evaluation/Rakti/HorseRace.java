package com.accolite.au.y2021.mt.evaluation.Rakti;
import java.util.*;

class HorseRace extends Thread {
	Horse horse;
	Result r;
	static int distance = 1000;
	static int n;
	
	HorseRace(Horse h, Result r) {
		this.horse = h;
		this.r = r;

	}

	public void run() {
		do 
		{
			synchronized (this)
			{
				Thread race = Thread.currentThread();
				if (horse.distanceCovered >= distance) {
					r.list.add(horse);
					r.count++;
					break;
				}
				SpeedClass ss = new SpeedClass(horse);
				ss.start();
				try 
				{
					ss.join();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				} 
				Check s = new Check(horse, race.getName());
				s.start();

			}
		} 
		
		while (true);
		if (r.count == n)
		{
			System.out.println("Horse Race is Finished ");
			System.out.println("============================================================");
			for (int i = 1; i <= r.list.size(); i++) 
			{
				Horse horse = r.list.get(i - 1);
				if (i == 1)
				{
			System.out.println(horse.name +" scored position " + i );
			System.out.println("Top speed : " + horse.topSpeed + "m/s" );
			System.out.println( "Lowest speed : "+ horse.lowSpeed + "m/s");
			System.out.println("Average Speed : " + horse.averageSpeed + "m/s" );
			System.out.println("All the speed of horse are : "+ horse.speedHistory.substring(0, horse.speedHistory.length() - 2));
				}
				else {
				
					System.out.println(horse.name +" scored position " + i );
					System.out.println("Top speed : " + horse.topSpeed + "m/s" );
					System.out.println( "Lowest speed : "+ horse.lowSpeed + "m/s");
					System.out.println("Average Speed : " + horse.averageSpeed + "m/s" );
					System.out.println("All the speed of horse are : "+ horse.speedHistory.substring(0, horse.speedHistory.length() - 2));
						
				}
				System.out.println("=============================================================================");
			}
		}
	}

	public static void main(String[] args) {
		Result r = new Result();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter how many horses for race: ");
		 n=sc.nextInt();
		
		for (int i = 0; i < n; i++)
		{ 
			HorseRace h = new HorseRace(new Horse("Horse " + i), r);
			h.start();

		}

	}
}


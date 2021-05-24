package package com.accolite.au.y2021.mt.evaluation.Rakti;

public class Check extends Thread{

	Horse horse;
	String Tname;

	public Check(Horse h, String Tname) {
		horse = h;
		this.Tname = Tname;

	}

	public void run() {
		
		synchronized (this) {
			horse.speeds += horse.speed;
			horse.totallSpeedChanges += 1;
			horse.speedHistory += horse.speed + "m/s   ";
			horse.distanceCovered += horse.speed * 10;
			horse.averageSpeed = horse.speeds / horse.totallSpeedChanges;

			if (horse.topSpeed < horse.speed)
				horse.topSpeed = horse.speed;
			
			if (horse.lowSpeed > horse.speed)
				horse.lowSpeed = horse.speed;
		}
	}
}

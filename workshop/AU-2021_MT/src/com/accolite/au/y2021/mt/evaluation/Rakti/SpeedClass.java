package com.accolite.au.y2021.mt.evaluation.Rakti;

public class SpeedClass extends Thread{
	Horse horse;

	public SpeedClass(Horse horse) {
		this.horse = horse;
	}

	public void run() {
		horse.speed = ((int) (((Math.random() * 10) + 40) + (Math.random() * 10)));
	}
}

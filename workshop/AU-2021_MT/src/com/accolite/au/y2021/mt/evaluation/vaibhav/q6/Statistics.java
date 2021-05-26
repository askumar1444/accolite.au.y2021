package com.accolite.au.y2021.mt.evaluation.vaibhav.q6;

import java.util.ArrayList;

public class Statistics implements Runnable {
	ArrayList<Horse> hr;

	Statistics(ArrayList<Horse> hr) {
		this.hr = hr;

	}

	public void run() {

		synchronized (this) {
			for (int i = 0; i < hr.size(); i++) {
				while (hr.get(i).flag != 1) {

					hr.get(i).distanceRemaining = hr.get(i).track_Distance - hr.get(i).distanceCov;

					if (hr.get(i).distanceRemaining < hr.get(i).speed) {
						hr.get(i).timeTaken += (float) hr.get(i).distanceRemaining / hr.get(i).speed;
						hr.get(i).distanceCov = hr.get(i).track_Distance;

					}

					else {

						if (hr.get(i).history.contains(hr.get(i).speed + "")) {
							
							// Review: Sree - why another thread?
							Thread rs = new Thread();
							rs.start();
						} else {

							hr.get(i).history.add(hr.get(i).speed + "m/s ");

						}
						hr.get(i).timeTaken += 1;
						hr.get(i).distanceCov += hr.get(i).speed;

						hr.get(i).averageSpeed = (float) hr.get(i).track_Distance / hr.get(i).timeTaken;

						if (hr.get(i).topSpeed < hr.get(i).speed) {
							hr.get(i).topSpeed = hr.get(i).speed;
						}

						if (hr.get(i).lowSpeed > hr.get(i).speed) {
							hr.get(i).lowSpeed = hr.get(i).speed;
						}
					}
				}
			}
		}

	}
}

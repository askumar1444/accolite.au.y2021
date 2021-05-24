package com.accolite.au.y2021.mt.evaluation.vaibhav.q6;

import java.util.concurrent.ThreadLocalRandom;

public class Horse {

    String horseName;

	public Horse(String horseName) {
		this.horseName = horseName;

	}

	// Review : Sree -- You should accumulate the distances covered in each lap & print that as distance covered - not the input value.
    int totalDistance = 1000; 
    // Review : Sree -- Speed should be assigned by only the speed setter thread.
    int speed = ThreadLocalRandom.current().nextInt(40, 60 + 1); 
    float timeTaken = 0; 
    int distanceCovered = 0; 
    float averageSpeed = 0; 
    int topSpeed = Integer.MIN_VALUE; 
    int lowSpeed = Integer.MAX_VALUE; 
    String speedHistory = ""; 
    int distanceRemaining; 

}

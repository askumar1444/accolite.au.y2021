package com.accolite.au.y2021.mt.evaluation.vaibhav.q6;

public class Statistics implements Runnable {

    String horseName; 
    Horse reference; 


	Statistics(Horse reference, String horseName) {
		this.reference = reference;
		this.horseName = horseName;

	}

	int count = 0;

	public void run() {
		synchronized (this) {
			
			reference.distanceRemaining = reference.totalDistance - reference.distanceCovered;
			if (reference.distanceRemaining < reference.speed) {
			
				reference.timeTaken += (float) reference.distanceRemaining / reference.speed;
				reference.distanceCovered = reference.totalDistance;
			}


		else {


                reference.speedHistory += reference.speed + "m/s || ";

                reference.distanceCovered += reference.speed; 

                reference.timeTaken += 1; 

                reference.averageSpeed = (float) reference.distanceCovered / reference.timeTaken; 

               
                if (reference.topSpeed < reference.speed) {
                    reference.topSpeed = reference.speed;
                }
               
                if (reference.lowSpeed > reference.speed) {
                    reference.lowSpeed = reference.speed;
                }
            
	    }

	}
   }
}

package com.accolite.au.y2021.mt.evaluation.vaibhav.q6;

public class Statistics implements Runnable {
    String horseName;
    Horse reference;
    RandomSpeed random;

    Statistics(Horse reference, String horseName) {
        this.reference = reference;
        this.horseName = horseName;

    }

    public void run() {

        synchronized (this) {

            while (reference.flag != 1) {

                reference.distanceRemaining = reference.track_Distance - reference.distanceCov;
                if (reference.distanceRemaining < reference.speed) {

                    reference.timeTaken += (float) reference.distanceRemaining / reference.speed;
                    reference.distanceCov = reference.track_Distance;

                }

                else {

                    if (reference.history.contains(reference.speed + "")) {
                        Thread rs = new Thread();
                        rs.start();
                    } else {

                        reference.history.add(reference.speed + "m/s ");

                    }
                    reference.timeTaken += 1;
                    reference.distanceCov += reference.speed;

                    reference.averageSpeed = (float) reference.track_Distance / reference.timeTaken;

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
}

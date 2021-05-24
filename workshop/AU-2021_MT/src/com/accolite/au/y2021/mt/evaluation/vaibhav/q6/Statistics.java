package com.accolite.au.y2021.mt.evaluation.vaibhav.q6;


public class Statistics implements Runnable {
    String horseName;
    Horse reference;
    RandomSpeed random;

    Statistics(Horse reference, String horseName, RandomSpeed random) {
        this.reference = reference;
        this.horseName = horseName;
        this.random = random;

    }

    int count = 0;

    public void run() {

        synchronized (this) {

            if (reference.history.contains(reference.speed + "")) {
                Thread rs = new Thread();
                rs.start();
            } else {
                reference.history.add(reference.speed + "m/s ");
            }

            reference.timeTaken += 1;
            reference.averageSpeed = (float) reference.distanceCov / reference.timeTaken;

            if (reference.topSpeed < reference.speed) {
                reference.topSpeed = reference.speed;
            }

            if (reference.lowSpeed > reference.speed) {
                reference.lowSpeed = reference.speed;
            }
        }

    }
}

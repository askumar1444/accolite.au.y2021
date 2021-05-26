package com.accolite.au.y2021.mt.evaluation.vaibhav.q6;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

class Race implements Runnable {
    Horse reference;
    Outcome outcome;
    int N;

    Race(Horse reference, Outcome outcome, int N) {
        this.reference = reference;
        this.outcome = outcome;
        this.N = N;

    }

    public void run() {

        while (true) {
            if (reference.distanceCov >= reference.track_Distance) {
                outcome.al.add(reference);
                reference.flag = 1;

                outcome.count++;
                break;
            }

            reference.distanceRemaining = reference.track_Distance - reference.distanceCov;
            if (reference.distanceRemaining < reference.speed) {

                reference.timeTaken += (float) reference.distanceRemaining / reference.speed;
                reference.distanceCov = reference.track_Distance;

            }

        }

        HashMap<Horse, Number> map = new HashMap<Horse, Number>();

        if (outcome.count == N) {

            for (int i = 0; i < outcome.al.size(); i++) {
                if (!map.containsKey(outcome.al.get(i))) {
                    map.put(outcome.al.get(i), outcome.al.get(i).averageSpeed);
                }

            }
            int counter = 0;

            DecimalFormat df = new DecimalFormat(".##");

            for (Map.Entry<Horse, Number> hashMap : map.entrySet()) {
                if (counter == 0) {
                    System.out.println("---------- WINNER ---------- is " + hashMap.getKey().horseName);
                    System.out.println();
                    System.out.println("Horse Name = " + hashMap.getKey().horseName + "\nDistance Covered : "
                            + hashMap.getKey().distanceCov + "\nTime Taken : " + df.format(hashMap.getKey().timeTaken)
                            + "\nAverage Speed : " + df.format(hashMap.getKey().averageSpeed) + "\nMinimum Speed : "
                            + hashMap.getKey().lowSpeed + "\nMaximum Speed : " + hashMap.getKey().topSpeed
                            + "\nSpeed history : " + hashMap.getKey().history.toString());
                    counter++;
                    System.out.println();
                } else {
                    System.out.println(
                            "------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Horse Name = " + hashMap.getKey().horseName + "\nDistance Covered : "
                            + hashMap.getKey().distanceCov + "\nTime Taken : " + df.format(hashMap.getKey().timeTaken)
                            + "\nAverage Speed : " + df.format(hashMap.getKey().averageSpeed) + "\nMinimum Speed : "
                            + hashMap.getKey().lowSpeed + "\nMaximum Speed : " + hashMap.getKey().topSpeed
                            + "\nSpeed history : " + hashMap.getKey().history.toString());
                }
            }
        }

    }
}


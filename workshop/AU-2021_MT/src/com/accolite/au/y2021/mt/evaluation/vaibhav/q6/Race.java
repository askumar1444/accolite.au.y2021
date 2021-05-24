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
        do {
            synchronized (this) {

                
                if (reference.distanceCovered == reference.totalDistance) {
                    outcome.al.add(reference);
                    outcome.count++;
                    break;
                }
              
                if (reference.timeTaken % 5 == 0) {
                	// Review : Sree -- There should be only one thread instances of this type and should be started along with the horses. This thread should process only one thread at a time.
                    RandomSpeed rs = new RandomSpeed(reference);
                    Thread th = new Thread(rs);
                    th.start();

                }
                
                // Review : Sree -- There should be only one thread instances of this type and should be started along with the horses.
                Statistics sta = new Statistics(reference, Thread.currentThread().getName());
                Thread thd = new Thread(sta);
                thd.start();
          
                try {
                    thd.join();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } while (true);

    
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
                            + hashMap.getKey().distanceCovered + "\nTime Taken : "
                            + df.format(hashMap.getKey().timeTaken) + "\nAverage Speed : "
                            + df.format(hashMap.getKey().averageSpeed) + "\nMinimum Speed : "
                            + hashMap.getKey().lowSpeed + "\nMaximum Speed : " + hashMap.getKey().topSpeed
                            + "\nSpeed history at each instance : " + hashMap.getKey().speedHistory);
                    counter++;
                    System.out.println();
                } else {
                    System.out.println(
                            "------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Horse Name = " + hashMap.getKey().horseName + "\nDistance Covered : "
                            + hashMap.getKey().distanceCovered + "\nTime Taken : "
                            + df.format(hashMap.getKey().timeTaken) + "\nAverage Speed : "
                            + df.format(hashMap.getKey().averageSpeed) + "\nMinimum Speed : "
                            + hashMap.getKey().lowSpeed + "\nMaximum Speed : " + hashMap.getKey().topSpeed
                            + "\nSpeed history at each instance : " + hashMap.getKey().speedHistory);
                }
            }

        }
    }
}

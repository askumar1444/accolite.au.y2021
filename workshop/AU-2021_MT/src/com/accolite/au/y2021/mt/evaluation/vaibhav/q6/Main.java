package com.accolite.au.y2021.mt.evaluation.vaibhav.q6;

import java.util.*;

class Outcome {
    ArrayList<Horse> al;
    int count = 0;

    Outcome() {
        al = new ArrayList<>();
    }
}

public class Main extends Thread {

    public static void main(String args[]) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of horses you want to race : ");
        int N = sc.nextInt();
        System.out.print("Enter distance of the track : ");
        int track_Distance = sc.nextInt();
        System.out.println();
        Outcome outcome = new Outcome();

        for (int i = 1; i <= N; i++) {

            Horse rs = new Horse("Horse " + i);
            rs.track_Distance = track_Distance;

            RandomSpeed random = new RandomSpeed(rs, rs.horseName);
            Thread randomTh = new Thread(random);

            Statistics stats = new Statistics(rs, Thread.currentThread().getName());
            Thread thd = new Thread(stats);

            Race race = new Race(rs, outcome, N);
            Thread raceTh = new Thread(race);

            try {
                randomTh.start();
                thd.start();
                raceTh.start();

                randomTh.interrupt();
                raceTh.interrupt();
                thd.interrupt();

                randomTh.join();
                thd.join();
                raceTh.join();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        sc.close();
    }

}

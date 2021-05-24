package com.accolite.au.y2021.mt.evaluation.vaibhav.q6;

import java.util.*;

class Outcome {
    ArrayList<Horse> al;
    int count = 0;

    Outcome() {
        al = new ArrayList<>();
    }
}

public class Main {

    // void calculte_Distance(int track_Distance) {
    // int distanceCov = 0;
    // int distanceRemaining=0;
    // distanceRemaining = track_Distance -distanceCov;

    // }

    public static Thread raceTh;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of horses you want to race : ");
        int N = sc.nextInt();
        System.out.print("Enter distance of the track : ");
        int track_Distance = sc.nextInt();
        System.out.println();
        Outcome outcome = new Outcome();

        for (int i = 1; i <= N; i++) {

            Horse rs = new Horse("Horse " + i);
            RandomSpeed random = new RandomSpeed(rs);
            Thread randomTh = new Thread(random);
            randomTh.start();
            try {
                randomTh.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Statistics stats = new Statistics(rs, Thread.currentThread().getName(), random);

            Race race = new Race(rs, outcome, N, stats, random);

            raceTh = new Thread(race);
            raceTh.start();

            rs.track_Distance = track_Distance;

        }

        sc.close();

    }

}

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

        Store in = new Store();
        for (int i = 1; i <= N; i++) {

            Horse rs = new Horse("Horse " + i);
            rs.track_Distance = track_Distance;
            in.hr.add(rs);
        }
        in.startRandomAndStatsThread();
        in.startHorsethread();
        sc.close();
    }

}

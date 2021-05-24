package com.accolite.au.y2021.mt.evaluation.vaibhav.q6;

import java.util.*;


class Outcome {
    ArrayList<Horse> al; 
    int count = 0;

    Outcome() {
        al = new ArrayList<>();
    }
}

//Review : Sree -- Program should take track length as an input rather than hard coding it to 100
//Review : Sree -- No threads should be running with same speed in consecutive laps.

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); 
        Outcome outcome = new Outcome();
        for (int i = 1; i <= N; i++) {
         
            Race r = new Race(new Horse("Horse " + i), outcome, N);

            Thread th = new Thread(r);
            th.start();

        }
        sc.close();

    }

}

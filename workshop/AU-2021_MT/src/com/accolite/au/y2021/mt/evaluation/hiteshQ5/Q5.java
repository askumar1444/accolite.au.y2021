package com.accolite.au.y2021.mt.evaluation.hiteshQ5;

import com.accolite.au.y2021.mt.evaluation.hiteshQ5.model.Counter;
import com.accolite.au.y2021.mt.evaluation.hiteshQ5.threads.ThreadRunner;
import java.util.Scanner;


/**
 *  Problem Statement :- Three threads synchronization.
 * 	- Thread-1 is incrementing a counter(c1) value by 1 'n' times.
 * 	- When ever counter value is multiple of 25, then Thread-2 should increment another counter say c2 by 2;
 * 	- Whenever c2 is a multiple of 4 then another thread T3 should update counter c3 by 1;
 *
 * 	Output:-
 * 	- Finally print all the counters.
 *
 * 	Constraints:-
 * 	- Only input to the program should be 'n'.
 * 	- DO NOT Use anything from concurrent package
 *
 * @author HiteshChopra
 **/
class Q5 {

    public static void main(String[] args) throws InterruptedException {

        // Scanner Taking Inputs
        Scanner scn = new Scanner(System.in);

        // MaxCount Till which the pointers should be incremented.
        int n = scn.nextInt();

        Counter counter = new Counter(n);

        // Runner to Create Threads
        ThreadRunner threadRunner = new ThreadRunner();
        threadRunner.excecuteThreads(counter);
    }
}
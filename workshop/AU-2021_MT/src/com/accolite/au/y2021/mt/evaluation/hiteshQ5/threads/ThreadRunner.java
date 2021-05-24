package com.accolite.au.y2021.mt.evaluation.hiteshQ5.threads;

import com.accolite.au.y2021.mt.evaluation.hiteshQ5.model.Counter;
import com.accolite.au.y2021.mt.evaluation.hiteshQ5.threads.Thread1;
import com.accolite.au.y2021.mt.evaluation.hiteshQ5.threads.Thread2;
import com.accolite.au.y2021.mt.evaluation.hiteshQ5.threads.Thread3;


/**
 * Thread Runner Class To create And start All Threads.
 **/
public class ThreadRunner {

    public void excecuteThreads(Counter counter) {

        Thread1 thread1 = new Thread1(counter);
        Thread2 thread2 = new Thread2(counter);
        Thread3 thread3 = new Thread3(counter);

        System.out.println("Starting Executing Threads");
        start(thread1);
        start(thread2);
        start(thread3);
    }

    public void start(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.start();
    }
}

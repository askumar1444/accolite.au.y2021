package com.accolite.au.y2021.mt.evaluation.hiteshQ5.threads;

import com.accolite.au.y2021.mt.evaluation.hiteshQ5.model.Counter;

/**
 * Thread 3 Class Used to Increment the counter by 1 whenever the Counter Incremented by Thread2 is an multiple of 4.
 **/
public class Thread3 implements Runnable {
    Counter counter;

    public Thread3(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.getC1() <= counter.getMaxCount()) {
            if (counter.getC2() % 4 == 0 && counter.getC2() != 0 && !counter.isThirdConsumed()) {
                counter.increment3();
                counter.setThirdConsumed(true);
                System.out.println("Counter 3-> " + counter.getC3());
                counter.notifyOthers();
            }
        }
    }
}

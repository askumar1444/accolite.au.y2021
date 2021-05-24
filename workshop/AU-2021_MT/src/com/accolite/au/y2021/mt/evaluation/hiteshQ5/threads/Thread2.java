package com.accolite.au.y2021.mt.evaluation.hiteshQ5.threads;

import com.accolite.au.y2021.mt.evaluation.hiteshQ5.model.Counter;

/**
 * Thread 2 Class Used to Increment the counter by 2 whenever the Counter Incremented by Thread1 is an multiple of 25.
 **/
public class Thread2 implements Runnable {

    Counter counter;

    public Thread2(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.getC1() <= counter.getMaxCount()) {
            if (counter.getC1() % 25 == 0 && counter.getC1() != 0 && !counter.isSecondConsumed()) {
                counter.increment2();
                if (!counter.isThirdConsumed()) {
                    counter.takeWait();
                }
                // Review : Sree -- This thread should not modify state of another thread.
                if (counter.getC2() % 4 == 0 && counter.getC2() != 0) {
                    counter.setThirdConsumed(false);
                }
                counter.setSecondConsumed(true);
                System.out.println("Counter 2-> " + counter.getC2());
                counter.notifyOthers();
                counter.takeWait();
            }
        }
    }
}

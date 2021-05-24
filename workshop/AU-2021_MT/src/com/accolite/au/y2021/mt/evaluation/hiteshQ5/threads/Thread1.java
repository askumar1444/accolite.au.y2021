package com.accolite.au.y2021.mt.evaluation.hiteshQ5.threads;

import com.accolite.au.y2021.mt.evaluation.hiteshQ5.model.Counter;


/**
 * Thread 1 Class Used to Increment the counter till Max Value.
 **/
public class Thread1 implements Runnable {
    Counter counter;

    public Thread1(Counter counter) {
        this.counter = counter;
    }

    @Override public void run() {
        while (counter.getC1() < counter.getMaxCount()) {
            counter.increment1();
            System.out.println(
                Thread.currentThread().getName() + " Incremented Counter1 By 1 and Counter Becomes-> " + counter
                    .getC1());
            if (!counter.isSecondConsumed() || !counter.isThirdConsumed()) {
                counter.takeWait();
            }
            if (counter.getC1() % 25 == 0 && counter.getC1() != 0) {
                counter.setSecondConsumed(false);
                counter.notifyOthers();
                counter.takeWait();
            }
        }
        while (!counter.isSecondConsumed() && !counter.isThirdConsumed()) ;
        counter.notifyOthers();
        counter.setTerminateExecution(true);
    }
}

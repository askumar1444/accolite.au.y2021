package com.accolite.au.y2021.mt.evaluation.vaibhav.q5;

class ThreadTwo implements Runnable {
    Counter count;

    public ThreadTwo(Counter count) {
        this.count = count;
    }

    Main mainObject = new Main();

    @Override
    public synchronized void run() {
        while (count.isCounting) {
            mainObject.refershResult(() -> {
                if (count.previousCounterValue2 != count.counter1) {
                    count.previousCounterValue2 = count.counter1;
                    if (count.counter1 % 25 == 0) {
                        count.counter2 += 2;
                    }
                }
            });
        }
    }

}
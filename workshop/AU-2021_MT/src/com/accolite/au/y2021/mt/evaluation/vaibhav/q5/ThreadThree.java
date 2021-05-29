package com.accolite.au.y2021.mt.evaluation.vaibhav.q5;

class ThreadThree implements Runnable {
    Counter count;

    public ThreadThree(Counter count) {
        this.count = count;
    }

    Main mainObject = new Main();

    @Override
    public synchronized void run() {
        while (count.isCounting) {
            mainObject.refershResult(() -> {
                if (count.previousCounterValue3 != count.counter1) {
                    count.previousCounterValue3 = count.counter1;
                    if (count.counter1 % 4 == 0) {
                        count.counter3 += 1;
                    }
                }
            });
        }
    }

}
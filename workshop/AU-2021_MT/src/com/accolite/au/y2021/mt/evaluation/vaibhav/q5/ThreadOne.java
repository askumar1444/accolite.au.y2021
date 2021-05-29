package com.accolite.au.y2021.mt.evaluation.vaibhav.q5;

class ThreadOne implements Runnable {
    Counter count;
    int n;

    public ThreadOne(Counter count, int n) {
        this.count = count;
        this.n = n;
    }

    Main mainObject = new Main();

    @Override
    public synchronized void run() {

        while (count.isCounting) {
            mainObject.refershResult(() -> {
                if ((count.previousCounterValue2 == count.counter1)
                        && (count.previousCounterValue3 == count.counter1)) {
                    count.counter1 += 1;
                    if (count.counter1 == n) {
                        count.isCounting = false;

                    }
                }

            });
        }

    }

}
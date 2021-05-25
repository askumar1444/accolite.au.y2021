package com.accolite.au.y2021.mt.evaluation.vaibhav.q6;

class RandomSpeed implements Runnable {
    Horse reference;
    String horseName;

    public RandomSpeed(Horse reference, String horseName) {
        this.reference = reference;
        this.horseName = horseName;
    }

    int minSpeed = 40;
    int maxSpeed = 60;
    int range = maxSpeed - minSpeed + 1;
    int count = 0;

    public synchronized void run() {

        System.out.print("Random" + reference.horseName);
        while (reference.flag != 1 && reference.horseName == horseName) {

            if (count == 0) {
                reference.speed = (int) (Math.random() * range) + minSpeed;

                count++;

            } else if (reference.timeTaken % 5 == 0) {

                reference.speed = (int) (Math.random() * range) + minSpeed;

            }

        }

    }

}

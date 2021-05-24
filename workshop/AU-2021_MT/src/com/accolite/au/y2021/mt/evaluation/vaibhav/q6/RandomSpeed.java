package com.accolite.au.y2021.mt.evaluation.vaibhav.q6;

class RandomSpeed implements Runnable {
    Horse reference;
    public RandomSpeed(Horse reference) {
        this.reference = reference;
    }

    int minSpeed = 40;
    int maxSpeed = 60;
    int range = maxSpeed - minSpeed + 1;

    public void run() {
        reference.speed = (int) (Math.random() * range) + minSpeed; 
    }
}

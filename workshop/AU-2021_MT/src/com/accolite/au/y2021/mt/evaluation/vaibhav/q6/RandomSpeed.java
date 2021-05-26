package com.accolite.au.y2021.mt.evaluation.vaibhav.q6;

import java.util.ArrayList;

class RandomSpeed implements Runnable {
    ArrayList<Horse> hr;

    RandomSpeed(ArrayList<Horse> hr) {
        this.hr = hr;
    }

    int minSpeed = 40;
    int maxSpeed = 60;
    int range = maxSpeed - minSpeed + 1;
    int count = 0;

    public synchronized void run() {

        for (int i = 0; i < hr.size(); i++) {
            while (hr.get(i).flag != 1) {
            	int speed = 0;
                if (count == 0) {
                	speed = (int) (Math.random() * range) + minSpeed;
                    count++;
                } else if (hr.get(i).timeTaken % 10 == 0) {
                	speed = (int) (Math.random() * range) + minSpeed;
                }
                hr.get(i).speed = speed;
                System.out.println(Thread.currentThread().getName() + " -- Set Speed For: " + hr.get(i).horseName + ", speed -- " + speed);
            }
        }
    }
}

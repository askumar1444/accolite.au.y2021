package com.accolite.au.y2021.mt.evaluation.aayush.q6;


import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Speed implements Runnable{

    List<Integer> speedHistory;
    Integer avgSpeed;
    int topSpeed;
    int lowSpeed;
    Horse h;

    Speed(Horse h)
    {
        this.h = h;
        speedHistory = new ArrayList<>();
        topSpeed = Integer.MIN_VALUE;
        lowSpeed = Integer.MAX_VALUE;
    }

    public void Calculation()
    {
        int speed = h.speed;
        speedHistory.add(speed);
        topSpeed = Math.max(topSpeed,speed);
        lowSpeed = Math.min(lowSpeed,speed);
    }

    @Override
    public void run() {
        Calculation();
    }
}


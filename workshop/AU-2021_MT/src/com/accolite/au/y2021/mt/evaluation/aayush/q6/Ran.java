package com.accolite.au.y2021.mt.evaluation.aayush.q6;

import java.util.Random;

public class Ran implements Runnable {

    int r=0;

    public void getrandom()
    {
        r = new Random().nextInt(20)+40;
    }

    @Override
    public void run() {
        this.getrandom();
    }
}
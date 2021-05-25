package com.accolite.au.y2021.mt.evaluation.vaibhav.q6;

import java.util.HashSet;

public class Horse {

    String horseName;

    public Horse(String horseName) {
        this.horseName = horseName;

    }

    int flag = 0;
    int track_Distance;
    int distanceCov = 0;
    int speed = 0;
    float timeTaken = 0;
    float averageSpeed = 0;
    int topSpeed = Integer.MIN_VALUE;
    int lowSpeed = Integer.MAX_VALUE;
    int distanceRemaining;
    HashSet<String> history = new HashSet<>();

}

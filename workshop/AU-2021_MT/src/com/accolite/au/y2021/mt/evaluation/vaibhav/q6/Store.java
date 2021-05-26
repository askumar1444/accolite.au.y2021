package com.accolite.au.y2021.mt.evaluation.vaibhav.q6;
import java.util.ArrayList;

public class Store {
    ArrayList<Horse> hr;

    Store() {
        hr = new ArrayList<>();
    }

    void startRandomAndStatsThread() {
        RandomSpeed random = new RandomSpeed(hr);
        Thread randomTh = new Thread(random);

        Statistics stats = new Statistics(hr);
        Thread thd = new Thread(stats);

        randomTh.start();
        thd.start();

    }

    Outcome outcome = new Outcome();

    void startHorsethread() {
        for (int i = 0; i < hr.size(); i++) {

            Race race = new Race(hr.get(i), outcome, hr.size());
            Thread raceTh = new Thread(race);

            try {
                raceTh.start();
                raceTh.interrupt();
                raceTh.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

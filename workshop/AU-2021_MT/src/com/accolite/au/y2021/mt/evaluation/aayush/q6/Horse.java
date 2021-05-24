package com.accolite.au.y2021.mt.evaluation.aayush.q6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Horse implements Runnable{
    //    Ran r = new Ran();
    static List<Winner> list=new ArrayList<>();
    int distance;
    String name;
    int speed;
    int time=0;
    Speed s;

    public Horse(String name, int speed) {
        this.name = name;
        this.speed = speed;
        this.distance=0;
        this.time = 0;
        s=new Speed(this);
    }


    @Override
    public synchronized void run()
    {
        int i;
        for(i=0;true;i++)
        {
            if(this.distance>=Main.dist)
            {
                break;
            }

//            this.time = this.distance/this.speed;
            System.out.println("===========================================");
            System.out.println("STARTED -> " + Thread.currentThread().getName());
            System.out.println("Name   Speed   Distance");
            System.out.println(this.name + "   " + this.speed+"      "+this.distance);
            System.out.println("===========================================");


            this.distance = this.distance+((speed*60)/100);

            Ran r1 = new Ran();
            Thread t = new Thread(r1);
            Thread t1 = new Thread(this.s);
            try {
                t.start();
                t.join();
                t1.start();
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                this.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.speed = r1.r;

        }

        Winner w = new Winner(this,this.distance,i,this.s);
        list.add(w);

        if(list.size()==Main.n)
        {
            winner();
        }

    }

    public static void winner()
    {
        Collections.sort(list,(a,b)->a.i==b.i?b.distance-a.distance:a.i-b.i);

        for(int i=0;i<list.size();i++)
        {
            System.out.println("*****************************************************");
            System.out.println(list.get(i).h.name+" Position -> "+(i+1));
            System.out.println("Speed History -> "+list.get(i).s.speedHistory);
            System.out.println("Average Speed -> "+list.get(i).s.speedHistory.stream().mapToInt(Integer::intValue).average());
            System.out.println("Top Speed -> "+list.get(i).s.topSpeed);
            System.out.println("Lowest Speed -> "+list.get(i).s.lowSpeed);
            System.out.println("*****************************************************");
        }

    }


}

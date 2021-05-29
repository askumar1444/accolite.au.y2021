package com.accolite.au.y2021.mt.evaluation.vaibhav.q5;
import java.util.Scanner;

class Main {
    static Counter counterObject = new Counter();

    public synchronized void refershResult(Runnable update) {
        update.run();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " Counter 1 value :: " + counterObject.counter1
                + " || Counter 2 value :: " + counterObject.counter2 + " " + " || Counter 3 value :: " + " "
                + counterObject.counter3);

    }

    public static void main(String args[]) {
        System.out.print("Enter value of N");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        ThreadOne objOne = new ThreadOne(counterObject, n);
        Thread one = new Thread(objOne);

        ThreadTwo objTwo = new ThreadTwo(counterObject);
        Thread two = new Thread(objTwo);

        ThreadThree objThree = new ThreadThree(counterObject);
        Thread three = new Thread(objThree);

        try {
            one.start();
            two.start();
            three.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
        in.close();
    }

}

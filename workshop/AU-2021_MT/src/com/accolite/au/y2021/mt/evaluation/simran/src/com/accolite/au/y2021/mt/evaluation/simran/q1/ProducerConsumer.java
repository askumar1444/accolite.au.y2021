

package com.accolite.au.y2021.mt.evaluation.simran.q1;
import java.util.*;

public class ProducerConsumer
{
   static int n;
   public static void main(String[] args)
   {
	  Scanner obj = new Scanner(System.in);
	   n=obj.nextInt();
	  
      Stack<Integer> sharedItems=new Stack<Integer>();
      Thread t1=new Thread(new Producer(sharedItems));
      Thread t2=new Thread(new Consumer(sharedItems));
      t1.start();
      t2.start();
   }
   public int func()
   {
	   return n;
   }
}




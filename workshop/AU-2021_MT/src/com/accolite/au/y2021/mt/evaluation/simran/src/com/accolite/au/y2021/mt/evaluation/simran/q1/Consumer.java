package com.accolite.au.y2021.mt.evaluation.simran.q1;

import java.util.*;

class Consumer extends ProducerConsumer implements Runnable
{
	
    Stack<Integer> sharedItems =null;
    
    int MaxSize=func();

    public Consumer(Stack<Integer> sharedItems)
    {
       super();
       this.sharedItems=sharedItems;
     }
   
     @Override
     public void run()
     {
    	System.out.println("Current Thread Name is :- " + Thread.currentThread().getName());
        while(true)
        try
        {
           consume(); 
         }
         catch(InterruptedException e)
         {
         }
      }

     public void consume() throws InterruptedException     //pop
     {
        synchronized (sharedItems)
        {
            while(sharedItems.isEmpty())
            {
               System.out.println(" Shared Items are not present..waiting for the producer to produce ");
               sharedItems.wait();
             }
         }
        
        synchronized (sharedItems)
        {
               Thread.sleep(2000);
               System.out.println(" Consumed the element "+sharedItems.remove(0)); 
               sharedItems.notify();
             }
         }             
}
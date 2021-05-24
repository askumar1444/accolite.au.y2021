package com.accolite.au.y2021.mt.evaluation.simran.q1;

import java.util.*;

class Producer extends ProducerConsumer implements Runnable 
{
    Stack<Integer> sharedItems =null;
    
    int MaxSize=func();
    
    private int i=0;
    public Producer(Stack<Integer> sharedItems)
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
           produce(i++); 
         }
         catch(InterruptedException e)
         {
         }
      }

     public void produce(int i) throws InterruptedException    //push
     {
        synchronized (sharedItems)
        {
            while(sharedItems.size()==MaxSize)
            {
               System.out.println(" Shared Items are full..waiting for consumer to consume ");
               sharedItems.wait();
             }
         }
        
        synchronized (sharedItems)
        {
               System.out.println(" Producer produced element "+i);
               sharedItems.add(i);
               Thread.sleep(2000);
               sharedItems.notify();
             }
         }              
}
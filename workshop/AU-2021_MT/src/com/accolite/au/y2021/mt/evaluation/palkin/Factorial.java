package com.accolite.au.y2021.mt.evaluation.Palkin.q4;


import java.util.*;

class Factorial implements Runnable
{
    Thread t;
    int n;
     
    Factorial(int x)
    {
        n = x;
        t=new Thread(this,"Factorial Thread");
        System.out.println("\nFactorial thread created : "+t);
        t.start();
    }
    
    public static void main(String args[])
    {
    	Scanner sc=new Scanner(System.in);
    	Factorial f;
    	int n=sc.nextInt();
    	for(int i=0;i<n;i++)
    		f=new Factorial(i);
    }
     
    public void run()
    {
        try
        {
            long f = 1;
            for(int i = 2;i<=n;i++)
            {
                f*=i;
            }
            System.out.print("Factorial of "+n+" is : "+f);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        System.out.println("\nExiting "+t);
    }
}
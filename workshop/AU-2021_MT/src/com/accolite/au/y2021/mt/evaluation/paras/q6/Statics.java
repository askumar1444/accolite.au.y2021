package com.accolite.au.y2021.mt.evaluation.paras.q6;
class Statics extends Thread{
	 Horse horse;
	 String Tname;
	 int gap;
	 public Statics(Horse h,String Tname,int gap)
	 { horse=h;
	   this.Tname=Tname;
	   this.gap=gap;
		 
	 }
	 public void run()
	 {   
	      
	      synchronized(this){horse.speeds+=horse.speed;
	      horse.totallSpeedChanges+=1;
	      horse.speedHistory+=horse.speed+"m/s->";
	      horse.distanceCovered+=horse.speed*gap;
	      horse.timeTaken+=1;
	      horse.averageSpeed=horse.speeds/horse.totallSpeedChanges;
	     
	      if(horse.topSpeed<horse.speed)
	         horse.topSpeed=horse.speed;
	      if(horse.lowSpeed>horse.speed)
		     horse.lowSpeed=horse.speed;
	   }
	 }
}


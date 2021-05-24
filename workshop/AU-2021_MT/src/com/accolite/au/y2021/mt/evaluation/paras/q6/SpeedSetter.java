package com.accolite.au.y2021.mt.evaluation.paras.q6;

class SpeedSetter extends Thread{
	Horse h;
	public SpeedSetter(Horse h)
	{
		this.h=h;
	}
	
	public void run()
	{
		h.speed=((int)(((Math.random()*10)+40)+(Math.random()*10)));
	}
}

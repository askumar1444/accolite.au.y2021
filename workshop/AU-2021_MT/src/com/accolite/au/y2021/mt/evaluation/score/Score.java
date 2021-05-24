package com.accolite.au.y2021.mt.evaluation.score;

import java.util.Arrays;
import java.util.List;

public enum Score {
	
	
	Vikram(new Double[] {65D}, "PENDING_FINAL"),
	Adishi(new Double[] {40D}, "PENDING_FINAL"),
	Paras(new Double[] {80D, 60D}, "PENDING_FINAL"),
	Priyanshu(new Double[] {45D}, "PENDING_FINAL"),
	Himanshu(new Double[] {45D}, "PENDING_FINAL"),
	Hitesh(new Double[] {65D}, "PENDING_FINAL"),
	Simran(new Double[] {20D}, "PENDING_FINAL"),
	Vaibhav(new Double[] {0D}, "PENDING_FINAL"),
	
	Rakti(new Double[] {0D}, "REJECTED_CnP"),
	
	Mohit(new Double[] {70D}, "FINAL"),
	Palkin(new Double[] {0D}, "FINAL");
	
	private Score(Double[] scores, String status) {
		this.scores = scores;
		this.status = status;
	}
	
	final Double[] scores;
	final String status;
	
	public static void main(String[] args) {
		System.out.println("***** Report *****");
		List<Score> sl = Arrays.asList(Score.values());
		sl.sort((a, b) -> b.scores[0].compareTo(a.scores[0]));
		sl.forEach(a -> System.err.println(1 + sl.indexOf(a) + ".\t" + a.name() + "\t\t====> " + a.scores[0] + " -- " + a.status));
	}
}

package it.unipv.SO.main;

import java.util.concurrent.ForkJoinPool;

/**
 * Classe usata per gestire come un Thread la classe MultiThreadSummation
 * Calcola la sommatoria da 1 a N sfruttando la classe MultiThreadSummation.
 */
public class SummationThreadManager implements Runnable {

	private int number;
	private int summation;
	
	
	
	public SummationThreadManager(int number) {
		if (number < 0) {
			number = 0;
		} else {
			this.number = number;
		}
	}
	
	@Override
	public void run() {
		ForkJoinPool pool = new ForkJoinPool();
		
		MultiThreadSummation task = new MultiThreadSummation(number);
		summation = pool.invoke(task);
	}
	
	public int getSummation() {
		return summation;
	}
	
	

}

package it.unipv.SO.main;

import java.util.concurrent.RecursiveTask;

/**
 * Classe che calcola la sommatoria da 1 a N utilizzando un modello ricorsivo multithread.
 * 
 */
public class MultiThreadSummation extends RecursiveTask<Integer> {

	static final int THRESHOLD = 100;
	
	private int lower;
	private int upper;
	
	
	
	public MultiThreadSummation(int lower, int upper) {
		this.lower = lower;
		this.upper = upper;
	}
	
	public MultiThreadSummation(int upper) {
		this(1, upper);
	}

	@Override
	protected Integer compute() {
		if (upper - lower < THRESHOLD ) {
			int sum = 0;
			for (int i = lower; i <= upper; i++) {
				sum += i;
			}
			
		return sum;
		} else {
			int mid = (lower + upper) / 2;
			MultiThreadSummation leftTask = new MultiThreadSummation(lower, mid);
			MultiThreadSummation rightTask = new MultiThreadSummation(mid + 1, upper);
			
			leftTask.fork();
			rightTask.fork();
			
			return leftTask.join() + rightTask.join();
		}
	}
	
}

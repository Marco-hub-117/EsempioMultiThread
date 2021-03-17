package it.unipv.SO.main;

public class DivisorsCounter implements Runnable {

	private int number;
	private int divisorsNumber;
	
	public DivisorsCounter(int number) {
		divisorsNumber = 0;
		if (number < 0) {
			number = 0 ;
		}else {
			this.number = number;
		}
	}

	@Override
	public void run() {
		for (int i = 1; i <= number; i++) {
			if (number%i == 0) {
				divisorsNumber++;
			}
		}
	}

	public int getDivisorsNumber() {
		return divisorsNumber;
	}
	
	

}

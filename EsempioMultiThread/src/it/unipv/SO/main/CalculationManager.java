package it.unipv.SO.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe che gestisce i calcoli richiesti.
 * Dato un numero intero N può calcolare:
 *  - La sommatoria da 1 a N 
 *  - Il successivo numero primo maggiore di N
 *  - Il numero di divisori di N
 *
 */
public class CalculationManager {

	private List<Thread> workers;
	private SummationThreadManager sumRun;
	private NextPrimeNumber primeRun;
	private DivisorsCounter divCountRun;
	
	public CalculationManager(int N) {
		sumRun = new SummationThreadManager(N);
		primeRun = new NextPrimeNumber(N);
		divCountRun = new DivisorsCounter(N);
		startThreads();		// parte il calcolo in modo concorrente
	}
	
	private void startThreads() {
		workers = new ArrayList<>();
		workers.add(new Thread(sumRun));
		workers.add(new Thread(primeRun));
		workers.add(new Thread (divCountRun));
		for(Thread t : workers) {
			t.start();
		}
	}
	
	public void joinThreads() {
		for(Thread t : workers) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		
		return "SOMMATORIA : " + sumRun.getSummation() + "\nPROSSIMO PRIMO : " + primeRun.getNextPrimeNumber() + "\nNUMERO DI DIVISORI: "+ divCountRun.getDivisorsNumber();
		
	}
	

}

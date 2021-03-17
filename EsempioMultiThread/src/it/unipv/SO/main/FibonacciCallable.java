package it.unipv.SO.main;

import java.util.concurrent.Callable;

public class FibonacciCallable implements Callable<Long> {

	private int index;
	
	/**
	 * In questa classe il primo elemento della serie di fibonacci (con indice zero) è 0, seguito da 1, 1, 2, 3, 5, 8, 13 ... --> 
	 * esempio : [0, 1, 1, 2, 3, 5, 8, 13 ...] hanno rispettivamente indice [0, 1, 2, 3, 4, 5, 6, 7 ...]
	 * Il costruttore inizializza l'indice a zero se viene passato un numero negativo. 
	 * @param index indice dell'N-esimo elemento della serie di fibonacci che si vuole calcolare.
	 */
	public FibonacciCallable(int index) {
		if (index < 0) {
			this.index = 0;
		} else {
			this.index = index;
		}
	}
	
	/**
	 * Restituisce L'N-esimo elemento della serie di fibonacci, con N passato durante la creazione dell'oggetto.
	 */
	@Override
	public Long call()  {
		
		if ( index == 0) return (long) 0;
		
		long nextFib = 1;	  
		long prevFib= 0;	  
		for(int i = 1; i < index; i++) {
			long temp = nextFib;
			nextFib += prevFib;
			prevFib = temp;
		}
		
		return nextFib;
		
	}
	
	

}

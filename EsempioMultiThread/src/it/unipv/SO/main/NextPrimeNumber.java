package it.unipv.SO.main;

/**
 * Questa Classe calcola il successivo numero primo maggiore del numero passato come argomento del costruttore.
 * 
 *
 */
public class NextPrimeNumber implements Runnable {

	private int number;
	private int nextPrimeNumber;
	
	/**
	 * Se il parametro passato è minore di zero, number viene automaticamente inizializzato a 0.
	 * @param number numero del quale si vuole sapere il successivo numero primo
	 */
	public NextPrimeNumber(int number) {
		if (number < 0) {
			number = 0 ;
		}else {
			this.number = number;
		}
		
	}

	@Override
	public void run() {
		int temp = number + 1 ;
		while (!isPrime(temp)) { // finchè non trovo un numero primo continuo il ciclo
			temp++;
		}
		// Se arrivo qui ho trovato il numero primo, lo assegno a nextPrimeNumber.
		nextPrimeNumber = temp;
	}
	
	/**
	 * restituisce un boolean che è true se il numero n passato come argomento è primo.
	 * @param n
	 * @return
	 */
	private boolean isPrime(int n) {
		boolean result = true;
		for (int i = 2; i < n; i++) {
			if ( n%i == 0 ) { // ho trovato un divisore, n non è un numero primo
				result = false;
				break;
			}
		}
		return result;
	}

	public int getNextPrimeNumber() {
		return nextPrimeNumber;
	}

}

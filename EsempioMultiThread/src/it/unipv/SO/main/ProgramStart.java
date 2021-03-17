package it.unipv.SO.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProgramStart {

	public static void main(String[] args) {
		System.out.println("Il programma richiede di Inserire un numero N e calcola: ");
		System.out.println(" - la sommatoria da 1 a N;");
		System.out.println(" - il successivo numero primo maggiore di N;");
		System.out.println(" - il numero di divisori di N;");
		System.out.println("Il programma termina quando Viene inserito un numero negativo ");
		System.out.println("\n ################################################################ \n");
		
		Scanner input = new Scanner(System.in);
		int N;
		while (true)  {		
			System.out.println("Inserire il numero N (per terminare inserire un numero negativo) :");
			String lettura = input.nextLine();
			try {
				N = Integer.parseInt(lettura);
				if (N < 0) {
					break;
				}
				
				CalculationManager calcManager = new CalculationManager(N);
				calcManager.joinThreads();
				System.out.println(calcManager.toString());
				
			} catch (NumberFormatException e) {
				System.out.println("ATTENZIONE! è stato inserito un valore non valido, inserire un numero intero");
			}
		}
	}

}

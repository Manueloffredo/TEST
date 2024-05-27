package Boundary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controller.GestoreSegreteria;
import exception.OperationException;

public class bStudenti {
	
	final static int MAX_LENGHT = 16;
	static Scanner scan = new Scanner(System.in);
	
	public static void login() throws OperationException {
		
		boolean valido = false;
		boolean risultato = false;
		String UsernameStudente = null, Password = null;
		GestoreSegreteria gestoreSegreteria = GestoreSegreteria.getIstance();
		
		System.out.println("\n--------ACCESSO--------\n");
		System.out.println("Inserisci i dati:");
		
		while(!valido) {
			try {
				System.out.println("\nInserisci l'username: ");
				UsernameStudente = scan.nextLine();
				
				if(UsernameStudente.length() > MAX_LENGHT) {
					System.out.println("\nInput non valido, riprovare... ");
				}
				else {
					valido = true;
				}	
			}catch(IllegalArgumentException e) {
				 System.out.println("\nStringa inserita non valida, riprovare...");
			}
		}
		valido = false;
		while(!valido) {
			try {
				System.out.println("\nInserisci la password: ");
				Password = scan.nextLine();
				
				if(UsernameStudente.length() > MAX_LENGHT) {
					System.out.println("\nInput non valido, riprovare. ");
				}
				else {
					valido = true;
				}	
			}catch(IllegalArgumentException e) {
				 System.out.println("\nStringa inserita non valida, riprovare...");
			}
		}
		
		risultato = gestoreSegreteria.login(UsernameStudente, Password);
		if(risultato) {
			System.out.println("\nAccesso eseguito correttamente!");
		}
		else{
			System.out.println("\nCredenziali non valide, riprovare...");
		}
	}
	
	public static void visualizzaEsamiSvolti() throws OperationException {
		
		GestoreSegreteria gestoreSegreteria = GestoreSegreteria.getIstance();
		
		List<String> esamiSvolti = new ArrayList<>();
		
		boolean valido = false;
		String usernameS = null;
		System.out.println("\n--------Visualizza Esami--------\n");
		while(!valido) {
			try {
				System.out.println("\nInserisci l'username: ");
				usernameS = scan.nextLine();
				
				if(usernameS.length() > MAX_LENGHT) {
					System.out.println("\nInput non valido, riprovare... ");
				}
				else {
					valido = true;
				}	
			}catch(IllegalArgumentException e) {
				 System.out.println("\nUsername non valido, riprovare...");
			}
		}
		
		try {
			
			esamiSvolti = gestoreSegreteria.visualizzaEsamisvolti(usernameS);
			
			if (esamiSvolti.isEmpty()) {
                throw new OperationException("Nessun esame svolto dallo studente: " + usernameS);
            }
			else {
		 		System.out.println("Esami svolti per l'username " + usernameS + ":\n");
		 		
		 		for (String esame : esamiSvolti) {
		 			System.out.println("- " + esame);
		 		}
		 	}
		}catch (OperationException e) {
			 System.out.println("\nQualcosa e' andato storto, riprovare...");
		}
		
	}
}

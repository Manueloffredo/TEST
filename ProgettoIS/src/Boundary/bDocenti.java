package Boundary;


import java.util.Date;
import java.util.Scanner;

import Controller.GestoreSegreteria;
import exception.OperationException;

public class bDocenti {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void inserisciEsame() throws OperationException {
		
		GestoreSegreteria gestoreSegreteria = GestoreSegreteria.getIstance();
		boolean valido = false, lode = false;
		int codiceCorso = 0, valutazione = 0;
		String Username = null, note_docenti = null;
		Date dataOdierna = new Date();

		System.out.println("\n--------Inserimento Esame--------\n");
		
		while(!valido) {
			try {
				System.out.println("Inserire il codice del corso: ");
				codiceCorso = scan.nextInt();
				
				System.out.println("Inserire l'username dello studente: ");
				Username = scan.nextLine();
				
				System.out.println("Inserire la Valutazione: ");
				valutazione = scan.nextInt();
				
				if(valutazione == 30) {
					System.out.println("Si vuole inserire la lode? s/n: ");
					String risposta = scan.nextLine();
					if (risposta.equalsIgnoreCase("s")) {
			            System.out.println("Hai scelto di inserire la lode.");
			            lode = true;
			        } else if (risposta.equalsIgnoreCase("n")) {
			            System.out.println("Hai scelto di non inserire la lode.");
			        } else {
			            System.out.println("Risposta non valida, riprovare.");
			        }
				}
				System.out.println("Inserire eventuali Note: ");
				note_docenti = scan.nextLine();
				
				valido = true;
			}catch(IllegalArgumentException e) {
				 System.out.println("\nStringa inserita non valida, riprovare...");
			}
		}
		try {
			
			gestoreSegreteria.inserisciEsami(codiceCorso, Username, valutazione, lode, note_docenti, dataOdierna);
		
		}catch (OperationException e){
			System.out.println("\nQualcosa e' andato storto...");
		}
 
		
	}
}

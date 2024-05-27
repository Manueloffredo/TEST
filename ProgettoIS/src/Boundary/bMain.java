package Boundary;

import java.util.NoSuchElementException;
import java.util.Scanner;

import exception.OperationException;

public class bMain {

	public static void main(String [] argc) throws OperationException {
		
		boolean input = true, flag = false;
        Scanner scan = new Scanner(System.in);
        String scelta = null, operazione = null;
        while (input){
        	 
        	System.out.println("\n-----Benvenuto al Conservatorio-----");
            System.out.println("\nDigita '1' -Studente, '2'-Docente");
            
            try {
            	scelta = scan.nextLine();
            	
            	switch(scelta) {
            	
            		case "1":
            		  flag = false;
            		  while(flag) {
            				
            			try{
            			  System.out.println("\nQuale operazione vuoi eseguire? (Digita il numero alla sinistra dell'operazione oppure '0' per tornare indietro)");
                          System.out.println("1) LOGIN" + "\n"+ "2) VISUALIZZA ESAMI SVOLTI"+ "\n");
                          
                          operazione = scan.nextLine();
                          
                          switch(operazione) {
                          	
                          	case "0":
                          		flag = true;
                          		break;

                          	case "1":
                          		bStudenti.login();
                          		flag = true;
                          		break;
                          		
                          	case "2":
                          		bStudenti.visualizzaEsamiSvolti();
                          		flag = true;
                          		break;
                          	
                          	 default: System.out.println("\nValore inserito non valido, riprova...");
                          }
                          
                          
            			}catch(NoSuchElementException e){
                                System.out.println("Exception: Valore inserito non valido, riprovare...");
                        }
            			
            		  }
            		  break;
            		  
            		case "2":
            		  flag = false;
            		  
            		  while(!flag) {
            			 
            			try {
            				 System.out.println("\nQuale operazione vuoi eseguire? (Digita il numero alla sinistra dell'operazione oppure '0' per tornare indietro)");
                             System.out.println("1) INSERISCI ESAME " + "\n");
                             
                             operazione = scan.nextLine();
                             
                             switch(operazione) {
                               
                               case "0":
                           		flag = true;
                           		break;
                           		
                               case "1":
                              	bDocenti.inserisciEsame();
                            	flag = true;
                              	break;
                              	
                               default: System.out.println("\nValore inserito non valido, riprova...");
                             }
            		    	
            		    }catch(NoSuchElementException e){
                            System.out.println("Exception: Valore inserito non valido, riprovare...");
            		    }
            		  }
            	}
            	
            } catch(NoSuchElementException e){
                System.out.println("Exception: Valore inserito non valido, riprovare...");
            }
        }
	}
}

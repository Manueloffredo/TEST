package Controller;

import java.util.ArrayList;
import java.util.List;

import Database.StudenteDAO;
import Entity.EntityStudente;
import exception.DAOException;
import exception.DBConnectionException;
import exception.OperationException;



public class GestoreSegreteria {
	
	private static GestoreSegreteria gS = null;
	
	public static GestoreSegreteria getIstance() {
		
		if( gS == null)		gS = new GestoreSegreteria();
		
		return gS;
	}
	
	public boolean login(String Username, String Password) throws OperationException {
		
		try {
			
			EntityStudente studente = StudenteDAO.readStudente(Username, Password);
			
			if(Username.equals(studente.getUsername()) && Password.equals(studente.getPassword())){
				
				return true;
				
			} else {
				
				throw new OperationException("Credenziali non valide");
			}
		
		}catch(DBConnectionException dbEx) {
			
			throw new OperationException("\nRiscontrato problema interno applicazione!\n");

		}catch(DAOException ex) {

			throw new OperationException("Ops, qualcosa e' andato storto..");
		}
		
	}
	//public static List<String> visualizzaEsamisvolti();
	//public void inserisciEsami();
	
	
}


/*

*/

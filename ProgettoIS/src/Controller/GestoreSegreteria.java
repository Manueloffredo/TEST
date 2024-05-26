package Controller;

import java.util.ArrayList;
import java.util.List;

import Database.EsamiSvoltiDAO;
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
	
	public static List<String> visualizzaEsamisvolti(String username) throws OperationException{
		
		List<String> listaEsamiS = new ArrayList<String>();
		
		try {
		
			listaEsamiS = EsamiSvoltiDAO.readEsamiSvolti(username);
			
			if(listaEsamiS == null)		throw new OperationException("Nessun esame svolto dallo studente: "+ username);
		}catch(DBConnectionException dbEx) {
			
			throw new OperationException("\nRiscontrato problema interno applicazione!\n");

		}catch(DAOException ex) {

			throw new OperationException("Ops, qualcosa e' andato storto..");
		}
		return listaEsamiS;
		
	}
	
	
	public void inserisciEsami(int CodiceCorso, String username, List<String> esamiS ) throws OperationException {
		
		List<String> corsiPropedeutici = new ArrayList<String>();
		boolean NOesamiP = false;
		try {
			
			corsiPropedeutici = EsamiSvoltiDAO.readEsamiSvolti(username);
			
			if(corsiPropedeutici == null)	NOesamiP = true;			//creo un flag per inserire direttamente gli esami 
																		//qualora non fossero presenti propedeuticità
			EsamiSvoltiDAO.updateEsamiSvolti(username, CodiceCorso , corsiPropedeutici, NOesamiP);
			
			
		}catch(DBConnectionException dbEx) {
			
			throw new OperationException("\nRiscontrato problema interno applicazione!\n");

		}catch(DAOException ex) {

			throw new OperationException("Ops, qualcosa e' andato storto..");
		}
		
	}
	
	
}


/*

*/

package Database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import exception.DAOException;
import exception.DBConnectionException;

public class EsamiSvoltiDAO {
	
	public static List<String> readEsamiSvolti(String username) throws DAOException, DBConnectionException{
		
		String query = "SELECT lista_esami_svolti FROM Studente WHERE username = ?";//Prendo la lista esami svolti di un certo studente
		List<String> esamiS = new ArrayList<String>();
		try {
			
			Connection conn = DBManager.getConnection();
			
			try {
				
				PreparedStatement statement = conn.prepareStatement(query);
				statement.setString(1, username);

				ResultSet result = statement.executeQuery();
				
				while(result.next()) {
					String id = result.getString("idCorso");
					esamiS.add(id);
				}
			
			}catch (SQLException e) {

				throw new DAOException("Nessun esame svolto");

			}finally {

				DBManager.closeConnection();
			}
		} catch (SQLException e) {

			throw new DBConnectionException("Connessione al Database non riuscita");

		}
		return esamiS;
		
	}
	
	public static boolean updateEsamiSvolti(String username, int codiceEsame
											, List<String> esamiS, boolean NoEsamiP) throws DAOException, DBConnectionException {
		
		String query = "SELECT id_corso FROM esami_svolti WHERE usernameS = ? AND id_corsoP = ?";//prendo il codice del corso riferito ad un certo studente e ad un certo esame propedeutico  
		String query1 = "SELECT * FROM esami_svolti where id_studente = ? AND idCorso = ?";
		String query2 = "INSERT INTO EsamiSvolti id_corso = ? , usernameS = ?";
		
		try {
			
			Connection conn = DBManager.getConnection();
			
			try {
			  if(!NoEsamiP) {												//se non ci sono esami propedeutici salto il controllo												
				PreparedStatement statement = conn.prepareStatement(query);		
				statement.setString(1, username);
				statement.setInt(2, codiceEsame);
				ResultSet result = statement.executeQuery();
				
				if(result.next()) {
					for(String Esame : esamiS) {								//utilizzo Esame per iterare la lista di tutti
																				//gli esami propedeutici contenuti in esamiS.
						PreparedStatement stat = conn.prepareStatement(query1);
						stat.setString(1, username);
						stat.setString(2, Esame);
						ResultSet res = statement.executeQuery();
						if(!res.next()) {
							return false;
						}
					}
					PreparedStatement stat2 = conn.prepareStatement(query);				//SERVE FARLO OGNI VOLTA?
					stat2.setString(1, username);
					stat2.setInt(2, codiceEsame);
					ResultSet res2 = statement.executeQuery();
					
				}
			  }

			}catch(SQLException e) {
				
				throw new DAOException("Nessun esame svolto");
				
			}finally {
				
				DBManager.closeConnection();
				
			}
		}catch (SQLException e) {

			throw new DBConnectionException("Connessione al Database non riuscita");

		}
		return true;
		
	}
}

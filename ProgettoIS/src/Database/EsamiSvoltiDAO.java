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
		
		String query = "SELECT lista_esami_svolti FROM Studente WHERE username = ?"; 
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
	
	public static boolean updateEsamiSvolti(String username, String codiceEsame, List<String> esamiS) throws DAOException, DBConnectionException {
		
		String query = "SELECT id_corso FROM esami_svolti WHERE usernameS = ? AND id_corsoP = ?"; 
		String query1 = "SELECT * FROM esami_svolti where id_studente = ? AND idCorso = ?"; 
		
		try {
			
			Connection conn = DBManager.getConnection();
			
			try {
				
				PreparedStatement statement = conn.prepareStatement(query);
				statement.setString(1, username);
				statement.setString(2, codiceEsame);
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

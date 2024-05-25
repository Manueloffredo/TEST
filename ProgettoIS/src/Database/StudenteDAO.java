package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.EntityStudente;

import exception.DAOException;
import exception.DBConnectionException;

public class StudenteDAO {
	
	public static EntityStudente readStudente(String username, String password) throws DAOException, DBConnectionException{
		
		String query = "SELECT Username, Password FROM Studenti WHERE Username = ? AND Password=?"; 
		EntityStudente studente = null;
		
		try {
			
			Connection conn = DBManager.getConnection();
			
			try {
				
				PreparedStatement statement = conn.prepareStatement(query);
				statement.setString(1, username);
				statement.setString(2, password);
				ResultSet result = statement.executeQuery();			
			
				if(result.next()) {
					System.out.println("Accesso Eseguito");
				}
			} catch (SQLException e) {

				throw new DAOException("Accesso non eseguito");

			} finally {

				DBManager.closeConnection();
			}
		} catch (SQLException e) {

			throw new DBConnectionException("Connessione al Database non riuscita");

		}
		return null;
		
	}
}


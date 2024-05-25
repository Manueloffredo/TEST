package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Entity.EntityStudente;
import database.DBManager;
import entity.CartaCredito;
import entity.Cliente;
import exception.DAOException;
import exception.DBConnectionException;

public class StudenteDAO {
	
	public static EntityStudente readStudente(String username, String password) {
		
	}
}

/*
	public static Cliente createCliente(String username, String password, String numeroTelefono, CartaCredito cartaCredito) throws DBConnectionException, DAOException{
		
		String query = "INSERT INTO Clienti VALUES (?,?,?,?);";
		Cliente cliente = null;
		
		try {

			Connection connection = DBManager.getConnection();

			try {
				
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setString(1, username);
				statement.setString(2, password);
				statement.setString(3, numeroTelefono);
				statement.setString(4, cartaCredito.name()); 
				
				statement.executeUpdate();
				
				cliente = new Cliente(username, password, numeroTelefono, cartaCredito);

			} catch (SQLException e) {

				throw new DAOException("Creazione cliente non riuscita");

			} finally {

				DBManager.closeConnection();
			}

		} catch (SQLException e) {

			throw new DBConnectionException("Connessione al Database non riuscita");

		}
		
		return cliente;
					
	}
*/

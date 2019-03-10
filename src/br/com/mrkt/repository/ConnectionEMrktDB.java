package br.com.mrkt.repository;

import java.util.Properties;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

import br.com.mrkt.repository.DataBaseAccess;

/**
 * Classe responsável por realizar a conexão com o Banco de Dados - &Market.
 * @author Lenno Sousa
 */
public class ConnectionEMrktDB implements IConnection{

	private Connection iConnection = null;
	
	public ConnectionEMrktDB() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Properties properties = new Properties();
		properties.put("user", DataBaseAccess.getUser());
        properties.put("password", DataBaseAccess.getPassword());
		
        this.iConnection = DriverManager.getConnection(DataBaseAccess.getServer(), properties); 
        this.iConnection.setAutoCommit(false);
        //this.iConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMrktDB","root","root"); 
	}

	@Override
	public Connection getConnection() {
		
		return this.iConnection;
	}

	@Override
	public void close() {
		if(this.iConnection != null) {
			try {
				this.iConnection.close();
			}catch(SQLException ex) {
				Logger.getLogger(ConnectionEMrktDB.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	@Override
	public void commit() throws SQLException {
		this.iConnection.commit();
		this.close();
	}

	@Override
	public void rollback() {
		if(this.iConnection != null) {
			try {
				this.iConnection.rollback();
			}catch(SQLException ex) {
				Logger.getLogger(ConnectionEMrktDB.class.getName()).log(Level.SEVERE, null, ex);
			}finally {
				this.close();
			}
		}
		
	}
	
}

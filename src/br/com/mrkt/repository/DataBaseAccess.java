package br.com.mrkt.repository;

public class DataBaseAccess {
	
	//private static String server = "jdbc:mysql://localhost:3306/EMrktDB";
	private static String server = "jdbc:mysql://localhost:3306/e_mrktdb_dev";
	private static String database;
	private static String user = "root";
	private static String password = "adminroot";
	
	public DataBaseAccess () {}

	public static String getServer() {
		return server;
	}
	
	public static void setServer(String server) {
		DataBaseAccess.server = server;
	}
	
	public static String getDatabase() {
		return database;
	}
	
	public static void setDatabase(String database) {
		DataBaseAccess.database = database;
	}
	
	public static String getUser() {
		return user;
	}
	
	public static void setUser(String user) {
		DataBaseAccess.user = user;
	}
	
	public static String getPassword() {
		return password;
	}
	
	public static void setPassword(String password) {
		DataBaseAccess.password = password;
	}
	
	
	//e_mrktdb_dev
	
}

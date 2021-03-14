package de.beam.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysql {
	
	public static Connection con;
	private static String host = "";
	private static int port = 0;
	private static String database = "";
	private static String user = "";
	private static String password = "";
	public static boolean connectMySQL() throws SQLException {
		
		
		 con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, password);
		
		
		
		return false;
	}
	
	

}

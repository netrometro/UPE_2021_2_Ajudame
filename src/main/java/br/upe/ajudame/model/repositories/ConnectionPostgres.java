package br.upe.ajudame.model.repositories;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
		
public class ConnectionPostgres {
	
//	private final String url = "jdbc:postgresql://localhost/template1";
//    private final String user = "netro";
//    private final String password = "";

	public Connection connect() throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		//Connection connection = DriverManager.getConnection(url, user, password);
		
		System.out.println(System.getenv("DATABASE_URL"));
		
		Connection connection = DriverManager.getConnection(System.getenv("DATABASE_URL"));
		return connection;
	}
}

package br.upe.ajudame.model.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionPostgres {
	/*/
    private final String URL = "jdbc:postgresql://localhost/";
    private final String USER = "netro";
    private final String PASSWORD = "";
    private final String DB = "ajudame1";
	//*/
	public Connection connect() throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		//Connection connection = DriverManager.getConnection(URL + DB, USER, PASSWORD);
		
		System.out.println(System.getenv("DATABASE_URL"));
		
		// jdbc:postgresql://localhost/<<database>>?user=<<user>>
		Connection connection = DriverManager.getConnection(System.getenv("DATABASE_URL"));
		
		return connection;
	}
	
	public void query(String sql) throws SQLException, ClassNotFoundException {
		Connection conn = this.connect();
		
		Statement statement = conn.createStatement();
		statement.execute(sql);
		
		statement.close();
		conn.close();
	}
	
	public void queryPrepared(String sql, String[] data) throws SQLException, ClassNotFoundException {
		Connection conn = this.connect();
		
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		for (int i = 0; i < data.length; i++) {
			preparedStatement.setString(i+1, data[i]);
		}
		
		preparedStatement.executeUpdate();
		
		preparedStatement.close();
		conn.close();
	}
	
	public ResultSet queryResult(String sql)  throws SQLException, ClassNotFoundException {
		Connection conn = this.connect();

		
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();
		
		conn.close();
		return rs;
	}
}

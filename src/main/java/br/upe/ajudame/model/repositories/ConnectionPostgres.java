package br.upe.ajudame.model.repositories;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.upe.ajudame.model.entities.Questionario;

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
	
	public void query(String sql) throws SQLException, ClassNotFoundException {
		Connection conn = this.connect();
		
		Statement statement = conn.createStatement();
		statement.execute(sql);
	}
	
	public void queryPrepared(String sql, String[] data) throws SQLException, ClassNotFoundException {
		Connection conn = this.connect();
		
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		for (int i = 0; i < data.length; i++) {
			preparedStatement.setString(i+1, data[i]);
		}
		
		preparedStatement.executeUpdate();
	}
	
	public void queryPreparedObject(String sql, Questionario[] data) throws SQLException, ClassNotFoundException {
		Connection conn = this.connect();
		
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		for (int i = 0; i < data.length; i++) {
			preparedStatement.setArray(i+1, (Array) data[i]);
		}
		
		preparedStatement.executeUpdate();
	}
	
	public ResultSet queryResult(String sql)  throws SQLException, ClassNotFoundException {
		Connection conn = this.connect();

		
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();
		
		conn.close();
		return rs;
	}
}

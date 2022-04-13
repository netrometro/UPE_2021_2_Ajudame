package br.upe.ajudame.model.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionPostgres {

    private final String url = "jdbc:postgresql://localhost/template1";
    private final String user = "netro";
    private final String password = "";

	private Connection connect() throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection(url, user, password);
		
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
}

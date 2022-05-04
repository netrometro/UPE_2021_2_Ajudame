package br.upe.ajudame.model.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserMigration {

	private ConnectionPostgres postgres;

	public UserMigration() {
		postgres = new ConnectionPostgres();
	}

	public void migrate() {
		try {
			Connection conn = postgres.connect();
			String sql = "CREATE TABLE users " +
			        "(id SERIAL PRIMARY KEY ," +
			        " name VARCHAR, " +
			        " email VARCHAR(50), " +
			        " password VARCHAR(50)" +
			        ");";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();
			
			ps.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void refresh() {
		try {
			Connection conn = postgres.connect();
			String sql = "DROP TABLE IF EXISTS users;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();
			
			this.migrate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void populate() {
		try {
			String[][] data = { 
					{ "Fulano", "fulano@email.com", "123" },
					{ "Pedro de Alcântara Francisco Antônio João Carlos Xavier de Paula Miguel Rafael Joaquim José Gonzaga Pascoal Cipriano Serafim de Bragança e Bourbon", "pedro.alcantara@email.com", "111" }
				};
			Connection conn = postgres.connect();
			String sql = "INSERT INTO users" +
			        "  (name, email, password) VALUES " +
			        " (?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			for (String[] d : data) {
				ps.setString(1, d[0]);
				ps.setString(2, d[1]);
				ps.setString(3, d[2]);
				ps.execute();
			}
			
			ps.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}

package br.upe.ajudame.model.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.upe.ajudame.model.entities.User;

public class ForumMigration {
	private ConnectionPostgres postgres;

	public ForumMigration() {
		postgres = new ConnectionPostgres();
	}

	public void migrate() {
		try {
			Connection conn = postgres.connect();
			String sql = "CREATE TABLE forum " +
			        "(id SERIAL PRIMARY KEY ," +
			        " topico VARCHAR, " +
			        " titulo VARCHAR, " +
			        " pergunta VARCHAR, " +
			        " resposta VARCHAR" +
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
			String sql = "DROP TABLE IF EXISTS forum;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();
			
			this.migrate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void populate() {
		try {
			User user = new User("Fulano", "fulano@email.com", "123");
			
			Connection conn = postgres.connect();
			String sql = "INSERT INTO forum" +
			        "  (topico, titulo, pergunta) VALUES " + " (?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);			
			
			ps.close();
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}

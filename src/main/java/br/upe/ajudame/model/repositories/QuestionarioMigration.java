package br.upe.ajudame.model.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.upe.ajudame.model.entities.User;

public class QuestionarioMigration {

	private ConnectionPostgres postgres;
	private QuestionarioDAO dao;

	public QuestionarioMigration() {
		postgres = new ConnectionPostgres();
	}
	
	

	public void migrate() {
		try {
			Connection conn = postgres.connect();
			String sql = ("CREATE TABLE questionario" + "(id SERIAL PRIMARY KEY ," 
					+ "curso_id INTEGER NOT NULL ,"
					+ "user_id INTEGER NOT NULL ,"
					+ "CONSTRAINT fk_curso_questionario FOREIGN KEY (curso_id) REFERENCES cursos(id) ON DELETE CASCADE ON UPDATE CASCADE,"
					+ "CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE" + ");");
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
			String sql = "DROP TABLE IF EXISTS questionario;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();

			this.migrate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void populate() {
		
	}

}

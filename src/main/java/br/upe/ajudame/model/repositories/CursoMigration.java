package br.upe.ajudame.model.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CursoMigration {

	private ConnectionPostgres postgres;

	public CursoMigration() {
		postgres = new ConnectionPostgres();
	}

	public void migrate() {
		try {
			Connection conn = postgres.connect();
			String sql = "CREATE TABLE Cursos " +
			        "(id SERIAL PRIMARY KEY ," +
			        " nameCurso VARCHAR, " +
			        " descricao VARCHAR(250), " +
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
			String sql = "DROP TABLE IF EXISTS Cursos;";
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
					{ "Java Web", "Aprenda desenvolvimento web com java." },
					{ "GameDev Java", "Aprenda desenvolvimento de jogos em java com eclipse." }
				};
			Connection conn = postgres.connect();
			String sql = "INSERT INTO Cursos" +
			        "  (nameCurso, descricao) VALUES " +
			        " (?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			for (String[] d : data) {
				ps.setString(1, d[0]);
				ps.setString(2, d[1]);
				ps.execute();
			}
			
			ps.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}

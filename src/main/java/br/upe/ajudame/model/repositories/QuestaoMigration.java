package br.upe.ajudame.model.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QuestaoMigration {
	
	private ConnectionPostgres postgres;
	
	public QuestaoMigration() {
		postgres = new ConnectionPostgres();
	}
	
	public void migrate() {
		try {
			Connection conn = postgres.connect();
			String sql = ("CREATE TABLE questoes" +
					"(id SERIAL PRIMARY KEY ," +
					"pergunta VARCHAR ," +
					"resposta VARCHAR ," +
					"explicacao VARCHAR ," +
					"questionario_id INTEGER NOT NULL ," +
					"CONSTRAINT fk_questionario FOREIGN KEY (questionario_id) REFERENCES questionario(id)" +
					");");
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();
			
			ps.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void migrateAlternativas() {
		try {
			Connection conn = postgres.connect();
			String sql = ("CREATE TABLE alternativas" +
					"(id SERIAL PRIMARY KEY ," +
					"alternativa VARCHAR ," +
					"questao_id INTEGER NOT NULL ," +
					"CONSTRAINT fk_questao_alternativa FOREIGN KEY (questao_id) REFERENCES questoes(id)" +
					");");
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
			String sql = "DROP TABLE IF EXISTS questao;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();
			
			this.migrate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
}

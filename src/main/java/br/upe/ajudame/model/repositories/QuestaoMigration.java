package br.upe.ajudame.model.repositories;

import java.sql.SQLException;

public class QuestaoMigration {
	
	private ConnectionPostgres repository;
	
	public QuestaoMigration() {
		repository = new ConnectionPostgres();
	}
	
	public void migrate() {
		try {
			repository.query("CREATE TABLE questoes" +
					"(id SERIAL PRIMARY KEY ," +
					"pergunta VARCHAR ," +
					"resposta VARCHAR ," +
					"explicacao VARCHAR ," +
					"questionario_id INTEGER NOT NULL ," +
					"CONSTRAINT fk_questionario FOREIGN KEY (questionario_id) REFERENCES questionario(id)" +
					");");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void migrateAlternativas() {
		try {
			repository.query("CREATE TABLE alternativas" +
					"(id SERIAL PRIMARY KEY ," +
					"alternativa VARCHAR ," +
					"questao_id INTEGER NOT NULL ," +
					"CONSTRAINT fk_questao_alternativa FOREIGN KEY (questao_id) REFERENCES questoes(id)" +
					");");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void refresh() {
		try {
			repository.query("DROP TABLE IF EXISTS questionario;");
			this.migrate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
}

package br.upe.ajudame.model.repositories;

import java.sql.SQLException;

public class GamificacaoMigration {
	
	private ConnectionPostgres repository;
	
	public GamificacaoMigration() {
		repository = new ConnectionPostgres();
	}

	public void migrate() {
		try {
			repository.query("CREATE TABLE gamificacao " +
			        "(pontos SERIAL PRIMARY KEY ," +
			        " name VARCHAR, " +
			        " acao VARCHAR(50), " +
			        ");");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void refresh() {
		try {
			repository.query("DROP TABLE IF EXISTS users;");
			this.migrate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void populate() {
		try {
			String[][] data = { 
					{ "Fulano", "1", "123" },
					{ "Pedro de Alcântara Francisco Antônio João Carlos Xavier de Paula Miguel Rafael Joaquim José Gonzaga Pascoal Cipriano Serafim de Bragança e Bourbon", "1", "111" }
				};
			for (String[] d : data) {
				repository.queryPrepared("INSERT INTO users" +
				        "  (pontos,acao, nome) VALUES " +
				        " (?, ?, ?);", d );
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}

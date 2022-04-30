package br.upe.ajudame.model.repositories;

import java.sql.SQLException;

public class UserMigration {
private ConnectionPostgres repository;
	
	public UserMigration() {
		repository = new ConnectionPostgres();
	}

	public void migrate() {
		try {
			repository.query("CREATE TABLE users " +
			        "(id SERIAL PRIMARY KEY ," +
			        " name VARCHAR, " +
			        " email VARCHAR(50), " +
			        " password VARCHAR(50)" +
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
					{ "Fulano", "fulano@email.com", "123" },
					{ "Pedro de Alcântara Francisco Antônio João Carlos Xavier de Paula Miguel Rafael Joaquim José Gonzaga Pascoal Cipriano Serafim de Bragança e Bourbon", "pedro.alcantara@email.com", "111" }
				};
			for (String[] d : data) {
				repository.queryPrepared("INSERT INTO users" +
				        "  (name, email, password) VALUES " +
				        " (?, ?, ?);", d );
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}

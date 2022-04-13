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
			        "(ID SERIAL PRIMARY KEY ," +
			        " NAME VARCHAR, " +
			        " EMAIL VARCHAR(50), " +
			        " PASSWORD VARCHAR(50));");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void refresh() {
		try {
			repository.query("DROP TABLE users;");
			this.migrate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void populate() {
		String[] data = { "Fulano", "fulano@email.com", "123" };
		try {
			repository.queryPrepared("INSERT INTO users" +
			        "  (name, email, password) VALUES " +
			        " (?, ?, ?);", data );
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}

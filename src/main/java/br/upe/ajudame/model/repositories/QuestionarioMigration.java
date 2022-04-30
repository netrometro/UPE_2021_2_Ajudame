package br.upe.ajudame.model.repositories;

import java.sql.SQLException;

import br.upe.ajudame.model.entities.Questionario;
import br.upe.ajudame.model.entities.User;

public class QuestionarioMigration {
	
	private ConnectionPostgres repository;
	
	public QuestionarioMigration() {
		repository = new ConnectionPostgres();
	}
	
	public void migrate() {
		try {
			repository.query("CREATE TABLE questionario" +
								"(id SERIAL PRIMARY KEY ," +
								"tema VARCHAR ," +
								"totalAcertos INTEGER ," +
								"totalErros INTEGER ," +
								"user_id INTEGER NOT NULL ," +
								"CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id)" +
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
	
	public void populate() {
		try {
			User user = new User("fulano", "fulano@gmail", "123");
			Questionario questionario = new Questionario("Historia", user);
			Questionario[][] data = { 
					{ questionario}
				};
			for (Questionario[] d : data) {
				repository.queryPreparedObject("INSERT INTO questionario" +
				        "  (tema, totalAcertos, totalErros, user) VALUES " +
				        " (?, ?, ?);", d );
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}

package br.upe.ajudame.model.repositories;

import java.sql.SQLException;

public class CursoMigration {
	
	private ConnectionPostgres repository;
	
	public CursoMigration() {
		repository = new ConnectionPostgres();
	}

	public void migrate() {
		try {
			repository.query("CREATE TABLE cursos " +
			        "(id SERIAL PRIMARY KEY ," +
			        " nameCurso VARCHAR, " +
			        " description VARCHAR(250), " +
			        ");");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void refresh() {
		try {
			repository.query("DROP TABLE IF EXISTS cursos;");
			this.migrate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void populate() {
		try {
			System.out.println("Teste populate");
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
	
}
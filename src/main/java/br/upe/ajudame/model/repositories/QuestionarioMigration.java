package br.upe.ajudame.model.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.upe.ajudame.model.entities.Questao;
import br.upe.ajudame.model.entities.Questionario;
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
			String sql = ("CREATE TABLE questionario" + "(id SERIAL PRIMARY KEY ," + "tema VARCHAR ,"
					+ "totalAcertos INTEGER ," + "totalErros INTEGER , " + "user_id INTEGER NOT NULL ,"
					+ "CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id)" + ");");
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
		try {
			User user = new User("Fulano", "fulano@email.com", "123");

			Questionario questionario1 = new Questionario("Historia", user);
			Questionario questionario2 = new Questionario("Geografia", user);

			List<String> alternativas1 = new ArrayList<String>();
			alternativas1.add("A) 1490");
			alternativas1.add("B) 1500");
			alternativas1.add("C) 1510");
			alternativas1.add("D) 1520");

			Questao questao1 = new Questao("Em que ano os portugueses chegaram ao Brasil?", alternativas1, "B) 1500",
					"Os portugueses desembarcaram nas terras tupiniquins no ano de 1500");

			List<String> alternativas2 = new ArrayList<String>();
			alternativas2.add("A) 1943");
			alternativas2.add("B) 1944");
			alternativas2.add("C) 1945");
			alternativas2.add("D) 1946");
			Questao questao2 = new Questao("Em que ano terminou a Segunda Guerra Mundial?", alternativas2, "C) 1945",
					"A Segunda Guerra Mundial acabou em Setembro do ano 1945.");

			questionario1.CriarPerguntas(questao1);
			questionario1.CriarPerguntas(questao2);
			
			List<Questionario> data = new ArrayList<Questionario>();
			
			data.add(questionario1);
			data.add(questionario2);
			for (int i = 0; i < data.size(); i++) {
				this.dao.add(data.get(i));
			}
			
//			for (Questionario d : data) {
//				ps.setString(1, d.getTema());
//				ps.setInt(2, d.getTotalAcertos());
//				ps.setInt(3, d.getTotalErros());
//				ps.setInt(4, d.getUser().getId());
//				ps.execute();
//			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}

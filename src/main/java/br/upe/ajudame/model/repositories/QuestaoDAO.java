package br.upe.ajudame.model.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.upe.ajudame.model.entities.Questao;
import br.upe.ajudame.model.entities.Questionario;

public class QuestaoDAO {
	
	private ConnectionPostgres postgres;
	
	public QuestaoDAO() {
		postgres = new ConnectionPostgres();
	}
	
	public void add (Questao questao, Integer questionario_id) throws ClassNotFoundException, SQLException {
		Connection conn = postgres.connect();
		System.out.println(questao.getPergunta());
		String sql = "INSERT INTO questoes (pergunta, resposta, explicacao, questionario_id) VALUES (?,?,?,?);";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, questao.getPergunta());
		ps.setString(2, questao.getResposta());
		ps.setString(3, questao.getExplicação());
		ps.setInt(4, questionario_id);
		ps.execute();
		
		ps.close();
		conn.close();
	}
	
	public Integer searchQuestao(String pergunta) throws SQLException, ClassNotFoundException {
		Connection conn = postgres.connect();

		String sql = "SELECT * FROM questoes WHERE pergunta = ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, pergunta);
		ResultSet rs = ps.executeQuery();

		Questao busca = new Questao();
		
		while (rs.next()) {
			busca.setId(rs.getInt("id"));
		}

		ps.close();
		rs.close();
		conn.close();

		return busca.getId();
	}
	
	public void addAlternativa (List<String> alternativas, Integer questao_id) throws ClassNotFoundException, SQLException {
		Connection conn = postgres.connect();
		String sql = "INSERT INTO alternativas (alternativa, questao_id) VALUES (?,?);";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		for (int i = 0; i < alternativas.size(); i++) {
			ps.setString(1, alternativas.get(i));
			ps.setInt(2, questao_id);
			ps.execute();
		}
	
		ps.close();
		conn.close();
	}

}

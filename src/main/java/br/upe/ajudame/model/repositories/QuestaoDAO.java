package br.upe.ajudame.model.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.upe.ajudame.model.entities.Alternativa;
import br.upe.ajudame.model.entities.Questao;

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
		ps.setString(3, questao.getExplicacao());
		ps.setInt(4, questionario_id);
		ps.execute();
		
		ps.close();
		conn.close();
	}
	
	public void remove(Integer questao) throws ClassNotFoundException, SQLException {
		Connection conn = postgres.connect();

		String sql = "DELETE FROM questoes WHERE id = ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, questao);
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}
	
	public void update(Questao questao) throws ClassNotFoundException, SQLException{
		Connection conn = postgres.connect();
		
		String sql = "UPDATE questoes SET pergunta = ?, resposta = ?, explicacao = ? WHERE id = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, questao.getPergunta());
		ps.setString(2, questao.getResposta());
		ps.setString(3, questao.getExplicacao());
		ps.setInt(4, questao.getId());
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}
	
	public List<Questao> list(Integer id_curso) throws ClassNotFoundException, SQLException {
		Connection conn = postgres.connect();
		
		String sql = "SELECT * FROM questoes AS QS INNER JOIN questionario AS QT ON QS.questionario_id = QT.id INNER JOIN cursos as C ON QT.curso_id = C.id WHERE C.id = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id_curso);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Questao> lista = new ArrayList<Questao>();
		
		while(rs.next()) {
			Questao questao = new Questao();
			questao.setId(rs.getInt("id"));
			questao.setPergunta(rs.getString("pergunta"));
			questao.setExplicacao(rs.getString("explicacao"));
			questao.setResposta(rs.getString("resposta"));
			
			lista.add(questao);
		}
		
		ps.close();
		rs.close();
		conn.close();
		
		return lista;
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
	
	public Questao searchByIdQuestao(Integer id_questao) throws SQLException, ClassNotFoundException {
		Connection conn = postgres.connect();

		String sql = "SELECT * FROM questoes WHERE id = ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id_questao);
		ResultSet rs = ps.executeQuery();

		
		Questao questao = new Questao();
		while (rs.next()) {
			questao.setId(rs.getInt("id"));
			questao.setPergunta(rs.getString("pergunta"));
			questao.setExplicacao(rs.getString("explicacao"));
			questao.setResposta(rs.getString("resposta"));			
		}

		ps.close();
		rs.close();
		conn.close();

		return questao;
	}
	
	public void addAlternativa (List<Alternativa> alternativas, Integer questao_id) throws ClassNotFoundException, SQLException {
		Connection conn = postgres.connect();
		String sql = "INSERT INTO alternativas (alternativa, questao_id) VALUES (?,?);";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		for (int i = 0; i < alternativas.size(); i++) {
			ps.setString(1, alternativas.get(i).getAlternativa());
			ps.setInt(2, questao_id);
			ps.execute();
		}
	
		ps.close();
		conn.close();
	}
	
	public void updateAlternativas(List<Alternativa> alternativas) throws ClassNotFoundException, SQLException{
		Connection conn = postgres.connect();
		
		String sql = "UPDATE alternativas SET alternativa = ? WHERE id = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		for (int i = 0; i < alternativas.size(); i++) {
			ps.setString(1, alternativas.get(i).getAlternativa());
			ps.setInt(2, alternativas.get(i).getId());
			ps.executeUpdate();
		}
		
		ps.close();
		conn.close();
	}
	
	public List<Alternativa> listAlternativas(Integer id_questao) throws SQLException, ClassNotFoundException {
		Connection conn = postgres.connect();
		
		String sql = "SELECT * FROM alternativas WHERE questao_id = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id_questao);
		ResultSet rs = ps.executeQuery();
		
		List<Alternativa> lista = new ArrayList<Alternativa>();
		while (rs.next()) {
			Alternativa alternativa = new Alternativa();
			
			alternativa.setId(rs.getInt("id"));
			alternativa.setAlternativa(rs.getString("alternativa"));
			
			lista.add(alternativa);
			 
		}
		
		return lista;
	}

}

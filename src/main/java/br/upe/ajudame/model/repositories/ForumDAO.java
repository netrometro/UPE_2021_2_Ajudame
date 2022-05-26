package br.upe.ajudame.model.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.upe.ajudame.model.entities.Forum;

public class ForumDAO {
	
	private ConnectionPostgres postgres;
	
	public ForumDAO() {
		postgres = new ConnectionPostgres();
	}

	public void add(Forum forum) throws ClassNotFoundException, SQLException {
		Connection conn = postgres.connect();
		
		String sql = "INSERT INTO Forums (topico, tema, pergunta, resposta) VALUES (?,?,?,?,?)";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, forum.getTopico());
		ps.setString(2, forum.getTema());
		ps.setString(3, forum.getPergunta());
		ps.setString(4, forum.getResposta());
		ps.setInt(5, forum.getUser().getId());
		ps.execute();

		ps.close();
		conn.close();
	}

	public void remove(Forum forum) throws ClassNotFoundException, SQLException {
		Connection conn = postgres.connect();
		
		String sql = "DELETE FROM questionario WHERE id = ? cascade";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, forum.getUser().getId());
	}

	public void update(Forum forum) throws ClassNotFoundException, SQLException {
		
		Connection conn = postgres.connect();
		
		String sql = "UPDATE questionario "
				+ "SET topico = ? "
				+ "SET tema = ? "
				+ "SET pergunta = ? "
				+ "SET resposta = ? "
				+ "WHERE id = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, forum.getTopico());
		ps.setString(2, forum.getTema());
		ps.setString(3, forum.getPergunta());
		ps.setString(4, forum.getResposta());
		ps.setInt(5, forum.getUser().getId());
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}

	public List<Forum> list() throws ClassNotFoundException, SQLException {
		Connection conn = postgres.connect();

		String sql = "SELECT * FROM forum";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		
		ArrayList<Forum> lista = new ArrayList<Forum>();
		while (rs.next()) {
			Forum forum = new Forum();
			forum.setTopico(rs.getString("topico"));
			forum.setTema(rs.getString("tema"));
			forum.setPergunta(rs.getString("pergunta"));
			forum.setResposta(rs.getString("resposta"));
			
			lista.add(forum);
		}
		
		ps.close();
		rs.close();
		conn.close();
		
		return lista;
	}

	public List<Forum> searchByTopico(String topico) throws ClassNotFoundException, SQLException {
		Connection conn = postgres.connect();

		String sql = "SELECT * FROM forum WHERE name LIKE '%?%'";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, topico);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Forum> lista = new ArrayList<Forum>();
		while (rs.next()) {
			Forum forum = new Forum();
			forum.setTopico(rs.getString("topico"));
			forum.setTema(rs.getString("tema"));
			forum.setPergunta(rs.getString("pergunta"));
			
			lista.add(forum);
		}
		
		ps.close();
		rs.close();
		conn.close();
		
		return lista;
	}

	public String searchTema(String tema) throws SQLException, ClassNotFoundException {
		Connection conn = postgres.connect();

		String sql = "SELECT * FROM forum WHERE tema = ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, tema);
		ResultSet rs = ps.executeQuery();
		
		Forum buscar = new Forum();
		
		while (rs.next()) {
			buscar.setTema(rs.getString("tema"));
		}
		
		ps.close();
		rs.close();
		conn.close();
		
		return buscar.toString();
	}
}

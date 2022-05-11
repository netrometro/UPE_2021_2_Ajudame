package br.upe.ajudame.model.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.upe.ajudame.model.entities.Questionario;

public class QuestionarioDAO {

	private ConnectionPostgres postgres;

	public QuestionarioDAO() {
		postgres = new ConnectionPostgres();
	}

	public void add(Questionario questionario) throws SQLException, ClassNotFoundException {
		Connection conn = postgres.connect();

		String sql = "INSERT INTO questionario (tema, totalacertos, totalerros, user_id) VALUES (?,?,?,?);";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, questionario.getTema());
		ps.setInt(2, questionario.getTotalAcertos());
		ps.setInt(3, questionario.getTotalErros());
		ps.setInt(4, questionario.getUser().getId());
		ps.execute();

		ps.close();
		conn.close();
	}

	public void remove(Questionario questionario) throws ClassNotFoundException, SQLException {
		Connection conn = postgres.connect();
		
		String sql = "DELETE FROM questionario WHERE id = ? cascade";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, questionario.getId());
	}

	public void update(Questionario questionario) throws ClassNotFoundException, SQLException {
		
		Connection conn = postgres.connect();
		
		String sql = "UPDATE questionario "
				+ "SET tema = ? "
				+ "WHERE id = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, questionario.getTema());
		ps.setInt(2, questionario.getId());
		ps.executeUpdate();
		
		ps.close();
		conn.close();

	}

	public List<Questionario> list() throws ClassNotFoundException, SQLException {
		Connection conn = postgres.connect();

		String sql = "SELECT * FROM questionario";

		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		ArrayList<Questionario> lista = new ArrayList<Questionario>();
		while (rs.next()) {
			Questionario questionario = new Questionario();
			questionario.setId(rs.getInt("id"));
			questionario.setTema(rs.getString("tema"));
			questionario.setTotalAcertos(rs.getInt("totalAcertos"));
			questionario.setTotalErros(rs.getInt("totalErros"));

			lista.add(questionario);
		}

		ps.close();
		rs.close();
		conn.close();

		return lista;
	}

	public List<Questionario> searchByTema(String tema) throws SQLException, ClassNotFoundException {
		Connection conn = postgres.connect();

		String sql = "SELECT * FROM questionario WHERE tema LIKE '%?%'";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, tema);
		ResultSet rs = ps.executeQuery();

		ArrayList<Questionario> lista = new ArrayList<Questionario>();
		while (rs.next()) {
			Questionario questionario = new Questionario();
			questionario.setId(rs.getInt("id"));
			questionario.setTema(rs.getString("tema"));

			lista.add(questionario);
		}

		ps.close();
		rs.close();
		conn.close();

		return lista;
	}

	public Integer searchQuestionario(String tema) throws SQLException, ClassNotFoundException {
		Connection conn = postgres.connect();

		String sql = "SELECT * FROM questionario WHERE tema = ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, tema);
		ResultSet rs = ps.executeQuery();

		Questionario busca = new Questionario();
		
		while (rs.next()) {
			busca.setId(rs.getInt("id"));
		}

		ps.close();
		rs.close();
		conn.close();

		return busca.getId();
	}

}

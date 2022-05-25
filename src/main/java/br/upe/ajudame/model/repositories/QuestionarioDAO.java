package br.upe.ajudame.model.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.upe.ajudame.model.entities.Cursos;
import br.upe.ajudame.model.entities.Questionario;
import br.upe.ajudame.model.entities.User;

public class QuestionarioDAO {

	private ConnectionPostgres postgres;

	public QuestionarioDAO() {
		postgres = new ConnectionPostgres();
	}

	public void add(Questionario questionario) throws SQLException, ClassNotFoundException {
		Connection conn = postgres.connect();

		String sql = "INSERT INTO questionario (curso_id, user_id) VALUES (?,?);";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, questionario.getCurso().getId());
		ps.setInt(2, questionario.getUser().getId());
		ps.execute();

		ps.close();
		conn.close();
	}

	public void remove(Integer questionario) throws ClassNotFoundException, SQLException {
		Connection conn = postgres.connect();

		String sql = "DELETE FROM questionario WHERE id = ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, questionario);
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}

	public void update(Questionario questionario) throws ClassNotFoundException, SQLException {

		Connection conn = postgres.connect();

		String sql = "UPDATE questionario " + "SET curso_id = ? " + "WHERE id = ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, questionario.getCurso().getId());
		ps.setInt(2, questionario.getId());
		ps.executeUpdate();

		ps.close();
		conn.close();

	}

	public List<Questionario> list() throws ClassNotFoundException, SQLException {
		Connection conn = postgres.connect();

		String sql = "SELECT * FROM questionario as Q INNER JOIN cursos as C ON Q.curso_id = C.id INNER JOIN users as U ON Q.user_id = U.id";

		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		ArrayList<Questionario> lista = new ArrayList<Questionario>();
		while (rs.next()) {
			Questionario questionario = new Questionario();
			questionario.setId(rs.getInt("id"));

			Cursos curso = new Cursos();
			curso.setId(rs.getInt("curso_id"));
			curso.setNameCurso(rs.getString("nameCurso"));
			curso.setDescription(rs.getString("description"));

			questionario.setCurso(curso);
			
			User user = new User();
			user.setId(rs.getInt("user_id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			
			questionario.setUser(user);

			lista.add(questionario);
		}

		ps.close();
		rs.close();
		conn.close();

		return lista;
	}

	public List<Questionario> searchByCurso(String tema) throws SQLException, ClassNotFoundException {
		Connection conn = postgres.connect();

		String sql = "SELECT * FROM questionario WHERE tema LIKE '%?%'";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, tema);
		ResultSet rs = ps.executeQuery();

		ArrayList<Questionario> lista = new ArrayList<Questionario>();
		while (rs.next()) {
			Questionario questionario = new Questionario();
			questionario.setId(rs.getInt("id"));

			Cursos curso = new Cursos();
			curso.setId((rs.getInt("curso_id")));

			questionario.setCurso(curso);

			lista.add(questionario);
		}

		ps.close();
		rs.close();
		conn.close();

		return lista;
	}

	public Integer searchQuestionario(Integer curso_id) throws SQLException, ClassNotFoundException {
		Connection conn = postgres.connect();

		String sql = "SELECT * FROM questionario WHERE curso_id = ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, curso_id);
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

	public Cursos searchCurso(String curso) throws SQLException, ClassNotFoundException {
		Connection conn = postgres.connect();

		String sql = "SELECT * FROM cursos WHERE nameCurso = ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, curso);
		ResultSet rs = ps.executeQuery();

		Cursos busca = new Cursos();

		while (rs.next()) {
			busca.setId(rs.getInt("id"));
			busca.setNameCurso(rs.getString("nameCurso"));
			busca.setDescription(rs.getString("description"));
		}

		ps.close();
		rs.close();
		conn.close();

		return busca;
	}

	public User searchByNameUser(Integer id) throws ClassNotFoundException, SQLException {
		Connection conn = postgres.connect();

		String sql = "SELECT * FROM users WHERE id = ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		User user = new User();

		if (!rs.next()) {
			// Nenhum registro
		} else {
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			System.out.println(user.toString());
		}

		ps.close();
		rs.close();
		conn.close();

		return user;
	}

}

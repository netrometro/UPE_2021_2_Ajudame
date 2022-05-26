package br.upe.ajudame.model.repositories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.upe.ajudame.model.entities.Cursos;
import br.upe.ajudame.model.entities.User;

public class CursosDAO {

	private ConnectionPostgres postgres;
	
	public CursosDAO() {
		postgres = new ConnectionPostgres();
	}

	public void add(Cursos curso) throws ClassNotFoundException, SQLException {
		Connection conn = postgres.connect();

		String sql = "INSERT INTO cursos (curso_id, user_id) VALUES (?,?);";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, curso.getNameCurso());
		ps.setString(2, curso.getDescription());
		ps.execute();

		ps.close();
		conn.close();
	}

	public void remove(Cursos curso) {

	}

	public void update(Cursos curso) {

	}
	
	public void get(Cursos curso) {

	}

	public ArrayList<Cursos> list() throws ClassNotFoundException, SQLException {
		
		Connection conn = postgres.connect();

		String sql = "SELECT * FROM cursos";

		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		ArrayList<Cursos> lista = new ArrayList<Cursos>();
		while (rs.next()) {
			Cursos curso = new Cursos();
			curso.setId(rs.getInt("id"));
			curso.setNameCurso(rs.getString("nameCurso"));
			curso.setDescription(rs.getString("description"));

			lista.add(curso);
		}

		ps.close();
		rs.close();
		conn.close();

		return lista;
	}
	
}

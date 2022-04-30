package br.upe.ajudame.model.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.upe.ajudame.model.entities.User;

public class UserDAO {
	
	private ConnectionPostgres repository;

	
	public UserDAO() {
		repository = new ConnectionPostgres();
	}

	public void add(User user) {
		// TODO Auto-generated method stub

	}

	public void remove(User user) {
		// TODO Auto-generated method stub

	}

	public void update(User user) {
		// TODO Auto-generated method stub

	}

	public List<User> list() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM users";
		ResultSet rs = repository.queryResult(sql);
		
		ArrayList<User> lista = new ArrayList<User>();
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			
			lista.add(user);
		}
		
		return lista;
	}

	public List<User> searchByName(User user) {
		// TODO Auto-generated method stub
		return null;
	}
}

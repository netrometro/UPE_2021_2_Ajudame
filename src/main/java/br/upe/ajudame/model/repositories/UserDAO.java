package br.upe.ajudame.model.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.upe.ajudame.model.entities.User;

public class UserDAO {
	
	private ConnectionPostgres postgres;
	
	public UserDAO() {
		postgres = new ConnectionPostgres();
	}

	public void add(User user) throws ClassNotFoundException, SQLException {
		Connection conn = postgres.connect();
		
		String sql = "INSERT INTO users (name, email, password) VALUES (?,?,?)";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getPassword());
		ps.execute();

		ps.close();
		conn.close();
	}

	public void remove(User user) {
		// TODO Auto-generated method stub

	}

	public void update(User user) {
		// TODO Auto-generated method stub

	}

	public List<User> list() throws ClassNotFoundException, SQLException {
		Connection conn = postgres.connect();

		String sql = "SELECT * FROM users";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		
		ArrayList<User> lista = new ArrayList<User>();
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			
			lista.add(user);
		}
		
		ps.close();
		rs.close();
		conn.close();
		
		return lista;
	}

	public List<User> searchByName(String name) 
			throws ClassNotFoundException, SQLException {
		Connection conn = postgres.connect();

		String sql = "SELECT * FROM users WHERE name LIKE '%?%'";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		
		
		ArrayList<User> lista = new ArrayList<User>();
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			
			lista.add(user);
		}
		
		ps.close();
		rs.close();
		conn.close();
		
		return lista;
	}

	public User autentication(String email, String password) 
			throws ClassNotFoundException, SQLException {
		
		Connection conn = postgres.connect();

		String sql = "SELECT * FROM users WHERE emaiL=? and password=?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		
		User user = null;
		while (rs.next()) {
			user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
		}
		
		ps.close();
		rs.close();
		conn.close();
		
		return user;
	}
}

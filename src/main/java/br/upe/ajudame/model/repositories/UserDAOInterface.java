package br.upe.ajudame.model.repositories;

import java.util.List;

import br.upe.ajudame.model.entities.User;

public interface UserDAOInterface {
	void add(User user);
	void remove(User user);
	void update(User user);
	List<User> list();
	List<User> searchByName(User user);
}

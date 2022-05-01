package br.upe.ajudame.model.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.upe.ajudame.model.entities.Gamificacao;


public class GamificacaoDAO {
	
	private ConnectionPostgres repository;
	
	public GamificacaoDAO() {
		repository = new ConnectionPostgres();
	}

	public void add(Gamificacao game) {
		// TODO Auto-generated method stub

	}

	public void remove(Gamificacao game) {
		// TODO Auto-generated method stub

	}

	public void update(Gamificacao game) {
		// TODO Auto-generated method stub

	}

	public List<Gamificacao> list() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM users"; //Falta ver aqui
		ResultSet rs = repository.queryResult(sql);
		
		ArrayList<Gamificacao> lista = new ArrayList<Gamificacao>();
		while (rs.next()) {
			Gamificacao game = new Gamificacao();
			game.setAcao(rs.getString("Acao"));
			game.setNome(rs.getString("Nome"));
			game.setPontos(rs.getString("Pontos"));
			
			lista.add(game);
		}
		
		return lista;
	}

	public List<Gamificacao> searchByName(Gamificacao game) {
		// TODO Auto-generated method stub
		return null;
	}

}

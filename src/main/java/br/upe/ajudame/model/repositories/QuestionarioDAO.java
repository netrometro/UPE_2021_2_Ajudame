package br.upe.ajudame.model.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.upe.ajudame.model.entities.Questionario;

public class QuestionarioDAO {
	
	private ConnectionPostgres repository;
	
	public QuestionarioDAO() {
		repository = new ConnectionPostgres();
	}
	
	public void add(Questionario questionario) {
		
	}
	
	public void remove(Questionario questionario) {
		
	}
	
	public void update(Questionario questionario) {
		
	}
	
	public List<Questionario> list() throws ClassNotFoundException, SQLException{
		String sql = "SELECT * FROM questionario";
		ResultSet rs = repository.queryResult(sql);
		
		ArrayList<Questionario> lista = new ArrayList<Questionario>();
		while(rs.next()) {
			Questionario questionario = new Questionario();
			questionario.setId(rs.getInt("id"));
			questionario.setTema(rs.getString("tema"));
			questionario.setTotalAcertos(rs.getInt("totalAcertos"));
			questionario.setTotalErros(rs.getInt("totalErros"));
			
			lista.add(questionario);
		}
		
		return lista;
	}
	
	public List<Questionario> searchByTema(Questionario questionario){
		return null;
	}

}

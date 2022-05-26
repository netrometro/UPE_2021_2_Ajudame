package br.upe.ajudame.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Cursos {

	//Usuario atual
	private int id;
	private User user;
	//descrição do curso
	private String nameCurso;
	private String description;
	
	private List<CursosDisponiveis> cursosList = new ArrayList<CursosDisponiveis>();
	
	//Entidade de cursos "objeto de aprendizagem" (arquivos e materiais do curso)
	//private ArrayList<objAprendizagem> cursosLit = new ArrayList<objAprendizagem>();
	
	public Cursos() {}
	
	public Cursos(User user) {
		this.user = user;
	}
	public List<CursosDisponiveis> getCursosList() {
		return cursosList;
	}
	public void setCursos(List<CursosDisponiveis> cursosList) {
		this.cursosList = cursosList;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameCurso() {
		return nameCurso;
	}
	public void setNameCurso(String nameCurso) {
		this.nameCurso = nameCurso;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}

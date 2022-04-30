package br.upe.ajudame.model.entities;

import java.util.ArrayList;

public class Cursos {

	//Usuario atual
	private int id;
	private User user = new User();
	private String nameUser = user.getName();
	//descrição do curso
	private String nameCurso;
	private String description;
	//Entidade de cursos "objeto de aprendizagem" (arquivos e materiais do curso)
	//private ArrayList<objAprendizagem> cursosLit = new ArrayList<objAprendizagem>();
	
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

package br.upe.ajudame.model.entities;

/*
 * O usuário pode administrar perguntas. 
 * O usuário pode pesquisar perguntas. 
 * O usuário pode responder perguntas. 
 * O usuário pode votar (assertividade) em uma ou mais respostas.
 * 
 * Requisito: Usuário (classe)
 */

public class Forum {
	
	//Atributos da classe fórum
	private String topico;
	private String tema;
	private String pergunta;
	private String resposta;
	private int like;
	
	//Utilização da classe usuário
	private User user;
	
	public String getTopico() {
		return topico;
	}

	public void setTopico(String topico) {
		this.topico = topico;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String titulo) {
		this.tema = titulo;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}

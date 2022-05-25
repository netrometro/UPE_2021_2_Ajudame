package br.upe.ajudame.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Questao{
	
	private Integer id;
	private String pergunta;
	private List<Alternativa> alternativas = new ArrayList<Alternativa>();
	private String resposta;
	private String explicacao;
	
	public Questao() {}
	
	public Questao(String pergunta, String resposta, String explicacao) {
		this.pergunta = pergunta;
		this.resposta = resposta;
		this.explicacao = explicacao;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	
	public List<Alternativa> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public String getExplicacao() {
		return explicacao;
	}

	public void setExplicacao(String explicacao) {
		this.explicacao = explicacao;
	}

	public void adicionarAlternativas(Alternativa alternativa) {
		this.alternativas.add(alternativa);
	}

	@Override
	public String toString() {
		return "Pergunta [pergunta=" + pergunta + ", alternativas=" + alternativas + ", resposta=" + resposta
				+ ", explicação=" + explicacao + "]";
	}

}
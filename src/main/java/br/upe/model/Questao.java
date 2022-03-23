package br.upe.model;

import java.util.ArrayList;
import java.util.List;

public class Questao{
	
	private String pergunta;
	private List<String> alternativas = new ArrayList<String>();
	private String resposta;
	private String explicação;
	
	public Questao() {}
	
	public Questao(String pergunta, List<String> alternativas, String resposta, String explicação) {
		this.pergunta = pergunta;
		this.alternativas = alternativas;
		this.resposta = resposta;
		this.explicação = explicação;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public List<String> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(List<String> alternativas) {
		this.alternativas = alternativas;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public String getExplicação() {
		return explicação;
	}

	public void setExplicação(String explicação) {
		this.explicação = explicação;
	}

	@Override
	public String toString() {
		return "Pergunta [pergunta=" + pergunta + ", alternativas=" + alternativas + ", resposta=" + resposta
				+ ", explicação=" + explicação + "]";
	}

}

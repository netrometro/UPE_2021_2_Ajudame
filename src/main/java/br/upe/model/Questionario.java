package br.upe.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * 				O QUE O SOFTWARE VAI TER
 * 
 * Quiz, Perguntas, Alternativas 
 * (tema, perguntas, alternativas, resposta, explicação)
 * 
 * O usuário pode administrar um ou mais quiz, com várias 
 * perguntas. Cada pergunta com várias respostas, sendo 
 * uma ou mais respostas certas. Pode visualizar os quiz 
 * criados. Pode associar uma lição. Pode visualizar as 
 * perguntas e alternativas de um quiz. Pode responder o 
 * quiz e ver o total de acertos e erros. No erro pode ver 
 * a explicação da resposta certa.
 * 
 * Usuário, objeto de aprendizagem.
 * 
 * */

public class Questionario {
	
	private String tema;
	private List<Questao> questoes = new ArrayList<Questao>();
	
	private Usuario usuario;
	
	private int totalAcertos;
	private int totalErros;
	
	public Questionario() {}

	public Questionario(String tema, Usuario usuario) {
		this.tema = tema;
		this.usuario = usuario;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Questao> getQuestao() {
		return questoes;
	}

	public void setPerguntas(List<Questao> questoes) {
		this.questoes = questoes;
	}

	public int getTotalAcertos() {
		return totalAcertos;
	}

	public void setTotalAcertos(int totalAcertos) {
		this.totalAcertos = totalAcertos;
	}

	public int getTotalErros() {
		return totalErros;
	}

	public void setTotalErros(int totalErros) {
		this.totalErros = totalErros;
	}

	public void CriarPerguntas(Questao questao) {
		this.questoes.add(questao);
	}
	
	//Concluir implementação do Metodo
	public String ResponderQuiz(Questao questaoRecebida, String respostaRecebida) {
		//Pergunta pergunta = this.PegarPergunta();
		
		if(questaoRecebida.getResposta().equals(respostaRecebida)) {
			this.totalAcertos ++;
			return "Você acertou!";
		} else {
			this.totalErros ++;
			return "Você errou!" 
					+ "\n Resposta: " + questaoRecebida.getResposta() 
					+ "\n Explicação: " + questaoRecebida.getExplicação();
		}
	}
	
	//Concluir implementação do Metodo
	public Questao PegarQuestao() {
		
		Random rand = new Random();
		
		int posicao = rand.nextInt(this.questoes.size());
		
		Questao pergunta = this.questoes.get(posicao);
		
		return pergunta;
	}

	@Override
	public String toString() {
		return "Quiz [tema=" + tema + ",\n questoes=" + questoes + ",\n usuario=" + usuario + ",\n totalAcertos="
				+ totalAcertos + ", totalErros=" + totalErros + "]";
	}

	

	

}

package br.upe.ajudame.model.entities;

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
	
	private Integer id;
	private List<Questao> questoes = new ArrayList<Questao>();
	
	private User user;
	
	private Cursos curso;
	
	private Integer totalAcertos;
	private Integer totalErros;
	
	public Questionario() {}

	public Questionario(Cursos curso, User user) {
		this.curso = curso;
		this.user = user;
		this.totalAcertos = 0;
		this.totalErros = 0;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Cursos getCurso() {
		return curso;
	}

	public void setCurso(Cursos curso) {
		this.curso = curso;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getTotalAcertos() {
		return totalAcertos;
	}

	public void setTotalAcertos(Integer totalAcertos) {
		this.totalAcertos = totalAcertos;
	}

	public Integer getTotalErros() {
		return totalErros;
	}

	public void setTotalErros(Integer totalErros) {
		this.totalErros = totalErros;
	}

	public void CriarPerguntas(Questao questao) {
		this.questoes.add(questao);
	}
	
	public Questao retornarQuestao() {
		Questao questao = new Questao();
		for (int i = 0; i < this.questoes.size(); i++) {
			if (questoes != null) {
				questao = this.getQuestoes().get(i);
			}
		}
		return questao;
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
					+ "\n Explicação: " + questaoRecebida.getExplicacao();
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
		return "Questionario [id=" + id + ", questoes=" + questoes + ", user=" + user + ", curso=" + curso
				+ ", totalAcertos=" + totalAcertos + ", totalErros=" + totalErros + "]";
	}
}

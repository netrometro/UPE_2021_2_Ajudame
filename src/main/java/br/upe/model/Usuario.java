package br.upe.model;

/**Class Usuario simples para suprir a minha dependencia
 * Só tem apenas como atributo NOME. (Sujeita a alteração)
**/
public class Usuario {
	
	private String nome;

	public Usuario(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + "]";
	}
	
}

package estoquedomiciliar;

import java.time.LocalDate;

public class Produto {
	private String nome;
	private LocalDate validade;
	
	public Produto () {
		this.nome = "AProductHasNoName";
		this.validade = null;
	}
	
	public Produto (String nome, LocalDate validade) {
		this.nome = nome;
		this.validade = validade;
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + "," + " Validade: " + validade + System.getProperty("line.separator");
	}
	
	public LocalDate getValidade() {
		return this.validade;
	}

}


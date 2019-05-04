package estoquedomiciliar;

import java.time.LocalDate;

public class Produto {
	private String nome;
	private LocalDate validade;
	
	public Produto () {
		nome = "AProductHasNoName";
		validade = LocalDate.now();
	}	
	
	@Override
	public String toString() {
		return "Nome: " + nome + "," + " Validade: " + validade + System.getProperty("line.separator");
	}

}


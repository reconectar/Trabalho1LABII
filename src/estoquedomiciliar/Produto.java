package estoquedomiciliar;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Produto implements Ordenavel{
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
		return "Nome: " + nome + "," + " Validade: " + validade;
	}
	
	public LocalDate getValidade() {
		return this.validade;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setValidade (String date) throws IOException{
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		this.validade = LocalDate.parse(date, formato);
	}

	@Override
	public boolean menorQue(Ordenavel o) {
		// TODO Auto-generated method stub
		return false;
	}	

}


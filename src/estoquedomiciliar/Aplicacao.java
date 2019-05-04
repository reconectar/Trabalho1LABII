package estoquedomiciliar;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Aplicacao {
	
	private static Scanner userInput;
	private static Scanner fileInput;
	private static Estoque estoque;
	private static File arquivo;
	
	
	public static LocalDate registerDate (String date) throws IOException{
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate produtoDate = LocalDate.parse(date, formato);
		return produtoDate;
	}

	public static void main(String[] args) {
		try {
			estoque = new Estoque(); //inicializa o estoque
			userInput = new Scanner(System.in);
			
			System.out.print("Insira o nome do produto: ");
			String nome = userInput.nextLine();
			System.out.println("Insira uma data de validade no formato: yyyy-MM-dd, (ex: 1993-02-19)");
			
			
			LocalDate produtoDate = registerDate(userInput.nextLine());
			userInput.close();
			Produto novo = new Produto(nome, produtoDate);
			estoque.writeFile(novo);
			
			//Logica de impressao de conteudo do arquivo
			arquivo = new File("BancoDeDados.txt");
			fileInput = new Scanner(arquivo);
			while(fileInput.hasNextLine()) {
				System.out.println(fileInput.nextLine());
			}
			
		} catch (IOException entrada) {
			System.out.println("Data inseridos inválidos");
			entrada.printStackTrace();
		} finally {
			System.out.println("Programa encerrado com sucesso!");			
		}

	}

}

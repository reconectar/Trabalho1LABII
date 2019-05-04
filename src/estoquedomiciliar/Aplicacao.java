package estoquedomiciliar;

import java.io.IOException;
import java.util.Scanner;

public class Aplicacao {
	
	private static Scanner userInput;
	private static Estoque estoque;
	private static Produto novo;
	
	public static void imprimiMenu(){
		System.out.println("\n\n### Gerenciamento de Compras Domiciliar ###");
		System.out.println("\n                  ================================");
		System.out.println("                  |     1 - Cadastro Itens   |");
		System.out.println("                  |     2 - Consulta Itens       |");
		System.out.println("                  |     0 - Sair                   |");
		System.out.println("                  =================================\n");
		System.out.println                    ("Opção -> ");
	}

	public static void main(String[] args) {
		try {
			estoque = new Estoque(); //inicializa o estoque
			userInput = new Scanner(System.in);
			int n = 0;
			while (n==0) {
				imprimiMenu();
				switch(n) {
				case 1:
					novo = new Produto();
					System.out.print("Insira o nome do produto: ");
					novo.setNome(userInput.nextLine());
					System.out.println("Insira uma data de validade no formato: yyyy-MM-dd, (ex: 1993-02-19)");			
					novo.setValidade(userInput.nextLine());
					estoque.adicionarProduto(novo);
					estoque.removerProdutoPodre(novo); //FIXME Gambiarra
					break;
				case 2:
					estoque.getProdutos().imprime();
					break;
				default:
					System.out.println("Opcao inválida!");
				}
			}
			System.out.println(estoque.getQtdePodres() + "produtos podres removidos!");
			userInput.close();			
		} catch (IOException e) {
			System.out.println("Data inseridos inválidos");
			e.printStackTrace();
		} finally {
			System.out.println("Programa encerrado com sucesso!");			
		}

	}

}

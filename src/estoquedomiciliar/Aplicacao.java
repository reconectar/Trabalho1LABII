package estoquedomiciliar;

import java.io.IOException;
import java.util.Scanner;

public class Aplicacao {

	private static Scanner userInput;
	private static Estoque estoque;
	private static Produto novo;
	private static CFila aux;

	public static void imprimiMenu() {
		System.out.println("\n### Gerenciamento de Compras Domiciliar ###");
		System.out.println("\n     ================================");
		System.out.println("     |     1 - Cadastro Itens       |");
		System.out.println("     |     2 - Consulta Itens       |");
		System.out.println("     |     0 - Sair                 |");
		System.out.println("     ================================\n");
		System.out.print("Op��o -> ");
	}
	
	public static void imprimeLista() {
		System.out.println("\nItens: ");
		System.out.println("================================");
		estoque.getProdutos().imprime();
		System.out.println("================================");
	}

	public static void main(String[] args) {
		try {
			estoque = new Estoque(); // inicializa o estoque
			aux = new CFila();
			System.out.println("Data: " + estoque.getHoje());
			int n = -1;
			while (n != 0) {
				imprimiMenu();
				userInput = new Scanner(System.in);
				n = userInput.nextInt();
				switch (n) {
				case 0:
					System.out.println("Fim do programa!");
					break;
				case 1:
					novo = new Produto();
					System.out.print("Insira o nome do produto: ");
					userInput.nextLine();
					novo.setNome(userInput.nextLine());
					System.out.println("Insira uma data de validade no formato: yyyy-MM-dd, (ex: 1993-02-19)");
					novo.setValidade(userInput.nextLine());
					estoque.adicionarProduto(novo);
					aux.enfileira(novo);
					break;
				case 2:
					imprimeLista();
					break;
				default:
					System.out.println("Opcao inv�lida!");
				}
			}
			while(!aux.vazia()) {
				estoque.removerProdutoExpirado((Produto) aux.desenfileira());
			}
			if(estoque.getQtdeExpirados()>0) {
				System.out.println(System.getProperty("line.separator") + estoque.getQtdeExpirados() + " produtos Expirados removidos! Nova lista: ");
				imprimeLista();
			}
			userInput.close();
		} catch (IOException e) {
			System.out.println("Data inseridos inv�lidos");
			e.printStackTrace();
		} finally {
			System.out.println(System.getProperty("line.separator") + "Programa encerrado com sucesso!");
		}

	}

}

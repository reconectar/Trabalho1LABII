package EstoqueDomiciliar;

import java.io.File;

// Interpreta e modifica a Classe Estoque.

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Aplicação {

	public static void main (String arg []) throws FileNotFoundException{
		   
		// Cria arquivo
	       File file = new File("teste.txt");
	       ArrayList<Estoque> ListaEstoque = new ArrayList();
	       
		//  menu principal
			int opcao = 0;
			Scanner lerOption = new Scanner(System.in);
			Scanner ler = new Scanner(System.in);
			do {
				Menu.imprimiMenu();
				opcao = lerOption.nextInt();
				
				System.out.print("\n");
				switch (opcao) {
				case 1: 
					System.out.printf("Informe seu nome do item que deseja cadastrar:\n");
			 		String nome = ler.nextLine();
			 		System.out.printf("Informe a data de validade deste item :\n");
			 		String data = ler.nextLine();
			 		ListaEstoque.add(new Estoque(nome, data));
			 		Estoque.salvarEstoque(file, (new Estoque(nome, data)));
					break;
				case 2:
					System.out.printf("Informe o nome do Funcionario que deseja pesquisar:\n");
	            	nome = ler.nextLine();
	            	for(int i=0; i<ListaEstoque.size(); i++){
	            		Estoque Estoque = ListaEstoque.get(i);
	                    if(ListaEstoque.contains(nome)) {
	                    	System.out.println("Contém na lista: "+nome);
	                    }
	                    else {
	                    	System.out.println("Item não cadastrado");
	                    }
	            	}
	            	break;
	            case 3:
	            	
				case 0:
					break;
				default:
					System.out.println("Opção Inválida!");
					break;
				}
			} while (opcao != 0);
			
			
			
			System.out.println("Programa encerrado.");
			
	   }
	}
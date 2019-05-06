package estoquedomiciliar;
/**
 * @(#)CFila.java
 *
 *
 * @author Rodrigo Richard Gomes
 * @version 1.00 2018/3/16
 */

public class CFila {
	private CCelula frente; // Celula cabeca.
	private CCelula tras; // Ultima celula.
	private int qtde;

	// Funcao construtora. Cria a celula cabeca e faz as referencias frente e tras
	// apontarem para ela.
	public CFila() {
		frente = new CCelula();
		tras = frente;
	}

	// Verifica se a fila esta vazia. Retorna TRUE se a fila estiver vazia e FALSE
	// caso contrario.
	public boolean vazia() {
		return frente == tras;
	}

	public void mostra() {
		System.out.print("[ ");
		for (CCelula c = frente.prox; c != null; c = c.prox)
			System.out.print(c.item + " ");
		System.out.println("] ");
	}

	// Insere um novo Item no fim da fila.
	// O parametro "valorItem" e um Object contendo o elemento a ser inserido no
	// final da fila.
	public void enfileira(Object valorItem) {
		tras.prox = new CCelula(valorItem);
		tras = tras.prox;
		qtde++;
	}

	// Retira e retorna o primeiro elemento da fila.
	// Retorna um Object contendo o primeiro elemento da fila. Caso a fila esteja
	// vazia retorna null.
	public Object desenfileira() {
		Object item = null;
		if (frente != tras) {
			frente = frente.prox;
			item = frente.item;
			qtde--;
		}
		return item;
	}

	// Retorna o primeiro Item da fila sem remove-lo.
	// Retorna um Object contendo o primeiro Item da fila.
	public Object peek() {
		if (frente != tras)
			return frente.prox.item;
		else
			return null;
	}

	// Verifica se o Item passado como parametro esta contido na fila.
	// O parametro "valorItem" e um object contendo o Item a ser localizado.
	// O metodo retorna TRUE caso o item esteja presente na fila.
	public boolean contem(Object valorItem) {
		boolean achou = false;
		CCelula aux = frente.prox;
		while (aux != null && !achou) {
			achou = aux.item.equals(valorItem);
			aux = aux.prox;
		}
		return achou;
	}

	// Verifica se o Item passado como parametro esta contido na fila. (Obs: usa o
	// comando FOR)
	// Recebe como parametro um object contendo o Item a ser localizado.
	// Retorna TRUE caso o Item esteja presente na fila.
	public boolean contemFor(Object valorItem) {
		boolean achou = false;
		for (CCelula aux = frente.prox; aux != null && !achou; aux = aux.prox)
			achou = aux.item.equals(valorItem);
		return achou;
	}

	// Metodo que retorna a quantidade de itens da fila.
	public int quantidade() {
		return qtde;
	}

	// Questao 9 lista 3
	// Chama o m�todo desempilha enquanto nao estiver vazio (enquanto quantidade for
	// diferente de 0)
	void limpa() {
		while (this.qtde != 0) {
			this.desenfileira();
		}
	}
	
	// Questao 10 lista 3
	void furaFila(Object item) {
		if(frente != tras) {			
			CCelula aux = new CCelula();
			aux.prox = frente.prox;
			aux.item = item;
			frente.prox = aux;
		}else{
			enfileira(item);
		}
	}

}
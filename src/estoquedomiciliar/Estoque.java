package estoquedomiciliar;

import java.io.IOException;
import java.time.LocalDate;

public class Estoque {

	private CListaDup produtos;
	private LocalDate hoje;
	private int qtdeExpirados;

	public Estoque() {
		produtos = new CListaDup();
		hoje = LocalDate.now();
		qtdeExpirados = 0;
	}

	public void adicionarProduto(Produto a) throws IOException { // FIXME logica de inserir ordenado
		this.produtos.insereFim(a);
	}

	public void removerProdutoExpirado(Produto a) throws IOException {
		if (!produtos.vazia()) {
			if (a.getValidade().isBefore(hoje)) {
				this.produtos.remove(a);
				this.qtdeExpirados++;
			}
		}else {
			System.out.println("Lista Vazia!");
		}
	}

	public CListaDup getProdutos() {
		return produtos;
	}

	public LocalDate getHoje() {
		return hoje;
	}

	public int getQtdeExpirados() {
		return qtdeExpirados;
	}

}

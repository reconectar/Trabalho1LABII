package estoquedomiciliar;

import java.io.IOException;
import java.time.LocalDate;

public class Estoque{
	
	private CListaDup produtos;
	private LocalDate hoje;
	private int qtdePodres;

	public Estoque(){
		produtos = new CListaDup();	
		hoje = LocalDate.now();
		qtdePodres = 0;
	}
	
	public void adicionarProduto(Produto a) throws IOException{ //FIXME logica de inserir ordenado
		if(produtos.vazia()) {
			this.produtos.insereFim(a);
		}if(a.getValidade().isBefore(((Produto) produtos.retornaPrimeiro()).getValidade())) {
			this.produtos.insereComeco(a);
		}else if(a.getValidade().isAfter(((Produto) produtos.retornaUltimo()).getValidade())){
			this.produtos.insereFim(a);
		}else {
			this.produtos.insereFim(a); //FIXME logica de inserir no segundo lugar
		}
	}
	
	public void removerProdutoPodre(Produto a) throws IOException {
        if(a.getValidade().isAfter(getHoje())) {
            this.produtos.remove(a);
        }
        this.qtdePodres++;
    }
	
	public CListaDup getProdutos() {
		return produtos;
	}
	
	public LocalDate getHoje() {
		return hoje;
	}
	
	public int getQtdePodres() {
		return qtdePodres;
	}

}

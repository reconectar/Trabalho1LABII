package estoquedomiciliar;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

public class Estoque implements Ordenavel{
	
	private CListaDup produtos;
	private LocalDate hoje;
	
	public Estoque(){
		produtos = new CListaDup();	
		hoje = LocalDate.now();
	}
	
	public void writeFile(Produto a) throws IOException{
		String path = "BancoDeDados.txt";
		boolean append = true;
		FileOutputStream arquivo = new FileOutputStream(path, append);
		arquivo.write(a.toString().getBytes());
		arquivo.close();
	}
	
	public void adicionarProduto(Produto a) throws IOException{
		if(produtos.vazia()) {
			this.produtos.insereFim(a);
		}if(a.getValidade().isBefore(((Produto) produtos.retornaPrimeiro()).getValidade())) {
			this.produtos.insereComeco(a);
		}else {
			this.produtos.insereFim(a);
		}
	}

	@Override
	public boolean menorQue(Ordenavel o) {
		// TODO Fazer logica de ordenação
		return false;
	}
	

}

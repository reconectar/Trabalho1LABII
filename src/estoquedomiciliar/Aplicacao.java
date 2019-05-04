package estoquedomiciliar;

import java.io.FileOutputStream;
import java.io.IOException;

public class Aplicacao {
	
	public static void writeFile(Produto a) throws IOException {
		String path = "teste.txt";
		boolean append = true;
		FileOutputStream arquivo = new FileOutputStream(path, append);
		arquivo.write(a.toString().getBytes());
		arquivo.close();
	}

	public static void main(String[] args) {		
		try {
			Produto a = new Produto();
			
			writeFile(a);
			
		}catch(Exception e) {
			
		}finally {
			
		}

	}

}

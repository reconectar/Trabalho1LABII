package EstoqueDomiciliar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Estoque {
	@Override
	public String toString() {
		return "Estoque [nomeDoItem=" + nome + ", DataValidade=" + data + "]";
	}

	private static final Map<String, Estoque> Cadastro = new HashMap<>();


    public static Estoque pesquisar(String nome) {
        return Estoque.get(nome);
    }

    public static Estoque get(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private final String nome;
    private final String data;
    

    public Estoque(String nome, String data) {
        
        this.nome = nome;
        this.data = data;
    }
    
public static void salvarEstoque(File file, Estoque Estoque) throws FileNotFoundException {
	
	FileOutputStream saida = null;
	OutputStreamWriter gravador = null;
	BufferedWriter buffer_saida = null;
	
	BufferedReader buffRead = new BufferedReader (new FileReader(file));
	
	buffRead.lines().count();
	
	
	try {
		
	saida = new FileOutputStream(file, true);
	gravador = new OutputStreamWriter(saida);
	buffer_saida = new BufferedWriter(gravador);
	buffRead.lines().count();
		
	buffer_saida.write(Estoque.nome + " ");
	buffer_saida.write(Estoque.data);
	buffer_saida.newLine();
	
	
		
	buffer_saida.flush();
	}catch (Exception Exception) {
		
		}   
	}
}

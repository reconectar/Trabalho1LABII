package estoquedomiciliar;

public class Ordenador {
	public static Ordenavel[] crescente(Ordenavel[] entrada) {
		Ordenavel temp;
		Ordenavel[] saida = entrada.clone();
		for (int i = 1; i < saida.length; i++) {
			for (int j = i; j > 0; j--) {
				if (saida[j].menorQue(saida[j - 1])) {
					temp = saida[j];
					saida[j] = saida[j - 1];
					saida[j - 1] = temp;
				}
			}
		}
		return saida;
	}

	public static Ordenavel[] decrescente(Ordenavel[] entrada) {
		Ordenavel temp;
		Ordenavel[] saida = entrada.clone();
		for (int i = 1; i < saida.length; i++) {
			for (int j = i; j > 0; j--) {
				if (!saida[j].menorQue(saida[j - 1])) {
					temp = saida[j];
					saida[j] = saida[j - 1];
					saida[j - 1] = temp;
				}
			}
		}
		return saida;
	}
}

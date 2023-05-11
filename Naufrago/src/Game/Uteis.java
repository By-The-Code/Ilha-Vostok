package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Uteis {

	// VARIAVÉIS
	Random random = new Random();

	List<String> relatorio = new ArrayList<String>();
	int ataques = 0;
	int fugas = 0;

	// PRINTA O TEXTO LETRA POR LETRA, PARA FAZER UMA 'ANIMAÇÃO' AO INVÉS DO PRINT
	// PADRÃO
	public void printaTexto(String texto, int tempo) {
		for (int i = 0; i < texto.length(); i++) {
			System.out.print(texto.charAt(i));
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// "LIMPA O CONSOLE", PRINTANDO 50 LINHAS EM BRANCO.
	public void limpaConsole() {

		for (int i = 0; i <= 50; i++) {
			System.out.println();
		}
	}

	// GERA UM NÚMERO 'ALEATÓRIO' ENTRE OS VALORES PASSADOS
	public int geraNumeroRandomico(int valorMin, int valorMax) {
		return random.nextInt(valorMin, valorMax);
	}

	// CONTINUA COM O MÉTODO SEGUINTE APERTANDO QUALQUER TECLA, DEFINIMOS 'ENTER'
	// APENAS PARA FACILITAR AO JOGADOR
	public boolean Continuar() {

		System.out.println("||************************************||\n"
				+ "||  Pressione 'ENTER' para continuar. ||\n"
				+ "||************************************||\n");

		String input = Game.sc.nextLine();

		if (input == "" || input != "")
			return true;
		else
			return true;
	}

	// EXECUTA O PRÓXIMO COMANDO APÓS X PERÍODO DE TEMPO, 25 = 2500 = 2 SEGUNDOS E 5
	// MILÉSSIMOS
	public void delayParaProximoComando(int tempo) {

		tempo *= 100;
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ADIÇÃO RELATÓRIOS
	public void addRelatorios(String text) {
		relatorio.add(text);
		// for (int i = 0; i <= relatorio.size(); i++) {
		// System.out.println(relatorio.get(i));
		// }
	}

	public void mostraRelatorio() {

		Game.uteis.limpaConsole();

		String rel = "\n                            RELATÓRIO: ";

		printaTexto(rel, 5);

		for (int i = 0; i < relatorio.size(); i++) {
			System.out.print(" || " + relatorio.get(i) + " || ");
			System.out.println("|| ");
		}

		System.out.println("ATAQUES:" + ataques);
		System.out.println("FUGAS: " + fugas);

	}
}

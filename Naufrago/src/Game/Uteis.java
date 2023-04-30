package Game;

import java.util.Random;

public class Uteis {
	
	Random random = new Random();

	public void printaTexto(String texto, int tempo) {
		for(int i = 0; i < texto.length(); i++) {
			System.out.print(texto.charAt(i));
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();	
			}
		}
	}
	
	public void limpaConsole() { 
		
		for (int i = 0; i <= 50; i++) {
			System.out.println();
		}
	}
	
	public int geraNumeroRandomico(int valorMin, int valorMax) {
		return random.nextInt(valorMin, valorMax);
	}
	
	public boolean Continuar() {
		
		System.out.println(	"||************************************||\n"
						+ 	"||  Pressione 'ENTER' para continuar. ||\n"
						+ 	"||************************************||\n");
		
		String input = Game.sc.nextLine();
		
		if (input == "" || input != "") return true;
		else return true;
	}
	
	public void delayParaProximoComando(int tempo) {
		
		tempo *= 100;
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

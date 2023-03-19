package Game;

public class Uteis {

	public void printaTexto(String texto, int tempo) {
		for(int loop = 0; loop < texto.length(); loop++) {
			System.out.print(texto.charAt(loop));
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
	
	public double geraNumeroRandomico() {
		double random = Math.random() * 101;
		return random;
	}
}

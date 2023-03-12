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
	
	public void limparConsole() { 
		
		for (int i = 0; i <= 50; i++) {
			System.out.println();
		}
	}
}

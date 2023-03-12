package Game;

public class Game {
	
	public static Menu menu = new Menu();
	public static Uteis uteis = new Uteis();
		
	public static void main(String [] args) {
		
		String texto = 	"+========================================+\n" 
				+ 		"|         By The Code - Apresenta        |\n"
				+ 		"+========================================+\n"
				+ 		"|                                        |\n"
				+ 		"|                NAUFRAGO                |\n"
				+       "|                                        |\n"
				+ 		"+========================================+\n";
		
		uteis.printaTexto(texto, 25);
		try {
			Thread.sleep(2000);
			uteis.limparConsole();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		menu.getMenu();
	}
}
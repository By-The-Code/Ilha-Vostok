package Game;

public class Game {
	
	public static GameController gc = new GameController();
	
	public static void main(String [] args) {
		gc.menu.getIntro();
		/*gc.jogador = new Jogador ("Alfonse", "PROFESSOR");
		gc.historia.PrimeiroAto();*/
	}
}
package Game;

public class Game {
	
	public static GameController gc = new GameController();
	
	public static void main(String [] args) {
		gc.jogador = new Jogador ("Alfonse", "PROFESSOR");
		
		System.out.println(gc.jogador.getStatus());
		gc.historia.PrimeiroAto();
	}
}
package Game;

public class Game {
	
	public static GameController gc = new GameController();
	
	public static void main(String [] args) {
		gc.jogador = new Jogador ("Josué", "MÉDICO");
		gc.jogador.setNivel(2);
		gc.escolherInimigo();
		if (gc.inimigo != null) {
			gc.jogador.getStatus();
			gc.inimigo.getStatusInimigo();
		}
		/*gc.jogador = new Jogador ("Alfonse", "PROFESSOR");
		gc.historia.PrimeiroAto();*/
	}
}
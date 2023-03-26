package Game;
import java.util.Scanner;

public class GameController {
	
	public static Scanner sc = new Scanner(System.in);
	public static Menu menu = new Menu();
	public static Uteis uteis = new Uteis();
	public static Inimigo inimigo = new Inimigo();
	public static Jogador jogador;
	public static Historia historia = new Historia();

	public static void escolherInimigo() {
		int random = uteis.geraNumeroRandomico(0, 101);
		int randomAtt = uteis.geraNumeroRandomico(-2, 3);
		
		if (random >= 50 && random <= 65) {
			System.out.println("Você encontrou um Macaco-Aranha enquanto andava");
			Inimigo("Macaco-Aranha", 10 * jogador.getNivel() + randomAtt, 5 + jogador.getNivel() + randomAtt, 5 + jogador.getNivel() + randomAtt, jogador.getNivel() + randomAtt); 
		}
		else if (random >= 66 && random <= 85) {
			System.out.println("Você encontrou uma Cobra-Voadora enquanto andava");
			Inimigo("Cobra-Voadora", 10 * jogador.getNivel() + randomAtt, 5 + jogador.getNivel() + randomAtt, 5 + jogador.getNivel() + randomAtt, jogador.getNivel() + randomAtt); 
		}
		else if (random >= 86) {
			System.out.println("SpVocê encontrou uma Lacraia Gigante enquanto andava");
			Inimigo("Lacraia", 10 * jogador.getNivel() + randomAtt, 5 + jogador.getNivel() + randomAtt, 5 + jogador.getNivel() + randomAtt, jogador.getNivel() + randomAtt); 
		}
		else {
			return;
		}
	}
	
	public static void Inimigo(String nomeInimigo, int vidaInimigo, int forcaInimigo, int resistenciaInimigo, int nivelInimigo) {
		inimigo = new Inimigo(nomeInimigo, vidaInimigo, forcaInimigo, resistenciaInimigo, nivelInimigo);
	}
}
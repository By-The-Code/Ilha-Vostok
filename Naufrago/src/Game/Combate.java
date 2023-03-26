package Game;

public class Combate {
	
	private static int errarAtaque;
	
	public void escolherInimigo() {
		int random = GameController.uteis.geraNumeroRandomico(0, 101);
		int randomAtt = GameController.uteis.geraNumeroRandomico(-2, 3);
		
		if (random >= 10 && random <= 65) {
			System.out.println("Você encontrou um Macaco-Aranha enquanto andava");
			istInimigo("Macaco-Aranha", 10 * GameController.jogador.getNivel() + randomAtt, 
					2 + GameController.jogador.getNivel() + randomAtt, 
					2 + GameController.jogador.getNivel() + randomAtt, 
						GameController.jogador.getNivel() + randomAtt); 
		}
		else if (random >= 66 && random <= 85) {
			System.out.println("Você encontrou uma Cobra-Voadora enquanto andava");
			istInimigo("Cobra-Voadora", 10 * GameController.jogador.getNivel() + randomAtt, 
					2 + GameController.jogador.getNivel() + randomAtt, 
					2 + GameController.jogador.getNivel() + randomAtt, 
						GameController.jogador.getNivel() + randomAtt); 
		}
		else if (random >= 86) {
			System.out.println("Você encontrou uma Lacraia Gigante enquanto andava");
			istInimigo("Lacraia", 10 * GameController.jogador.getNivel() + randomAtt, 
					2 + GameController.jogador.getNivel() + randomAtt, 
					2 + GameController.jogador.getNivel() + randomAtt, 
						GameController.jogador.getNivel() + randomAtt); 
		}
		else {
			return;
		}
	}
	
	public static void istInimigo(String nomeInimigo, int vidaInimigo, int forcaInimigo, int resistenciaInimigo, int nivelInimigo) {
		GameController.inimigo = new Inimigo(nomeInimigo, vidaInimigo, forcaInimigo, resistenciaInimigo, nivelInimigo);
		
		System.out.println("Você encontra o inimigo: " + GameController.inimigo.getNomeInimigo() + ".\n\n");
		combate();
	}
	
	public static void combate() {
		
		System.out.println(
						   "||*************  O QUE VOCÊ FAZ? *************||\n"
				         + "||============================================||\n"
				         + "|| 1 - Atacar                                 ||\n"
				         + "|| 2 - Fugir                                  ||\n"
				         + "||============================================||\n");
		
		String input = GameController.sc.nextLine().toUpperCase();
		
		switch (input) {
		case "1", "ATACAR":
			ataque();
			break;
		case "2", "FUGIR":
			System.out.println("Você fugiu!");
			return;
			
		default: 
			System.out.println("Opção Inválida");
			combate();
		}
	}
	
	public static void ataque() {
		errarAtaque = GameController.uteis.geraNumeroRandomico(0, 11);
		
		System.out.println(	"Você tenta atacar o(a) " + GameController.inimigo.getNomeInimigo() + ".\n"
						  + "Seus Status: \n" + GameController.jogador.getStatus() + "\n"
						  +	"Status Inimigo: \n" + GameController.inimigo.getStatusInimigo());
		
		if (errarAtaque < 2) {
			System.out.println("Você errou o ataque");
			dano();
		}
		else {
			GameController.inimigo.setVidaInimigo(GameController.jogador.getDanoJogador(GameController.inimigo.getResistenciaInimigo()));
			System.out.println(	"Você deu " + GameController.jogador.getDanoJogador(GameController.inimigo.getResistenciaInimigo()) + " de dano.\n"
							+	"Vida atual do inimigo: " + GameController.inimigo.getVidaInimigo());
			
			if (GameController.inimigo.getVidaInimigo() > 0)
			dano();
			
			else {
				GameController.jogador.passaDeNivel(GameController.inimigo.getVidaInicialInimigo() / GameController.inimigo.getNivelInimigo());
				System.out.println(GameController.jogador.getStatus());
			}
		}
	}
	
	public static void dano() {
		errarAtaque = GameController.uteis.geraNumeroRandomico(0, 11);
		
		System.out.println(	/*"Sua vida atual" + GameController.jogador.getVida() + ".\n"
						+ 	"Vida do inimigo" + GameController.inimigo.getVidaInimigo()*/
							"O " + GameController.inimigo.getNomeInimigo() + " tenta te atacar");
		
		if (errarAtaque < 2) {
			System.out.println(GameController.inimigo.getNomeInimigo() + " errou o ataque");
			combate();
		}
		else {
			GameController.jogador.setVidaDano(GameController.inimigo.danoInimigo(GameController.jogador.getDefesaJogador()));
			System.out.println(	"Você recebeu " + GameController.inimigo.danoInimigo(GameController.jogador.getDefesaJogador()) + " de dano.\n"
							+	"Sua vida atual: " + GameController.jogador.getVida());
			
			if (GameController.jogador.getVida() > 0)
			combate();
			
			else GameController.historia.gameOver();
		}
	}
}

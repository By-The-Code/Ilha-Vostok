package Game;

public class Combate {
	
	private static int errarAtaque;
	
	public void escolherInimigo() {
		int random = Game.uteis.geraNumeroRandomico(0, 101);
		int randomAtt = Game.uteis.geraNumeroRandomico(-2, 3);
		
		if (random >= 10 && random <= 65) {
			System.out.println("Você encontrou um Macaco-Aranha enquanto andava");
			istInimigo("Macaco-Aranha", 10 * Game.jogador.getNivel() + randomAtt, 
					2 + Game.jogador.getNivel() + randomAtt, 
					2 + Game.jogador.getNivel() + randomAtt, 
						Game.jogador.getNivel() + randomAtt); 
		}
		else if (random >= 66 && random <= 85) {
			System.out.println("Você encontrou uma Cobra-Voadora enquanto andava");
			istInimigo("Cobra-Voadora", 10 * Game.jogador.getNivel() + randomAtt, 
					2 + Game.jogador.getNivel() + randomAtt, 
					2 + Game.jogador.getNivel() + randomAtt, 
						Game.jogador.getNivel() + randomAtt); 
		}
		else if (random >= 86) {
			System.out.println("Você encontrou uma Lacraia Gigante enquanto andava");
			istInimigo("Lacraia", 10 * Game.jogador.getNivel() + randomAtt, 
					2 + Game.jogador.getNivel() + randomAtt, 
					2 + Game.jogador.getNivel() + randomAtt, 
						Game.jogador.getNivel() + randomAtt); 
		}
		else {
			return;
		}
	}
	
	public static void istInimigo(String nomeInimigo, int vidaInimigo, int forcaInimigo, int resistenciaInimigo, int nivelInimigo) {
		Game.inimigo = new Inimigo(nomeInimigo, vidaInimigo, forcaInimigo, resistenciaInimigo, nivelInimigo);
		
		System.out.println("Você encontra o inimigo: " + Game.inimigo.getNomeInimigo() + ".\n\n");
		combate();
	}
	
	public static void combate() {
		
		System.out.println(
						   "||*************  O QUE VOCÊ FAZ? *************||\n"
				         + "||============================================||\n"
				         + "|| 1 - Atacar                                 ||\n"
				         + "|| 2 - Fugir                                  ||\n"
				         + "||============================================||\n");
		
		String input = Game.sc.nextLine().toUpperCase();
		
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
		errarAtaque = Game.uteis.geraNumeroRandomico(0, 11);
		
		System.out.println(	"Você tenta atacar o(a) " + Game.inimigo.getNomeInimigo() + ".\n"
						  + "Seus Status: \n" + Game.jogador.getStatus() + "\n"
						  +	"Status Inimigo: \n" + Game.inimigo.getStatusInimigo());
		
		if (errarAtaque < 2) {
			System.out.println("Você errou o ataque");
			dano();
		}
		else {
			Game.inimigo.setVidaInimigo(Game.jogador.getDanoJogador(Game.inimigo.getResistenciaInimigo()));
			System.out.println(	"Você deu " + Game.jogador.getDanoJogador(Game.inimigo.getResistenciaInimigo()) + " de dano.\n"
							+	"Vida atual do inimigo: " + Game.inimigo.getVidaInimigo());
			
			if (Game.inimigo.getVidaInimigo() > 0)
			dano();
			
			else {
				Game.jogador.passaDeNivel(Game.inimigo.getVidaInicialInimigo() / Game.inimigo.getNivelInimigo());
				System.out.println(Game.jogador.getStatus());
			}
		}
	}
	
	public static void dano() {
		errarAtaque = Game.uteis.geraNumeroRandomico(0, 11);
		
		System.out.println(	/*"Sua vida atual" + Game.jogador.getVida() + ".\n"
						+ 	"Vida do inimigo" + Game.inimigo.getVidaInimigo()*/
							"O " + Game.inimigo.getNomeInimigo() + " tenta te atacar");
		
		if (errarAtaque < 2) {
			System.out.println(Game.inimigo.getNomeInimigo() + " errou o ataque");
			combate();
		}
		else {
			Game.jogador.setVidaDano(Game.inimigo.danoInimigo(Game.jogador.getDefesaJogador()));
			System.out.println(	"Você recebeu " + Game.inimigo.danoInimigo(Game.jogador.getDefesaJogador()) + " de dano.\n"
							+	"Sua vida atual: " + Game.jogador.getVida());
			
			if (Game.jogador.getVida() > 0)
			combate();
			
			else Game.historia.gameOver();
		}
	}
}

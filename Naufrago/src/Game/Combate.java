package Game;

public class Combate {
	
	private static int errarAtaque;
	
	public void escolherInimigo() {
		int random = Game.uteis.geraNumeroRandomico(0, 101);
		//int randomAtt = Game.uteis.geraNumeroRandomico(-1, 3);
		String criatura = "";
		
		if (random >= 10 && random <= 65) {
			criatura = "Macaco-Aranha";
		}
		else if (random >= 66 && random <= 85) {
			criatura = "Cobra Voadora";
		}
		else if (random >= 86) {
			criatura = "Lacraia Gigante";
		}
		else {
			return;
		}
		
		spawnaInimigo(criatura, 10 	* 	Game.jogador.getNivel(), //+ randomAtt, 
								3 	*	Game.jogador.getNivel(), //+ randomAtt, 
								3 	* 	Game.jogador.getNivel(), //+ randomAtt, 
										Game.jogador.getNivel());
	}
	

	public void spawnaInimigo(String nomeInimigo, int vidaInimigo, int forcaInimigo, int resistenciaInimigo, int nivelInimigo) {
		Game.inimigo = new Inimigo(nomeInimigo, vidaInimigo, forcaInimigo, resistenciaInimigo, nivelInimigo);
		
		System.out.println("Você encontra o inimigo: " + Game.inimigo.getNomeInimigo() + ".\n\n");
		combate();
	}
	
	public static void combate() {
		
		System.out.println("||*************  O QUE VOCÊ FAZ? *************||\n"
				         + "||============================================||\n"
				         + "|| 1 - Atacar                                 ||\n"
				         + "|| 2 - Fugir                                  ||\n"
				         + "||============================================||");
		
		String input = Game.sc.nextLine().toUpperCase();
		
		switch (input) {
		case "1", "ATACAR":
			ataqueJogador();
			break;
		case "2", "FUGIR":
			System.out.println(	"||*******************||\n"
							+ 	"||    VOCÊ FUGIU!    ||\n"
							+ 	"||*******************||\n");
			return;
			
		default: 
			System.out.println("Opção Inválida");
			combate();
		}
	}
	
	public static void ataqueJogador() {
		errarAtaque = Game.uteis.geraNumeroRandomico(0, 11);
		
		System.out.println(	"Você tenta atacar o(a) " + Game.inimigo.getNomeInimigo() + ".\n"
						  + "Seus Status: \n" + Game.jogador.getStatus() + "\n"
						  +	"Status Inimigo: \n" + Game.inimigo.getStatusInimigo());
		
		if (errarAtaque < 2) {
			System.out.println("Você errou o ataque");
			ataqueInimigo();
		}
		else {
			Game.inimigo.setVidaInimigo(Game.jogador.getDanoJogador(Game.inimigo.getResistenciaInimigo()));
			System.out.println(	"Você deu " + Game.dc.format(Game.jogador.getDanoJogador(Game.inimigo.getResistenciaInimigo())) + " de dano.\n"
							+	"Vida atual do inimigo: " + Game.inimigo.getVidaInimigo());
			
			if (Game.inimigo.getVidaInimigo() > 0)
				ataqueInimigo();
			
			else {
				Game.jogador.passaDeNivel(Game.inimigo.dropExperiencia());
				System.out.println(Game.jogador.getStatus());
			}
		}
	}
	
	public static void ataqueInimigo() {
		errarAtaque = Game.uteis.geraNumeroRandomico(0, 11);
		
		System.out.println("O " + Game.inimigo.getNomeInimigo() + " tenta te atacar");
		
		if (errarAtaque < 2) {
			System.out.println(Game.inimigo.getNomeInimigo() + " errou o ataque");
			combate();
		}
		else {
			Game.jogador.setVidaDano(Game.inimigo.danoInimigo(Game.jogador.getDefesaJogador()));
			System.out.println(	"Você recebeu " + Game.dc.format(Game.inimigo.danoInimigo(Game.jogador.getDefesaJogador())) + " de dano.\n"
							+	"Sua vida atual: " + Game.jogador.getVida());
			
			if (Game.jogador.getVida() > 0)
			combate();
			
			else Game.historia.gameOver();
		}
	}
}

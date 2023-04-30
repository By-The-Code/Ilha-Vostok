package Game;

public class Combate {
	
	private static int errarAtaque;
	private static int danoCritico;
	private static int inimigoSpawnControl = 0;
	
	
	public void inimigo(String tipoInimigo, String nomeBoss) {
		
		String criatura = "";
		int bossStatus = 1;
		int randomAtt = Game.uteis.geraNumeroRandomico(0, 3);
		int random = Game.uteis.geraNumeroRandomico(0, 101);
		
		if(tipoInimigo == "inimigo") {
			
			if (random >= 10 && random <= 65) {
				criatura = "Macaco-Aranha";
			}
			else if (random >= 66 && random <= 85) {
				criatura = "Cobra-Voadora";
			}
			else if (random >= 86) {
				criatura = "Lacraia-Maior";
			}
			else {
				return;
			}
			
			spawnaInimigo(criatura, 10 	* 	Game.jogador.getNivel(), //+ randomAtt, 
									3 	*	Game.jogador.getNivel(), //+ randomAtt, 
									3 	* 	Game.jogador.getNivel(), //+ randomAtt, 
											Game.jogador.getNivel() + randomAtt,
											tipoInimigo);
		}
		
		else {
			if (random <= 50) {
				spawnaInimigo(nomeBoss, 25 	* 	Game.jogador.getNivel() + bossStatus, //+ randomAtt, 
										4 	*	Game.jogador.getNivel() + bossStatus, //+ randomAtt, 
										4 	* 	Game.jogador.getNivel() , //+ randomAtt, 
												Game.jogador.getNivel() + bossStatus + randomAtt * 2,
												tipoInimigo);
				bossStatus++;
			}
			else {
				spawnaInimigo(nomeBoss, 25 	* 	Game.jogador.getNivel() + bossStatus, //+ randomAtt, 
										4 	*	Game.jogador.getNivel() , //+ randomAtt, 
										4 	* 	Game.jogador.getNivel() + bossStatus, //+ randomAtt, 
												Game.jogador.getNivel() + bossStatus + randomAtt * 2,
												tipoInimigo);
				bossStatus++;
			}
		}
	}
	

	public void spawnaInimigo(String nomeInimigo, int vidaInimigo, int forcaInimigo, int resistenciaInimigo, int nivelInimigo, String tipoInimigo) {
		
		if (tipoInimigo == "inimigo")
		{
			Game.inimigo = new Inimigo(nomeInimigo, vidaInimigo, forcaInimigo, resistenciaInimigo, nivelInimigo);
			System.out.println("Você encontra o inimigo: " + Game.inimigo.getNomeInimigo() + ".\n\n");
		}
		
		else {
			Game.boss = new Boss(nomeInimigo, vidaInimigo, forcaInimigo, resistenciaInimigo, nivelInimigo);
			System.out.println("Você encontra o inimigo: " + Game.boss.getNomeInimigo() + ".\n\n");
		}
		
		combate(tipoInimigo);
	}
	
	public static void combate(String tipoInimigo) {
		
		
		if (inimigoSpawnControl == 0) {
			System.out.println("||*************  O QUE VOCÊ FAZ? *************||\n"
					         + "||============================================||\n"
					         + "|| 1 - Atacar                                 ||\n"
					         + "||============================================||"
					         );
		}
		
		else if (inimigoSpawnControl == 1) { 
			System.out.println("||*************  O QUE VOCÊ FAZ? *************||\n"
					         + "||============================================||\n"
					         + "|| 2 - Fugir                                  ||\n"
					         + "||============================================||");
		}
		
		else {
			System.out.println("||*************  O QUE VOCÊ FAZ? *************||\n"
					         + "||============================================||\n"
					         + "|| 1 - Atacar                                 ||\n"
					         + "|| 2 - Fugir                                  ||\n"
					         + "||============================================||");
			
		}
		
		String input = Game.sc.next().toUpperCase();
			
		switch (input) {
		case "1", "ATACAR":
			ataqueJogador(tipoInimigo);
			break;
		case "2", "FUGIR":
			if (tipoInimigo == "boss") {
				System.out.println(	"Você não pode fugir!\n\n");
				combate(tipoInimigo);
			}
			else {
			inimigoSpawnControl++;
			System.out.println(	"||*******************||\n"
							+ 	"||    VOCÊ FUGIU!    ||\n"
							+ 	"||*******************||\n");
			}
			return;
				
		default: 
			System.out.println("Opção Inválida");
			combate(tipoInimigo);
		}
	}
	
	public static void ataqueJogador(String tipoInimigo) {
		errarAtaque = Game.uteis.geraNumeroRandomico(0, 11);
		
		if(tipoInimigo == "inimigo") {
			System.out.println(	"Você tenta atacar o(a) " + Game.inimigo.getNomeInimigo() + ".\n"
					  		+ 	"Seus Status: \n" + Game.jogador.getStatus() + "\n"
					  		+	"Status Inimigo: \n" + Game.inimigo.getStatusInimigo() + "\n");
		}
		else {
			System.out.println(	"Você tenta atacar o(a) " + Game.boss.getNomeInimigo() + ".\n"
					  		+ 	"Seus Status: \n" + Game.jogador.getStatus() + "\n"
					  		+	"Status Inimigo: \n" + Game.boss.getStatusInimigo() + "\n");
		}
		
		
		if (errarAtaque < 2) {
			System.out.println("Você errou o ataque");
			ataqueInimigo(tipoInimigo);
		}
		
		else {
			danoCritico = Game.uteis.geraNumeroRandomico(0, 11);
			
			if (tipoInimigo == "inimigo") {
				
				if (danoCritico > 8) {
					Game.inimigo.setVidaInimigo(Game.jogador.getDanoJogador(Game.inimigo.getResistenciaInimigo()) * 2);
					System.out.println(	"Você deu " + Game.dc.format(Game.jogador.getDanoJogador(Game.inimigo.getResistenciaInimigo()) * 2) + " de dano.\n"
									+	"Vida atual do inimigo: " + Game.inimigo.getVidaInimigo() + "\n");
				}
					
				else {
					Game.inimigo.setVidaInimigo(Game.jogador.getDanoJogador(Game.inimigo.getResistenciaInimigo()));
					System.out.println(	"Você deu " + Game.dc.format(Game.jogador.getDanoJogador(Game.inimigo.getResistenciaInimigo())) + " de dano.\n"
									+	"Vida atual do inimigo: " + Game.inimigo.getVidaInimigo() + "\n");
				}
				
				if (Game.inimigo.getVidaInimigo() > 0)
					ataqueInimigo(tipoInimigo);
				
				else {
					inimigoSpawnControl++;
					System.out.println("Você derrotou o(a)) " + Game.inimigo.getNomeInimigo() + ".\n");
					Game.jogador.passaDeNivel(Game.inimigo.dropExperiencia());
					System.out.println(Game.jogador.getStatus() + "\n");
				}
			}
			else {
				Game.boss.setVidaInimigo(Game.jogador.getDanoJogador(Game.boss.getResistenciaInimigo()));
				System.out.println(	"Você deu " + Game.dc.format(Game.jogador.getDanoJogador(Game.boss.getResistenciaInimigo())) + " de dano.\n"
								+	"Vida atual do inimigo: " + Game.boss.getVidaInimigo() + "\n");
				
				if (Game.boss.getVidaInimigo() > 0)
					ataqueInimigo(tipoInimigo);
				
				else {
					System.out.println("Você derrotou o(a)) ;" + Game.boss.getNomeInimigo());
					Game.jogador.passaDeNivel(Game.boss.dropExperiencia());
					System.out.println(Game.jogador.getStatus() + "\n");
				}
			}
		}
	}
	
	public static void ataqueInimigo(String tipoInimigo) {
		errarAtaque = Game.uteis.geraNumeroRandomico(0, 11);
		
		if(tipoInimigo == "inimigo")
			System.out.println("O " + Game.inimigo.getNomeInimigo() + " tenta te atacar");
		
		else 
			System.out.println("O " + Game.boss.getNomeInimigo() + " tenta te atacar");
		
		if (errarAtaque < 2 && tipoInimigo == "inimigo") {
			System.out.println(Game.inimigo.getNomeInimigo() + " errou o ataque\n");
			combate(tipoInimigo);
		}
		else if (errarAtaque < 2 && tipoInimigo == "boss") {
			System.out.println(Game.boss.getNomeInimigo() + " errou o ataque\n");
			combate(tipoInimigo);
		}
		
		else {
			danoCritico = Game.uteis.geraNumeroRandomico(0, 11);
			
			if(tipoInimigo == "inimigo") {
				
				if (danoCritico > 8) {
					Game.jogador.setVidaDano(Game.inimigo.danoInimigo(Game.jogador.getDefesaJogador()) * 2);
					System.out.println(	"Você recebeu " + Game.dc.format(Game.inimigo.danoInimigo(Game.jogador.getDefesaJogador()) * 2) + " de dano.\n"
									+	"Sua vida atual: " + Game.jogador.getVida() + "\n");
				}
				else {
					Game.jogador.setVidaDano(Game.inimigo.danoInimigo(Game.jogador.getDefesaJogador()));
					System.out.println(	"Você recebeu " + Game.dc.format(Game.inimigo.danoInimigo(Game.jogador.getDefesaJogador())) + " de dano.\n"
									+	"Sua vida atual: " + Game.jogador.getVida() + "\n");
				}
				
				if (Game.jogador.getVida() > 0)
					combate(tipoInimigo);
				
				else Game.gameOver();
			}
			
			else {
				if (danoCritico > 8) {
					Game.jogador.setVidaDano(Game.boss.danoInimigo(Game.jogador.getDefesaJogador()) * 2);
					System.out.println(	"Você recebeu " + Game.dc.format(Game.boss.danoInimigo(Game.jogador.getDefesaJogador()) * 2) + " de dano.\n"
									+	"Sua vida atual: " + Game.jogador.getVida() + "\n");
				}
				else {
					Game.jogador.setVidaDano(Game.boss.danoInimigo(Game.jogador.getDefesaJogador()));
					System.out.println(	"Você recebeu " + Game.dc.format(Game.boss.danoInimigo(Game.jogador.getDefesaJogador())) + " de dano.\n"
									+	"Sua vida atual: " + Game.jogador.getVida() + "\n");
				}
				
				if (Game.jogador.getVida() > 0)
					combate(tipoInimigo);
				
				else Game.gameOver();
			}
		}
	}
}

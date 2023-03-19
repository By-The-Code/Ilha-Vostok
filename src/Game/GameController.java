package Game;
import java.util.Scanner;

public class GameController {
	
	public static Scanner sc = new Scanner(System.in);
	public static Menu menu = new Menu();
	public static Uteis uteis = new Uteis();
	public static Inimigo inimigo;
	public static Jogador jogador;
	public static Historia historia = new Historia();


	/*
	private static String nome;
	private static int profissao;
	*/
	
	/*
	public static void escolherNome() {
		String escolherNome = 	"Escolha seu nome: ";
		String temCerteza 	= 	"Tem certeza que esse é seu nome? \n"
							+ 	"1 - SIM\n"
							+ 	"2 - NÃO\n";
		uteis.printaTexto(escolherNome, 10);
		
		nome = sc.nextLine();
		uteis.printaTexto(temCerteza, 10);
		confirmarEscolha(sc.nextLine().toUpperCase(), 1);
	}
	
	public static void escolherProfissao() {
		String escolherProfissao = 	"Escolha sua profissão: \n"
								 + 	"+========================================================+\n"
								 + 	"|PROFI/STATUS  |   VIDA   |    FORÇA   |   RESISTÊNCIA   |\n"
								 + 	"+========================================================+\n"
								 + 	"|1 - MÉDICO    |    +15   |      +0    |        +5       |\n"
								 + 	"+========================================================+\n"
								 + 	"|2 - SOLDADO   |    +15   |      +5    |        +0       |\n"
								 + 	"+========================================================+\n"
								 + 	"|3 - PROFESSOR |    +10   |      +3    |        +3       |\n"
								 + 	"+========================================================+\n";
		String temCerteza 	= 	"Tem certeza que essa é sua profissão? \n"
							+ 	"1 - SIM\n"
							+ 	"2 - NÃO\n";
		
		uteis.printaTexto(escolherProfissao, 5);
		
		profissao = sc.nextInt();
		uteis.printaTexto(temCerteza, 10);
		confirmarEscolha(sc.nextLine().toUpperCase(), 2);
	}
	
	public static void confirmarEscolha(String escolha, int numEscolha) {
		switch (numEscolha) {
			case 1: 
				switch(escolha) {
					case "1", "SIM", "S": 
						escolherProfissao();
					break;
					case "2", "NAO", "N":
						escolherNome();
					break;
					default: uteis.printaTexto("Opção inválida!\n\n",2);
							 escolherNome();
				}
				break;
			case 2: 
				switch(escolha) {
					case "1", "SIM", "S": 
						teste();
					break;
					case "2", "NAO", "N":
						escolherProfissao();
					break;
					default: uteis.printaTexto("Opção inválida!\n\n", 2);
							 escolherProfissao();
				}
				break;
		}
	}
	
	public static void teste() {
		jogador = new Jogador(nome, profissao);
		jogador.getStatus();
	}
	
	public static void spawnInimigo(String nome, int vida, int forca, int resistencia, int nivel) {
		inimigo = new Inimigo(nome, vida, forca, resistencia, nivel); 
	}
	
	public static void escolherInimigo() {
		double random = uteis.geraNumeroRandomico();
		
		if (random >= 50 && random <= 65) {
			System.out.println("Spawnou o Macaco-Aranha");
			//spawnInimigo("Macaco-Aranha", 10, 2, 3, Game.jogador.getNivel()); 
		}
		else if (random >= 66 && random <= 85) {
			System.out.println("Spawnou a Cobra-Voadora");
			//spawnInimigo("Cobra-Voadora", 10, 2, 3, Game.jogador.getNivel()); 
		}
		else if (random >= 86) {
			System.out.println("Spawnou a Lacraia");
			//spawnInimigo("Lacraia", 10, 2, 3, Game.jogador.getNivel()); 
		}
		else {
			return;
		}
	}
	*/
}
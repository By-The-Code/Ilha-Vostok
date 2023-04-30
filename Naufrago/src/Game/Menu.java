package Game;

import java.util.Scanner;


public class Menu {
	
	Scanner entrada = new Scanner(System.in);
	
	public void intro() {
		String texto = 	"||****************************************||\n" 
				+ 		"||         By The Code - Apresenta        ||\n"
				+ 		"||========================================||\n"
				+ 		"||                                        ||\n"
				+ 		"||                NAUFRAGO                ||\n"
				+       "||                                        ||\n"
				+ 		"||****************************************||\n";
		
		Game.uteis.printaTexto(texto, 5);
		Game.uteis.delayParaProximoComando(30);
		Game.uteis.limpaConsole();
		menu();
	}

	public void menu() {
		
		 String menu = 	"||****************************************||\n" 
				+ 		"||                  Menu                  ||\n"
				+ 		"||========================================||\n"
				+ 		"||                                        ||\n"
				+ 		"||               1 - Jogar                ||\n"
				+       "||               2 - Instruções           ||\n"
				+       "||               3 - Créditos             ||\n"
				+       "||               4 - Sair                 ||\n"
				+ 		"||                                        ||\n"
				+ 		"||****************************************||\n";
		
		Game.uteis.printaTexto(menu, 5);
		 
		System.out.println("\nDigite uma opção:");
		int opcao = entrada.nextInt();
		
		switch (opcao) {
		case 1:
			Game.uteis.limpaConsole();
			Game.historia.intro();
			break;
		case 2:
			Game.uteis.limpaConsole();
			instrucoes();
			break;
		case 3:
			Game.uteis.limpaConsole();
			creditos();
			break;
		case 4:
			Game.uteis.limpaConsole();
			sair();
			break;
		default:
			System.out.println("Opção inválida!");
			Game.uteis.limpaConsole();
			menu();	
		}
	}
	
	public void instrucoes() {
		String instrucoes 	= "||****************************************** INSTRUÇÕES *******************************************||\n"
							+ "|| VidaMaxima: Vida máxima do jogador;                                                             ||\n"
							+ "|| Vida: Vida atual do jogador;                                                                    ||\n"
							+ "|| Força: Força atual do jogador, utilizada para o cálculo de dano;                                ||\n"
							+ "|| Resistência: Resistência atual do jogador, utilizada para o cálculo de defesa;                  ||\n"
							+ "|| XP: Experiência atual do jogador, utilizada para subir de nível;                                ||\n"
							+ "|| Arma: Arma atual do jogador, utilizada para o cálculo de dano;                                  ||\n"
							+ "|| Armadura: Armadura atual do jogador, utilizada para o cálculo de defesa;                        ||\n"
							+ "|| Escolhas: Para definir o que deseja fazer, digite o número correspondente a cada uma das opções ||\n"
							+ "||                                                                                                 ||\n"
							+ "|| Exemplo: 1 - Jogar | 2 - Sair, se quiser jogar, digite 1, se quiser sair digite 2.              ||\n"
							+ "||*************************************************************************************************||\n\n";
		
		Game.uteis.printaTexto(instrucoes, 5);
		voltar();	
	}
	
	public void creditos() {
		String creditos = "||************** CRÉDITOS **************||\n"
						+ "||               NAUFRAGO               ||\n"
						+ "||======================================||\n"
						+ "|| Uma produção By The Code             ||\n"
						+ "||                                      ||\n"
						+ "|| Uma criação de:                      ||\n"
						+ "|| Eduardo Ribeiro Torquato             ||\n"
						+ "|| Eliana Moura de Lima                 ||\n"
						+ "|| Nathalia Narumi Nakamura             ||\n"
						+ "|| Paulo Garcia Santos                  ||\n"
						+ "|| Vinicius Araujo da Silveira          ||\n"
						+ "||**************************************||\n\n";
	
		Game.uteis.printaTexto(creditos, 25);
		voltar();
		
	}
	
	
	public void sair() {
		System.out.println(	"||*************************************||\n"
						+ 	"||         OBRIGADO POR JOGAR!         ||\n"
						+ 	"||*************************************||\n");
		System.exit(1);
	}
	
	public void voltar() {
		System.out.println(	"||*************************************||\n"
						+ 	"||         DIGITE 1 PARA VOLTAR!       ||\n"
						+ 	"||*************************************||\n");
		int opcao = entrada.nextInt();
		
		if(opcao == 1)  {
			Game.uteis.limpaConsole();
			menu();
		} else {
			System.out.println("Opção Inválida!");
			voltar();	
		}
	}
}
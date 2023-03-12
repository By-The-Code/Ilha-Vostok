package Game;

import java.util.Scanner;


public class Menu {
	
	Scanner entrada = new Scanner(System.in);

	public void getMenu() {
		
		 String menu = 	"+========================================+\n" 
				+ 		"|                  Menu                  |\n"
				+ 		"+========================================+\n"
				+ 		"|                                        |\n"
				+ 		"|               1 - Jogar                |\n"
				+       "|               2 - Instruções           |\n"
				+       "|               3 - Créditos             |\n"
				+       "|               4 - Sair                 |\n"
				+ 		"|                                        |\n"
				+ 		"+========================================+\n";
		
		Game.uteis.printaTexto(menu, 15);
		 
		System.out.println("\nDigite uma opção:");
		int opcao = entrada.nextInt();
		
		switch (opcao) {
		case 1:
			Game.uteis.limparConsole();
			System.out.println("Escolheu a opção 1 Jogar");
			break;
		case 2:
			Game.uteis.limparConsole();
			instrucoes();
			break;
		case 3:
			Game.uteis.limparConsole();
			creditos();
			break;
		case 4:
			Game.uteis.limparConsole();
			sair();
			break;
		default:
			System.out.println("Opção inválida!");
			Game.uteis.limparConsole();
			getMenu();	
		}
	}
	
	public void jogar() {
		//esperando criação do jogo
		
	}
	
	public void instrucoes() {
		String instrucoes 	= "+===============INSTRUÇÕES===============+														\n\n"
							+ " VidaMaxima: Vida máxima do jogador;                                           					\n"
							+ " Vida: Vida atual do jogador;                                                  					\n"
							+ " Força: Força atual do jogador, utilizada para o cálculo de dano;              					\n"
							+ " Resistência: Resistência atual do jogador, utilizada para o cálculo de defesa;					\n"
							+ " XP: Experiência atual do jogador, utilizada para subir de nível;              					\n"
							+ " Arma: Arma atual do jogador, utilizada para o cálculo de dano;                					\n"
							+ " Armadura: Armadura atual do jogador, utilizada para o cálculo de defesa;      					\n"
							+ " Escolhas: Para definir o que deseja fazer, digite o número correspondente a cada uma das opções,\n"
							+ " Exemplo: 1 - Jogar | 2 - Sair, se quiser jogar, digite 1, se quiser sair digite 2.				\n\n"
							+ "+========================================+														\n\n";
		
		Game.uteis.printaTexto(instrucoes, 5);
		voltar();	
	}
	
	public void creditos() {
		String creditos = "+================CRÉDITOS================+		\n"
						+ "                 NAUFRAGO 						\n\n"
						+ " Uma produção de By The Code 					\n\n"
						+ " Uma criação de:         						\n"
						+ " Eduardo Ribeiro Torquato    					\n"
						+ " Eliana Moura de Lima      						\n"
						+ " Nathalia Narumi Nakamura    					\n"
						+ " Paulo Garcia Santos      						\n"
						+ " Vinicius Araujo da Silveira 					\n"
						+ "+========================================+  		\n\n";
	
		Game.uteis.printaTexto(creditos, 25);
		voltar();
		
	}
	
	
	public void sair() {
		System.out.println("Obrigado por Jogar!");
		System.exit(1);
	}
	
	public void voltar() {
		System.out.println("Digite 1 Para Voltar:");
		int opcao = entrada.nextInt();
		
		if(opcao == 1)  {
			Game.uteis.limparConsole();
			getMenu();
		} else {
			System.out.println("Opção Inválida!");
			voltar();	
		}
	}
}
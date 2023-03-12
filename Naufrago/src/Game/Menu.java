package Game;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
//Tipo da variável > nome da variável > atribuição de valor > valor
	Scanner entrada = new Scanner(System.in);

	public void getMenu() {
		 String menu = 	"+==================+\n" 
				+ 		"|       Menu       |\n"
				+ 		"+==================+\n"
				+ 		"|   1 - Jogar      |\n"
				+       "|   2 - Instruções |\n"
				+       "|   3 - Créditos   |\n"
				+       "|   4 - Sair       |\n"
				+ 		"+==================+";
		
		//for(variavelDeControle; Condição; Mudança Da Variável de Controle)
		for(int loop = 0; loop < menu.length(); loop++) {
			System.out.print(menu.charAt(loop));
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
		System.out.println("\nDigite uma opção:");
		int opcao = entrada.nextInt();
		
		switch (opcao) {
		case 1:
			System.out.println("Escolheu a opção 1 Jogar");
			limparConsole();
			break;
		case 2:
			limparConsole();
			instrucoes();
			break;
		case 3:
			limparConsole();
			creditos();
			break;
		case 4:
			limparConsole();
			sair();
			break;
		default:
			System.out.println("Opção inválida!");
			limparConsole();
			getMenu();	
		}
	}
	
	public void limparConsole() { 
	
		for (int i = 0; i <= 50; i++) {
			System.out.println();
		}
	}
	
	public void jogar() {
		//esperando criação do jogo
	}
	
	public void instrucoes() {
		String instrucoes = "VidaMaxima: Vida máxima do jogador;                                           \n"
				+           "Vida: Vida atual do jogador;                                                  \n"
				+           "Força: Força atual do jogador, utilizada para o cálculo de dano;              \n"
				+           "Resistência: Resistência atual do jogador, utilizada para o cálculo de defesa;\n"
				+           "XP: Experiência atual do jogador, utilizada para subir de nível;              \n"
				+           "Arma: Arma atual do jogador, utilizada para o cálculo de dano;                \n"
				+           "Armadura: Armadura atual do jogador, utilizada para o cálculo de defesa;      \n"
				+           "Escolhas: Para definir o que deseja fazer, digite o número correspondente a cada uma das opções,\n"
				+           "Exemplo: 1 - Jogar | 2 - Sair, se quiser jogar, digite 1, se quiser sair digite 2.\n\n";
		
		for(int loop = 0; loop < instrucoes.length(); loop++) {
			System.out.print(instrucoes.charAt(loop));
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
		System.out.println("Digite 1 Para Voltar:");
		int opcao = entrada.nextInt();
		
		if(opcao == 1)  {
			limparConsole();
			getMenu();
		}
		else {
			System.out.println("Opção Inválida!");
			instrucoes();
		}	
	}
	
	public void creditos() {
		String creditos = "Uma produção de By The Code \n"
				+         " Uma criação de:            \n"
				+         " Vinicius Araujo da Silveira\n"
				+         " Eliana Moura de Lima       \n"
				+         " Eduardo Ribeiro Torqauto   \n"
				+         " Nathalia Narumi Nakamura   \n"
				+         " Paulo Garcia Santos        \n\n";
	
		for(int loop = 0; loop < creditos.length(); loop++) {
			System.out.print(creditos.charAt(loop));
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				e.printStackTrace();
					
			}
		}
		System.out.println("Digite 1 Para Voltar:");
		int opcao = entrada.nextInt();
		
		//> < != == <= >=
		if(opcao == 1)  {
			limparConsole();
			getMenu();
		}
		else {
			System.out.println("Opção Inválida!");
			creditos();	
		}
	}
	
	
	public void sair() {
		System.out.println("Obrigado por Jogar!");
		/*
		try {
			Thread.sleep(6000);
			System.exit(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.exit(1);
	}
	
}
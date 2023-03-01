package Packages_CdA;

import java.util.Scanner;

public class Game {
	
	static Historia hist 	= new Historia();
	static Scanner 	scan 	= new Scanner(System.in);
	static Jogador 	jogador = new Jogador();
	static Tabela	tabela	= new Tabela();
	
	public static void main(String[] args) {
		menuIniciar();
	}
	
	public static void menuIniciar() {
		
		System.out.println("Deseja iniciar o jogo? '1 - SIM || 2 - NAO'\n");
		String input = scan.nextLine();
		
		if (input.equalsIgnoreCase("Sim") || input.equalsIgnoreCase("1")) {
			hist.intro();
			hist.escolherNome();
		}
		else if (input.equalsIgnoreCase("Nao") || input.equalsIgnoreCase("2")) {
			System.out.println("Desligando!");
			System.exit(1);
		}
		else {
			System.out.println("Não entendi o que você quis dizer, tentar novamente!");
			menuIniciar();
		}
	}
}

package Game;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Game {
	
	public static final DecimalFormat dc = new DecimalFormat ("0.00");
	
	public static Scanner sc = new Scanner(System.in);
	public static Menu menu = new Menu();
	public static Uteis uteis = new Uteis();
	public static Inimigo inimigo;
	public static Jogador jogador;
	public static Historia historia = new Historia();
	public static Combate combate = new Combate();
	
	public static void main(String [] args) {
		/*
		jogador = new Jogador ("Alfonse", "PROFESSOR");
		
		System.out.println(jogador.getStatus());
		historia.primeiroAto();
		*/
		menu.intro();
	}
}
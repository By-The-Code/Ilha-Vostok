package Game;
import java.util.Scanner;

public class GameController {
	
	public static Scanner sc = new Scanner(System.in);
	public static Menu menu = new Menu();
	public static Uteis uteis = new Uteis();
	public static Inimigo inimigo = new Inimigo();
	public static Jogador jogador;
	public static Historia historia = new Historia();
	public static Combate combate = new Combate();
}
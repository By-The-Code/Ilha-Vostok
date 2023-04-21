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
		
		jogador = new Jogador ("Alfonse", "PROFESSOR");
		
		System.out.println(jogador.getStatus());
		historia.segundoAto();
		
		menu.intro();
	}
	
	public static void gameOver() {
        System.out.println(
        			"||********************||\n"
        		+ 	"||    VOCÊ MORREU!    ||\n"
        		+ 	"||    FIM DE JOGO     ||\n"
        		+ 	"||********************||");

        try {
            Thread.sleep(5000);
            Game.uteis.limpaConsole();
            Game.menu.intro();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
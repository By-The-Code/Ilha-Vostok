package Game;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Game {

	//INSTANCIA TODAS AS CLASSES E SALVA NUMA VARÍAVEL
	//VARIAVÉIS DO JOGO
    public static final DecimalFormat dc = new DecimalFormat("0.00");

    public static Scanner sc = new Scanner(System.in);
    public static Menu menu = new Menu();
    public static Uteis uteis = new Uteis();
    public static Inimigo inimigo;
    public static Jogador jogador;
    public static Boss boss;
    public static Historia historia = new Historia();
    public static Combate combate = new Combate();

    //INICIA O JOGO CHAMANDO O MÉTODO 'INTRO' DA CLASSE 'MENU'
    public static void main(String[] args) {

		jogador = new Jogador ("Alfonse", "PROFESSOR");
		System.out.println(jogador.getStatus());
		historia.penultimoAto();
       
		// menu.intro();
    }

    
    //SE O JOGADOR MORRER O JOGO ACABA
    public static void fimDeJogo() {
        System.out.println(
                  "||********************||\n"
                + "||    VOCÊ MORREU!    ||\n"
                + "||    FIM DE JOGO     ||\n"
                + "||********************||");

        uteis.delayParaProximoComando(50);
        /*
        uteis.limpaConsole();
        new Game();
         */
        System.exit(1);
    }
}

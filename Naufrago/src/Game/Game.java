package Game;

	import java.util.Scanner;
	import java.util.Random;

public class Game {
		
		public static void main(String [] args) {
	
			//Ojectos do Sistema
			Scanner entrada = new Scanner(System.in);
			Random aleatorio = new Random ();
			
			//Variáveis do Fogo
			String [] inimigos = { "Macaco-Aranha filhote", "Lacraia filhote", "Esqueletos", "Sapo Cururu" };
			int vidaMaxInimigo = 75;
			int ataqueInimigo = 50;
			
			// Variáveis do Jogador
			int vidaJogador = 100;
			int ataqueJogador = 50;
			
			boolean running =  true;
			
			System.out.println("\tHey, you. You're finnally awake!");
				
			
			GAME:
				
				//Sistema de combate.
				//Encontros aleatórios
				
			while (running) {
				System.out.println("-------------------------------------------------------------");
				
				int vidaInimigo = aleatorio.nextInt(vidaMaxInimigo);
				String inimigo = inimigos[aleatorio.nextInt(inimigos.length)];
				
				System.out.println("\t# "+ inimigo + " apareceu na sua frente! #\n");
				
				//Enquanto a vida do inimigo for maior que 0 (enquanto estiver vivo) execute as linhas de código abaixo.
				
				while(vidaInimigo > 0) {
					System.out.println("\tSua vida: " + vidaJogador);
					System.out.println("\tVida do inimigo: " + vidaInimigo);
					System.out.println("\tO que você vai fazer?");
					System.out.println("\t1. Atacar!");
					System.out.println("\t2. Fugir!");
					
					String input = entrada.nextLine();
					if(input.equals("1")); {
						int danoCausado = aleatorio.nextInt(ataqueJogador);
						int danoRecebido= aleatorio.nextInt(ataqueInimigo); 
						
						vidaInimigo -= danoCausado;
						vidaJogador -= danoRecebido;
						
						System.out.println("\tVocê atingiu o " + inimigo + " " + danoCausado + " vezes!");
						System.out.println("\tVocê levou " + danoRecebido + " hits de dano!" );
						
						if (vidaInimigo < 0) {
							
							System.out.println("Você morreu!");
							break;	
						}
						
					else if (input.equals("2")); {
						
						System.out.println("\tVocê fugiu do " + inimigo + "!");
						continue GAME;
						}

					}
					
				}
				
			}
			
      }
}
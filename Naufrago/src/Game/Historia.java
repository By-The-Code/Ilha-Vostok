package Game;

import java.util.Scanner;

public class Historia {

	public static Menu menu = new Menu();
	public static Uteis uteis = new Uteis();

	Scanner entrada = new Scanner(System.in);

	public void getIntro() {

		String intro = 
				  "****************************************************************** INTRO ******************************************************************\n"
				+ " Uma tempestade torrencial cai dos céus sobre o jato Praetor 600, enquanto os raios e trovões intermitentes cortam as nuvens\n"
				+ "e os ouvidos da tripulação e seus passageiros. Que era apenas constituída por dois pilotos e uma comitiva de pesquisadores destinada\n"
				+ "a ilha Vostok, que ainda não tinha sido mapeada.\n" 
				+ "\r\n"
				+ " A turbulência estava fora do comum e o comandante já não possuía mais forças para segurar o manche,que agora parecia pesar uma tonelada.\n"
				+ "Como uma força sobrenatural, o avião dá um solavanco abrupto para baixo quando uma das turbinas explode e a aeronave parece ser “sugada”\n"
				+ "em direção ao mar, como se não fosse meramente a força da gravidade." 
				+ "\r\n"
				+ "Agora despencando em uma queda livre, avançando metros e metros em poucos segundos em direção a água,um breve vislumbre de um imenso\n"
				+ "buraco negro no meio do nada, é visto através de uma pequena janela por um dos tripulantes que ainda mantinha o pouco de sua sanidade intacta.\n"
				+ "\r\n" + "E então, a colisão.";

		uteis.printaTexto(intro, 15);
	}

	public void getApresentacao() {

		String apresentacaoNome = 
				"\n\rVocê acorda numa ilha no meio do Pacífico.\n"
				+ "Olhando ao redor você nota que todos os outros membros da comitiva não tiveram a mesma sorte que você.\n"
				+ "Você tenta se lembrar de coisas básicas como o seu nome.\n";

		uteis.printaTexto(apresentacaoNome, 15);

		System.out.println("\nComo você se chama?");
		String nome = entrada.next();

		String apresentacaoProfissao = 
				  "\nIsso mesmo, seu nome é " + nome
				+ ". Você também tenta lembrar de outras coisas básicas da sua vida para garantir que está tudo bem,\n"
			  	+ "você tenta se recordar do que fazia.\n"
			  	+ "\nAqui você possui três opções:\n"
			  	+ "1 - Médico\n"
			  	+ "2 - Soldado\n"
			  	+ "3 - Professor\n"
			  	+ "Cada escolha lhe dará atributos iniciais, consulte a tabela para escolher o que deseja.\n";
			
		uteis.printaTexto(apresentacaoProfissao, 15);
				
		System.out.println("\nQual é sua profissão?");
		String profissao = entrada.next();
		
		String lembranca = 
				"É verdade... Você é um " + profissao + ". E, apesar de atordoado, você se levanta e dá alguns passos lentos na areia\n"
				+ "tentando encontrar algum sinal de vida ou esperança. Caminhando pela orla, você deduz olhando afrente oque parece ser\n"
				+ "algum objeto útil um pouco atolado na areia.";
		
		uteis.printaTexto(lembranca, 15);
	}

	public void getPrimeiroAto() {
		
		String caminhoItem = 
				"Apesar da queda, você encontra um item que pode te auxiliar naquele lugar.\n"
				+ "Um boné! Vai ser bom para se proteger do sol!\n"
				+ "+ GANHA MAIS RESISTÊNCIA +\n"
				+ "Andando mais a frente, você nota uma mata fechada ao norte, mas também nota que a praia se estende ao redor de toda a ilha.\n"
				+ "O que você fará agora?";
		
		uteis.printaTexto(caminhoItem, 15);
		
		String caminhoNormal = 
				  "Era apenas um pedaço de folha atolado na areia, que pena. Aparentemente, tudo de útil que estava no avião se perdeu.\n"
				+ "Andando mais a frente, você nota uma mata fechada ao norte, mas também nota que a praia se estende ao redor de toda a ilha.\n"
				+ "O que você fará agora?";
		
		uteis.printaTexto(caminhoNormal, 15);
	}
	
	public void getSegundoAto () {
		
		String caminhoPraia = 
				  "Andando pela praia, você encontra parte dos destroços do avião, não parece ter nada útil, exceto por um encosto de braço de um dos\n"
				+ "assentos do avião que se partiu exatamente após a curvatura, gerando um punhal praticamente perfeito. Você analisa e decide utilizar\n"
				+ "o encosto como arma."
				+ "\r\n"
				+ "Você se depara com uma montanha de rochas que impede que você siga pela praia, sua única opção é entrar na floresta e é exatamente isso que você faz.\n"
				+ "Entrando na floresta você se depara com uma cobra no tronco de uma árvore, porém você nota alguma coisa brotando do que seriam as ‘costas’ do réptil,\n"
				+ "mas também nota que ela aparenta ser um filhote pelo seu tamanho."
				+ "Quando você percebe a peculiaridade deste animal, ela já está avançando em sua direção com um par de asas abertas e por mais jovem que seja, é um animal\n"
				+ "extremamente violento, você já notou que as histórias sobre esse lugar aparentavam ser verdadeiras”.\n";
		
		uteis.printaTexto(caminhoPraia, 15);
		
		String caminhoFloresta = 
				  "Ao entrar na floresta você é quase atingido por um coco, vindo do alto. Buscando o que poderia ter acontecido ao ser quase atingido por aquele coco,\n"
				+ "você avista um pequeno macaco, mas ele possui características que te deixam amedrontado.\n"
				+ "Apesar de sua estatura, o macaco possui 6 braços e 8 pontos vermelhos no rosto que te encaram com bastante raiva, você já notou que as histórias sobre\n"
				+ "esse lugar aparentavam ser verdadeiras”.\n";
		
		uteis.printaTexto(caminhoFloresta, 15);
		
		//System.out.println("Você pega o coco que o macaco havia jogado em você. Parece seguro comer") -- Você come e recupera 1 de vida. --
		
	}
	
}

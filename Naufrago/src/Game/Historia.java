package Game;

public class Historia {
	
	boolean control = false;
	
	public void getIntro() {

		String intro = 
				  "****************************************************************** INTRO ******************************************************************\n"
				+ "Uma tempestade torrencial cai dos céus sobre o jato Praetor 600, enquanto os raios e trovões intermitentes cortam as nuvens\n"
				+ "e os ouvidos da tripulação e seus passageiros. Que era apenas constituída por dois pilotos e uma comitiva de pesquisadores destinada\n"
				+ "a ilha Vostok, que ainda não tinha sido mapeada.\n" 
				+ "\r\n"
				+ "A turbulência estava fora do comum e o comandante já não possuía mais forças para segurar o manche,que agora parecia pesar uma tonelada.\n"
				+ "Como uma força sobrenatural, o avião dá um solavanco abrupto para baixo quando uma das turbinas explode e a aeronave parece ser “sugada”\n"
				+ "em direção ao mar, como se não fosse meramente a força da gravidade." 
				+ "\r\n"
				+ "Agora despencando em uma queda livre, avançando metros e metros em poucos segundos em direção a água,um breve vislumbre de um imenso\n"
				+ "buraco negro no meio do nada, é visto através de uma pequena janela por um dos tripulantes que ainda mantinha o pouco de sua sanidade intacta.\n"
				+ "\r\n" + "E então, a colisão.";

		GameController.uteis.printaTexto(intro, 15);
		try {
			Thread.sleep(2000);
			Apresentacao();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Apresentacao() {

		String apresentacaoNome = 
					"\n\rVocê acorda numa ilha no meio do Pacífico.\n"
				+ 	"Olhando ao redor você nota que todos os outros membros da comitiva não tiveram a mesma sorte que você.\n"
				+ 	"Você tenta se lembrar de coisas básicas como o seu nome.\n";

		GameController.uteis.printaTexto(apresentacaoNome, 15);

		System.out.println("\nComo você se chama?");
		String nome = GameController.sc.nextLine();

		String apresentacaoProfissao = 
				  "\nIsso mesmo, seu nome é " + nome + ".\n"
				+ "Você também tenta lembrar de outras coisas básicas da sua vida para garantir que está tudo bem,\n"
			  	+ "você tenta se recordar do que fazia.\n"
			  	+ "+=========================================================+\n"
				+ "| PROFI/STATUS  |   VIDA   |    FORÇA   |   RESISTÊNCIA   |\n"
				+ "+=========================================================+\n"
				+ "| 1 - MÉDICO    |    +15   |      +0    |        +5       |\n"
				+ "+=========================================================+\n"
				+ "| 2 - SOLDADO   |    +15   |      +5    |        +0       |\n"
				+ "+=========================================================+\n"
				+ "| 3 - PROFESSOR |    +10   |      +3    |        +3       |\n"
				+ "+=========================================================+\n";
			
		GameController.uteis.printaTexto(apresentacaoProfissao, 10);
				
		System.out.println("\nQual é sua profissão?");
		String input =  GameController.sc.nextLine().toUpperCase();
		String profissao = "";
		
		switch(input) {
		case "1", "MEDICO", "MÉDICO":
			profissao = "MÉDICO";
			GameController.jogador = new Jogador (nome, profissao);
			break;
			
		case "2", "SOLDADO":
			profissao = "SOLDADO";
			GameController.jogador = new Jogador (nome, profissao);
			break;
			
		case "3", "PROFESSOR":
			profissao = "PROFESSOR";
			GameController.jogador = new Jogador (nome, profissao);
			break;
			
		default: 
					GameController.uteis.limpaConsole();
					System.out.println("Opção inválida!");
					Apresentacao();
		}
		
		String lembranca = 
					"É verdade... Você é um " + profissao + ".\n"
				+ 	"Apesar de atordoado, você se levanta e dá alguns passos lentos na areia\n"
				+ 	"tentando encontrar algum sinal de vida ou esperança. \n"
				+	"Caminhando pela orla, você avista o que parece ser algum objeto útil um pouco atolado na areia.\n\n";
		GameController.uteis.printaTexto(lembranca, 15);
		
		if(GameController.uteis.Continuar()) {
			GameController.uteis.limpaConsole();
			PrimeiroAto();
		}
		else {
			Apresentacao();
		}
	}

	public void PrimeiroAto() {
		
		if (!control) {
		double random = GameController.uteis.geraNumeroRandomico();
		
			if (random >= 50.01) {
				caminhoItem();
				control = true;
			} else {
				caminhoNormal();
				control = true;
			}
		}
		
		System.out.println(	"\tO que você fará agora?\n"
						+ 	"\t1 - Seguir pela Praia\n"
						+ 	"\t2 - Seguir pela Floresta\n");
		
		String input = GameController.sc.next().toUpperCase();
		
		switch(input) {
		case "1", "PRAIA":
			caminhoPraia();
			break;
		
		case "2", "FLORESTA":
			caminhoFloresta();
			break;
		
		default: System.out.println("Opção Inválida!");
				 PrimeiroAto();
		}
	}
	
	public void caminhoItem () {
		String caminhoItem = "";
		caminhoItem = 
				"Apesar da queda, você encontra um item que pode te auxiliar naquele lugar.\n"
			+ 	"Um boné! Vai ser bom para se proteger do sol!\n"
			+ 	"+ GANHA MAIS RESISTÊNCIA +\n"
			+ 	"Andando mais a frente, você nota uma mata fechada ao norte, mas também nota que a praia se estende ao redor de toda a ilha.\n\n";
	
	
		GameController.uteis.printaTexto(caminhoItem, 15);
		GameController.jogador.setArmadura("Boné");
	}
	
	public void caminhoNormal() {
		String caminhoNormal = "";
		caminhoNormal = 
				  "Era apenas um pedaço de folha atolado na areia, que pena.\n"
				+ "Aparentemente, tudo de útil que estava no avião se perdeu.\n"
				+ "Andando mais a frente, você nota uma mata fechada ao norte, mas também nota que a praia se estende ao redor de toda a ilha.\n\n";
		
		GameController.uteis.printaTexto(caminhoNormal, 15);
	}
	
	public void caminhoPraia () {
		
		String caminhoPraia = 
				  "Andando pela praia, você encontra parte dos destroços do avião, não parece ter nada útil, exceto por um encosto de braço de um dos\n"
				+ "assentos do avião que se partiu exatamente após a curvatura, gerando um punhal praticamente perfeito. Você analisa e decide utilizar\n"
				+ "o encosto como arma."
				+ "+ NOVA ARMA ADQUIRIDA +\\n"
				+ "\r\n";
		GameController.jogador.setArma("Braço do Assento");
		String continuacaoPraia = 
				  "Você se depara com uma montanha de rochas que impede que você siga pela praia, sua única opção é entrar na floresta e é exatamente isso que você faz.\n"
				+ "Entrando na floresta você se depara com uma cobra no tronco de uma árvore, porém você nota alguma coisa brotando do que seriam as ‘costas’ do réptil,\n"
				+ "mas também nota que ela aparenta ser um filhote pelo seu tamanho."
				+ "Quando você percebe a peculiaridade deste animal, ela já está avançando em sua direção com um par de asas abertas e por mais jovem que seja, é um animal\n"
				+ "extremamente violento, você já notou que as histórias sobre esse lugar aparentavam ser verdadeiras”.\n";
		
		GameController.uteis.printaTexto(caminhoPraia, 15);
		GameController.uteis.printaTexto(continuacaoPraia, 15);
		//System.out.println("Você pega o coco que o macaco havia jogado em você. Parece seguro comer") -- Você come e recupera 1 de vida. --
	}
	
	public void caminhoFloresta() {
		String caminhoFloresta = 
				  "Ao entrar na floresta você é quase atingido por um coco, vindo do alto. Buscando o que poderia ter acontecido ao ser quase atingido por aquele coco,\n"
				+ "você avista um pequeno macaco, mas ele possui características que te deixam amedrontado.\n"
				+ "Apesar de sua estatura, o macaco possui 6 braços e 8 pontos vermelhos no rosto que te encaram com bastante raiva, você já notou que as histórias sobre\n"
				+ "esse lugar aparentavam ser verdadeiras”.\n";
		
		GameController.uteis.printaTexto(caminhoFloresta, 15);
	}
}

package Game;

import java.util.Scanner;

public class Historia {

	Scanner entrada = new Scanner(System.in);
	public static Historia hist = new Historia();

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
			getApresentacao();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getApresentacao() {

		String apresentacaoNome = 
					"\n\rVocê acorda numa ilha no meio do Pacífico.\n"
				+ 	"Olhando ao redor você nota que todos os outros membros da comitiva não tiveram a mesma sorte que você.\n"
				+ 	"Você tenta se lembrar de coisas básicas como o seu nome.\n";

		GameController.uteis.printaTexto(apresentacaoNome, 15);

		System.out.println("\nComo você se chama?");
		String nome = entrada.next();

		String apresentacaoProfissao = 
				  "\nIsso mesmo, seu nome é " + nome + ".\n"
				+ "Você também tenta lembrar de outras coisas básicas da sua vida para garantir que está tudo bem,\n"
			  	+ "você tenta se recordar do que fazia.\n"
			  	+ "+========================================================+\n"
				+ "|PROFI/STATUS  |   VIDA   |    FORÇA   |   RESISTÊNCIA   |\n"
				+ "+========================================================+\n"
				+ "|1 - MÉDICO    |    +15   |      +0    |        +5       |\n"
				+ "+========================================================+\n"
				+ "|2 - SOLDADO   |    +15   |      +5    |        +0       |\n"
				+ "+========================================================+\n"
				+ "|3 - PROFESSOR |    +10   |      +3    |        +3       |\n"
				+ "+========================================================+\n";
			
		GameController.uteis.printaTexto(apresentacaoProfissao, 15);
				
		System.out.println("\nQual é sua profissão?");
		String input = entrada.next().toUpperCase();
		String profissao = "";
		
		switch(input) {
		case "1", "MEDICO", "MÉDICO":
			profissao = "MÉDICO";
			break;
		case "2", "SOLDADO":
			profissao = "SOLDADO";
			break;
		case "3", "PROFESSOR":
			profissao = "PROFESSOR";
			break;
		default: System.out.println("Opção inválida!");
			getApresentacao();
		}
		
		String lembranca = 
					"É verdade... Você é um " + profissao + ". E, apesar de atordoado, você se levanta e dá alguns passos lentos na areia\n"
				+ 	"tentando encontrar algum sinal de vida ou esperança. Caminhando pela orla, você deduz olhando afrente oque parece ser\n"
				+ 	"algum objeto útil um pouco atolado na areia.";
		
		GameController.uteis.printaTexto(lembranca, 15);
		
		getPrimeiroAto();
	}

	public void getPrimeiroAto() {
		
		double random = GameController.uteis.geraNumeroRandomico();
		
		if (random >= 50.01) {
		String caminhoItem = 
					"Apesar da queda, você encontra um item que pode te auxiliar naquele lugar.\n"
				+ 	"Um boné! Vai ser bom para se proteger do sol!\n"
				//+ 	"+ GANHA MAIS RESISTÊNCIA +\n"
				+ 	"Andando mais a frente, você nota uma mata fechada ao norte, mas também nota que a praia se estende ao redor de toda a ilha.\n";
		
		GameController.uteis.printaTexto(caminhoItem, 15);
		//GameController.jogador.setArmadura("Boné");
		} else {
		String caminhoNormal = 
				  "Era apenas um pedaço de folha atolado na areia, que pena. Aparentemente, tudo de útil que estava no avião se perdeu.\n"
				+ "Andando mais a frente, você nota uma mata fechada ao norte, mas também nota que a praia se estende ao redor de toda a ilha.\n";
		
		GameController.uteis.printaTexto(caminhoNormal, 15);
		}
		getSegundoAto();
	}
	
	public void getSegundoAto () {
		
		String escolhaDeCaminho =
				  "\r"
				+ "*** O QUE VOCÊ FARÁ AGORA? ***	\n"
				+ "===============================	\n"
				+ "    1 - Seguir pela Praia     	\n"
				+ "    2 - Entrar na Floresta    	\n"
				+ "===============================	\n";
		GameController.uteis.printaTexto(escolhaDeCaminho, 10);
		int input = entrada.nextInt();
		
		switch (input) {
			
			case 1: 
			GameController.uteis.limpaConsole();	
			hist.getCaminhoPraia();
			break;
			
			case 2:
			GameController.uteis.limpaConsole();	
			hist.getCaminhoFloresta();
			break;
			
			default: 
			System.out.println("Opção inválida!");
			GameController.uteis.limpaConsole();
			getSegundoAto();
		}

	}

	public void getCaminhoPraia () {
		
		String caminhoPraia = 
				  "Andando pela praia, você encontra parte dos destroços do avião, não parece ter nada útil, exceto por um encosto de braço de um dos\n"
				+ "assentos do avião que se partiu exatamente após a curvatura, gerando um punhal praticamente perfeito. Você analisa e decide utilizar\n"
				+ "o encosto como arma."
				+ "\r\n";
		//GameController.jogador.setArma("Braço do Assento");
		
		String continuacaoPraia = 
				  "Você se depara com uma montanha de rochas que impede que você siga pela praia, sua única opção é entrar na floresta e é exatamente isso que você faz.\n"
				+ "Entrando na floresta você se depara com uma cobra no tronco de uma árvore, porém você nota alguma coisa brotando do que seriam as ‘costas’ do réptil,\n"
				+ "mas também nota que ela aparenta ser um filhote pelo seu tamanho."
				+ "Quando você percebe a peculiaridade deste animal, ela já está avançando em sua direção com um par de asas abertas e por mais jovem que seja, é um animal\n"
				+ "extremamente violento, você já notou que as histórias sobre esse lugar aparentavam ser verdadeiras.\n";
		
		GameController.uteis.printaTexto(caminhoPraia, 15);
		GameController.uteis.printaTexto(continuacaoPraia, 15);
		} 
	
	public void getCaminhoFloresta() {
	
		String caminhoFloresta = 
				  "Ao entrar na floresta você é quase atingido por um coco, vindo do alto. Buscando o que poderia ter acontecido ao ser quase atingido por aquele coco,\n"
				+ "você avista um pequeno macaco, mas ele possui características que te deixam amedrontado.\n"
				+ "Apesar de sua estatura, o macaco possui 6 braços e 8 pontos vermelhos no rosto que te encaram com bastante raiva, você já notou que as histórias sobre\n"
				+ "esse lugar aparentavam ser verdadeiras.\n";
		GameController.uteis.printaTexto(caminhoFloresta, 15);
		
		String continuacaoFloresta =
				  "Você pega o coco que o macaco havia jogado em você. Parece seguro comer.\n";
			//	+ "-- Você come e recupera 1 de vida. ---"
			//	+ "Além disso, você decide levar um pedaço de madeira para se defender de futuras ameaças";
			// GameController.jogador.setArma("Braço do Assento");
		
		}
	
	public void getTerceiroAto() {
		
		String caminhosUnificados = 
				  "Você continua floresta adentro, ao retirar alguns galhos e folhas do caminho, você acidentalmente se depara com um, ou melhor,\n"
				+ "centenas de patas pertencentes a uma lacraia gigante, com aproximadamente 1,50m de comprimento bem próximo a você.\n"
				+ "Ela não gostou de você por ter descoberto o esconderijo dela, expondo-a à luz do dia. Enquanto ela se contorce para cima para te amedrontar,\n"
				+ "a única coisa que vem a sua mente é que este inseto aparentava ser bem mais forte do que a última criatura que enfrentou.\n"
				+ "\r"
				+ "Diante de uma criatura aterrorizante daquela, você decide fugir. Você corre até uma clareira, onde seus passos desesperados conseguiram te levar, pois percebeu que aquela criatura não gostava muito da luz do sol portanto ela não te seguiu.\n"
				+ "Chegando naquele espaço aberto, você começa a raciocinar sobre seu real estado, onde você se encontra e o que mais aquela ilha poderia estar guardando para você.\n"
				+ "Diante desse cenário você decide traçar um plano para fugir, porém você não sabe quanto tempo exatamente isso pode levar e por instinto, você sabe que vai escurecer em algumas horas. Tentando aumentar suas\n"
				+ "chances de sobrevivência você decide procurar por água, comida e abrigo. Porém, duas coisas chamam sua atenção.\n"
				+ "\r"
				+ "Ao leste você ouve um som de água, aparentemente vindo de uma cachoeira. E, ao oeste você consegue ver um sinal de fumaça entre a copa das árvores.\n"
				+ "\r"
				+ "*************  O QUE VOCÊ FAZ? *************\n"
				+ "============================================	\n"
				+ "    1 - Anda em direção ao Leste (Cachoeira) \n"
				+ "    2 - Anda em direção ao Oeste (Fumaça)  	\n"
				+ "============================================	\n";
		
		GameController.uteis.printaTexto(caminhosUnificados, 15);
		int input = entrada.nextInt();
		
		switch (input) {
			
			case 1: 
			GameController.uteis.limpaConsole();	
			hist.getCaminhoCachoeira();
			break;
			
			case 2:
			GameController.uteis.limpaConsole();	
			hist.getCaminhoFumaca();
			break;
			
			default: 
			System.out.println("Opção inválida!");
			GameController.uteis.limpaConsole();
			getTerceiroAto();
		}
	}
	
	public void getCaminhoCachoeira () {
		
		String caminhoCachoeira = 
				  "Ao chegar na cachoeira você se depara com um local lindo e estaria ainda mais maravilhado se não lembrasse das possíveis lacraias gigantes que poderiam existir por ali, te deixando alerta.\n"
				+ "Além disso você consegue ver a extensão do rio levando até a praia, você está morrendo de sede e precisa se hidratar, mesmo com os riscos você decide beber a água.\n";
			   
				//-Se vidaMaxima não faz nada, se vida < vidaMaxima restaura vida-
		
		String continuacaoCachoeira = 
				  "\rA água parece boa, você se sente renovado.\n"
				//Água adquirida, falta comida e abrigo.
				+ "\rOlhando a frente, você verifica que numa das “paredes” da cachoeira possui uma abertura. Aparentemente uma caverna que poderia servir de abrigo durante a noite, mas ela pode abrigar criaturas desconhecidas como as vistas até aqui.\n"
				+ "Você pode ir para a caverna ou você pode voltar para a clareira e seguir o sinal de fumaça que viu mais cedo.\n"
				+ "\r"
				+ "*********** O QUE VOCÊ FAZ? *********\n"
				+ "=====================================\n"
				+ " 	1 - Entra na caverna 		 	\n"
				+ " 2 - Volta para o Oeste (Fumaça)		\n"
				+ "=====================================\n";
		
		GameController.uteis.printaTexto(caminhoCachoeira, 15);
		GameController.uteis.printaTexto(continuacaoCachoeira, 15);
		
		int input = entrada.nextInt();
		
		switch (input) {
		
		case 1: 
		GameController.uteis.limpaConsole();	
		hist.getCaminhoCaverna();
		break;
		
		case 2:
		GameController.uteis.limpaConsole();	
		hist.getCaminhoFumaca();
		break;
		
		default: 
		System.out.println("Opção inválida!");
		GameController.uteis.limpaConsole();
		getCaminhoCachoeira();
	}
		
	}
	
	public void getCaminhoCaverna () {
		
		String caminhoCaverna = 
				  "Se esgueirando pelos cantos até entrar na caverna, você acha estranho o fato dela ser quente e pensa que passar a noite ali seria realmente bem agradável, afinal, você já estaria protegido do frio, porém, não é só você que teve essa ideia…\n"
				+ "No teto da caverna, de cabeça para baixo, estão pendurados o que parecem ser uma família enorme de morcegos fluorescentes e no meio deles, existe um que se destaca, aparentemente a mãe de todos aqueles filhotes.\n"
				+ "Ela acorda com um grito amedrontador e feroz quando te vê, abre as asas iluminando ainda mais toda a caverna e avança na sua direção."
		
				+"*************  O QUE VOCÊ FAZ? *************\n"
				+ "============================================	\n"
				+ "    1 - Ataca/Se Protege com o que tem 		\n"
				+ "    2 - Foge (Volta para cachoeira)		  	\n"
				+ "============================================	\n";
		
		GameController.uteis.printaTexto(caminhoCaverna, 15);
		
		int input = entrada.nextInt();
				
				switch (input) {
				
				/*case 1: 
				GameController.uteis.limpaConsole();	
				--- MODO DE COMBATE ---;
				break; */
				
				case 2:
				GameController.uteis.limpaConsole();	
				hist.getCaminhoCachoeira();
				break;
				
				default: 
				System.out.println("Opção inválida!");
				GameController.uteis.limpaConsole();
				getCaminhoCaverna();
		
		String continuacaoCaverna =
				  "Após você enfrentar e matar a mãe de todos, seus filhotes voam para fora da caverna, fugindo com medo, agora que sua mãe está morta.\n"
				+ "Agora mais calmo, você consegue notar alguns objetos do que um dia pertenceram a um humano, que não teve tanta sorte quanto você. Pela insígnia em sua roupa desgastada, ele era um piloto, o que justificava alguns itens espalhados ao seu redor...\n";
		
				// Você adquiriu 1 fêmur e 1 latinha de querosene - Arma
		
		GameController.uteis.printaTexto(continuacaoCaverna, 15);
		
			}
	}
	
	
	public void getCaminhoFumaca() {
		
		String caminhoFumaca = 
				  "Ao chegar no local da fumaça, além de ter o que te chamou atenção a distância, você nota que há muitas abóboras, de variados tamanhos, até mesmo algumas gigantes e bem maduras espalhadas no chão,\n"
				+ "como uma plantação bem sucedida. Porém, você nota que aquela fumaça está emergindo do chão envolvendo os legumes e não há sinal de fogo aparente, apenas aquela nuvem branca.\n"
				+ "Você se aproxima e percebe que elas estão quentes, assim como o chão, e os legumes devidamente assados. Essa ilha é realmente mágica! Você decide comê-las antes que\n"
				+ "desmaie de fome.";
		
				// -Se vidaMaxima não faz nada, se vida < vidaMáxima restaura vida.-
		
		String continuacaoFumaca = 
				  "\rAs abóboras estavam deliciosas, você se sente saciado e mais disposto.\n"
				// Comida adquirida, falta abrido e água.
				+ "Olhando ao redor, você percebe que a vegetação muda um pouco, as árvores aqui se assemelham a baobás, com a copa e os troncos largos o bastante para acomodarem um humano deitado,\n"
				+ "com folhagens densas o bastante para impedir a chuva, além disso alguns galhos menores estão dispostos nas árvores de madeira que formam perfeitamente degraus até o topo.\n"
				+ "Você precisa de um lugar para passar a noite e, para se proteger do frio, poderia colocar algumas abóboras quentinhas e folhagens sob você."
				+ "\r"
				+ "************** O QUE VOCÊ FAZ? ************	\n"
				+ "===========================================	\n"
				+ " 	1 - Vai em direção a Cachoeira (Leste) 	\n"
				+ " 		2 - Fica e sobe na Árvore			\n"
				+ "=========================================== 	  ";
		
		int input = entrada.nextInt();
				
				switch (input) {
				
				case 1: 
				GameController.uteis.limpaConsole();	
				hist.getCaminhoCachoeira();
				break;
				
				case 2:
				GameController.uteis.limpaConsole();	
				hist.getCaminhoArvore();
				break;
				
				default: 
				System.out.println("Opção inválida!");
				GameController.uteis.limpaConsole();
				getCaminhoFumaca();
			}

		GameController.uteis.printaTexto(caminhoFumaca, 15);
		GameController.uteis.printaTexto(continuacaoFumaca, 15);
		
	}
	
	public void getCaminhoArvore() {
		
		String caminhoArvore = 
				  "Você colocou algumas folhagens e abóboras na base da árvore e irá subi-las pouco a pouco. Na primeira leva de materiais, você se depara com um ninho do que aparenta ser alguma ave,\n"
				+ "você até pensa por um instante que pode ser inabitado, entretanto, este pensamento não dura muito, pois, você sente um vulto passando no céu atrás de você, ao se virar o que parece ser um cavalo,\n"
				+ "com cabeça e asas de àguia está voando a toda velocidade na sua direção, aparentemente aquele ninho pertence a ela. Você se lembra de histórias antigas e de um animal assim… Um Hipogrifo, é isso que você enfrentará."

				+ "*************  O QUE VOCÊ FAZ? *************\n"
				+ "============================================	\n"
				+ "    1 - Ataca/Se Protege com o que tem 		\n"
				+ "    2 - Foge (Desce para as abóboras)		\n"
				+ "============================================	\n";
		
		int input = entrada.nextInt();
		
		switch (input) {
		
		/*case 1: 
		GameController.uteis.limpaConsole();	
		--- MODO DE COMBATE ---;
		break; */
		
		case 2:
		GameController.uteis.limpaConsole();	
		hist.getCaminhoFumaca();
		break;
		
		default: 
		System.out.println("Opção inválida!");
		GameController.uteis.limpaConsole();
		getCaminhoFumaca();
			
		String continuacaoArvore =
				  "Após você enfrentar e matar a ave, agora mais calmo, você consegue notar alguns objetos do que um dia pertenceram a um humano, que não teve tanta sorte quanto você.";
		
				// Você adquiriu 1 pederneira e 1 faca - Arma
		
		GameController.uteis.printaTexto(caminhoArvore, 15);
		GameController.uteis.printaTexto(continuacaoArvore, 15);
		
	}
}
	
	public void getQuartoAto() {
		
		String caminhosUnificados2 = 
				 //Você acabou passando a noite com fome/ sede/ sem abrigo, você se sente um pouco debilitado ao acordar” -> vida -= x
				  "Após acordar, você decide ir até a outra extremidade da ilha para explorar um pouco mais e decidir quais serão os próximos passos.\n"
				+ "Chegando na praia você elabora uma lista na areia dos itens que precisa para construir sua jangada: FOLHAS DE PALMEIRA, MADEIRAS E CORDAS.\n"
				+ "\r"
				+ "********* O QUE VOCÊ FAZ PRIMEIRO? *********\n"
				+ "============================================	\n"
				+ "    1 - Vou procurar Folhas de Palemeira		\n"
				+ "    2 - Vou procurar as Madeiras				\n"
				+ "    3 - Vou procurar as Cordas				\n"
				+ "============================================	\n";

		
		GameController.uteis.printaTexto(caminhosUnificados2, 15);
		int input = entrada.nextInt();
		
		switch (input) {
			
			case 1: 
			GameController.uteis.limpaConsole();	
			hist.getFolhasDePalmeira();
			break;
			
			case 2:
			GameController.uteis.limpaConsole();	
			hist.getMadeira();
			break;
			
			case 3:
			GameController.uteis.limpaConsole();	
			hist.getCorda();
			break;
			
			default: 
			System.out.println("Opção inválida!");
			GameController.uteis.limpaConsole();
		}
		
	}
	
	public void getFolhasDePalmeira () {
		
		String formigasGigantes = 
				  "Você decide ir atrás de folhas de palmeira.\n"
				+ "\r"
				+ "Você sabe que achar tecidos por aqui seria pedir demais, já é incrível ter permanecido vivo.\n"
				+ "Então, você se lembra do coco que o macaco-aranha havia arremessado em você, então, deviam haver palmeiras por perto, você anda um pouco até encontrá-las, mas o som de outros macaco-aranhas te ajudou a achar o que procurava.\n"
				+ "Você vê uma trilha que te leva para uma espécie de “montanha”, como se algo passasse ali com bastante frequência, a sua esquerda uma montanha de terra é um cenário diferente das árvores do local, à sua direita você vê uma folha bem grande,\n"
				+ "o suficiente para te cobrir, sendo carregada por uma formiga tão grande quanto a folha.\n"
				+ "Ao detectar sua presença e proximidade do que agora você sabe ser um formigueiro, o inseto exala um odor diferente, o que atrai outra formiga tão grande quanto ela, essa outra formiga porém possuía pinças bem maiores, claramente era responsável\n"
				+ "pela defesa do formigueiro e das demais formigas, você se prepara para atacar, pois agora aquelas formigas estão logo a frente das palmeiras que você tanto precisa";
		
				// - BATALHA -

		String continuacaoFormigasGigantes = 
				   "Você conseguiu derrotá-lo! Você pega todas as folhas necessárias para sua jangada e leva para a praia."	
		
				// Item: Pinça de formiga - Arma (Formiga que foi derrotada em uma briga) / Folhas de Palmeira
		
				+ "********* PARA ONDE QUER IR AGORA? *********\n"
				+ "============================================	\n"
				+ "    			1 - Ir atrás de Madeira 		\n"
				+ "    			2 - Ir atrás de Corda			\n"
				+ "============================================	\n";
		
		int input = entrada.nextInt();
		
		switch (input) {
			
			case 1: 
			GameController.uteis.limpaConsole();	
			hist.getMadeira();
			break;
			
			case 2:
			GameController.uteis.limpaConsole();	
			hist.getCorda();
			break;
			
			default: 
			System.out.println("Opção inválida!");
			GameController.uteis.limpaConsole();
			getFolhasDePalmeira();
		}
		
		 GameController.uteis.printaTexto(formigasGigantes, 15);
		 GameController.uteis.printaTexto(continuacaoFormigasGigantes, 15);
	
	}
	
	public void getMadeira () {
		
		String cupimGigante = 
				  "Você decide ir atrás de madeira.\n"
				+ "\r"
				+ "Você encontra madeiras que servirão perfeitamente para a jangada, com o diâmetro bom o suficiente para subir com uns 5 troncos, que ficarão firmes com as cordas.\n"
				+ "Contente, você olha ao redor das árvores e nota alguns montes de barro gigante, como se todos os cupinzeiros do mundo tivessem se juntado num só e criado várias ‘bases’ nos arredores.\n"
				+ "Além disso, várias árvores estão derrubadas/podres e algumas tem fumaça saindo da base onde foi feito o corte, como se tivesse derrubado a árvore utilizando algum ácido, além disso\n"
				+ "o cheiro do ambiente te deixa um pouco nauseado. Você aproveita as árvores já caídas e que ainda parecem boas, porém, ao tocar na primeira delas, vindo de um dos montes de barro,\n"
				+ "um cupim gigante brota, disparando um ácido na sua direção, você desvia e sabe que terá que lutar pelas madeiras.\n";
		
				// - BATALHA -
		
		String continuacaoCupimGigante = 
				  "Você conseguiu derrotá-lo! Você pega todas as madeiras necessárias para sua jangada e leva para a praia."
		
				// Item: Cola Orgânica de Cupim (para revestimento)
				
				+"********* PARA ONDE QUER IR AGORA? *********\n"
				+ "============================================	\n"
				+ "    			1 - Ir atrás de Corda 			\n"
				+ "============================================	\n";
		
		int input = entrada.nextInt();
		
		switch (input) {
			
			case 1: 
			GameController.uteis.limpaConsole();	
			hist.getCorda();
			break;
			
			default: 
			System.out.println("Opção inválida!");
			GameController.uteis.limpaConsole();
			getMadeira();
			}
		
		GameController.uteis.printaTexto(cupimGigante, 15);
		GameController.uteis.printaTexto(continuacaoCupimGigante, 15);
		
		}
	
	public void getCorda () {
		
		String louvaDeusGigante = 
				  "Você decide ir atrás de cordas.\n"
				+ "\r"
				+ "Andando pela praia você encontra uma extensão da floresta contendo diversas trepadeiras. Não são cordas propriamente ditas, mas os cipós das árvores irão servir perfeitamente para a jangada.\n"
				+ "Porém, ao se aproximar da vegetação, um Louva-Deus Gigante aparece cortando parte dos cipós com as suas patas dianteiras que aparentam ser revestidas com algum metal que se assemelham a facas de serra.\n"
				+ "Você só consegue pensar nos diversos vídeos de louva-deuses atacando lagartos ou outros animais e como os louva-deus fêmeas comem as cabeças dos machos após a reprodução. Você sente calafrios por toda a espinha,\n"
				+ "seu corpo grita para que você fuja, mas não tem como fugir, você precisa dos cipós.\n"
				+ "";
		
				// - BATALHA -
		
		String continuacaoLouvaDeusGigante = 
				  "Você conseguiu derrotá-lo! Você pega todas as cordas necessárias para sua jangada e leva para a praia. Aparentemente agora você tem tudo que necessita";
		
				// Item: Cola Orgânica de Cupim (para revestimento)
		
		GameController.uteis.printaTexto(louvaDeusGigante, 15);
		GameController.uteis.printaTexto(continuacaoLouvaDeusGigante, 15);
		
		}
	
	public void getPenultimoAto () {
		
		String finalBoss = 
				  "\rApós conseguir todos os itens da lista, você começa a montar sua jangada…\n"
				+ "Você utiliza as madeiras, cola, folhas de palmeira e os cipós para construir a jangada que te levará para longe desta ilha. Você aproveita também para confeccionar uma arma mais forte utilizando a pata de metal do louva-deus\n"
				+ "e a pinça da formiga gigante. Algumas horas depois você termina a jangada, não é muito, mas vai funcionar para sair da ilha e com sorte chegar até o continente ou um lugar sem tantas criaturas bizarras.\n"
				+ "\r"
				+ "Você coloca a jangada na água e parte dando adeus àquela ilha maldita, você olha para trás e sorri, agradecendo por ter sobrevivido e pensando em tudo que faria a partir dali, quando estivesse realmente a salvo, porém sua esperança dura pouco…\n"
				+ "Diante de você uma criatura enorme emerge das águas, os tentáculos da criatura envolvem toda a jangada e um olho do tamanho da sua cabeça está diante de você, te olhando fixamente. Você precisa tomar uma atitude rápida."
	
				+ "************* O QUE VOCÊ FAZ? *************\n"
				+ "============================================	\n"
				+ "    	1 - Bate com a arma nos Tentáculos 		\n"
				+ "    	2 - Fura o olho da Criatura				\n"
				+ "============================================	\n";
		
		
		
		/*int input = entrada.nextInt();
				
				switch (input) {
					
					case 1: 
					GameController.uteis.limpaConsole();	
					-- 	MODO COMBATE --
					break;
					
					case 2: 
						GameController.uteis.limpaConsole();	
						-- 	MODO COMBATE --
						break;
					
					default: 
					System.out.println("Opção inválida!");
					GameController.uteis.limpaConsole();
					getPenultimoAto();*/
		
					}
	
	
	public void getUltimoAto() {
		
		String ultimaDecisao = 
				  "Você venceu, garantindo suas chances de sobrevivência e podendo fugir sem maiores obstáculos da ilha. Você vê a Lula Gigante ainda próxima, mas ela já está fraca e bastante ferida, se você deixá-la em paz, ela irá sobreviver, mas você pode decidir terminar o serviço…\n"

				+ "*** O QUE VOCÊ FAZ? ***\n"
				+ "======================\n"
				+ "    1 - Matar		 \n"
				+ "    2 - Ir Embora	 \n"
				+ "======================\n";
		
		GameController.uteis.printaTexto(ultimaDecisao, 15);
		int input = entrada.nextInt();
		
		if (input == 1) {
			
			String finalMisericordioso = 
				 "Você poupa o animal.\n"
				+ "Por pior que aquela situação tenha sido, você ainda manteve parte da sua humanidade. E, atacar um animal que não oferecia mais riscos parecia errado. Você senta na sua jangada contemplando o horizonte e sentindo a briza do mar, enquanto a criatura foge para longe.\n"
				+ "Você sorri enquanto lágrimas escorrem em seu rosto, com um alívio e esperança de um novo recomeço…";
			
			GameController.uteis.printaTexto(finalMisericordioso, 15);
			
		}
			
			else {
				
				String finalRancoroso = 
						  "Você mata a Lula sem piedade, fincando a arma em um só golpe em seu olho gigante.\n"
						+ "Você se tornou tão selvagem quanto as criaturas que te atacaram enquanto estava na ilha. Sem remorso, você segue seu caminho. Você senta na jangada e chora… Será que a vida será a mesma daqui em diante?";
			
			GameController.uteis.printaTexto(finalRancoroso, 15);
			
			}
	}
	
	public void getFim () {
		
		String fim = 
			 "F I M";
		GameController.uteis.printaTexto(fim, 250);
	}
	
}
	
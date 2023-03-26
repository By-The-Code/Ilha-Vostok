package Game;

public class Historia {
	
	boolean control = false;
	
	public void getIntro() {

		String intro = 
				          "||******************************************** INTRO ********************************************||\n"
						+ "|| Uma tempestade torrencial cai dos céus sobre o jato Praetor 600, enquanto os raios e trovões  ||\n"
						+ "|| intermitentes cortam as nuvens e os ouvidos da tripulação e seus passageiros. Que era apenas  ||\n"
						+ "|| constituída por dois pilotos e uma comitiva de pesquisadores destinada a ilha Vostok, que     ||\n"
						+ "|| ainda não tinha sido mapeada.                                                                 ||\n"	
						+ "|| A turbulência estava fora do comum e o comandante já não possuía mais forças para segurar o   ||\n"
						+ "|| manche, que agora parecia pesar uma tonelada. Como uma força sobrenatural, o avião dá um      ||\n"
						+ "|| solavanco abrupto para baixo quando uma das turbinas explode e a aeronave parece ser “sugada” ||\n"
						+ "|| em direção ao mar, como se não fosse meramente a força da gravidade.                          ||\n"		
						+ "|| Agora despencando em uma queda livre, avançando metros e metros em poucos segundos em direção ||\n"
						+ "|| a água, um breve vislumbre de um imenso buraco negro no meio do nada, é visto através de uma  ||\n"
						+ "|| pequena janela por um dos tripulantes que ainda mantinha o pouco de sua sanidade intacta.     ||\n"
						+ "|| E então, a colisão.                                                                           ||\n"
						+ "||***********************************************************************************************||\n";   

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
		double random = GameController.uteis.geraNumeroRandomico(0, 101);
		
			if (random >= 50) {
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
			GameController.escolherInimigo();
			caminhoPraia();
			break;
		
		case "2", "FLORESTA":
			GameController.escolherInimigo();
			caminhoFloresta();
			break;
		
		default: System.out.println("Opção Inválida!");
				 PrimeiroAto();
		}
	}
	
	public void caminhoItem () {
		
<<<<<<< HEAD
		GameController.jogador.setResistencia(1);
=======
>>>>>>> Vini_GameController
		String caminhoItem = "";
		caminhoItem = 
				"Apesar da queda, você encontra um item que pode te auxiliar naquele lugar.\n"
			+ 	"Um boné! Vai ser bom para se proteger do sol!\n"
			+ 	"Você aumentou sua resistência!\n\r"
			+ 	"\tRESISTÊNCIA: "
			+ 	GameController.jogador.getResistencia()	
			+ 	"\rAndando mais a frente, você nota uma mata fechada ao norte, mas também nota que a praia se estende ao redor de toda a ilha.\n\n";
	
	
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
				"||***********************************************************************************************||\n"
						+ "|| Andando pela praia, você encontra parte dos destroços do avião, não parece ter nada útil,     ||\n"
		                + "|| exceto por um encosto de braço de um dos assentos do avião que se partiu exatamente após a    ||\n"
		                + "|| curvatura, gerando um punhal praticamente perfeito. Você analisa e decide utilizar o encosto  ||\n"
		                + "|| como arma.                                                                                    ||\n"
						+ "||***********************************************************************************************||\n";
		GameController.jogador.setArma("Braço do Assento");
		String continuacaoPraia = 
				          "||***********************************************************************************************||\n"
                        + "|| Você se depara com uma montanha de rochas que impede que você siga pela praia, sua única      ||\n"
                        + "|| opção é entrar na floresta e é exatamente isso que você faz.                                  ||\n"
                        + "|| Entrando na floresta você se depara com uma cobra no tronco de uma árvore, porém você nota    ||\n"
                        + "|| alguma coisa brotando do que seriam as ‘costas’ do réptil, mas também nota que ela aparenta   ||\n"
                        + "|| ser um filhote pelo seu tamanho. Quando você percebe a peculiaridade deste animal, ela já     ||\n"
                        + "|| está avançando em sua direção com um par de asas abertas e por mais jovem que seja, é um      ||\n"
                        + "|| animal extremamente violento, você já notou que as histórias sobre esse lugar aparentavam     ||\n"
                        + "|| ser verdadeiras                                                                               ||\n"
		                + "|| Você pega o coco que o macaco havia jogado em você. Parece seguro comer.                      ||\n"
                        + "||***********************************************************************************************||\n";
		
		/*Inimigo inimigo = new Inimigo();
		
		inimigo.setNomeInimigo("Macaco");*/
		
		GameController.uteis.printaTexto(caminhoPraia, 15);
		GameController.uteis.printaTexto(continuacaoPraia, 15);
		
		//- Você come e recupera 1 de vida. --
		
		/*GameController.jogador.setVida(1);
		System.out.println(GameController.jogador.getVidaMaxima());*/
		
	}
	
	public void caminhoFloresta() {
		String caminhoFloresta = 
                "||***********************************************************************************************||\n"
              + "|| Ao entrar na floresta você é quase atingido por um coco, vindo do alto. Buscando o que        ||\n"
              + "|| poderia ter acontecido ao ser quase atingido por aquele coco, você avista um pequeno macaco,  ||\n"
              + "|| mas ele possui características que te deixam amedrontado.                                     ||\n"
              + "|| Apesar de sua estatura, o macaco possui 6 braços e 8 pontos vermelhos no rosto que te encaram ||\n"
              + "|| com bastante raiva, você já notou que as histórias sobre esse lugar aparentavam ser           ||\n"
              + "|| verdadeiras.”                                                                                 ||\n"
              + "||***********************************************************************************************||\n";
		
		GameController.uteis.printaTexto(caminhoFloresta, 15);
	}
	
	public void getTerceiroAto() {
		
		String caminhosUnificados = 
				"||***********************************************************************************************||\n"
                        + "|| Você continua floresta adentro, ao retirar alguns galhos e folhas do caminho, você            ||\n"
                        + "|| acidentalmente se depara com um, ou melhor, centenas de patas pertencentes a uma lacraia      ||\n"
                        + "|| gigante, com aproximadamente 1,50m de comprimento bem próximo a você. Ela não gostou de você  ||\n" 
                        + "|| por ter descoberto o esconderijo dela, expondo-a à luz do dia. Enquanto ela se contorce para  ||\n"
                        + "|| cima para te amedrontar, a única coisa que vem a sua mente é que este inseto aparentava ser   ||\n"
                        + "|| bem mais forte do que a última criatura que enfrentou.                                        ||\n"   
		                + "|| Diante de uma criatura aterrorizante daquela, você decide fugir. Você corre até uma clareira, ||\n" 
                        + "|| onde seus passos desesperados conseguiram te levar, pois percebeu que aquela criatura não     ||\n" 
                        + "|| gostava muito da luz do sol portanto ela não te seguiu.                                       ||\n"
	 	                + "|| Chegando naquele espaço aberto, você começa a raciocinar sobre seu real estado, onde você se  ||\n"
                        + "|| encontra e o que mais aquela ilha poderia estar guardando para você.                          ||\n"
		                + "|| Diante desse cenário você decide traçar um plano para fugir, porém você não sabe quanto tempo ||\n"
                        + "|| exatamente isso pode levar e por instinto, você sabe que vai escurecer em algumas horas.      ||\n"
                        + "|| Tentando aumentar suas chances de sobrevivência você decide procurar por água, comida e       ||\n"        
                        + "|| abrigo. Porém, duas coisas chamam sua atenção.                                                ||\n"
		                + "|| Ao leste você ouve um som de água, aparentemente vindo de uma cachoeira. E, ao oeste você     ||\n"
                        + "|| consegue ver um sinal de fumaça entre a copa das árvores.                                     ||\n"
		                + "||***********************************************************************************************||\n"
                        
                        + "\r"

		                + "||*************  O QUE VOCÊ FAZ? *************||\n"
		                + "||============================================||\n"
		                + "|| 1 - Anda em direção ao Leste (Cachoeira)   ||\n"
		                + "|| 2 - Anda em direção ao Oeste (Fumaça)      ||\n"
		                + "||============================================||\n";
		
		GameController.uteis.printaTexto(caminhosUnificados, 15);
		int input = GameController.sc.nextInt();
		
		switch (input) {
			
			case 1: 
			GameController.uteis.limpaConsole();	
			getCaminhoCachoeira();
			break;
			
			case 2:
			GameController.uteis.limpaConsole();	
			getCaminhoFumaca();
			break;
			
			default: 
			System.out.println("Opção inválida!");
			GameController.uteis.limpaConsole();
			getTerceiroAto();
		}
	}
	
	public void getCaminhoCachoeira () {
		
		String caminhoCachoeira = 
				          "||***********************************************************************************************||\n"
                        + "|| Ao chegar na cachoeira você se depara com um local lindo e estaria ainda mais maravilhado se  ||\n"
                        + "|| não lembrasse das possíveis lacraias gigantes que poderiam existir por ali, te deixando       ||\n"
                        + "|| alerta. Além disso você consegue ver a extensão do rio levando até a praia, você está         ||\n"
                        + "|| morrendo de sede e precisa se hidratar, mesmo com os riscos você decide beber a água.         ||\n"
                        + "||***********************************************************************************************||\n";
			   
				//-Se vidaMaxima não faz nada, se vida < vidaMaxima restaura vida-
		
		String continuacaoCachoeira = 
							 "||***********************************************************************************************||\n"
	                     + "|| A água parece boa, você se sente renovado.                                                    ||\n"
	                     + "|| Olhando a frente, você verifica que numa das “paredes” da cachoeira possui uma abertura.      ||\n"
	                     + "|| Aparentemente uma caverna que poderia servir de abrigo durante a noite, mas ela pode abrigar  ||\n"
	                     + "|| criaturas desconhecidas como as vistas até aqui.                                              ||\n"
	                     + "|| Você pode ir para a caverna ou você pode voltar para a clareira e seguir o sinal de fumaça que||\n"
	                     + "|| viu mais cedo.                                                                                ||\n" 
	                     + "||***********************************************************************************************||\n"  
				    //Água adquirida, falta comida e abrigo.
	                     + "||************* O QUE VOCÊ FAZ? *************||\n"
	                     + "||===========================================||\n"
				         + "||           1 - Entra na caverna            ||\n"
				         + "||           2 - Volta para o Oeste (Fumaça) ||\n"
				         + "||===========================================||\n";
		
		GameController.uteis.printaTexto(caminhoCachoeira, 15);
		GameController.uteis.printaTexto(continuacaoCachoeira, 15);
		
		int input = GameController.sc.nextInt();
		
		switch (input) {
		
		case 1: 
		GameController.uteis.limpaConsole();	
		getCaminhoCaverna();
		break;
		
		case 2:
		GameController.uteis.limpaConsole();	
		getCaminhoFumaca();
		break;
		
		default: 
		System.out.println("Opção inválida!");
		GameController.uteis.limpaConsole();
		getCaminhoCachoeira();
	}
		
	}
	
	public void getCaminhoCaverna () {
		
		String caminhoCaverna = 
				 "||***********************************************************************************************||\n"
	           + "|| Se esgueirando pelos cantos até entrar na caverna, você acha estranho o fato dela ser quente e||\n"
	           + "|| pensa que passar a noite ali seria realmente bem agradável, afinal, você já estaria protegido ||\n"
	           + "|| do frio, porém, não é só você que teve essa ideia…                                            ||\n"
			   + "|| No teto da caverna, de cabeça para baixo, estão pendurados o que parecem ser uma família      ||\n"
	           + "|| enorme de morcegos fluorescentes e no meio deles, existe um que se destaca, aparentemente a   ||\n" 
	           + "|| mãe de todos aqueles filhotes.                                                                ||\n"
	           + "|| Ela acorda com um grito amedrontador e feroz quando te vê, abre as asas iluminando ainda mais ||\n"
	           + "|| toda a caverna e avança na sua direção.                                                       ||\n" 
			   + "||***********************************************************************************************||\n"  

			   + "||************* O QUE VOCÊ FAZ? *************||\n"
			   + "||===========================================||\n"
			   + "||    1 - Ataca/Se Protege com o que tem     ||\n"
			   + "||    2 - Foge (Volta para cachoeira)        ||\n"
			   + "||===========================================||\n";
		
		GameController.uteis.printaTexto(caminhoCaverna, 15);
		
		int input = GameController.sc.nextInt();
				
				switch (input) {
				
				/*case 1: 
				GameController.uteis.limpaConsole();	
				--- MODO DE COMBATE ---;
				break; */
				
				case 2:
				GameController.uteis.limpaConsole();	
				getCaminhoCachoeira();
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
                         "|| Ao chegar no local da fumaça, além de ter o que te chamou atenção a distância, você nota que  ||\n"
                       + "|| há muitas abóboras, de variados tamanhos, até mesmo algumas gigantes e bem maduras espalhadas ||\n"
                       + "|| no chão, como uma plantação bem sucedida. Porém, você nota que aquela fumaça está emergindo   ||\n"
                       + "|| do chão envolvendo os legumes e não há sinal de fogo aparente, apenas aquela nuvem branca.    ||\n" 
			           + "|| Você se aproxima e percebe que elas estão quentes, assim como o chão, e os legumes devidamente||\n"
                       + "|| assados. Essa ilha é realmente mágica! Você decide comê-las antes que desmaie de fome.        ||\n"
                       + "||***********************************************************************************************||\n";
		
				// -Se vidaMaxima não faz nada, se vida < vidaMáxima restaura vida.-;
		
				// -Se vidaMaxima não faz nada, se vida < vidaMáxima restaura vida.-
		
		String continuacaoFumaca = 
               "||***********************************************************************************************||\n"
	         + "|| As abóboras estavam deliciosas, você se sente saciado e mais disposto.                        ||\n"
		     + "|| Olhando ao redor, você percebe que a vegetação muda um pouco, as árvores aqui se assemelham a ||\n"
             + "|| baobás, com a copa e os troncos largos o bastante para acomodarem um humano deitado,          ||\n"
		     + "|| com folhagens densas o bastante para impedir a chuva, além disso alguns galhos menores estão  ||\n"
             + "|| dispostos nas árvores de madeira que formam perfeitamente degraus até o topo.                 ||\n"
		     + "|| Você precisa de um lugar para passar a noite e, para se proteger do frio, poderia colocar     ||\n"
             + "|| algumas abóboras quentinhas e folhagens sob você.                                             ||\n"
		     + "||***********************************************************************************************||\r"

		     + "||************* O QUE VOCÊ FAZ? *************||\n"
		     + "||===========================================||\n"
		     + "||	 1 - Vai em direção a Cachoeira (Leste)  ||\n"
		     + "||   2 - Fica e sobe na Árvore               ||\n"
		     + "||===========================================||\n";
		
				// Comida adquirida, falta abrigo e água.
		
		int input = GameController.sc.nextInt();
				
				switch (input) {
				
				case 1: 
				GameController.uteis.limpaConsole();	
				getCaminhoCachoeira();
				break;
				
				case 2:
				GameController.uteis.limpaConsole();	
				getCaminhoArvore();
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
                "||***********************************************************************************************||\n"
              + "|| Você colocou algumas folhagens e abóboras na base da árvore e irá subi-las pouco a pouco.     ||\n"
              + "|| Na primeira leva de materiais, você se depara com um ninho do que aparenta ser alguma ave,    ||\n"
              + "|| você até pensa por um instante que pode ser inabitado, entretanto, este pensamento não dura   ||\n"
              + "|| muito, pois, você sente um vulto passando no céu atrás de você, ao se virar o que parece ser  ||\n"
              + "|| um cavalo, com cabeça e asas de àguia está voando a toda velocidade na sua direção,           ||\n"
              + "|| aparentemente aquele ninho pertence a ela. Você se lembra de histórias antigas e de um animal ||\n"
              + "|| assim… Um Hipogrifo, é isso que você enfrentará.                                              ||\n"
              + "||***********************************************************************************************||\n"

		+ "||*************  O QUE VOCÊ FAZ? *************||\n"
		+ "||============================================||\n"
		+ "||    1 - Ataca/Se Protege com o que tem      ||\n"
		+ "||    2 - Foge (Desce para as abóboras)       ||\n"
		+ "||============================================||\n";
		
		int input = GameController.sc.nextInt();
		
		switch (input) {
		
		/*case 1: 
		GameController.uteis.limpaConsole();	
		--- MODO DE COMBATE ---;
		break; */
		
		case 2:
		GameController.uteis.limpaConsole();	
		getCaminhoFumaca();
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
				  "||***********************************************************************************************||\n"
                + "|| Após acordar, você decide ir até a outra extremidade da ilha para explorar um pouco mais e    ||\n"
                + "|| decidir quais serão os próximos passos. Chegando na praia você elabora uma lista na areia dos ||\n"
                + "|| itens que precisa para construir sua jangada:                                                 ||\n"
                + "|| FOLHAS DE PALMEIRA, MADEIRAS E CORDAS.                                                        ||\n" 
				+ "||***********************************************************************************************||\n"

				+ "||********* O QUE VOCÊ FAZ PRIMEIRO? ********||\n"
				+ "||===========================================||\n"
				+ "||     1 - Vou procurar Folhas de Palmeira   ||\n"
				+ "||     2 - Vou procurar as Madeiras          ||\n"
				+ "||     3 - Vou procurar as Cordas            ||\n"
				+ "||===========================================||\n";

		
		GameController.uteis.printaTexto(caminhosUnificados2, 15);
		int input = GameController.sc.nextInt();
		
		switch (input) {
			
			case 1: 
			GameController.uteis.limpaConsole();	
			getFolhasDePalmeira();
			break;
			
			case 2:
			GameController.uteis.limpaConsole();	
			getMadeira();
			break;
			
			case 3:
			GameController.uteis.limpaConsole();	
			getCorda();
			break;
			
			default: 
			System.out.println("Opção inválida!");
			GameController.uteis.limpaConsole();
		}
		
	}
	
	public void getFolhasDePalmeira () {
		
		String formigasGigantes = 
							  "||***********************************************************************************************||\n"
	                        + "|| Você decide ir atrás de folhas de palmeira.                                                   ||\n"
	                        + "|| Você sabe que achar tecidos por aqui seria pedir demais, já é incrível ter permanecido vivo.  ||\n"
	                        + "|| Então, você se lembra do coco que o macaco-aranha havia arremessado em você, então, deviam    ||\n"
	                        + "|| haver palmeiras por perto, você anda um pouco até encontrá-las, mas o som de outros           ||\n"
	                        + "|| macaco-aranhas te ajudou a achar o que procurava. Você vê uma trilha que te leva para uma     ||\n"
	                        + "|| espécie de “montanha”, como se algo passasse ali com bastante frequência, a sua esquerda uma  ||\n"
	                        + "|| montanha de terra é um cenário diferente das árvores do local, à sua direita você vê uma folha||\n" 
	                        + "|| bem grande, o suficiente para te cobrir, sendo carregada por uma formiga tão grande quanto a  ||\n" 
	                        + "|| folha.                                                                                        ||\n"
	                        + "|| Ao detectar sua presença e proximidade do que agora você sabe ser um formigueiro, o inseto    ||\n"
	                        + "|| exala um odor diferente, o que atrai outra formiga tão grande quanto ela, essa outra formiga  ||\n"
	                        + "|| porém possuía pinças bem maiores, claramente era responsável pela defesa do formigueiro e das ||\n"
	                        + "|| demais formigas, você se prepara para atacar, pois agora aquelas formigas estão logo a frente ||\n"
	                        + "|| das palmeiras que você tanto precisa                                                          ||\n"
	                        + "||***********************************************************************************************||\n";
		
				// - BATALHA -

		String continuacaoFormigasGigantes = 
				   "Você conseguiu derrotá-lo! Você pega todas as folhas necessárias para sua jangada e leva para a praia."	
		
				// Item: Pinça de formiga - Arma (Formiga que foi derrotada em uma briga) / Folhas de Palmeira
		
				+ "||********* PARA ONDE QUER IR AGORA? ********||\n"
				+ "||===========================================||\n"
				+ "||           1 - Ir atrás de Madeira         ||\n"
				+ "||           2 - Ir atrás de Corda           ||\n"
				+ "||===========================================||\n";
		
		int input = GameController.sc.nextInt();
		
		switch (input) {
			
			case 1: 
			GameController.uteis.limpaConsole();	
			getMadeira();
			break;
			
			case 2:
			GameController.uteis.limpaConsole();	
			getCorda();
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
                "||***********************************************************************************************||\n"
              + "|| Você decide ir atrás de madeira.                                                              ||\n"
              + "|| Você encontra madeiras que servirão perfeitamente para a jangada, com o diâmetro bom o        ||\n"
              + "|| suficiente para subir com uns 5 troncos, que ficarão firmes com as cordas.                    ||\n"
              + "|| Contente, você olha ao redor das árvores e nota alguns montes de barro gigante, como se todos ||\n"
              + "|| os cupinzeiros do mundo tivessem se juntado num só e criado várias ‘bases’ nos arredores.     ||\n"
		      + "|| Além disso, várias árvores estão derrubadas/podres e algumas tem fumaça saindo da base onde   ||\n"
              + "|| foi feito o corte, como se tivesse derrubado a árvore utilizando algum ácido, além disso      ||\n"
              + "|| o cheiro do ambiente te deixa um pouco nauseado. Você aproveita as árvores já caídas e que    ||\n"
              + "|| ainda parecem boas, porém, ao tocar na primeira delas, vindo de um dos montes de barro,       ||\n"
              + "|| um cupim gigante brota, disparando um ácido na sua direção, você desvia e sabe que terá que   ||\n"
              + "|| lutar pelas madeiras.                                                                         ||\n"
              + "||***********************************************************************************************||\n";
		
				// - BATALHA -
		
		String continuacaoCupimGigante = 
				  "Você conseguiu derrotá-lo! Você pega todas as madeiras necessárias para sua jangada e leva para a praia."
		
				// Item: Cola Orgânica de Cupim (para revestimento)
				
				+ "||******** PARA ONDE QUER IR AGORA? *******||\n"
				+ "||=========================================||\n"
				+ "||           1 - Ir atrás de Corda         ||\n"
				+ "||=========================================||\n";
		
		int input = GameController.sc.nextInt();
		
		switch (input) {
			
			case 1: 
			GameController.uteis.limpaConsole();	
			getCorda();
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
                "||***********************************************************************************************||\n"
              + "|| Você decide ir atrás de cordas.                                                               ||\n"
              + "|| Andando pela praia você encontra uma extensão da floresta contendo diversas trepadeiras.      ||\n"
              + "|| Não são cordas propriamente ditas, mas os cipós das árvores irão servir perfeitamente para a  ||\n"
              + "|| jangada. Porém, ao se aproximar da vegetação, um Louva-Deus Gigante aparece cortando parte dos||\n"
              + "|| cipós com as suas patas dianteiras que aparentam ser revestidas com algum metal que se        ||\n"
              + "|| assemelham a facas de serra. Você só consegue pensar nos diversos vídeos de louva-deuses      ||\n"
              + "|| atacando lagartos ou outros animais e como os louva-deus fêmeas comem as cabeças dos machos   ||\n"
              + "|| após a reprodução. Você sente calafrios por toda a espinha, seu corpo grita para que você     ||\n"
              + "|| fuja, mas não tem como fugir, você precisa dos cipós.                                         ||\n"
              + "||***********************************************************************************************||\n";
		
				// - BATALHA -
		
		String continuacaoLouvaDeusGigante = 
				  "Você conseguiu derrotá-lo! Você pega todas as cordas necessárias para sua jangada e leva para a praia. Aparentemente agora você tem tudo que necessita";
		
				// Item: Cola Orgânica de Cupim (para revestimento)
		
		GameController.uteis.printaTexto(louvaDeusGigante, 15);
		GameController.uteis.printaTexto(continuacaoLouvaDeusGigante, 15);
		
		}
	
	public void getPenultimoAto () {
		
		String finalBoss = 
				      "||***********************************************************************************************||\n"
	                + "|| Após conseguir todos os itens da lista, você começa a montar sua jangada…                     ||\n"
					+ "|| Você utiliza as madeiras, cola, folhas de palmeira e os cipós para construir a jangada que te ||\n"
	                + "|| levará para longe desta ilha. Você aproveita também para confeccionar uma arma mais forte     ||\n"
	                + "|| utilizando a pata de metal do louva-deus                                                      ||\n"
					+ "|| e a pinça da formiga gigante. Algumas horas depois você termina a jangada, não é muito, mas   ||\n"
	                + "|| vai funcionar para sair da ilha e com sorte chegar até o continente ou um lugar sem tantas    ||\n"
	                + "|| criaturas bizarras.                                                                           ||\n"
					+ "|| Você coloca a jangada na água e parte dando adeus àquela ilha maldita, você olha para trás e  ||\n"
	                + "|| sorri, agradecendo por ter sobrevivido e pensando em tudo que faria a partir dali, quando     ||\n"
	                + "|| estivesse realmente a salvo, porém sua esperança dura pouco…                                  ||\n"
	                + "|| Diante de você uma criatura enorme emerge das águas, os tentáculos da criatura envolvem toda a||\n"
	                + "|| jangada e um olho do tamanho da sua cabeça está diante de você, te olhando fixamente.         ||\n"
	                + "|| Você precisa tomar uma atitude rápida.                                                        ||\n"
	                + "||***********************************************************************************************||\n"
		
					+ "||************* O QUE VOCÊ FAZ? *************||\n"
					+ "||===========================================||\n"
					+ "||       1 - Bate com a arma nos Tentáculos  ||\n"
					+ "||       2 - Fura o olho da Criatura         ||\n"
					+ "||===========================================||\n";
		
		
		
		/*int input = GameController.sc.nextInt();
				
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

				+ "||*** O QUE VOCÊ FAZ? ***||\n"
				+ "||=======================||\n"
				+ "||      1 - Matar        ||\n"
				+ "||      2 - Ir Embora    ||\n"
				+ "||=======================||\n";
		
		GameController.uteis.printaTexto(ultimaDecisao, 15);
		int input = GameController.sc.nextInt();
		
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

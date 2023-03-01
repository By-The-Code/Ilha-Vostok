package Packages_CdA;

public class Historia {
	
	private String nome;
	private String profissao; 
	
	public void intro() {
		System.out.println(
					"\n--------------------------------PRÓLOGO--------------------------------\n"
				+ 	"Uma tempestade torrencial cai dos céus sobre o jato Praetor 600, \n"
				+ 	"enquanto os raios e trovões intermitentes cortam as nuvens e os ouvidos da tripulação e seus passageiros, \n"
				+ 	"apenas constituída por dois pilotos e uma comitiva de pesquisadores destinada a Miami. \n"
				+ 	"A turbulência estava fora do comum e o comandante já não possuía mais forças para segurar \n"
				+ 	"o manche que agora parecia pesar uma tonelada.\n\n"
				+ 	"Como uma força sobrenatural, \n"
				+ 	"o avião dá um solavanco abrupto para baixo quando uma das turbinas explode \n"
				+ 	"e a aeronave parece ser “sugada” em direção ao mar, \n"
				+ 	"como se não fosse meramente a força da gravidade. \n"
				+ 	"Agora despencando em uma queda livre, \n"
				+ 	"avançando metros e metros em poucos segundos em direção a água, \n"
				+ 	"um breve vislumbre de um imenso buraco no meio do nada, \n"
				+ 	"é visto através de uma pequena janela por um dos tripulantes que ainda mantinha o pouco de sua sanidade intacta. \n"
				+ 	"E então, a colisão.\n"
				+ 	"-----------------------------------------------------------------------\n");
	}
	
	public void escolherNome() {
		System.out.println(
					"\n--------------------------------QUEM VOCÊ É?--------------------------------\n"
				+ 	"Você acorda numa ilha no meio do Pacífico, \n"
				+ 	"olhando ao redor você nota que todos os outros membros da comitiva não tiveram a mesma sorte que você, "
				+ 	"você tenta se lembrar de coisas básicas como o seu nome.\n"
				+ 	"Como você se chama: \n"
				+ 	"------------------------------------------------------------------------------\n");
		
				nome = Game.scan.nextLine();
				System.out.println("Você se chama " + nome.toUpperCase() + ", correto? '1 - SIM || 2 - NAO'\n");
				String input = Game.scan.nextLine();
				
				if (input.equalsIgnoreCase("SIM") || input.equalsIgnoreCase("1")) {
					escolherProfissao();
				}
				else if (input.equalsIgnoreCase("NAO") || input.equalsIgnoreCase("2")) {
					escolherNome();
				}
				else {
					System.out.println("Não entendi o que quis dizer, por favor, tente novamente!");
					escolherNome();
				}
}
	
	public void escolherProfissao() {
		System.out.println(
					"\n--------------------------------O QUE VOCÊ FAZ?--------------------------------\n"
				+ 	"Isso mesmo seu nome é " + nome.toUpperCase() + ", \n"
				+ 	"você também tenta se recordar de outras coisas básicas da sua vida para garantir que está tudo bem, "
				+ 	"você tenta se recordar do que fazia."
				+ 	"---------------------------------------------------------------------------------\n\n"
				+ 	"Aqui você possui três opções: \n"
				+ 	"1 - Medico \n"
				+ 	"2 - Soldado \n"
				+ 	"3 - Professor \n"
				+ 	"cada escolha lhe dará atributos iniciais, consulte a tabela para escolher o que deseja:");
		
			Game.tabela.geraTabelaDeProfissoes();
	
			profissao = Game.scan.nextLine().toUpperCase();
			
			if (profissao.equalsIgnoreCase("MEDICO") || profissao.equalsIgnoreCase("MÉDICO") || profissao.equalsIgnoreCase("1") ||
					profissao.equalsIgnoreCase("SOLDADO") || profissao.equalsIgnoreCase("2") ||
						profissao.equalsIgnoreCase("PROFESSOR") || profissao.equalsIgnoreCase("3")) {
				
				switch (profissao) {
					case "1":
						profissao = "MEDICO";
					break;
					case "2":
						profissao = "SOLDADO";
					break;
					case "3":
						profissao = "PROFESSOR";
					break;
				}
				
				System.out.println("Você tem certeza que era " + profissao.toUpperCase() + "? '1 - SIM || 2 - NAO'\n");
				String input = Game.scan.nextLine();
				
				if (input.equalsIgnoreCase("SIM") || input.equalsIgnoreCase("1")) {
					Game.jogador.atribuindoProfissao(profissao);
				}
				else if (input.equalsIgnoreCase("NAO") || input.equalsIgnoreCase("2")) {
					escolherProfissao();
				}
				else {
					System.out.println("Não entendi o que quis dizer, por favor, tente novamente!");
					escolherProfissao();
				}
			}
			else { 
				System.out.println("Não entendi o que quis dizer, por favor tente novamente!");
				escolherProfissao();
			}
	}
	
	public void regrasBasicas() {
		System.out.println(
				"\n--------------------------------REGRAS--------------------------------\n"
			+ 	"Vida: Ao chegar em 0 o jogo termina e você volta para o início;\n"
			+ 	"Estamina: Determina quantas ações você pode fazer por dia, ao zerar o dia acaba e a estamina reseta;\n"
			+ 	"Força: Somada com o quanto de dano você inflinge nos inimigos, também é alterado pela arma utilizada;\n"
			+ 	"Resistência: Subtraído da quantidade de dano que os inimigos infligem sobre você;\n"
			+ 	"Inteligência: Somada com a qauntidade de XP recebido ao derrotar inimigos/ cumprir missões; \n"
			+ 	"XP: Quando chegar na quantidade necessário para o 'próximo nível', "
			+ 		"aumenta 1 no nível e você recebe 1 ponto para definir no que irá gastar dos itens acima");
	}
}

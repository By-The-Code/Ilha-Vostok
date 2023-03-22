package Game;

public class Uteis {

	public void printaTexto(String texto, int tempo) {
		for(int loop = 0; loop < texto.length(); loop++) {
			System.out.print(texto.charAt(loop));
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();	
			}
		}
	}
	
	public void limpaConsole() { 
		
		for (int i = 0; i <= 50; i++) {
			System.out.println();
		}
	}
	
	public double geraNumeroRandomico() {
		return Math.random() * 101;
	}
	
	public boolean Continuar() {
		
		System.out.println("Precione qualquer tecla para continuar\n");
		String input = GameController.sc.nextLine();
		
		if (input == "" || input != "") return true;
		else return false;
	}
	
	public void delayParaProximoComando(int tempo) {
		
		tempo *= 100;
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	public void escolha(String input, String caminho) {
		switch (caminho) {
		
		case "PRAIA":
			if (input == "1" || input == "PRAIA") GameController.historia.caminhoPraia();
			else if (input == "2" || input == "FLORESTA") GameController.historia.caminhoPraia();
			else {
				System.out.println("Não entendi, tente novamente!");
				String inp = GameController.sc.nextLine().toUpperCase();
				GameController.uteis.escolha(inp, );
			}
			break;
		case "FLORESTA":
			break;
		case "FUMACA":
			break;
		case "CACHOEIRA":
			break;
		case "ARVORE":
			break;
		case "CAVERNA":
			break;
		case "MADEIRA":
			break;
		case "CORDA":
			break;
		case "FOLHAS":
			break;
		case "TENTACULOS":
			break;
		case "OLHO":
			break;
		case "PARTIR":
			break;
		case "MATAR":
			break;
		
		}
		
		
	}*/
}

package Packages_CdA;

public class Jogador {
	private int vida = 10;
	private int estamina = 10;
	private int forca;
	private int resistencia;
	private int inteligencia;
	private int nivel;

	private double xp = 0;
	private double xpParaUpar = 10;
	private String profissao;
	private String arma;
	
	/********************************/
	//GETs
	/********************************/
	public void getStatus() {
		System.out.print("Status do Jogador: \n");
		System.out.print("Vida: " 			+ getVida() 		+ "\n");
		System.out.print("Estamina: " 		+ getEstamina() 	+ "\n");
		System.out.print("Força: " 			+ getForca() 		+ "\n");
		System.out.print("Resistência: " 	+ getResistencia() 	+ "\n");
		System.out.print("Inteligência: " 	+ getInteligencia() + "\n");
		System.out.print("Profissão: " 		+ getProfissao() 	+ "\n");
		System.out.print("Nível: " 			+ getNivel() 		+ "\n");
		System.out.print("XP: " 			+ getXp() 			+ "\n");
		System.out.print("Próximo Nível: " 	+ getXpParaUpar() 	+ "\n");
	}

	private int getVida() {
		return vida;
	}

	private int getEstamina() {
		return estamina;
	}

	private int getForca() {
		return forca;
	}

	private int getResistencia() {
		return resistencia;
	}

	private int getInteligencia() {
		return inteligencia;
	}

	public String getProfissao() {
		return profissao;
	}
	
	public double getXp() {
		return xp;
	}
	
	public int getNivel() {
		return nivel;
	}
	
	public double getXpParaUpar() {
		return xpParaUpar;
	}
	
	/********************************/
	//SETs
	/********************************/
	public void setVida(int vida) {
		this.vida += vida;
	}
	
	
	public void setEstamina(int estamina) {
		this.estamina += estamina;
	}
	
	
	public void setForca(int forca) {
		this.forca += forca;
	}
	
	public void setResistencia(int resistencia) {
		this.resistencia += resistencia;
	}
	
	
	public void setInteligencia(int inteligencia) {
		this.inteligencia += inteligencia;
	}
	
	public void setXp(double xp) {
		this.xp += xp;
	}
	
	public void setNivel(int nivel) {
		this.nivel += nivel;
	}
	
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
	public void atribuindoProfissao(String profissao) {
			
		switch(profissao) {
			case "MEDICO", "MÉDICO", "1":
				setVida(5);
				setResistencia(5);
				setInteligencia(2);
				
			break;
			case "SOLDADO", "2":
				setEstamina(5);
				setForca(5);
				setVida(2);
			break;
			case "PROFESSOR", "3":
				setVida(3);
				setEstamina(3);
				setInteligencia(6);
			break;
				
			default: System.out.println("Não entendi o que quis dizer, tente novmaente.\n");
					 Game.hist.escolherProfissao();
			}
			
		setProfissao(profissao);
		getStatus();
	}
	
	public void uparNivel(double exp) {
		
		if (xp + exp >= xpParaUpar) {
			setXp(xp + exp - xpParaUpar);
			xpParaUpar *= 1.25; 
			uparStatus();
		}
		else {
			setXp(exp);
		}
	}
	
	public void uparStatus() {
		
		System.out.println(	"Você upou de nível, defina o que seja melhorar: \n"
				+ 	"1 - Vida\n"
				+ 	"2 - Estamina\n"
				+ 	"3 - Forca\n"
				+ 	"4 - Resistencia\n"
				+ 	"5 - Inteligencia\n");

		String escolha = Game.scan.nextLine();
		
		switch (escolha.toUpperCase()) {
		case "VIDA", "1":
			setVida(1);
		break;
		case "ESTAMINA", "2":
			setEstamina(1);
		break;
		case "FORCA", "3":
			setForca(1);
		break;
		case "RESISTENCIA", "4":
			setResistencia(1);
		break;
		case "INTELIGENCIA", "5":
			setInteligencia(1);	
		break;
		
		default: System.out.println("Não entendi o que quis dizer, tente novamente!");
				 uparStatus();
		}
		
		setNivel(1);
	}
	
	public double Ataque() {
		double dano = 0;
		double dezPorCento = 10.0 / 100.0;
		
		dano = /*((*/getForca() * dezPorCento /*)+ armaDano()) / defesaInimigo()*/;
		
		return dano;
	}
}

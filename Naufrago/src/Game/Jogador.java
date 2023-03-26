package Game;

import java.util.Scanner;

public class Jogador {
	
	private int 	vidaMaxima = 100;
	private float 	vida = 100;
	private int 	forca = 0;
	private int 	resistencia = 0;
	private int 	nivel = 1;
	private float 	xp = 0.0f;
	private float 	xpParaUpar = 10.0f;
	private String 	nome = "";
	private String 	profissao = "";
	private String 	arma = "Mãos";
	private String 	armadura = "";
	
	public Jogador(String nome, String profissao) {
		
		this.nome = nome;
		
		switch(profissao) {
			case "MÉDICO": this.profissao = "Médico";
			atribuindoValoresBaseadoNaProfissao(this.profissao);
			break;
			
			case "SOLDADO": this.profissao = "Soldado";
			atribuindoValoresBaseadoNaProfissao(this.profissao);
			break;
			
			case "PROFESSOR": this.profissao = "Professor";
			atribuindoValoresBaseadoNaProfissao(this.profissao);
			break;
		}
	}
	
	private void atribuindoValoresBaseadoNaProfissao(String profissao) {
		
		switch (profissao) {
			case "Médico":  		
				setVidaMaxima(15);
				setResistencia(5);
				setVida(vidaMaxima);
				//getStatus();
				break;
				
			case "Soldado":
				setVidaMaxima(15);
				setVida(vidaMaxima);
				setForca(5);
				//getStatus();
				break;
				
			case "Professor":
				setVidaMaxima(10);
				setVida(vidaMaxima);
				setForca(3);
				setResistencia(3);
				//getStatus();
				break;	
				
			default: System.out.println("Comando Inválido!");
			atribuindoValoresBaseadoNaProfissao("Professor");
		}		
	}

	public String getStatus() {
		
		String txt = 		"Nome: "		+ nome 			+ " | Profissão: " + profissao + "\n"
						+	"Vida Máxima: " + vidaMaxima	+ "\n"
						+ 	"Vida: " 		+ vida 			+ "\n"
						+ 	"Força: " 		+ forca 		+ "\n"
						+ 	"Resistência: " + resistencia 	+ "\n"
						+ 	"Nível: " 		+ nivel 		+ "\n"
						+ 	"XP: " 			+ xp 			+ "\n"
						+ 	"Arma: " 		+ arma			+ "\n"
						+ 	"Armadura: " 	+ armadura 		+ "\n"
						+ 	"XP p/ Upar: "  + xpParaUpar    + "\n";
		
		return txt;
	}
	
	
	public void passaDeNivel(float experiencia) {
		
		if(xp + experiencia >= xpParaUpar) {
			setXp(xp + experiencia - xpParaUpar);			
			setXpParaUpar(1.25f);
			setNivel(1);
			melhoraStatus();
		}
		else 
			setXp(experiencia);		
	}
	
	public void melhoraStatus() {
		
		System.out.println("||**********SUBIU DE NÍVEL************||"
						+  "|| Escolha o que você quer melhorar!  ||\n"
						+  "|| 1. Vida                            ||\n"
						+  "|| 2. Força                           ||\n"
						+  "|| 3. Resistência                     ||\n"
						+  "||************************************||\"");
		
		Scanner scan = new Scanner (System.in);
		int escolha = scan.nextInt();
		
		switch (escolha) {
			case 1: 
				setVidaMaxima(10);
				setVida(vidaMaxima);
				getStatus();
				break;
			case 2: 
				setForca(1);
				getStatus();
				break;
			case 3: 
				setResistencia(1);
				getStatus();
				break;
	
			default:
				System.out.println("Comando inválido!");
				melhoraStatus();
		}	
	}
	
	public int getDanoArma(String arma) {
		
		switch(arma) {
			case "Mãos":
				return 5;
			
			case "Braço do Assento":
				return 10;
			
			case "Pedaço de Madeira":
				return 10;
				
			case "Osso Humano":
				return 15;
			
			case "Pinças de Formiga Gigante":
				return 30;
				
			default: System.out.println("Esta arma é inválida!");
					 return 0;
		}
	}
	
	public float getDanoJogador(int defesaInimigo) {
		return (getForca() + getDanoArma(arma))/ defesaInimigo;
	}
	
	public int getDefesaArmadura(String armadura) {
		
		switch(armadura) {
			case "":
				return 0;
		
			case "Boné":
				return 5;
			
			case "A":
				return 10;
			
			case "B":
				return 10;
				
			case "C":
				return 15;
			
			case "D":
				return 30;
				
			default: System.out.println("Esta armadura é inválida!");
				return 0;
		}		
	}
	
	public int getDefesaJogador() {
		return getResistencia() + getDefesaArmadura(armadura);
	}

	public int getVidaMaxima() {
		return vidaMaxima;
	}

	public void setVidaMaxima(float vidaMaxima) {
		this.vidaMaxima += vidaMaxima;
	}

	public float getVida() {
		return vida;
	}
	
	public void setVida(float vida) {
		this.vida = vida;
	}
	
	public void setVidaDano(float dano) {
		this.vida -= dano;
	}
	
	public void setVidaCura(float vida) {
		this.vida += vida;
	}

	public int getForca() {
		return forca;
	}

	public void setForca(int forca) {
		this.forca += forca;
	}

	public int getResistencia() {
		return resistencia;
	}

	public void setResistencia(int resistencia) {
		this.resistencia += resistencia;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel += nivel;
	}

	public float getXp() {
		return xp;
	}

	public void setXp(float xp) {
		this.xp += xp;
	}

	public float getXpParaUpar() {
		return xpParaUpar;
	}


	public void setXpParaUpar(float xpParaUpar) {
		this.xpParaUpar *= xpParaUpar;
	}


	public String getNome() {
		return nome;
	}

	/*
	public void setNome(String nome) {
		this.nome = nome;
	}
	*/

	public String getProfissao() {
		return profissao;
	}

	/*
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	*/

	public String getArma() {
		return arma;
	}


	public void setArma(String arma) {
		this.arma = arma;
	}

	public String getArmadura() {
		return armadura;
	}

	public void setArmadura(String armadura) {
		this.armadura = armadura;
	}
	
	
	
}

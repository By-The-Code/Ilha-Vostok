package Game;

import java.util.Scanner;

public class Jogador {
	
	private int vidaMaxima = 100;
	private float vida = vidaMaxima;
	private int forca = 0;
	private int resistencia = 0;
	private int nivel = 1;
	private float xp = 0.0f;
	private float xpParaUpar = 10.0f;
	private String nome = "";
	private String profissao = "";
	private String arma = "Mãos";
	private String armadura = "";
	
	
	private void atribuindoValoresBaseadoNaProfissao(String profissao) {
		
		switch (profissao) {
		
		case "Médico":  		
			setVidaMaxima(15);
			setResistencia(5);
			getStatus();
			break;
			
			
		case "Soldado":
			setVidaMaxima(15);
			setForca(5);
			getStatus();
			break;
			
		case "Professor":
			setVidaMaxima(10);
			setForca(3);
			setResistencia(3);
			getStatus();
			break;	
			
		default: System.out.println("Comando Inválido!");
		atribuindoValoresBaseadoNaProfissao("Professor");
		}		
		
	}
	
	public Jogador(String nome, int profissao) {
		
		this.nome = nome;
		
		switch(profissao) {
		
		case 1: this.profissao = "Médico";
		atribuindoValoresBaseadoNaProfissao(this.profissao);
		break;
		
		case 2: this.profissao = "Soldado";
		atribuindoValoresBaseadoNaProfissao(this.profissao);
		break;
		
		case 3: this.profissao = "Professor";
		atribuindoValoresBaseadoNaProfissao(this.profissao);
		break;
		}
	}

	public void getStatus() {
		
		System.out.println(	"Nome: "		+ nome 			+ " | Profissão: " + profissao + "\n"
						+	"Vida Máxima: " + vidaMaxima	+ "\n"
						+ 	"Vida: " 		+ vida 			+ "\n"
						+ 	"Força: " 		+ forca 		+ "\n"
						+ 	"Resistência: " + resistencia 	+ "\n"
						+ 	"Nível: " 		+ nivel 		+ "\n"
						+ 	"XP: " 			+ xp 			+ "\n"
						+ 	"Arma: " 		+ arma			+ "\n"
						+ 	"Armadura: " 	+ armadura 		+ "\n"
						+ 	"XP p/ Upar: "  + xpParaUpar   );

	}
	
	
	public void passarDeNivel(float experiencia) {
		
		if(xp + experiencia >= xpParaUpar) {
			
			setXp(xp + experiencia - xpParaUpar);			
			
			setXpParaUpar(1.25f);
			
			setNivel(1);
			
			melhorarStatus();
		}
		
		else 
			xp += experiencia;
				
	}
	
	public void melhorarStatus() {
		
		System.out.println("Escolha o que você quer melhorar! \n"
						+  "1. Vida \n"
						+  "2. Força \n"
						+  "3. Resistência");
		
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
			
		melhorarStatus();
	}
		
}
	
	public int danoArma(String arma) {
		
		int var = 0;
		
		switch(arma) {
		
		case "Mãos":
			var = 5;
			return var;
		
		case "Braço do Assento":
			var = 10;
			return var;
		
		case "Pedaço de Madeira":
			var = 10;
			return var;
			
		case "Osso Humano":
			var = 15;
			return var;
		
		case "Pinças de Formiga Gigante":
			var = 30;
			return var;
			
		default: System.out.println("Esta arma é inválida!");
			return var;
		}
		
	}
	
	public float danoJogador() {
		return getForca() + danoArma(arma);
		// Falta definir a defesa do inimigo.
	}
	
	public int defesaArmadura(String armadura) {
		
		int var = 0;
		
		switch(armadura) {
		
		case "Boné":
			var = 5;
			return var;
		
		case "A":
			var = 10;
			return var;
		
		case "B":
			var = 10;
			return var;
			
		case "C":
			var = 15;
			return var;
		
		case "D":
			var = 30;
			return var;
			
		default: System.out.println("Esta armadura é inválida!");
			return var;
		}		
		
	}
	
	public float defesaJogador() {
		return getResistencia() + defesaArmadura(armadura);
		
	}

	public int getVidaMaxima() {
		return vidaMaxima;
	}


	public void setVidaMaxima(int vidaMaxima) {
		this.vidaMaxima += vidaMaxima;
	}


	public float getVida() {
		return vida;
	}


	public void setVida(float vida) {
		this.vida = vida;
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
		this.xp = xp;
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
	
	
	
}

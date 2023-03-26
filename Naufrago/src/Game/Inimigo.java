package Game;

public class Inimigo {

	private String nomeInimigo;
	private int vidaInimigo;
	private int forcaInimigo;
	private int resistenciaInimigo;
	private int nivelInimigo;
	
	public void getStatusInimigo() {
		System.out.println( 	"Nome Inimigo: " 		+ getNomeInimigo() 		  + "\n"
							+ 	"Vida Inimigo: " 		+ getVidaInimigo() 		  + "\n"
							+ 	"Força Inimigo: " 		+ getForcaInimigo()		  + "\n"
							+ 	"Resistência Inimigo: " + getResistenciaInimigo() + "\n"
							+ 	"Nível Inimigo: " 		+ getNivelInimigo());
	}
	
	public float danoInimigo() {
		float danoInimigo = (getForcaInimigo() * getNivelInimigo()) / GameController.jogador.getDefesaJogador();
		return danoInimigo;
	}
	
	public float defesaInimigo() {
		float defesaInimigo = getResistenciaInimigo() * getNivelInimigo();
		return defesaInimigo;
	}
	
	public Inimigo (String nome, int vida, int forca, int resistencia, int nivel) {
		this.nomeInimigo = nome;
		this.vidaInimigo = vida;
		this.forcaInimigo = forca;
		this.resistenciaInimigo = resistencia;
		this.nivelInimigo = nivel;
	}
	
	public Inimigo () {}

	/*
	private Inimigo(String nomeInimigo, int vidaInimigo, int forcaInimigo, int resistenciaInimigo, int nivelInimigo) {
		super();
		this.nomeInimigo = nomeInimigo;
		this.vidaInimigo = vidaInimigo;
		this.forcaInimigo = forcaInimigo;
		this.resistenciaInimigo = resistenciaInimigo;
		this.nivelInimigo = nivelInimigo;
	}
	*/

	private String getNomeInimigo() {
		return nomeInimigo;
	}

	private void setNomeInimigo(String nomeInimigo) {
		this.nomeInimigo = nomeInimigo;
	}

	private int getVidaInimigo() {
		return vidaInimigo;
	}

	private void setVidaInimigo(int vidaInimigo) {
		this.vidaInimigo = vidaInimigo;
	}

	private int getForcaInimigo() {
		return forcaInimigo;
	}

	private void setForcaInimigo(int forcaInimigo) {
		this.forcaInimigo = forcaInimigo;
	}

	private int getResistenciaInimigo() {
		return resistenciaInimigo;
	}

	private void setResistenciaInimigo(int resistenciaInimigo) {
		this.resistenciaInimigo = resistenciaInimigo;
	}

	private int getNivelInimigo() {
		return nivelInimigo;
	}

	private void setNivelInimigo(int nivelInimigo) {
		this.nivelInimigo = nivelInimigo;
	}

}

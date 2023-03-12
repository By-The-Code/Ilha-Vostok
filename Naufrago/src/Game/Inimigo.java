package Game;

public class Inimigo {

	private String nomeInimigo;
	private int vidaInimigo;
	private int forcaInimigo;
	private int resistenciaInimigo;
	private int nivelInimigo;
	
	public float danoInimigo(float forcaAtualInimigo, float nivelInimigo, float defesaJogador) {
		float danoInimigo = (forcaAtualInimigo * nivelInimigo) / defesaJogador;
		return danoInimigo;
	}
	
	public float defesaInimigo(float resistenciaAtualInimigo, float nivelInimigo) {
		float defesaInimigo = resistenciaAtualInimigo * nivelInimigo;
		return defesaInimigo;
	}

	private Inimigo(String nomeInimigo, int vidaInimigo, int forcaInimigo, int resistenciaInimigo, int nivelInimigo) {
		super();
		this.nomeInimigo = nomeInimigo;
		this.vidaInimigo = vidaInimigo;
		this.forcaInimigo = forcaInimigo;
		this.resistenciaInimigo = resistenciaInimigo;
		this.nivelInimigo = nivelInimigo;
	}

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

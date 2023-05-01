package Game;

public class Inimigo {

    private String nomeInimigo;
    private double vidaInicialInimigo;
    private double vidaInimigo;
    private double forcaInimigo;
    private double resistenciaInimigo;
    private int nivelInimigo;

    public Inimigo(String nome, double vida, double forca, double resistencia, int nivel) {
        this.nomeInimigo = nome;
        this.vidaInimigo = vida;
        this.forcaInimigo = forca;
        this.vidaInicialInimigo = this.vidaInimigo;
        this.resistenciaInimigo = resistencia;
        this.nivelInimigo = nivel;

        if (this.nivelInimigo <= 0) {
            this.nivelInimigo = 1;
        }
    }

    public String getStatusInimigo() {
        String txt = "INIMIGO: " + getNomeInimigo() + "\n"
                + "VIDA: " + Game.dc.format(getVidaInimigo()) + "\n"
                + "FORÇA: " + getForcaInimigo() + "\n"
                + "RESISTÊNCIA: " + getResistenciaInimigo() + "\n"
                + "NÍVEL: " + getNivelInimigo() + "\n";

        return txt;
    }

    public double dropExperiencia() {

        if (getForcaInimigo() > getResistenciaInimigo()) {
            double exp = (double) getVidaInicialInimigo() / (getNivelInimigo() + getResistenciaInimigo());
            return exp;
        } else {
            double exp = (double) getVidaInicialInimigo() / (getNivelInimigo() + getForcaInimigo());
            return exp;
        }
    }

    public double danoInimigo(int resistJogador) {
        double danoInimigo = (double) (getForcaInimigo() * getNivelInimigo()) / resistJogador;

        if (danoInimigo < 1) {
            return 1;
        } else {
            return danoInimigo;
        }
    }

    public double defesaInimigo() {
        double defesaInimigo = (double) getResistenciaInimigo() * getNivelInimigo();
        
        if (defesaInimigo < 1) {
            return 1;    
        } else {
            return defesaInimigo;
        }
        
    }

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
    public String getNomeInimigo() {
        return nomeInimigo;
    }

    /*
	private void setNomeInimigo(String nomeInimigo) {
		this.nomeInimigo = nomeInimigo;
	}
     */
    public double getVidaInicialInimigo() {
        return vidaInicialInimigo;
    }

    public double getVidaInimigo() {
        return vidaInimigo;
    }

    public void setVidaInimigo(double danoLevado) {
        this.vidaInimigo -= danoLevado;
    }

    public double getForcaInimigo() {
        return forcaInimigo;
    }

    /*
	private void setForcaInimigo(int forcaInimigo) {
		this.forcaInimigo = forcaInimigo;
	}
     */
    public double getResistenciaInimigo() {
        return resistenciaInimigo;
    }

    /*
	private void setResistenciaInimigo(int resistenciaInimigo) {
		this.resistenciaInimigo = resistenciaInimigo;
	}
     */
    public double getNivelInimigo() {
        return nivelInimigo;
    }

    /*
	private void setNivelInimigo(int nivelInimigo) {
		this.nivelInimigo = nivelInimigo;
	}
     */
}

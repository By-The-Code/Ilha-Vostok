package Game;

public class Inimigo {

	//VARIAVÉIS DO INÍMIGO
    private String nomeInimigo;
    private double vidaInicialInimigo;
    private double vidaInimigo;
    private double forcaInimigo;
    private double resistenciaInimigo;
    private int nivelInimigo;

	//CONSTRUTOR DO INIMIGO
    public Inimigo(String nome, double vida, double forca, double resistencia, int nivel) {
        this.nomeInimigo = nome;
        this.vidaInimigo = vida;
        this.forcaInimigo = forca;
        this.vidaInicialInimigo = this.vidaInimigo;
        this.resistenciaInimigo = resistencia;
        this.nivelInimigo = nivel;
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

    //RETORNA OS STATUS DO INÍMIGO/ BOSS
    public String getStatusInimigo() {
        String txt
        		= "INIMIGO: "       + getNomeInimigo() + "\n"
                + "VIDA: "          + Game.dc.format(getVidaInimigo()) + " | " + printaVidaInimigo() + "\n"
                + "FORÇA: "         + Game.dc.format(getForcaInimigo()) + "\n"
                + "RESISTÊNCIA: "   + Game.dc.format(getResistenciaInimigo()) + "\n"
                + "NÍVEL: "         + getNivelInimigo() + "\n";

        return txt;
    }

    //CÁLCULO DA XP DO INÍMIGO
    public double dropExperiencia() {

        if (getForcaInimigo() > getResistenciaInimigo()) {
            double exp = (double) getVidaInicialInimigo() / getResistenciaInimigo();
            return exp;
        } else {
            double exp = (double) getVidaInicialInimigo() / getForcaInimigo();
            return exp;
        }
    }

    //CÁLCULO DO DANO DO INÍMIGO/ BOSS (USA DE BASE A RESISTÊNCIA DO JOGADOR)
    public double danoInimigo(int resistJogador) {
        double danoInimigo = (double) (getForcaInimigo() * getNivelInimigo()) / resistJogador;

        //SE NO FINAL DO CÁLCULO O DANO FOR MENOR QUE 1, ENTÃO RETORNA AO MENOS 1 DE DANO, SE NÃO RETORNA O DANO NORMAL
        if (danoInimigo < 1) {
            return 1;
        } else {
            return danoInimigo;
        }
    }

    //CÁCULO DA DEFESA DO INÍMIGO/ BOSS
    public double defesaInimigo() {
        double defesaInimigo = (double) getResistenciaInimigo() * getNivelInimigo();
        
        //NO FINAL DO CÁLCULO SE A DEFESA FOR MENOR QUE 1, ENTÃO RETORNA AO MENOS 1 DE DEFESA, SE NÃO RETORNA A DEFESA NORMAL
        if (defesaInimigo < 1) {
            return 1;    
        } else {
            return defesaInimigo;
        }
    }
    
    public String printaVidaInimigo() {
    	
    	String l;
    	
    	if (getVidaInimigo() >= getVidaInicialInimigo())
    	{
    		l = "[❤  ❤  ❤  ❤  ❤  ❤  ❤  ❤  ❤  ❤]";
    	}
    	
    	else if (getVidaInimigo() >= getVidaInicialInimigo() * 0.90)
    	{
    		l = "[❤  ❤  ❤  ❤  ❤  ❤  ❤  ❤  ❤]";
    	}
    	
    	else if (getVidaInimigo() >= getVidaInicialInimigo() * 0.80)
    	{
    		l = "[❤  ❤  ❤  ❤  ❤  ❤  ❤  ❤]";
    	}
    	
    	else if (getVidaInimigo() >= getVidaInicialInimigo() * 0.70)
    	{
    		l = "[❤  ❤  ❤  ❤  ❤  ❤  ❤]";
    	}
    	
    	else if (getVidaInimigo() >= getVidaInicialInimigo() * 0.60)
    	{
    		l = "[❤  ❤  ❤  ❤  ❤  ❤]";
    	}
    	
    	else if (getVidaInimigo() >= getVidaInicialInimigo() * 0.50)
    	{
    		l = "[❤  ❤  ❤  ❤  ❤]";
    	}
    	
    	else if (getVidaInimigo() >= getVidaInicialInimigo() * 0.40)
    	{
    		l = "[❤  ❤  ❤  ❤]";
    	}
    	
    	else if (getVidaInimigo() >= getVidaInicialInimigo() * 0.30)
    	{
    		l = "[❤  ❤  ❤]";
    	}
    	
    	else if (getVidaInimigo() >= getVidaInicialInimigo() * 0.20)
    	{
    		l = "[❤  ❤]";
    	}
    	
    	else if (getVidaInimigo() >= getVidaInicialInimigo() * 0.01)
    	{
    		l = "[❤]";
    	}
    	
    	else {
    		l = "[]";
    	}
    	
		return l;
    }
    
    //RETORNA O NOME DO INÍMIGO/ BOSS
    public String getNomeInimigo() {
        return nomeInimigo;
    }

    /*
	private void setNomeInimigo(String nomeInimigo) {
		this.nomeInimigo = nomeInimigo;
	}
    */
    
    //RETORNA A VIDA INÍCIAL DO INÍMIGO/ BOSS
    public double getVidaInicialInimigo() {
        return vidaInicialInimigo;
    }

    //RETORNA A VIDA ATUAL DO INÍMIGO/ BOSS
    public double getVidaInimigo() {
        return vidaInimigo;
    }

    //DEFINE A NOVA VIDA DO INÍMIGO/ BOSS BASEADO NO DANO QUE LEVOU DO JOGADOR
    public void setVidaInimigo(double danoLevado) {
        this.vidaInimigo -= danoLevado;
    }

    //RETORNA A FORÇA DO INÍMIGO/ BOSS
    public double getForcaInimigo() {
        return forcaInimigo;
    }

    /*
	private void setForcaInimigo(int forcaInimigo) {
		this.forcaInimigo = forcaInimigo;
	}
    */
    
    //RETORNA A RESISTÊNCIA DO INÍMIGO/ BOSS
    public double getResistenciaInimigo() {
        return resistenciaInimigo;
    }

    /*
	private void setResistenciaInimigo(int resistenciaInimigo) {
		this.resistenciaInimigo = resistenciaInimigo;
	}
    */
    
    //RETORNA O NÍVEL DO INÍMIGO/ BOSS
    public double getNivelInimigo() {
        return nivelInimigo;
    }

    /*
	private void setNivelInimigo(int nivelInimigo) {
		this.nivelInimigo = nivelInimigo;
	}
    */
}
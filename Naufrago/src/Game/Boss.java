package Game;

public class Boss extends Inimigo {

    public Boss(String nome, int vida, int forca, int resistencia, int nivel) {
		super(nome, vida, forca, resistencia, nivel);
		// TODO Auto-generated constructor stub
	}

	@Override
    public double danoInimigo(int resistJogador) {
    	double danoInimigo = ((getForcaInimigo() * getNivelInimigo() + 10) / resistJogador) * 2;
        return danoInimigo;
    }

	
	@Override
	public double dropExperiencia() {
		
		if(getForcaInimigo() > getResistenciaInimigo()) {
			double exp = (double) getVidaInicialInimigo() / getResistenciaInimigo();
			return exp;
		} 
		else {
			double exp = (double) getVidaInicialInimigo() / getForcaInimigo();
			return exp;
		}
	}
}

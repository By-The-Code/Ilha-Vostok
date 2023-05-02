package Game;

public class Boss extends Inimigo {

	//CONSTRUTOR DO BOSS
    public Boss(String nome, double vida, double forca, double resistencia, int nivel) {
		super(nome, vida, forca, resistencia, nivel);
		// TODO Auto-generated constructor stub
	}

    /*
	@Override
    public double danoInimigo(int resistJogador) {
    	double danoInimigo = ((getForcaInimigo() * getNivelInimigo() + 5) / resistJogador) * 2;
        return danoInimigo;
    }
	
	@Override
	public double defesaInimigo() {
		double defesaInimigo = (double) getResistenciaInimigo() * getNivelInimigo() + 5;
		return defesaInimigo;
	}
	*/

	//OVERRIDE PARA RETORNAR MAIS XP QUANDO DERROTAR O BOSS, POIS OS INÍMIGOS COMUM DROPAM MENOS XP 
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

package Game;

public class Boss extends Inimigo {

    @Override
    public float danoInimigo(int resistJogador) {
        float danoInimigo = ((getForcaInimigo() * getNivelInimigo() + 10) / resistJogador) * 2;
        return danoInimigo;
    }

}

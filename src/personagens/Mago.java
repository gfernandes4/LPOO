package personagens;
import armas.ArmaMago;

public class Mago extends Personagem {
    public Mago(double saude, double forca, double destreza, ArmaMago arma) {
        super("Mago", saude, forca, destreza, arma);
    }
}
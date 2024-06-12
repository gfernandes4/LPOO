package personagens;
import armas.ArmaMago;

public class Mago extends Personagem {
    // contrutor da classe Mago
    public Mago(double saude, double forca, double destreza, ArmaMago arma) {
        // invoca o contrutor da superclasse Personagem
        super("Mago", saude, forca, destreza, arma);
    }
}
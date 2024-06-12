package personagens;
import armas.ArmaClerigo;

public class Clerigo extends Personagem{
    // contrutor da classe Clerigo
    public Clerigo(double saude, double forca, double destreza, ArmaClerigo arma) {
        // invoca o construtor da superclasse Personagem
        super("Clérigo", saude, forca, destreza, arma);
    }
}



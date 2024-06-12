package personagens;
import armas.ArmaPaladino;

public class Paladino extends Personagem{
    // contrutor da classe Paladino
    public Paladino(double saude, double forca, double destreza, ArmaPaladino armaPaladino) {
        // invoca o contrutor da superclasse Personagem
        super("Paladino", saude, forca, destreza, armaPaladino);
    }
}
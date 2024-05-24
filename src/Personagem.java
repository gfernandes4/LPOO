//personagem de rpg

public class Personagem {
    private String nomeTipo;
    private double saude;
    private double forca;
    private double destreza;
    private Arma arma;

    // constructor
    public Personagem(String nomeTipo, double saude, double forca, double destreza, Arma arma) {
        this.nomeTipo = nomeTipo;
        this.saude = saude;
        this.forca = forca;
        this.destreza = destreza;
        this.arma = arma;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
    }

    public double getSaude() {
        return saude;
    }

    public void setSaude(double saude) {
        this.saude = saude;
    }

    public double getForca() {
        return forca;
    }

    public void setForca(double forca) {
        this.forca = forca;
    }

    public double getDestreza() {
        return destreza;
    }

    public void setDestreza(double destreza) {
        this.destreza = destreza;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public void printStatus() {
        System.out.println("Tipo: " + nomeTipo);
        System.out.println("Saúde: " + saude);
        System.out.println("Força: " + forca);
        System.out.println("Destreza: " + destreza);
        System.out.println("Arma: " + arma.getNome() + " (Dano base: " + arma.getDanoBase() + ")");
    }

    public void atacar(Personagem personagem) {
        double dano = calculaDano();
        personagem.recebeDano(dano);
        System.out.println(nomeTipo + " atacou " + personagem.getNomeTipo() + " causando " + dano + " pontos de dano.");
        if (personagem.estaMorto()) {
            System.out.println(personagem.nomeTipo + " está morto");
        }
    }


    private double calculaDano() {
        return forca * destreza * arma.getModificadorDano();
    }

    private void recebeDano(double pontosDano) {
        saude -= pontosDano;
        if (saude < 0) {
            saude = 0;
        }
    }

    private boolean estaMorto() {
        return saude < 1;
    }
}

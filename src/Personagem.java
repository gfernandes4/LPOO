//personagem de rpg
public abstract class Personagem {
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

    // metodo que mostra o status do personagem
    public void printStatus() {
        if (this.estaMorto()) {
            System.out.println(this.nomeTipo + "[Saude: " + this.saude + ", Forca: " + this.forca +
                    "Destreza: " + this.destreza + "," + this.arma + "]");
        } else {
            System.out.println("Morreu [Forca: " + this.forca +
            "Destreza: " + this.destreza + "," + this.arma + "]");
        }
    }

    // metodo para atacar o personagem
    public void atacar(Personagem personagem) {
        if (personagem.estaMorto()) {
            System.out.println("O " + this.nomeTipo + " não consegue atacar, pois está morto.");
            return;
        }
        System.out.println("O " + this.nomeTipo + " com " + arma + ".");
        if (personagem.estaMorto()) {
            System.out.println("O " + personagem.nomeTipo + " não consegue atacar, pois está morto.");
            return;
        }

        if (this.forca > personagem.forca && this.destreza > personagem.destreza) {
            personagem.recebeDano(calculaDano());
            if (personagem.estaMorto()) {
                System.out.println("Pare! O " + personagem.nomeTipo + " já está morto!");
                return;
            } else {
                System.out.println("O ataque foi efetivo com " + calculaDano() + " pontos de dano!");
                return;
            }
        } else if (this.forca < personagem.forca || this.destreza < personagem.destreza) {
            personagem.recebeDano(calculaDano());
            if (personagem.estaMorto()) {
                System.out.println("O ataque foi inefetivo e revidado com " + calculaDano() + " pontos de dano!");
                return;
            } else {
                System.out.println("O ataque foi inefetivo e revidado com " + calculaDano() + " pontos de dano!");
            }
        } else {
            System.out.println("O ataque foi defendido, ninguém se machucou!");
        }
    }

    // metodo para receber dano
    private double calculaDano() {
        return this.forca * this.arma.getModificadorDano();
    }

    // metodo para receber dano
    private void recebeDano(double pontosDano) {
        this.saude -= pontosDano;
        if (saude < 0) {
            saude = 0;
        }
    }

    // metodo
    private boolean estaMorto() {
        return this.saude < 1;
    }
}

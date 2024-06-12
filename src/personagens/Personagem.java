package personagens;
//personagem de rpg

import armas.Arma;
public abstract class Personagem {
    private String nomeTipo;
    private double saude;
    private double forca;
    private double destreza;
    private Arma arma;

    // construtor da classe Personagem
    public Personagem(String nomeTipo, double saude, double forca, double destreza, Arma arma) {
        this.nomeTipo = nomeTipo;
        this.saude = saude;
        this.forca = forca;
        this.destreza = destreza;
        this.arma = arma;
    }

    // metodo que mostra o status do personagem
    public void printStatus() {
        if (saude < 1.0) {
            System.out.printf("%s [Morto, Forca: %.1f, Destreza: %.1f, %s]\n", nomeTipo, forca, destreza,
                    arma.getNome());

        } else {
            System.out.printf("%s [Saude: %.1f, Forca: %.1f, Destreza: %.1f, %s]\n", nomeTipo, saude, forca, destreza,
                    arma.getNome());
        }
    }

    // metodo para atacar o personagem
    public void atacar(Personagem b) {
        // verifica se o personagem esta morto
        if (this.estaMorto()) {
            System.out.printf("O %s não consegue atacar, pois está morto.\n", this.nomeTipo);
            return;
        }
        // se estiver vivo ataca
        System.out.printf("O %s ataca o %s com %s.\n", this.nomeTipo, b.nomeTipo, this.arma.getNome());

        // se o personagem 'b' estiver morto o ataque seja ineficiente 
        if (b.estaMorto()) {
            System.out.printf("Pare! O %s já está morto!\n", b.nomeTipo);
            return;
        }
        // só vai atacar se 'b' tiver a destreza menor que a de quem esta atacando
        if (this.destreza > b.destreza) {
            double dano = this.calculaDano();
            b.recebeDano(dano);
            System.out.printf("O ataque foi efetivo com %.1f pontos de dano!\n", dano);
        
        //se 'b' tiver a destreza maior, vai revidar o ataque
        } else if (this.destreza < b.destreza) {
            double dano = b.calculaDano();
            this.recebeDano(dano);
            System.out.printf("O ataque foi inefetivo e revidado com %.1f pontos de dano!\n", dano);
        
        // se a destreza dos dois forem iguais, o ataque é defendido
        } else {
            System.out.println("O ataque foi defendido, ninguem se machucou!");
        }
    }

    // metodo para calcular dano
    private double calculaDano() {
        return this.forca * this.arma.getModificadorDano();
    }

    // metodo para receber dano
    private void recebeDano(double pontosDano) {
        this.saude -= pontosDano;
    }

    // metodo que valida se esta morto ou nao
    private boolean estaMorto() {
        return this.saude < 1.0;
    }
}
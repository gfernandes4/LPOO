package armas;

public abstract class Arma {
    private String nome;
    private double modDano;

    // construtor da classe arma
    public Arma(String nome, double modDano) {
        this.nome = nome;
        this.modDano = modDano;
    }

    // metodo para obter o nome da arma
    public String getNome() {
        return this.nome;
    }
    
    // metodo para pegar o dano da arma
    public double getModificadorDano() {
        return this.modDano;
    }

}

public class Arma {
    private String nome;
    private double modDano;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getModDano() {
        return modDano;
    }
    public void setModDano(double modDano) {
        this.modDano = modDano;
    }

    public Arma(String nome, double modDano) {
        this.nome = nome;
        this.modDano = modDano;
    }
    
    public double getModificadorDano(){
        return this.modDano;
    }
}

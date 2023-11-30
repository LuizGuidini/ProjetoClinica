package Model;

//Classe Cao recebe herança da Classe Animal
public class Cao extends Animal{
    private String raca;

    // Metodo Construtor da Classe
    public Cao(int id, String nome, String especie, String dono, String raca) {
        super(id, nome, especie, dono);
        this.raca = raca;
    }

    // Metodos Getter e Setter
    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    //Método toString
    @Override
    public String toString() {
        return super.toString() +
                "Raça: " + raca + "\n";
    }
}

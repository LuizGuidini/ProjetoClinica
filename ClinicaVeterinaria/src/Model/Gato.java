package Model;

//Classe Gato recebe herança da Classe Animal
public class Gato extends Animal {
    private String tipoPelagem;

    // Método Construtor da Classe
    public Gato(int id, String nome, String especie, String dono, String tipoPelagem) {
        super(id, nome, especie, dono);
        this.tipoPelagem = tipoPelagem;
    }

    // Métodos Getter e Setter
    public String getTipoPelagem() {
        return tipoPelagem;
    }

    public void setTipoPelagem(String tipoPelagem) {
        this.tipoPelagem = tipoPelagem;
    }

    // Método toString
    @Override
    public String toString() {
        return super.toString() +
                "Tipo de Pelagem: " + tipoPelagem + "\n";
    }
}


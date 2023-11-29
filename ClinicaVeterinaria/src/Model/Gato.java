package Model;

public class Gato extends Animal {
    private String tipoPelagem;

    // Construtor
    public Gato(int id, String nome, String especie, String dono, String tipoPelagem) {
        super(id, nome, especie, dono);
        this.tipoPelagem = tipoPelagem;
    }

    // Getter e Setter
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


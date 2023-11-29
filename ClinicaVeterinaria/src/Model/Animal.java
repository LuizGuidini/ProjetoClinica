package Model;

public class Animal {
    private int id;
    private String nome;
    private String especie;
    private String dono;

    // Construtor
    public Animal(int id, String nome, String especie, String dono) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.dono = dono;
    }

    //Sobrecarga do metodo construtor

    public Animal(){}

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public String getDono() {
        return dono;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    // Metodo equals
    @Override
    public boolean equals(Object o) {
        return ((o instanceof Animal) && ((Animal) o).id == this.id);
    }

    //Metodo hashCode
    @Override
    public int hashCode() {
        return nome.length();
    }

    // Método toString
    @Override
    public String toString() {
        return "Nome do Animal: " + nome + "\n" +
               "Espécie: " + especie + "\n" +
               "Dono: " + dono + "\n";
    }
}


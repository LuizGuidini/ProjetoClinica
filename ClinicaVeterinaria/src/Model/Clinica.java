package Model;

import java.util.ArrayList;

public class Clinica {
    private ArrayList<Animal> animaisRegistrados;
    private ArrayList<HistoricoMedico> historicosMedicos;

    // Construtor
    public Clinica() {
        this.animaisRegistrados = new ArrayList<>();
        this.historicosMedicos = new ArrayList<>();
    }

    // Método para registrar animal
    public void registrarAnimal(Animal animal) {

        animaisRegistrados.add(animal);
    }

    // Método para remover registro de animal
    public void removerRegistro(Animal animal) {
        animaisRegistrados.remove(animal);
    }

    // Método para listar animais
    public void listarAnimais() {
        for (Animal animal : animaisRegistrados) {
            System.out.println(animal.toString());
        }
    }

    // Método para adicionar histórico médico
    public void adicionarHistoricoMedico(HistoricoMedico historico) {
        historicosMedicos.add(historico);
    }

    //Metodo para listar Historicos Medicos
    public void listarHistoricosMedicos() {
        System.out.println("Históricos Médicos:");
        for (HistoricoMedico registro : historicosMedicos) {
            System.out.println(registro.toString());
        }
        System.out.println("--------------------");
    }

    // Método para verificar animal registrado
    public boolean animalEstaRegistrado(Animal animal) {

        return animaisRegistrados.contains(animal);
    }

}

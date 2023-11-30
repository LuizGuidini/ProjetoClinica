package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HistoricoMedico {
    private Animal animal;
    private String historico;
    private LocalDateTime dataHoraRegistro;

    //Metodo Construtor da Classe
    public HistoricoMedico(Animal animal, String historico) {
        this.animal = animal;
        this.historico = historico;
        this.dataHoraRegistro = LocalDateTime.now();
    }

    //Metodos getter setter
    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public LocalDateTime getDataHoraRegistro() {
        return dataHoraRegistro;
    }

    public void setDataHoraRegistro(LocalDateTime dataHoraRegistro) {
        this.dataHoraRegistro = dataHoraRegistro;
    }

    //Metodo toString
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        return "Data/Hora: " + dataHoraRegistro.format(formatter) + "\n" +
               "Animal : "  + animal.getId() + "\n" +
               "Nome do Animal : " + animal.getNome() + "\n" +
               "Especie Animal : "  + animal.getEspecie() + "\n" +
               "Dono do Animal : "  + animal.getDono() + "\n" +
               "Histórico: " + historico + "\n";
    }
}

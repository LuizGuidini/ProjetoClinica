package View;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class ClinicaVeterinariaGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Clinica Veterinaria");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new GridLayout(6, 1));

            JButton registrarButton = new JButton("Registrar Animal");
            JButton removerButton = new JButton("Remover Animal");
            JButton listarButton = new JButton("Listar Animais");
            JButton adicionarHistoricoButton = new JButton("Adicionar Histórico Médico");
            JButton listarHistoricoButton = new JButton("Listar Histórico Médico");
            JButton sairButton = new JButton("Sair");

            frame.add(registrarButton);
            frame.add(removerButton);
            frame.add(listarButton);
            frame.add(adicionarHistoricoButton);
            frame.add(listarHistoricoButton);
            frame.add(sairButton);

            //registrarButton.addActionListener(e -> registrarAnimal());
            //removerButton.addActionListener(e -> removerAnimal());
            //listarButton.addActionListener(e -> listarAnimais());
            //adicionarHistoricoButton.addActionListener(e -> adicionarHistorico());
            //listarHistoricoButton.addActionListener(e -> listarHistorico());
            //sairButton.addActionListener(e -> System.exit(0));

            frame.setSize(300, 300);
            frame.setVisible(true);
        });
    }

    private static void registrarAnimal(Scanner sc, Clinica clinica) {
        try {
            Animal procurado = new Animal();
            do {
                System.out.print("Digite um numero de ID: ");
                sc = new Scanner(System.in);
                procurado.setId(Integer.parseInt(sc.nextLine()));

                if (clinica.animalEstaRegistrado(procurado)) {
                    System.out.println("ID já utilizado!");
                }
            }while (clinica.animalEstaRegistrado(procurado));

            int id = procurado.getId();
            System.out.print("Digite o nome do animal: ");
            String nome = sc.nextLine();
            System.out.print("Digite a espécie do animal: ");
            String especie = sc.nextLine();
            System.out.print("Digite o nome do dono do animal: ");
            String dono = sc.nextLine();

            System.out.println("O animal é um cão? (S/N): ");
            boolean isCao = sc.nextLine().equalsIgnoreCase("S");

            Animal animal;
            if (isCao) {
                System.out.print("Digite a raça do cão: ");
                String raca = sc.nextLine();
                animal = new Cao(id, nome, especie, dono, raca);
            } else {
                System.out.print("Digite o tipo de pelagem do gato: ");
                String tipoPelagem = sc.nextLine();
                animal = new Gato(id, nome, especie, dono, tipoPelagem);
            }

            clinica.registrarAnimal(animal);
            System.out.println("Animal registrado: " + animal.getNome());
        } catch (Exception e) {
            System.out.println("Erro ao registrar animal: " + e.getMessage());
        }
    }

    private static void removerAnimal(Scanner sc, Clinica clinica) {
        try {
            Animal procurado = new Animal();
            System.out.print("Digite o ID do animal a ser removido: ");
            sc =new Scanner(System.in);
            procurado.setId(Integer.parseInt(sc.nextLine()));

            if (clinica.animalEstaRegistrado(procurado)) {
                clinica.removerRegistro(procurado);
                System.out.println("Animal removido: ID " + procurado.getId() );
            } else {
                System.out.println("Animal não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao remover animal: " + e.getMessage());
        }
    }

    private static void listarAnimais(Clinica clinica) {
        try {
            System.out.println("\n  ---------Lista de Animais-------         ");
            clinica.listarAnimais();
            System.out.println("     --------------------------    ");
        } catch (Exception e) {
            System.out.println("Erro ao listar animais: " + e.getMessage());
        }
    }

    private static void adicionarHistorico(Scanner sc, Clinica clinica) {
        try {
            Animal procurado = new Animal();;
            do {
                System.out.print("Digite o numero de ID de um Animal cadastrado: ");
                sc = new Scanner(System.in);
                procurado.setId(Integer.parseInt(sc.nextLine()));
                if (!clinica.animalEstaRegistrado(procurado)) {
                    System.out.println("Animal não cadastrado!");
                }
            }while (!clinica.animalEstaRegistrado(procurado));
            int indice = Clinica.animaisRegistrados.indexOf(procurado);
            procurado = Clinica.animaisRegistrados.get(indice);
            System.out.println("Detalhes do Animal:\n" + procurado.toString());
            System.out.print("Digite o histórico médico: ");
            String historico = sc.nextLine();

            HistoricoMedico novohistorico = new HistoricoMedico(procurado,historico);

            clinica.adicionarHistoricoMedico(novohistorico);
            System.out.println("Histórico médico adicionado.");

        } catch (Exception e) {
            System.out.println("Erro ao adicionar histórico médico: " + e.getMessage());
        }
    }
    private static void listarHistorico(Clinica clinica) {
        try {
            System.out.println("Históricos: ");
            clinica.listarHistoricosMedicos();
            System.out.println("----------------------------");
        } catch (Exception e) {
            System.out.println("Erro ao listar os historicos " + e.getMessage());
        }
    }
}
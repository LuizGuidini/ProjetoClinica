import Model.*;

import java.util.Scanner;

public class ClinicaVeterinaria {
    public static void main(String[] args) {
        try {
            Clinica clinica = new Clinica();
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n#######   Clinica Veterinaria   #######");
                System.out.println("1. Registrar Animal");
                System.out.println("2. Remover Animal");
                System.out.println("3. Listar Animais");
                System.out.println("4. Adicionar Histórico Médico");
                System.out.println("5. Listar Histórico Médico");
                System.out.println("9. Sair");

                System.out.print("Escolha uma opção: ");
                int opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        registrarAnimal(sc, clinica);
                        break;
                    case 2:
                        removerAnimal(sc, clinica);
                        break;
                    case 3:
                        listarAnimais(clinica);
                        break;
                    case 4:
                        adicionarHistorico(sc, clinica);
                        break;
                    case 5:
                        listarHistorico(clinica);
                        break;
                    case 9:
                        System.out.println("Finalizando o programa !");
                        return;
                    default:
                        System.out.println("Opção inválida !");
                }
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
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
package Estacao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /**
         * SISTEMA DE GERENCIAMENTO DE EXPLORAÇÃO ESPACIAL (VERSÃO PROCEDURAL)
         * Este código é funcional, mas não utiliza os pilares da POO.
         * O desafio dos alunos é refatorar este sistema criando classes,
         * aplicando encapsulamento, herança e polimorfismo.
         */

        Scanner scanner = new Scanner(System.in);
        int opcao;

        // Dados iniciais para teste
        //Criação de objetos
        adicionarMissao("Missão Marte", "Explorar a superfície de Marte", "2025-01-15", "Planejada");
        adicionarNave("Discovery One", "Exploração", "5");
        adicionarAstronauta("Neil Armstrong", "Comandante");
        adicionarAstronauta("Buzz Aldrin", "Piloto");

        do {
            System.out.println("\n--- Sistema de Gerenciamento de Exploração Espacial ---");
            System.out.println("1. Adicionar Missão");
            System.out.println("2. Adicionar Nave Espacial");
            System.out.println("3. Adicionar Astronauta");
            System.out.println("4. Listar Missões");
            System.out.println("5. Listar Naves");
            System.out.println("6. Listar Astronautas");
            System.out.println("7. Associar Nave a Missão");
            System.out.println("8. Associar Astronauta a Missão");
            System.out.println("9. Atualizar Status da Missão");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, digite um número.");
                scanner.next();
            }
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome da Missão: ");
                    String nomeMissao = scanner.nextLine();
                    System.out.print("Objetivo da Missão: ");
                    String objetivoMissao = scanner.nextLine();
                    System.out.print("Data de Lançamento (AAAA-MM-DD): ");
                    String dataLancamento = scanner.nextLine();
                    System.out.print("Status (Planejada, Em Andamento, Concluída, Cancelada): ");
                    String statusMissao = scanner.nextLine();
                    adicionarMissao(nomeMissao, objetivoMissao, dataLancamento, statusMissao);
                    break;
                case 2:
                    System.out.print("Nome da Nave: ");
                    String nomeNave = scanner.nextLine();
                    System.out.print("Tipo da Nave: ");
                    String tipoNave = scanner.nextLine();
                    System.out.print("Capacidade da Nave: ");
                    String capacidadeNave = scanner.nextLine();
                    adicionarNave(nomeNave, tipoNave, capacidadeNave);
                    break;
                case 3:
                    System.out.print("Nome do Astronauta: ");
                    String nomeAstronauta = scanner.nextLine();
                    System.out.print("Especialidade do Astronauta: ");
                    String especialidadeAstronauta = scanner.nextLine();
                    adicionarAstronauta(nomeAstronauta, especialidadeAstronauta);
                    break;
                case 4:
                    listarMissoes();
                    break;
                case 5:
                    listarNaves();
                    break;
                case 6:
                    listarAstronautas();
                    break;
                case 7:
                    System.out.print("ID da Missão para associar nave: ");
                    String idMissaoAssocNave = scanner.nextLine();
                    System.out.print("ID da Nave para associar: ");
                    String idNaveAssoc = scanner.nextLine();
                    associarNaveAMissao(idMissaoAssocNave, idNaveAssoc);
                    break;
                case 8:
                    System.out.print("ID da Missão para associar astronauta: ");
                    String idMissaoAssocAstronauta = scanner.nextLine();
                    System.out.print("ID do Astronauta para associar: ");
                    String idAstronautaAssoc = scanner.nextLine();
                    associarAstronautaAMissao(idMissaoAssocAstronauta, idAstronautaAssoc);
                    break;
                case 9:
                    System.out.print("ID da Missão para atualizar status: ");
                    String idMissaoAtualizar = scanner.nextLine();
                    System.out.print("Novo Status (Planejada, Em Andamento, Concluída, Cancelada): ");
                    String novoStatus = scanner.nextLine();
                    atualizarStatusMissao(idMissaoAtualizar, novoStatus);
                    break;
                case 0:
                    System.out.println("Saindo do sistema.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}

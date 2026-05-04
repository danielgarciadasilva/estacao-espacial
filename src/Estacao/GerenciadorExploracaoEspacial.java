package Estacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GerenciadorExploracaoEspacial {


    // Simula um banco de dados de missões: [ID, Nome, Objetivo, DataLançamento, Status, NomeNave, NomesAstronautas]
    private static List<String[]> missoes = new ArrayList<>();
    // Simula um banco de dados de naves: [ID, Nome, Tipo, Capacidade]
    private static List<String[]> naves = new ArrayList<>();
    // Simula um banco de dados de astronautas: [ID, Nome, Especialidade]
    private static List<String[]> astronautas = new ArrayList<>();

    private static int proximoIdMissao = 1;
    private static int proximoIdNave = 1;
    private static int proximoIdAstronauta = 1;

    public static void adicionarMissao(String nome, String objetivo, String dataLancamento, String status) {
        // Estrutura: [ID, Nome, Objetivo, Data, Status, Nave, Astronautas]
        missoes.add(new String[]{String.valueOf(proximoIdMissao++), nome, objetivo, dataLancamento, status, "N/A", "N/A"});
        System.out.println("Missão " + nome + " adicionada com sucesso!");
    }

    public static void adicionarNave(String nome, String tipo, String capacidade) {
        naves.add(new String[]{String.valueOf(proximoIdNave++), nome, tipo, capacidade});
        System.out.println("Nave " + nome + " adicionada com sucesso!");
    }

    public static void adicionarAstronauta(String nome, String especialidade) {
        astronautas.add(new String[]{String.valueOf(proximoIdAstronauta++), nome, especialidade});
        System.out.println("Astronauta " + nome + " adicionado com sucesso!");
    }

    public static void listarMissoes() {
        System.out.println("\n--- Lista de Missões ---");
        if (missoes.isEmpty()) {
            System.out.println("Nenhuma missão cadastrada.");
            return;
        }
        for (String[] missao : missoes) {
            System.out.println("ID: " + missao[0] + " | Nome: " + missao[1] + " | Status: " + missao[4] +
                    " | Nave: " + missao[5] + " | Astronautas: " + missao[6]);
        }
    }

    public static void listarNaves() {
        System.out.println("\n--- Lista de Naves Espaciais ---");
        if (naves.isEmpty()) {
            System.out.println("Nenhuma nave cadastrada.");
            return;
        }
        for (String[] nave : naves) {
            System.out.println("ID: " + nave[0] + " | Nome: " + nave[1] + " | Tipo: " + nave[2] + " | Cap: " + nave[3]);
        }
    }

    public static void listarAstronautas() {
        System.out.println("\n--- Lista de Astronautas ---");
        if (astronautas.isEmpty()) {
            System.out.println("Nenhum astronauta cadastrado.");
            return;
        }
        for (String[] astronauta : astronautas) {
            System.out.println("ID: " + astronauta[0] + " | Nome: " + astronauta[1] + " | Especialidade: " + astronauta[2]);
        }
    }

    public static void associarNaveAMissao(String idMissao, String idNave) {
        String nomeNave = "N/A";
        for (String[] nave : naves) {
            if (nave[0].equals(idNave)) {
                nomeNave = nave[1];
                break;
            }
        }

        for (String[] missao : missoes) {
            if (missao[0].equals(idMissao)) {
                missao[5] = nomeNave;
                System.out.println("Nave " + nomeNave + " associada à missão ID " + idMissao);
                return;
            }
        }
        System.out.println("Missão ou Nave não encontrada.");
    }

    public static void associarAstronautaAMissao(String idMissao, String idAstronauta) {
        String nomeAstronauta = "N/A";
        for (String[] astronauta : astronautas) {
            if (astronauta[0].equals(idAstronauta)) {
                nomeAstronauta = astronauta[1];
                break;
            }
        }

        for (String[] missao : missoes) {
            if (missao[0].equals(idMissao)) {
                if (missao[6].equals("N/A")) {
                    missao[6] = nomeAstronauta;
                } else {
                    missao[6] += ", " + nomeAstronauta;
                }
                System.out.println("Astronauta " + nomeAstronauta + " associado à missão ID " + idMissao);
                return;
            }
        }
        System.out.println("Missão ou Astronauta não encontrada.");
    }

    public static void atualizarStatusMissao(String idMissao, String novoStatus) {
        for (String[] missao : missoes) {
            if (missao[0].equals(idMissao)) {
                missao[4] = novoStatus;
                System.out.println("Status atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Missão não encontrada.");
    }
}
 
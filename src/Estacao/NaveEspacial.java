package Estacao;

import java.util.ArrayList;
import java.util.List;

public class NaveEspacial extends EntidadeGenericaEspacial {

    private String tipo;
    private String capacidade;

    // Simula um banco de dados de naves: [ID, Nome, Tipo, Capacidade]
    private static List<String[]> naves = new ArrayList<>();
    private static int proximoIdNave = 1;

    public NaveEspacial(int id, String nome, String tipo, String capacidade) {
        super(id, nome);
        this.tipo = tipo;
        this.capacidade = capacidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public static List<String[]> getNaves() {
        return naves;
    }

    public static void setNaves(List<String[]> naves) {
        NaveEspacial.naves = naves;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }

    public static int getProximoIdNave() {
        return proximoIdNave;
    }

    public static void setProximoIdNave(int proximoIdNave) {
        NaveEspacial.proximoIdNave = proximoIdNave;
    }

    public static void adicionarNave(String nome, String tipo, String capacidade) {
        naves.add(new String[]{String.valueOf(proximoIdNave++), nome, tipo, capacidade});
        System.out.println("Nave " + nome + " adicionada com sucesso!");
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

    public static void associarNaveAMissao(String idMissao, String idNave) {
        String nomeNave = "N/A";
        for (String[] nave : naves) {
            if (nave[0].equals(idNave)) {
                nomeNave = nave[1];
                break;
            }
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
}

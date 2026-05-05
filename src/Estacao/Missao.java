package Estacao;

import java.util.ArrayList;
import java.util.List;

import static Estacao.Astronauta.astronautas;

public class Missao extends EntidadeGenericaEspacial {

    private String objetivo;
    private String dataLancamento;
    private String status;
    private String nomeNave;
    private String nomesAstronautas;

    // Simula um banco de dados de missões: [ID, Nome, Objetivo, DataLançamento, Status, NomeNave, NomesAstronautas]
    private static List<String[]> missoes = new ArrayList<>();
    private static int proximoIdMissao = 1;

    public Missao(int id, String nome, String objetivo, String dataLancamento, String status, String nomeNave, String nomesAstronautas) {
        super(id, nome);
        this.objetivo = objetivo;
        this.dataLancamento = dataLancamento;
        this.status = status;
        this.nomeNave = nomeNave;
        this.nomesAstronautas = nomesAstronautas;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getNomeNave() {
        return nomeNave;
    }

    public void setNomeNave(String nomeNave) {
        this.nomeNave = nomeNave;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNomesAstronautas() {
        return nomesAstronautas;
    }

    public void setNomesAstronautas(String nomesAstronautas) {
        this.nomesAstronautas = nomesAstronautas;
    }

    public static List<String[]> getMissoes() {
        return missoes;
    }

    public static void setMissoes(List<String[]> missoes) {
        Missao.missoes = missoes;
    }

    public static int getProximoIdMissao() {
        return proximoIdMissao;
    }

    public static void setProximoIdMissao(int proximoIdMissao) {
        Missao.proximoIdMissao = proximoIdMissao;
    }

    public static void adicionarMissao(String nome, String objetivo, String dataLancamento, String status) {
        // Estrutura: [ID, Nome, Objetivo, Data, Status, Nave, Astronautas]
        missoes.add(new String[]{String.valueOf(proximoIdMissao++), nome, objetivo, dataLancamento, status, "N/A", "N/A"});
        System.out.println("Missão " + nome + " adicionada com sucesso!");
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
}

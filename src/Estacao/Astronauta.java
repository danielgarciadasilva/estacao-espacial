package Estacao;

import java.util.ArrayList;
import java.util.List;

public class Astronauta extends EntidadeGenericaEspacial{

    private String especialidade;

    // Simula um banco de dados de astronautas: [ID, Nome, Especialidade]
    private static List<String[]> astronautas = new ArrayList<>();
    private static int proximoIdAstronauta = 1;

    public Astronauta(int id, String nome, String especialidade) {
        super(id, nome);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public static List<String[]> getAstronautas() {
        return astronautas;
    }

    public static void setAstronautas(List<String[]> astronautas) {
        Astronauta.astronautas = astronautas;
    }

    public static int getProximoIdAstronauta() {
        return proximoIdAstronauta;
    }

    public static void setProximoIdAstronauta(int proximoIdAstronauta) {
        Astronauta.proximoIdAstronauta = proximoIdAstronauta;
    }

    public static void adicionarAstronauta(String nome, String especialidade) {
        astronautas.add(new String[]{String.valueOf(proximoIdAstronauta++), nome, especialidade});
        System.out.println("Astronauta " + nome + " adicionado com sucesso!");
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
}

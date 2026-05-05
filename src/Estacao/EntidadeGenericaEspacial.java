package Estacao;

public abstract class EntidadeGenericaEspacial {

    private int id;
    private String nome;

    public EntidadeGenericaEspacial(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
 
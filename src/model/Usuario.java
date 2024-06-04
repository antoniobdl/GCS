package model;

public class Usuario {
    private int id;
    private String nome;
    private String iniciais;
    private String tipo; // Funcionário ou Administrador

    public Usuario(int id, String nome, String iniciais, String tipo) {
        this.id = id;
        this.nome = nome;
        this.iniciais = iniciais;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIniciais() {
        return iniciais;
    }

    public void setIniciais(String iniciais) {
        this.iniciais = iniciais;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

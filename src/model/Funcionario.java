package model;

public class Funcionario extends Usuario {
    private String dpt;

    public Funcionario(int id, String dpt, String nome, String iniciais, String tipo) {
        super(id, nome, iniciais, tipo);
        this.dpt = dpt;
    }

    public String getDpt() {
        return dpt;
    }

    public void setDpt(String dpt) {
        this.dpt = dpt;
    }
}

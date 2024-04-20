public class Departamento {
    private int id;
    private String nome;
    private double limiteOrcamento; // Limite orçamentário para pedidos

    public Departamento(int id, String nome, double limiteOrcamento) {
        this.id = id;
        this.nome = nome;
        this.limiteOrcamento = limiteOrcamento;
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

    public double getLimiteOrcamento() {
        return limiteOrcamento;
    }

    public void setLimiteOrcamento(double limiteOrcamento) {
        this.limiteOrcamento = limiteOrcamento;
    }

}

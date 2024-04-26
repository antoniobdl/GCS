public class Departamento {
    private int idDpt;
    private String nomeDpt;
    private double limiteOrcamento; // Limite orçamentário para pedidos

    public Departamento(int idDpt, String nomeDpt, double limiteOrcamento) {
        this.idDpt = idDpt;
        this.nomeDpt = nomeDpt;
        this.limiteOrcamento = limiteOrcamento;
    }

    public int getIdDpt() {
        return idDpt;
    }

    public void setIdDpt(int idDpt) {
        this.idDpt = idDpt;
    }

    public String getNomeDpt() {
        return nomeDpt;
    }

    public void setNomeDpt(String nomeDpt) {
        this.nomeDpt = nomeDpt;
    }

    public double getLimiteOrcamento() {
        return limiteOrcamento;
    }

    public void setLimiteOrcamento(double limiteOrcamento) {
        this.limiteOrcamento = limiteOrcamento;
    }

}

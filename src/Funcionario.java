public class Funcionario{
    private String dpt;
    private String nome;
    private String iniciais;
    private String tipo; // Funcionário ou Administrador

    public Funcionario(String dpt,String nome, String iniciais, String tipo){
        this.dpt = dpt;
        this.nome = nome;
        this.iniciais = iniciais;
        this.tipo = tipo;
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

    public String getDpt() {
        return dpt;
    }

    public void setDepartamento(String dpt) {
        this.dpt = dpt;
    }
}

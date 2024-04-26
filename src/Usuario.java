public class Usuario extends Funcionario{
    private int id;
    private String nome;
    private String iniciais;
    private String tipo; // Funcionário ou Administrador
    // Construtor
    public Usuario(int id,String dpt, String nome, String iniciais, String tipo) {
        super(dpt,nome,iniciais,tipo);
        this.id = id;
        this.nome = getNome();
        this.iniciais = getIniciais();
        this.tipo = getTipo();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
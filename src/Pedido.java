import java.time.LocalDate;

public class Pedido {
    private int id;
    private Usuario solicitante;
    private Departamento departamento;
    private LocalDate dataPedido;
    private LocalDate dataConclusao;
    private String status; // Possíveis valores: "Aberto", "Aprovado", "Reprovado"
    private String descricaoItem;
    private double valorUnitario;
    private int quantidade;
    private double valorTotal;

    public Pedido(int id, Usuario solicitante, Departamento departamento, LocalDate dataPedido,
                  String descricaoItem, double valorUnitario, int quantidade) {
        this.id = id;
        this.solicitante = solicitante;
        this.departamento = departamento;
        this.dataPedido = dataPedido;
        this.descricaoItem = descricaoItem;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.status = "Aberto"; // Status inicial
        calcularValorTotal();
    }

    private void calcularValorTotal() {
        this.valorTotal = valorUnitario * quantidade;
    }
    public double getValorTotal() {
        return valorTotal;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Usuario getSolicitante() {
        return solicitante;
    }
    public void setSolicitante(Usuario solicitante) {
        this.solicitante = solicitante;
    }

    public Departamento getDepartamento() {
        return departamento;
    }
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }
    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }
    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricaoItem() {
        return descricaoItem;
    }
    public void setDescricaoItem(String descricaoItem) {
        this.descricaoItem = descricaoItem;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
        calcularValorTotal();
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        calcularValorTotal();
    }

}
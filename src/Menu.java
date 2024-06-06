import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList<Usuario> listaUsuario = new ArrayList<>(15);
    private ArrayList<Pedido> listaPedido = new ArrayList<>();
    private ArrayList<Departamento> listaDpt = new ArrayList<>(5);
    private ArrayList<Funcionario> listaFuncionario = new ArrayList<>();
    private Pedido atual;
    Scanner in = new Scanner(System.in);

    public void testeMenu(){
        System.out.println("/----//----/Sistema/----//----/");
        System.out.println("[1] Escolher Usuário");
        System.out.println("[2] Registrar pedido de aquisição");
        System.out.println("[3] Remover pedido");
        System.out.println("[4] Alterar Status");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("[5] Estatísticas Gerais");
        System.out.println("[6] Visualizar pedido detalhado");
        System.out.println("[7] Buscar pedido descrição");
        System.out.println("[8] Buscar pedido funcionário");
        System.out.println("[9] Listar todos os pedidos");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        System.out.println("\f");

        int decisao = in.nextInt();
        switch(decisao){
            case 1: escolherUsuario(); break;
            case 2: addPedido() ; break;
            case 3: ; break;
            case 4: ; break;
            case 5: estatisticasGerais(); break;
            case 6: ; break;
            case 7: ; break;
            case 8: ;break;
            default: System.out.println("OPÇÃO INVALIDA!");
        }
    }

    public void executar(){
        System.out.print("Deseja fazer um novo pedido? Se sim digite 1.");
        int decisao = in.nextInt();
        if(decisao == 1){

        }

        System.out.print("Deseja alterar o status de algum pedido? Se sim digite 1.");
        int opc = in.nextInt();
        if(opc == 1){
            atual.alterarStatus();
        }else{
        }
    }
    public void adicionando(){
            listaFuncionario.add(new Funcionario("RH","João Pedro","JP","Admin"));
            listaFuncionario.add(new Funcionario("RH","Beatriz Santos","BS","Funcionário"));
            listaFuncionario.add(new Funcionario("RH","Felipe Arnt","FA","Funcionário"));
            listaFuncionario.add(new Funcionario("Financeiro","Lucas Ribeiro","LR","Admin"));
            listaFuncionario.add(new Funcionario("Financeiro","Antonio Lombardia","AL","Admin"));
    }

    private void escolherUsuario() {
        System.out.println("Insira o ID do Usuário: ");
        int userId = in.nextInt();
        for (Usuario u : listaUsuario) {
            if (u.getId() == userId) {
                usuarioAtual = u;
                System.out.println("Usuário " + u.getNome() + " selecionado.");
                return;
            }
        }
        System.out.println("Usuário não encontrado.");
    }

    public void estatisticasGerais() {
        if (usuarioAtual != null && usuarioAtual.getTipo().equals("Admin")) {
            int totalPedidos = listaPedido.size();
            int pedidosAprovados = 0;
            int pedidosReprovados = 0;
            int pedidosUltimos30Dias = 0;
            double valorTotalUltimos30Dias = 0.0;
            double valorTotalAbertos = 0.0;
            Pedido maiorPedidoAberto = null;

            LocalDate hoje = LocalDate.now();
            LocalDate trintaDiasAtras = hoje.minus(30, ChronoUnit.DAYS);

            for (Pedido pedido : listaPedido) {
                if (pedido.getStatus().equalsIgnoreCase("Aprovado")) {
                    pedidosAprovados++;
                } else if (pedido.getStatus().equalsIgnoreCase("Reprovado")) {
                    pedidosReprovados++;
                }

                if (pedido.getDataPedido().isAfter(trintaDiasAtras) && pedido.getDataPedido().isBefore(hoje)) {
                    pedidosUltimos30Dias++;
                    valorTotalUltimos30Dias += pedido.getValorTotal();
                }

                if (pedido.getStatus().equalsIgnoreCase("Aberto")) {
                    if (maiorPedidoAberto == null || pedido.getValorTotal() > maiorPedidoAberto.getValorTotal()) {
                        maiorPedidoAberto = pedido;
                    }
                    valorTotalAbertos += pedido.getValorTotal();
                }
            }

            double percentualAprovados = (totalPedidos > 0) ? (pedidosAprovados / (double) totalPedidos) * 100 : 0;
            double percentualReprovados = (totalPedidos > 0) ? (pedidosReprovados / (double) totalPedidos) * 100 : 0;
            double valorMedioUltimos30Dias = (pedidosUltimos30Dias > 0) ? valorTotalUltimos30Dias / pedidosUltimos30Dias : 0;

            System.out.println("Número total de pedidos: " + totalPedidos);
            System.out.println("Pedidos aprovados: " + pedidosAprovados + " (" + String.format("%.2f", percentualAprovados) + "%)");
            System.out.println("Pedidos reprovados: " + pedidosReprovados + " (" + String.format("%.2f", percentualReprovados) + "%)");
            System.out.println("Número de pedidos nos últimos 30 dias: " + pedidosUltimos30Dias);
            System.out.println("Valor médio dos pedidos nos últimos 30 dias: " + String.format("%.2f", valorMedioUltimos30Dias));
            System.out.println("Valor total dos pedidos abertos: " + String.format("%.2f", valorTotalAbertos));

            if (maiorPedidoAberto != null) {
                System.out.println("Detalhes do pedido de maior valor ainda aberto:");
                System.out.println("ID: " + maiorPedidoAberto.getId());
                System.out.println("Descrição: " + maiorPedidoAberto.getDescricaoItem());
                System.out.println("Valor Total: " + String.format("%.2f", maiorPedidoAberto.getValorTotal()));
            } else {
                System.out.println("Não há pedidos abertos.");
            }
        } else {
            System.out.println("Acesso negado. Somente administradores podem ver as estatísticas gerais.");
        }
    }


    public Pedido addPedido(){
        int id;
        Usuario solicitante;
        Departamento departamento;
        LocalDate dataPedido;
        String status; // Possíveis valores: "Aberto", "Aprovado", "Reprovado"
        String descricaoItem;
        double valorUnitario;
        int quantidade;
        Pedido p1 = new Pedido();
        System.out.println("Insira o id do pedido: ");
        id = in.nextInt();
        p1.setId(id);
        in.nextLine();

        System.out.println("Insira o id do Usuário: ");
        int index = checagemIndexUser();
        solicitante = listaUsuario.get(index);
        p1.setSolicitante(solicitante);
        //CONTINUAR A PARTIR DAQUI


        return p1;
    }

    public int checagemIndexUser(){
        int user = in.nextInt();
        int index = -1;
        for (int i = 0; i < listaUsuario.size(); i++) {
            Usuario u1 = listaUsuario.get(i);
            if (u1.getId() == user) {
                index = i;
                break;
            }
        }
        return index;
    }
}
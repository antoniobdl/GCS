import model.Departamento;
import model.Funcionario;
import model.Pedido;
import model.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeParseException;


public class Menu {
    private ArrayList<Usuario> listaUsuario = new ArrayList<>(15);
    private ArrayList<Pedido> listaPedido = new ArrayList<>();
    private ArrayList<Departamento> listaDpt = new ArrayList<>(5);
    private Pedido atual;
    Scanner in = new Scanner(System.in);

    public Menu() {
        adicionarUsuariosEDepartamentos(); // Adiciona usuários e departamentos na inicialização
    }

    public void exibirMenu() {
        while (true) {
            System.out.println("/----//----/Sistema/----//----/");
            System.out.println("[1] Escolher Usuário");
            System.out.println("[2] Registrar pedido de aquisição");
            System.out.println("[3] Remover pedido");
            System.out.println("[4] Alterar Status");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("[5] Estatísticas Gerais");
            System.out.println("[6] Visualizar pedido detalhado");
            System.out.println("[7] Buscar pedido por descrição");
            System.out.println("[8] Buscar pedido por funcionário");
            System.out.println("[9] Listar todos os pedidos");
            System.out.println("[10] Sair");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

            int decisao = in.nextInt();
            in.nextLine(); // Consume newline

            switch (decisao) {
                case 1:
                    escolherUsuario();
                    break;
                case 2:
                    addPedido();
                    break;
                case 3:
                    removerPedido();
                    break;
                case 4:
                    alterarStatus();
                    break;
                case 5:
                    exibirEstatisticas();
                    break;
                case 6:
                    visualizarPedidoDetalhado();
                    break;
                case 7:
                    buscarPedidoPorDescricao();
                    break;
                case 8:
                    buscarPedidoPorFuncionario();
                    break;
                case 9:
                    listarTodosOsPedidos();
                    break;
                case 10:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("OPÇÃO INVALIDA!");
            }
        }
    }

    public void executar() {
        exibirMenu(); // Chama o método para exibir o menu
    }

    public void adicionarUsuariosEDepartamentos() {
        listaUsuario.add(new Funcionario(1, "RH", "João Pedro", "JP", "Admin"));
        listaUsuario.add(new Funcionario(2, "RH", "Beatriz Santos", "BS", "Funcionário"));
        listaUsuario.add(new Funcionario(3, "RH", "Felipe Arnt", "FA", "Funcionário"));
        listaUsuario.add(new Funcionario(4, "Financeiro", "Lucas Ribeiro", "LR", "Admin"));
        listaUsuario.add(new Funcionario(5, "Financeiro", "Antonio Lombardia", "AL", "Admin"));

        listaDpt.add(new Departamento(1, "RH", 10000.0));
        listaDpt.add(new Departamento(2, "Financeiro", 15000.0));
        listaDpt.add(new Departamento(3, "Engenharia", 20000.0));
        listaDpt.add(new Departamento(4, "Manutenção", 5000.0));
        listaDpt.add(new Departamento(5, "Logística", 12000.0));
    }

    public Pedido addPedido() {
        int id;
        Usuario solicitante;
        Departamento departamento;
        LocalDate dataPedido;
        String status = "Aberto"; // Valor inicial para status
        String descricaoItem;
        double valorUnitario;
        int quantidade;

        Pedido p1 = new Pedido();
        System.out.println("Insira o id do pedido: ");
        id = in.nextInt();
        p1.setId(id);
        in.nextLine(); // Consume newline

        System.out.println("Insira o id do Usuário: ");
        int index = checagemIndexUser();
        if (index == -1) {
            System.out.println("Usuário não encontrado.");
            return null;
        }
        solicitante = listaUsuario.get(index);
        p1.setSolicitante(solicitante);

        System.out.println("Insira o id do Departamento: ");
        index = checagemIndexDepartamento();
        if (index == -1) {
            System.out.println("Departamento não encontrado.");
            return null;
        }
        departamento = listaDpt.get(index);
        p1.setDepartamento(departamento);
        in.nextLine(); // Consume newline

        while (true) {
            try {
                System.out.println("Insira a data do pedido (AAAA-MM-DD): ");
                String input = in.nextLine();
                dataPedido = LocalDate.parse(input);
                p1.setDataPedido(dataPedido);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido. Tente novamente.");
            }
        }

        System.out.println("Insira a descrição do item: ");
        descricaoItem = in.nextLine();
        p1.setDescricaoItem(descricaoItem);

        System.out.println("Insira o valor unitário do item: ");
        valorUnitario = in.nextDouble();
        p1.setValorUnitario(valorUnitario);
        in.nextLine(); // Consume newline

        System.out.println("Insira a quantidade do item: ");
        quantidade = in.nextInt();
        p1.setQuantidade(quantidade);
        in.nextLine(); // Consume newline

        p1.setStatus(status);
        listaPedido.add(p1);

        return p1;
    }



    public int checagemIndexUser() {
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

    public int checagemIndexDepartamento() {
        int dept = in.nextInt();
        int index = -1;
        for (int i = 0; i < listaDpt.size(); i++) {
            Departamento d1 = listaDpt.get(i);
            if (d1.getIdDpt() == dept) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void escolherUsuario() {
        System.out.println("Escolha um usuário pelo ID: ");
        int index = checagemIndexUser();
        if (index == -1) {
            System.out.println("Usuário não encontrado.");
        } else {
            Usuario usuario = listaUsuario.get(index);
            System.out.println("Usuário escolhido: " + usuario.getNome());
        }
    }

    public void removerPedido() {
        System.out.println("Digite o ID do pedido que deseja remover:");
        int pedidoId = in.nextInt();
        in.nextLine();

        Pedido pedido = null;
        for (Pedido p : listaPedido) {
            if (p.getId() == pedidoId) {
                pedido = p;
                break;
            }
        }

        if (pedido == null) {
            System.out.println("Pedido não encontrado.");
            return;
        }

        if (!pedido.getStatus().equalsIgnoreCase("Aberto")) {
            System.out.println("Somente pedidos com status 'Aberto' podem ser removidos.");
            return;
        }

        System.out.println("Digite o ID do funcionário solicitante:");
        int funcionarioId = in.nextInt();
        in.nextLine();  // Consumir a quebra de linha

        if (pedido.getSolicitante().getId() != funcionarioId) {
            System.out.println("Somente o funcionário solicitante pode remover este pedido.");
            return;
        }

        listaPedido.remove(pedido);
        System.out.println("Pedido removido com sucesso.");
    }


    public void alterarStatus() {
        System.out.println("Digite o ID do pedido que deseja alterar o status:");
        int pedidoId = in.nextInt();
        in.nextLine();  // Consumir a quebra de linha

        Pedido pedido = null;
        for (Pedido p : listaPedido) {
            if (p.getId() == pedidoId) {
                pedido = p;
                break;
            }
        }

        if (pedido == null) {
            System.out.println("Pedido não encontrado.");
            return;
        }

        System.out.println("Status atual do pedido: " + pedido.getStatus());
        if (!pedido.getStatus().equalsIgnoreCase("Aberto")) {
            System.out.println("Não é possível alterar o status de um pedido que não está 'Aberto'.");
            return;
        }

        System.out.println("Digite o novo status para o pedido (Aprovado/Reprovado):");
        String novoStatus = in.nextLine();

        if (!novoStatus.equalsIgnoreCase("Aprovado") && !novoStatus.equalsIgnoreCase("Reprovado")) {
            System.out.println("Status inválido. O status deve ser 'Aprovado' ou 'Reprovado'.");
            return;
        }

        pedido.setStatus(novoStatus);
        if (novoStatus.equalsIgnoreCase("Aprovado")) {
            pedido.setDataConclusao(java.time.LocalDate.now());
        }

        System.out.println("Status do pedido alterado com sucesso.");
    }

    public void exibirEstatisticas() {
        // Implementação para exibir estatísticas
    }

    public void visualizarPedidoDetalhado() {
        System.out.println("Digite o ID do pedido que deseja visualizar:");
        int pedidoId = in.nextInt();
        in.nextLine();

        Pedido pedido = null;
        for (Pedido p : listaPedido) {
            if (p.getId() == pedidoId) {
                pedido = p;
                break;
            }
        }

        if (pedido == null) {
            System.out.println("Pedido não encontrado.");
            return;
        }

        System.out.println("Detalhes do Pedido:");
        System.out.println("ID do Pedido: " + pedido.getId());
        System.out.println("Solicitante: " + pedido.getSolicitante().getNome());
        System.out.println("Departamento: " + pedido.getDepartamento().getNomeDpt());
        System.out.println("Data do Pedido: " + pedido.getDataPedido());
        System.out.println("Status: " + pedido.getStatus());
        System.out.println("Data de Conclusão: " + (pedido.getDataConclusao() != null ? pedido.getDataConclusao() : "Ainda não concluído"));
        System.out.println("Itens do Pedido:");
        System.out.println("Descrição: " + pedido.getDescricaoItem());
        System.out.println("Valor Unitário: " + pedido.getValorUnitario());
        System.out.println("Quantidade: " + pedido.getQuantidade());
        System.out.println("Total: " + pedido.getValorTotal());
        System.out.println("------------------------------");
        System.out.println("Valor Total do Pedido: " + pedido.getValorTotal());
    }

    public void buscarPedidoPorDescricao() {
        System.out.println("Digite a descrição do item que deseja buscar:");
        String descricao = in.nextLine();

        boolean encontrouPedidos = false;
        for (Pedido p : listaPedido) {
            if (p.getDescricaoItem().toLowerCase().contains(descricao.toLowerCase())) {
                encontrouPedidos = true;
                System.out.println("ID do Pedido: " + p.getId());
                System.out.println("Solicitante: " + p.getSolicitante().getNome());
                System.out.println("Departamento: " + p.getDepartamento().getNomeDpt());
                System.out.println("Data do Pedido: " + p.getDataPedido());
                System.out.println("Status: " + p.getStatus());
                System.out.println("Descrição: " + p.getDescricaoItem());
                System.out.println("Valor Unitário: " + p.getValorUnitario());
                System.out.println("Quantidade: " + p.getQuantidade());
                System.out.println("Total: " + p.getValorTotal());
                System.out.println("------------------------------");
            }
        }

        if (!encontrouPedidos) {
            System.out.println("Nenhum pedido encontrado com a descrição fornecida.");
        }
    }


    public void buscarPedidoPorFuncionario() {
        System.out.println("Digite o ID do funcionário que deseja buscar pedidos:");
        int funcionarioId = in.nextInt();
        in.nextLine();

        Usuario funcionario = null;
        for (Usuario u : listaUsuario) {
            if (u.getId() == funcionarioId) {
                funcionario = u;
                break;
            }
        }

        if (funcionario == null) {
            System.out.println("Funcionário não encontrado.");
            return;
        }

        System.out.println("Pedidos do funcionário " + funcionario.getNome() + ":");
        boolean encontrouPedidos = false;
        for (Pedido p : listaPedido) {
            if (p.getSolicitante().getId() == funcionarioId) {
                encontrouPedidos = true;
                System.out.println("ID do Pedido: " + p.getId());
                System.out.println("Departamento: " + p.getDepartamento().getNomeDpt());
                System.out.println("Data do Pedido: " + p.getDataPedido());
                System.out.println("Status: " + p.getStatus());
                System.out.println("Valor Total: " + p.getValorTotal());
                System.out.println("------------------------------");
            }
        }

        if (!encontrouPedidos) {
            System.out.println("Nenhum pedido encontrado para o funcionário " + funcionario.getNome() + ".");
        }
    }


    public void listarTodosOsPedidos() {
        if (listaPedido.isEmpty()) {
            System.out.println("Não há pedidos registrados.");
        } else {
            for (Pedido pedido : listaPedido) {
                System.out.println("ID do Pedido: " + pedido.getId());
                System.out.println("Solicitante: " + pedido.getSolicitante().getNome());
                System.out.println("Departamento: " + pedido.getDepartamento().getNomeDpt());
                System.out.println("Data do Pedido: " + pedido.getDataPedido());
                System.out.println("Descrição do Item: " + pedido.getDescricaoItem());
                System.out.println("Valor Unitário: " + pedido.getValorUnitario());
                System.out.println("Quantidade: " + pedido.getQuantidade());
                System.out.println("Valor Total: " + pedido.getValorTotal());
                System.out.println("Status: " + pedido.getStatus());
                System.out.println("Data de Conclusão: " + (pedido.getDataConclusao() != null ? pedido.getDataConclusao() : "Ainda não concluído"));
                System.out.println("------------------------------");
            }
        }
    }
}

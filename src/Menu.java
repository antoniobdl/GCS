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
            case 1: ; break;
            case 2: addPedido() ; break;
            case 3: ; break;
            case 4: ; break;
            case 5: ; break;
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
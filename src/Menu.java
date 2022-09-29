import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        ListaClientes listaClientes = new ListaClientes();
        ListaCompras listaCompras = new ListaCompras();
        ListaProdutos listaProdutos = new ListaProdutos();

        int opcao,opcaoDoWhile = 0;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Menu:");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Cadastrar produto");
            System.out.println("3 - Realizar compra");
            System.out.println("0 - Sair");
            opcao = in.nextInt();in.nextLine();
            switch(opcao) {
                case 1:
                    System.out.println("Digite o nome:");
                    String nome = in.nextLine();
                    System.out.println("Digite o CPF:");
                    String cpf = in.nextLine();
                    Cliente cliente = new Cliente(nome, cpf);
                    listaClientes.cadastrarClientes(cliente);
                    break;
                case 2:
                    System.out.println("Digite o ID:");
                    String id = in.nextLine();
                    System.out.println("Digite a descrição:");
                    String desc = in.nextLine();
                    System.out.println("Digite a quantidade do produto:");
                    int qtd = in.nextInt();in.nextLine();
                    System.out.println("Digite o preço:");
                    double preco = in.nextDouble();in.nextLine();
                    System.out.println("Digite a Nacionalidade:");
                    String nacionalidade = in.nextLine();
                    Produto produto = new Produto(id, desc, qtd, preco, nacionalidade);
                    listaProdutos.cadastrarProdutos(produto);
                    break;
                case 3:
                    String id2;
                    try{
                        System.out.println("Informe o ID do produto:");
                        id2 = in.nextLine();
                    } catch(InputMismatchException e){
                        System.out.println("Informe um valor válido:");
                        id2 = in.nextLine();
                    }
                    System.out.println("Informe o CPF do cliente:");
                    String cpf2 = in.nextLine();
                    Produto produto2 = listaProdutos.buscarProduto(id2);
                    Cliente cliente2 = listaClientes.buscarCliente(cpf2);
                    System.out.println("Informe a quantidade a ser comprada:");
                    int quantidade = in.nextInt();
                    if(produto2 != null && cliente2 != null){
                        if(quantidade <= produto2.getQuantidade()){
                            Compra compra = new Compra(produto2, cliente2, quantidade);
                            listaProdutos.atualizarEstoque(id2, produto2.getQuantidade() - quantidade);
                            compra.calcularValorTotal();
                            listaCompras.cadastrarCompras(compra);
                        }else{
                            System.out.println("Quantidade não disponível em estoque.");
                        }
                    }else{
                        System.out.println("Não foi possível realizar a compra!");
                    }
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção Inválida!");
            }
            System.out.println("Gostaria de continuar?");
            System.out.println("1 - Sim");
            System.out.println("Outro Valor - Não");
            opcaoDoWhile = in.nextInt();in.nextLine();
            opcao = 0;
        }while(opcaoDoWhile == 1);
    }
}

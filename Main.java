import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    static int codigo = 005;
    static String nome;
    static String tipo;
    static double valor;
    static int estoque;

    static List<Produto> listaDeProdutos = new ArrayList<>();
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        listaDeProdutos.add(new Produto(000, "Itaipava", "Cerveja", 1.50, 200));
        listaDeProdutos.add(new Produto(001, "Skol", "Cerveja", 1.70, 300));
        listaDeProdutos.add(new Produto(002, "Del Vale", "Suco", 2.10, 100));
        listaDeProdutos.add(new Produto(003, "Pepsi Cola 2L", "Refrigerante", 3.00, 800));
        listaDeProdutos.add(new Produto(004, "Guaraná Charrua 2L", "Refrigerante", 2.50, 340));
        listaDeProdutos.add(new Produto(005, "Bis branco", "Chocolate", 2.70, 50));

        int opcao;
        do {
            System.out.print("\n============ MENU ============" +
                    "\n1- Listar produtos." +
                    "\n2- Buscar produtos pelo nome." +
                    "\n3- Buscar produtos pelo tipo." +
                    "\n4- Cadastrar produtos." +
                    "\n5- Excluir produto." +
                    "\n6- Alterar valor de produto." +
                    "\n7- Alterar estoque de produto." +
                    "\n0- Sair do menu." +
                    "\nDigite uma das opcoes acima: ");
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    listarProdutos();
                    break;
                case 2:
                    buscarProduto("nome");
                    break;
                case 3:
                    buscarProduto("tipo");
                    break;
                case 4:
                    cadastrarProduto();
                    break;
                case 5:
                    excluirProduto();
                    break;
                case 6:
                    alterarProduto("valor");
                    break;
                case 7:
                    alterarProduto("estoque");
                    break;
                case 0:
                    break;
                default:
                    System.err.println("Digite uma opcao valida!");
            }
        } while (opcao != 0);
    }

    public static void listarProdutos(){
        for (Produto produto : listaDeProdutos) {
            System.out.println("\n==== PRODUTO ======");
            System.out.printf("Código: %03d%n",produto.codigo);
            System.out.println("Nome: " + produto.nome +
                    "\nTipo: " + produto.tipo +
                    "\nValor: " + produto.valor +
                    "\nEstoque: " + produto.estoque +
                    "\n===================");
        }
    }

    public static void buscarProduto(String criterio) {
        Scanner scanner = new Scanner(System.in);
        //doce como doce de batata doce
        System.out.println("\n" + "Digite o " + criterio + " do produto a ser pesquisado: ");
        String busca = scanner.nextLine();

        List<Produto> produtosEncontrados = new ArrayList<>();

        if(criterio.equals("nome")) {
            for (Produto produto : listaDeProdutos) {
                if (produto.getNome().equalsIgnoreCase(busca)) {
                    produtosEncontrados.add(produto);
                }
            }
        } else if(criterio.equals("tipo")) {
            for (Produto produto : listaDeProdutos) {
                if (produto.getTipo().equalsIgnoreCase(busca)) {
                    produtosEncontrados.add(produto);
                }
            }
        }
        if (produtosEncontrados.isEmpty()) {
            System.err.println("Nenhum produto encontrado com o nome: " + busca);
        } else {
            System.out.println("Produto encontrado com o nome: " + busca);
            for (Produto produto : produtosEncontrados) {
                System.out.println("------- Produto -------");
                System.out.println(produto);
            }
        }
    }

    public static int validarInteiro(){

        try{
            int numero = teclado.nextInt();
            if(numero >= 0) {
                return numero;
            }
        }catch (InputMismatchException e){

        }
        System.err.println("Digite um número válido!");
        teclado.next();
        return validarInteiro();
    }

    public static Double validarDouble(){

        try{
            Double numero = teclado.nextDouble();
            if(numero >= 0) {
                return numero;
            }
        }catch (InputMismatchException e){

        }
        System.err.println("Digite um número válido!");
        teclado.next();
        return validarDouble();
    }

    public static void cadastrarProduto() {
        System.out.println("=== CADASTRAR PRODUTO ===");
        teclado = new Scanner(System.in);
        System.out.print("Digite o nome: ");
        nome = teclado.nextLine();
        for (Produto produto : listaDeProdutos) {
            if (produto.getNome().equals(nome)) {
                System.err.println("Produto já consta na lista!");
                return;
            }
        }
        System.out.print("Digite o tipo: ");
        tipo = teclado.nextLine();
        System.out.print("Digite o valor: ");
        valor = validarDouble();
        System.out.print("Digite o estoque: ");
        estoque = validarInteiro();
        if(nome.isEmpty() || tipo.isEmpty() || valor < 0 || estoque < 0){
            System.err.print("Dados incompletos e/ou incorretos! Tente novamente.\n");
        } else {
            codigo += 1;
            listaDeProdutos.add(new Produto(codigo, nome, tipo, valor, estoque));
            System.out.println("Produto cadastrado!");
        }
    }

    public static void excluirProduto(){
        System.out.println("\n==== EXCLUIR PRODUTO ====" +
                "\nDigite o código do produto que deseja excluir: ");
        teclado = new Scanner(System.in);
        int codigoExcluir = validarInteiro();
        boolean produtoExcluido = false;
        for (Produto produto : listaDeProdutos) {
            if(produto.getCodigo() == codigoExcluir) {
                listaDeProdutos.remove(produto);
                System.out.println("Produto excluido!");
                produtoExcluido = true;
                break;
            }
        }
        if(!produtoExcluido) {
            System.err.println("Produto não encontrado!");
        }
    }

    public static void alterarProduto(String categoria) {
        System.out.println("\n==== ALTERAR " + categoria.toUpperCase() + " PRODUTO ====" +
                "\nDigite o codigo do produto que deseja alterar o valor: ");
        teclado = new Scanner(System.in);

        int codigoAlterarValor = validarInteiro();
        boolean produtoAlterado = false;
        for (Produto produto : listaDeProdutos) {
            if (produto.getCodigo() == codigoAlterarValor) {
                System.out.println("Digite o novo " + categoria + ": ");
                if(categoria.equals("valor")) {
                    produto.valor = validarDouble();
                } else if(categoria.equals("estoque")) {
                  produto.estoque = validarInteiro();
                }
                produtoAlterado = true;
                System.out.println("O "+ categoria + " do produto foi alterado com sucesso!");
                break;
            }
        }
        if (!produtoAlterado) {
            System.err.println("Produto não encontrado!");
        }
    }
}
package aplicacao;

import dominio.Cliente;
import dominio.ItemDoPedido;
import dominio.Pedido;
import dominio.Produto;
import dominio.enums.StatusDoPedido;
import reposittorio.PedidoRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class MercadoOpenSource {
    private static SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
    private static StatusDoPedido statusDoPedido;
    private static Cliente cliente;
    private static Produto produto;
    private static ItemDoPedido itemDoPedido;
    private static Pedido pedido;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
        obterDadosDoCliente();
        statusDoPedido = StatusDoPedido.valueOf(obterDados("Status do pedido:"));
        criarPedido();
        int numeroDeItensNoPedido = Integer.parseInt(obterDados("Quantos itens deseja pedir?"));
        adicionarItensAoPedido(numeroDeItensNoPedido);
        mostrarPedido();
        String caminhoDoArquivo = obterDados("Digite o caminho do arquivo onde será gravado o Pedido");
        gravarPedidoEmArquivo(caminhoDoArquivo);
    }

    private static void gravarPedidoEmArquivo(String caminhoDoArquivo) {
        new PedidoRepository(pedido).gravarEmArquivo(caminhoDoArquivo);
        System.out.println("Arquivo gravado com sucesso: "+caminhoDoArquivo);
    }

    private static void mostrarPedido() {
        System.out.println(pedido);
    }

    private static void adicionarItensAoPedido(int numeroDeItensNoPedido) {
        for (int i = 1; i <= numeroDeItensNoPedido; i++) {
            System.out.println("Entre com os dados do item " + i);
            String nomeDoProduto = obterDados("Nome do produto:");
            BigDecimal precoDoProduto = new BigDecimal(obterDados("Preco:")).setScale(2, RoundingMode.HALF_EVEN);
            int quantidadeDoProduto = Integer.parseInt(obterDados("Quantidade:"));
            produto = new Produto(nomeDoProduto, precoDoProduto);
            itemDoPedido = new ItemDoPedido(produto, quantidadeDoProduto);
            pedido.adicionarItens(itemDoPedido);
            System.out.println("Item adicionado com sucesso!");
        }
    }

    private static String obterDados(String mensagemAoUsuario) {
        System.out.println(mensagemAoUsuario);
        return scanner.nextLine();
    }

    private static void obterDadosDoCliente() throws ParseException {
        String nome = obterDados("Nome: ");
        String enderecoEletronico = obterDados("Endereço eletrônico: ");
        String dataDeNascimento = obterDados("Data de nascimento:");
        cliente = new Cliente(nome, enderecoEletronico, dataFormatada.parse(dataDeNascimento));
    }

    public static void criarPedido() {
        pedido = new Pedido(cliente, statusDoPedido);
    }
}

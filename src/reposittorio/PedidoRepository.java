package reposittorio;

import dominio.Pedido;
import dominio.Produto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PedidoRepository {
    private Pedido pedido;

    public PedidoRepository(Pedido pedido) {
        this.pedido = pedido;
    }

    public void gravarEmArquivo(String caminhoDoArquivo) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(caminhoDoArquivo))) {
            bufferedWriter.write(pedido.toString());
        } catch (IOException e) {
            System.out.println("Erro ao gravar em arquivo: "+e.getMessage());
        }
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void editar(Pedido pedito) {
        this.pedido = pedito;
    }
}

package dominio;

import dominio.enums.StatusDoPedido;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private StatusDoPedido statusDoPedido;
    private Date data = new Date();
    private SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private List<ItemDoPedido> itensDoPedido = new ArrayList<>();

    public Pedido(Cliente cliente, StatusDoPedido statusDoPedido) {
        this.cliente = cliente;
        this.statusDoPedido = statusDoPedido;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Dados do pedido:\n");
        stringBuilder.append("Data: " + dataFormatada.format(data) + "\n");
        stringBuilder.append(cliente + "\n");
        BigDecimal total = new BigDecimal("0.00");
        for (ItemDoPedido itemDoPedido : itensDoPedido) {
            stringBuilder.append(itemDoPedido);
            total = total.add(itemDoPedido.getSubTotal().setScale(2, RoundingMode.HALF_EVEN));
        }
        stringBuilder.append("Total do pedido: " + total);
        return stringBuilder.toString();
    }

    public void adicionarItens(ItemDoPedido itemDoPedido) {
        itensDoPedido.add(itemDoPedido);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemDoPedido> getItensDoPedido() {
        return Collections.unmodifiableList(itensDoPedido);
    }

}
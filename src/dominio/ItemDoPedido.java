package dominio;

import java.math.BigDecimal;

public class ItemDoPedido {
    private Produto produto;
    private Integer quantidadeDeProdutos;
    private BigDecimal subTotal;

    public ItemDoPedido(Produto produto, Integer quantidadeDeProdutos) {
        this.produto = produto;
        this.quantidadeDeProdutos = quantidadeDeProdutos;
        this.subTotal = produto.getPreco().multiply(new BigDecimal(quantidadeDeProdutos));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(produto+", quantidade: "+ quantidadeDeProdutos +", Subtotal: "+subTotal+"\n");
        return stringBuilder.toString();
    }
    public Integer getQuantidadeDeProdutos() {
        return quantidadeDeProdutos;
    }

    public Produto getProduto() {
        return produto;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }
}

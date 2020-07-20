package dominio;

import java.math.BigDecimal;

public class Produto {
    private String nome;
    private BigDecimal preco;

    public Produto(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(nome + ", " + preco);
        return stringBuilder.toString();
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}

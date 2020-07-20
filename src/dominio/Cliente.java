package dominio;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {
    private String nome;
    private String enderecoEletronico;
    private Date dataDeNascimento;
    private SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");

    public Cliente(String nome, String enderecoEletronico, Date dataDeNascimento) {
        this.nome = nome;
        this.enderecoEletronico = enderecoEletronico;
        this.dataDeNascimento = dataDeNascimento;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(nome+" ");
        stringBuilder.append("("+enderecoEletronico+") - "+dataFormatada.format(dataDeNascimento));
        return stringBuilder.toString();
    }

    public String getNome() {
        return nome;
    }

    public String getEnderecoEletronico() {
        return enderecoEletronico;
    }

    public void setEnderecoEletronico(String enderecoEletronico) {
        this.enderecoEletronico = enderecoEletronico;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }
}

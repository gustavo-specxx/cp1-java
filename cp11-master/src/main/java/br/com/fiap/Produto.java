package br.com.fiap;

import javax.persistence.*;

@Entity(name = "TDS_TB_ProdutoCS")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco")
    private Double preco;

    @Column(name = "validade")
    private String validade;

    @Column(name = "tamanho")
    private String tamanho;

    @Column(name = "descricao")
    private String descricao;

    public Produto() {}

    public Produto(Integer id, String nome, Double preco, String validade, String tamanho, String descricao) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.validade = validade;
        this.tamanho = tamanho;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Produto{id=").append(id);
        sb.append(", nome=").append(nome);
        sb.append(", preco=").append(preco);
        sb.append(", validade=").append(validade);
        sb.append(", tamanho=").append(tamanho);
        sb.append(", descricao=").append(descricao);
        sb.append('}');
        return sb.toString();
    }
}
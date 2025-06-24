package com.projectvs1.projetovs.shared;



//Anotação pra tornar a classe Produto uma entidade/tabela no banco

public class ProdutoDTO {

    // #region atributos

    private Integer id;

    private String nome;

    private Integer quantidade;

    private double valor;

    private String observacao;
    // #endregion

    // #region Getters e Setters
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

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    


}

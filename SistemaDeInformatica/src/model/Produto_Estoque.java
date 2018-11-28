/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author vinicius
 */
public class Produto_Estoque {
    private int id;
    private String nome;
    private String marca;
    private double preco;
    private int quantidade;
    
    public Produto_Estoque(Produto produto, Estoque estoque){
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.marca = produto.getMarca();
        this.preco = produto.getPreco();
        this.quantidade = estoque.getQuantidade();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}

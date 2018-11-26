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
public class Estoque {
    int id_Produto;
    int quantidade;

    public Estoque(int id_Produto, int quantidade) {
        this.id_Produto = id_Produto;
        this.quantidade = quantidade;
    }

    public Estoque() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_Produto() {
        return id_Produto;
    }

    public void setId_Produto(int id_Produto) {
        this.id_Produto = id_Produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}
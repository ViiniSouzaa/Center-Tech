/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author vinicius
 */
public class ClienteGenerico {
   
    private Cliente cliente;
    private SimpleStringProperty cpf;
    private SimpleStringProperty nome;
    private SimpleStringProperty endereco;
    private SimpleStringProperty telefone;

    public ClienteGenerico(Cliente c) {
        this.cliente = c;
        this.cpf = new SimpleStringProperty(c.getCPF());
        this.nome = new SimpleStringProperty(c.getNome());
        this.endereco = new SimpleStringProperty(c.getEndereco());
        this.telefone = new SimpleStringProperty(c.getTelefone());
    }
    

    public String getCpf() {
        return cpf.getValue();
    }

    public String getNome() {
        return nome.getValue();
    }

    public String getEndereco() {
        return endereco.getValue();
    }

    public String getTelefone() {
        return telefone.getValue();
    }
    
    public Cliente getCliente(){
        return cliente;
}
}

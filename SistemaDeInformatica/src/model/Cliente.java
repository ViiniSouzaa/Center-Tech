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
public class Cliente extends Pessoa{
    
    public Cliente(String nome, String endereco, String cpf, String telefone) {
        super(nome, endereco, cpf, telefone);
    }

    public Cliente() {
        super("", "", "", null);
    }
    
}

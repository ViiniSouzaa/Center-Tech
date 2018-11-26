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
public class Funcionario extends Pessoa{
    
    public Funcionario(String nome, String endereco, String cpf, String telefone) {
        super(nome, endereco, cpf, telefone);
    }

    public Funcionario() {
        super("", "", "", null);
    }
    
    
}

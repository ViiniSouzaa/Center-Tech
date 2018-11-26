/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

import java.util.List;
import model.Funcionario;

/**
 *
 * @author vinicius
 */
public interface ImplementsFuncionario {
    public void insert(Funcionario funcionario);
    
    public void update(Funcionario funcionario);
    
    public void delete(String cpf);
    
    public List<Funcionario> getFuncionario(String cpf);
    
    public List<Funcionario> getAllFuncionario();
}

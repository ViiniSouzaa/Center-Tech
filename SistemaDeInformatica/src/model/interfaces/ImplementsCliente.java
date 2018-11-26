/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

import java.util.List;
import model.Cliente;

/**
 *
 * @author vinicius
 */
public interface ImplementsCliente {
    public void insert(Cliente cliente);
    
    public void update(Cliente cliente);
    
    public void delete(String cpf);
    
    public List<Cliente> getCliente(String cpf);
    
    public List<Cliente> getAllCliente();
}

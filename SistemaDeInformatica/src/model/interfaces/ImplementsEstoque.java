/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

import java.util.List;
import model.Estoque;

/**
 *
 * @author vinicius
 */
public interface ImplementsEstoque {
    
    public void insert(Estoque estoque);
    public void update(Estoque estoque);
    public void delete(int id);
    public Estoque getEstoque(int id);
    public List<Estoque> getAllEstoque();
    
}

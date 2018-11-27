/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

import java.util.List;
import model.Produto;

/**
 *
 * @author vinicius
 */
public interface ImplementsProduto {
    public void insert(Produto produto);
    
    public void update(Produto produto);
    
    public void delete(int id);
    
    public List<Produto> getProduto(int id);
    
    public List<Produto> getAllProduto();
    
    public int getUltimoProduto();
    
    
}

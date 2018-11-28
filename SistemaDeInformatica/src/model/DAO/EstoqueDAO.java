/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import configurations.ConfigurationsMySQL;
import database.DataBaseGeneric;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Estoque;
import model.interfaces.ImplementsEstoque;

/**
 *
 * @author vinicius
 */
public class EstoqueDAO extends DataBaseGeneric implements ImplementsEstoque{
    public ArrayList<Estoque> list;
    
    public EstoqueDAO() {
        super(new ConfigurationsMySQL(), "Estoque");
    }

    @Override
    public void insert(Estoque estoque) {
        Map<Object, Object> mapObj = new HashMap<>();
        mapObj.put("id_Produto", estoque.getId_Produto());
        mapObj.put("quantidade", estoque.getQuantidade());
        this.genericInsert(mapObj);
    }

    @Override
    public void update(Estoque estoque) {
        Map<Object, Object> mapObj = new HashMap<>();
        Map<Object, Object> mapConditions = new HashMap<>();
        mapObj.put("quantidade", estoque.getQuantidade());
        mapConditions.put("id_Produto", estoque.getId_Produto());
        this.genericUpdate(mapObj, mapConditions);
    }

    @Override
    public void delete(int id) {
        Map<Object, Object> mapObj = new HashMap<>();
        mapObj.put("id_Produto", id);
        
    }

    @Override
    public Estoque getEstoque(int id) {
        try{
            ResultSet rs = this.getLike("id_Produto", String.valueOf(id));
            while(rs.next()){
                Estoque estoque =  new Estoque();
                estoque.setId_Produto(rs.getInt("id_Produto"));
                estoque.setQuantidade(rs.getInt("quantidade"));
                return estoque;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Estoque> getAllEstoque() {
        list =  new ArrayList<>();
        try{
            ResultSet rs = this.getAll();
            while(rs.next()){
                Estoque estoque =  new Estoque();
                estoque.setId_Produto(rs.getInt("id_Produto"));
                estoque.setQuantidade(rs.getInt("quantidade"));
                list.add(estoque);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
  
}

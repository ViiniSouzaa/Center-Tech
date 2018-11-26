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
import model.Produto;
import model.interfaces.ImplementsProduto;

/**
 *
 * @author vinicius
 */
public class ProdutoDAO extends DataBaseGeneric implements ImplementsProduto{
    
    public ArrayList<Produto> list;

    public ProdutoDAO() {
        super(new ConfigurationsMySQL(),"Produto");
    }

    @Override
    public void insert(Produto produto) {
        Map<Object, Object> mapObj =  new HashMap<>();
        mapObj.put("id",produto.getId());
        mapObj.put("nome", produto.getNome());
        mapObj.put("marca", produto.getMarca());
        mapObj.put("preco", produto.getPreco());
        mapObj.put("quantidade", produto.getQuantidade());
        this.genericInsert(mapObj);
    }

    @Override
    public void update(Produto produto) {
        Map<Object, Object> mapObj =  new HashMap<>();
        Map<Object, Object> mapConditions = new HashMap<>();
        mapObj.put("nome", produto.getNome());
        mapObj.put("marca", produto.getMarca());
        mapObj.put("preco", produto.getPreco());
        mapObj.put("quantidade", produto.getQuantidade());
        mapConditions.put("id", produto.getId());
        this.genericUpdate(mapObj, mapConditions);
    }

    @Override
    public void delete(int id) {
        Map<Object, Object> mapObj = new HashMap<>();
        mapObj.put("id", id);
    }

    @Override
    public List<Produto> getProduto(int id) {
        this.list = new ArrayList<>();
        try{
            ResultSet rs = this.getOne("id", id);
            while(rs.next()){
                Produto produto = new Produto();
                produto.setId(rs.getInt(1));
                produto.setNome(rs.getString("nome"));
                produto.setMarca(rs.getString("marca"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
                list.add(produto);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Produto> getAllProduto() {
      this.list = new ArrayList<>();
        try{
            ResultSet rs = this.getAll();
            while(rs.next()){
                Produto produto = new Produto();
                produto.setId(rs.getInt(1));
                produto.setNome(rs.getString("nome"));
                produto.setMarca(rs.getString("marca"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
                list.add(produto);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

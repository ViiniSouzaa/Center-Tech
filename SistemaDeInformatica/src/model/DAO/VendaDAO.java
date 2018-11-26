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
import model.Venda;
import model.interfaces.ImplementsVenda;

/**
 *
 * @author vinicius
 */
public class VendaDAO extends DataBaseGeneric implements ImplementsVenda {
    ArrayList<Venda> list;
    
    public VendaDAO() {
        super(new ConfigurationsMySQL(), "Venda");
    }
    
    @Override
    public void insert(Venda venda) {
        Map<Object, Object> mapObj =  new HashMap<>();
        mapObj.put("id", venda.getId());
        mapObj.put("cpfCliente", venda.getCpfCliente());
        mapObj.put("cpfFuncionario", venda.getCpfFuncionario());
        mapObj.put("idProdutos", venda.getIdProduto());
        mapObj.put("quant", venda.getQuant());
        this.genericInsert(mapObj);    
    }

    @Override
    public void update(Venda venda) {
        Map<Object, Object> mapObj =  new HashMap<>();
        Map<Object, Object> mapConditions =  new HashMap<>();
        mapConditions.put("id", venda.getId());
        mapObj.put("cpfCliente", venda.getCpfCliente());
        mapObj.put("cpfFuncionario", venda.getCpfFuncionario());
        mapObj.put("idProdutos", venda.getIdProduto());
        mapObj.put("quant", venda.getQuant());
        this.genericUpdate(mapObj, mapConditions); 
    }

    @Override
    public void delete(int id) {
        Map<Object, Object> mapObj = new HashMap<>();
        mapObj.put("id", id);
        this.genericDelete(mapObj);
    }

    @Override
    public List<Venda> getVenda(int id) {
        this.list = new ArrayList<>();
        try{
            ResultSet rs = this.getOne("id",id);
            Venda venda;
            while(rs.next()){
                venda =  new Venda();
                venda.setId(rs.getInt(1));
                venda.setCpfCliente(rs.getString("cpfCliente"));
                venda.setCpfFuncionario(rs.getString("cpfFuncionario"));
                venda.setIdProduto(rs.getInt("idProduto"));
                venda.setQuant(rs.getInt("quant"));
                this.list.add(venda);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Venda> getAllVenda() {
        this.list = new ArrayList<>();
        try{
            ResultSet rs = this.getAll();
            while(rs.next()){
                Venda venda =  new Venda();
                venda.setId(rs.getInt(1));
                venda.setCpfCliente(rs.getString("cpfCliente"));
                venda.setCpfFuncionario(rs.getString("cpfFuncionario"));
                venda.setIdProduto(rs.getInt("idProduto"));
                venda.setQuant(rs.getInt("quant"));
                this.list.add(venda);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

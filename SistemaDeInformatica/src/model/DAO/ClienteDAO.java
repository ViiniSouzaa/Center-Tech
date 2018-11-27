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
import model.Cliente;
import model.interfaces.ImplementsCliente;

/**
 *
 * @author vinicius
 */
public class ClienteDAO extends DataBaseGeneric implements ImplementsCliente{

    public ArrayList<Cliente> list;
    
    public ClienteDAO() {
        super(new ConfigurationsMySQL(), "Cliente");
    }
    
    @Override
    public void insert(Cliente cliente) {
        Map<Object, Object> mapObj =  new HashMap<>();
        mapObj.put("nome", cliente.getNome());
        mapObj.put("endereco", cliente.getEndereco());
        mapObj.put("cpf", cliente.getCPF());
        mapObj.put("telefone", cliente.getTelefone());
        this.genericInsert(mapObj);
    }

    @Override
    public void update(Cliente cliente) {
        Map<Object, Object> mapObj =  new HashMap<>();
        Map<Object, Object> mapConditions = new HashMap<>();
        mapObj.put("nome", cliente.getNome());
        mapObj.put("endereco", cliente.getEndereco());
        mapObj.put("telefone", cliente.getTelefone());
        mapConditions.put("cpf", cliente.getCPF());
        this.genericUpdate(mapObj, mapConditions);
    }

    @Override
    public void delete(String cpf) {
        Map<Object, Object> mapObj = new HashMap<>();
        mapObj.put("cpf", cpf);
        this.genericDelete(mapObj);
    }

    @Override
    public List<Cliente> getCliente(String cpf) {
        this.list = new ArrayList<>();
        try{
            ResultSet rs = this.getLike("cpf", cpf);
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setCPF(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getString("telefone"));
                list.add(cliente);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Cliente> getAllCliente() {
        this.list = new ArrayList<>();
        try{
            ResultSet rs = this.getAll();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setCPF(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getString("telefone"));
                list.add(cliente);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
}

    @Override
    public List<Cliente> getClienteNome(String nome) {
        this.list = new ArrayList<>();
        try{
            ResultSet rs = this.getLike("nome", nome);
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setCPF(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getString("telefone"));
                list.add(cliente);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

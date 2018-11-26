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
import model.Funcionario;
import model.interfaces.ImplementsFuncionario;

/**
 *
 * @author vinicius
 */
public class FuncionarioDAO extends DataBaseGeneric implements ImplementsFuncionario{
    public ArrayList<Funcionario> list;
    
    public FuncionarioDAO() {
        super(new ConfigurationsMySQL(), "Funcionario");
    }
    
    @Override
    public void insert(Funcionario funcionario) {
        Map<Object, Object> mapObj =  new HashMap<>();
        mapObj.put("nome", funcionario.getNome());
        mapObj.put("endereco", funcionario.getEndereco());
        mapObj.put("cpf", funcionario.getCPF());
        mapObj.put("telefone", funcionario.getTelefone());
        this.genericInsert(mapObj);
    }

    @Override
    public void update(Funcionario funcionario) {
        Map<Object, Object> mapObj =  new HashMap<>();
        Map<Object, Object> mapConditions = new HashMap<>();
        mapObj.put("nome", funcionario.getNome());
        mapObj.put("endereco", funcionario.getEndereco());
        mapObj.put("telefone", funcionario.getTelefone());
        mapConditions.put("cpf", funcionario.getCPF());
        this.genericUpdate(mapObj, mapConditions);
    }

    @Override
    public void delete(String cpf) {
        Map<Object, Object> mapObj = new HashMap<>();
        mapObj.put("cpf", cpf);
    }

    @Override
    public List<Funcionario> getFuncionario(String cpf) {
        this.list = new ArrayList<>();
        try{
            ResultSet rs = this.getLike("cpf", cpf);
            while(rs.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setCPF(rs.getString("cpf"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEndereco(rs.getString("endereco"));
                list.add(funcionario);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Funcionario> getAllFuncionario() {
        this.list = new ArrayList<>();
        try{
            ResultSet rs = this.getAll();
            while(rs.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setCPF(rs.getString("cpf"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEndereco(rs.getString("endereco"));
                list.add(funcionario);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
}
}

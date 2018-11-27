/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.ClienteGenerico;
import model.DAO.ClienteDAO;

/**
 *
 * @author vinicius
 */
public class ControladorTableCliente {
    ClienteDAO clienteDao;

    public ControladorTableCliente() {
        clienteDao = new ClienteDAO();
    }
    
    public List<ClienteGenerico> listaClientes(){
        List<ClienteGenerico> clientesGen = new ArrayList<>();
        clienteDao.getAllCliente().forEach(cliente -> {
            clientesGen.add(new ClienteGenerico(cliente));
        });
        return clientesGen;
    }
}

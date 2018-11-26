/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import model.Cliente;
import model.DAO.ClienteDAO;

/**
 * FXML Controller class
 *
 * @author vinicius
 */
public class CadastroClienteFormController implements Initializable {

    @FXML
    private TextField labelNome;

    @FXML
    private TextField labelCpf;

    @FXML
    private TextField labelEndereco;

    @FXML
    private TextField labelTelefone;

    @FXML
    private Button adicionarButton;

    @FXML
    private Button cancelarButton;
    
    ClienteDAO clienteDao =  new ClienteDAO();

    @FXML
    void adicionarAction(ActionEvent event) {
        Cliente cliente = new Cliente();
        cliente.setCPF(labelCpf.getText());
        cliente.setNome(labelNome.getText());
        cliente.setEndereco(labelEndereco.getText());
        cliente.setTelefone(labelTelefone.getText());
        clienteDao.insert(cliente);
        
        JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void cancelarAction(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.List;
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
public class AlterPessoaController implements Initializable {

    @FXML
    private Button alteraButton;

    @FXML
    private Button cancelaButton;

    @FXML
    private TextField labelCpf;

    @FXML
    private Button procuraButton;

    @FXML
    private TextField labelNome;

    @FXML
    private TextField labelEndereco;

    @FXML
    private TextField labelTelefone;
    
    ClienteDAO clienteDAO =  new ClienteDAO();

    @FXML
    void alteraAction(ActionEvent event) {
        Cliente cliente = new Cliente();
        cliente.setCPF(labelCpf.getText());
        cliente.setNome(labelNome.getText());
        cliente.setEndereco(labelEndereco.getText());
        cliente.setTelefone(labelTelefone.getText());
        clienteDAO.update(cliente);
        JOptionPane.showMessageDialog(null, "Alterado com sucesso");
        
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void cancelaAction(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void procuraAction(ActionEvent event) {
        List<Cliente> funcionario = clienteDAO.getCliente(labelCpf.getText());
        labelNome.setText(funcionario.get(0).getNome());
        labelEndereco.setText(funcionario.get(0).getEndereco());
        labelTelefone.setText(funcionario.get(0).getTelefone());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
}

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
import model.Funcionario;
import model.DAO.FuncionarioDAO;

/**
 * FXML Controller class
 *
 * @author vinicius
 */
public class CadastroFuncionarioFormController implements Initializable {

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
    
    FuncionarioDAO funcionarioDao =  new FuncionarioDAO();

    @FXML
    void adicionarAction(ActionEvent event) {
        Funcionario funcionario = new Funcionario();
        funcionario.setCPF(labelCpf.getText());
        funcionario.setNome(labelNome.getText());
        funcionario.setEndereco(labelEndereco.getText());
        funcionario.setTelefone(labelTelefone.getText());
        funcionarioDao.insert(funcionario);
        
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

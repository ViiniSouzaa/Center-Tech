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
import model.DAO.FuncionarioDAO;
import model.Funcionario;

/**
 * FXML Controller class
 *
 * @author vinicius
 */
public class AlterFuncionarioController implements Initializable {

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
    
    FuncionarioDAO funcionarioDao =  new FuncionarioDAO();

    @FXML
    void alteraAction(ActionEvent event) {
        Funcionario funcionario = new Funcionario();
        funcionario.setCPF(labelCpf.getText());
        funcionario.setNome(labelNome.getText());
        funcionario.setEndereco(labelEndereco.getText());
        funcionario.setTelefone(labelTelefone.getText());
        funcionarioDao.update(funcionario);
        JOptionPane.showMessageDialog(null, "Alterado com sucesso");
        
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void cancelaAction(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void procuraAction(ActionEvent event) {
        List<Funcionario> funcionario = funcionarioDao.getFuncionario(labelCpf.getText());
        labelNome.setText(funcionario.get(0).getNome());
        labelEndereco.setText(funcionario.get(0).getEndereco());
        labelTelefone.setText(funcionario.get(0).getTelefone());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

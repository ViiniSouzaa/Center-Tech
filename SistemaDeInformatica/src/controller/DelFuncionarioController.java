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
import model.DAO.FuncionarioDAO;

/**
 * FXML Controller class
 *
 * @author vinicius
 */
public class DelFuncionarioController implements Initializable {

    @FXML
    private TextField label;

    @FXML
    private Button deletaButton;

    @FXML
    private Button cancelaButton;
    
    FuncionarioDAO funcionarioDao =  new FuncionarioDAO();
    
    @FXML
    void cancelaAction(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void deletaAction(ActionEvent event) {
        funcionarioDao.delete(label.getText());
        
        JOptionPane.showMessageDialog(null, "Deletado com sucesso");
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

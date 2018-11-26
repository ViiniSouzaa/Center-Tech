/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vinicius
 */
public class PessoaOrProdutoFormController implements Initializable {

    @FXML
    private Button clienteButton;
    private Button funcionarioButton;
    private Button produtoButton;
    
    @FXML
    public void clienteAction(ActionEvent event){
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/CadastroClienteForm.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }catch(IOException e){
            
        }
    }
    
    @FXML
    public void funcionarioAction(ActionEvent event){
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/CadastroFuncionarioForm.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }catch(IOException e){
            
        }
    }
    
    @FXML
    public void produtoAction(ActionEvent event){
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/CadastroProdutoForm.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }catch(IOException e){
            
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

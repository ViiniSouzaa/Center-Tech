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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vinicius
 */
public class PesquisaController implements Initializable {

    @FXML
    public void clienteAction(ActionEvent event){
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/ClientePanelForm.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            System.out.println("DEU RUIM");
        }
    }
    
    @FXML
    public void funcionarioAction(ActionEvent event){
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/FuncionarioPanelForm.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            System.out.println("DEU RUIM");
        }
    
    }
    
    @FXML
    public void produtoAction(ActionEvent event){
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/ProdutoPanelForm.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            System.out.println("DEU RUIM");
        }
    }
    
    @FXML
    public void orcamentoAction(ActionEvent event){
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/OrcamentoPanelForm.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            System.out.println("DEU RUIM");
        }
    }
    
    @FXML
    public void vendaAction(ActionEvent event){
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/VendaPanelForm.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            System.out.println("DEU RUIM");
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

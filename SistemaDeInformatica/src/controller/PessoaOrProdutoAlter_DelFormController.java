/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author vinicius
 */
public class PessoaOrProdutoAlter_DelFormController implements Initializable {
    
    @FXML
    private RadioButton modificar;
    private RadioButton deletar;
    private Label labelAlter_Del;
    private Button clienteButton;
    private Button funcionarioButton;
    private Button produtoButton;
    
        @FXML
        public void clienteAction(ActionEvent event){
            modificar.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                    Parent root;
                    if(wasPreviouslySelected){
                        try {
                            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/AlterCliente.fxml"));
                            Stage stage =  new Stage();
                            stage.setScene(new Scene(root));
                            stage.setResizable(false);
                            stage.show();
                            ((Node)(event.getSource())).getScene().getWindow().hide();
                        } catch (IOException ex) {
                            System.out.println(ex);
                        }
                    }else{
                        try {
                            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/DelCliente.fxml"));
                            Stage stage =  new Stage();
                            stage.setScene(new Scene(root));
                            stage.setResizable(false);
                            stage.show();
                            ((Node)(event.getSource())).getScene().getWindow().hide();
                        } catch (IOException ex) {
                            Logger.getLogger(PessoaOrProdutoAlter_DelFormController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
        }
        

        @FXML
        public void funcionarioAction(ActionEvent event){
            modificar.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                    Parent root;
                    if(wasPreviouslySelected){
                        try {
                            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/AlterCliente.fxml"));
                            Stage stage =  new Stage();
                            stage.setScene(new Scene(root));
                            stage.setResizable(false);
                            stage.show();
                            ((Node)(event.getSource())).getScene().getWindow().hide();
                        } catch (IOException ex) {
                            System.out.println(ex);
                        }
                    }else{
                        try {
                            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/DelCliente.fxml"));
                            Stage stage =  new Stage();
                            stage.setScene(new Scene(root));
                            stage.setResizable(false);
                            stage.show();
                            ((Node)(event.getSource())).getScene().getWindow().hide();
                        } catch (IOException ex) {
                            Logger.getLogger(PessoaOrProdutoAlter_DelFormController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
        }
    
    
        @FXML
        public void produtoAction(ActionEvent event){
            modificar.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                    Parent root;
                    if(wasPreviouslySelected){
                        try {
                            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/AlterCliente.fxml"));
                            Stage stage =  new Stage();
                            stage.setScene(new Scene(root));
                            stage.setResizable(false);
                            stage.show();
                            ((Node)(event.getSource())).getScene().getWindow().hide();
                        } catch (IOException ex) {
                            System.out.println(ex);
                        }
                    }else{
                        try {
                            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/DelCliente.fxml"));
                            Stage stage =  new Stage();
                            stage.setScene(new Scene(root));
                            stage.setResizable(false);
                            stage.show();
                            ((Node)(event.getSource())).getScene().getWindow().hide();
                        } catch (IOException ex) {
                            Logger.getLogger(PessoaOrProdutoAlter_DelFormController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
        }
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
}

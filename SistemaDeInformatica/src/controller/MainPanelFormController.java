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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vinicius
 */
public class MainPanelFormController implements Initializable {

    @FXML
    private Button CadastroButton;
    private Button Alter_DelButton;
    private Button Orc_VendaButton;
    private Button PesquisaButton;
    
    @FXML
    public void cadastroClick(ActionEvent event) throws IOException{
       Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/PessoaOrProdutoForm.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
            
        }
        catch (IOException e) {
        }
    }
    
    @FXML
    public void orc_VendaClick(ActionEvent event) throws IOException{
       Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/CriarVendaOrOrcamentoForm.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        }
        catch (IOException e) {
        }
    }
    
    @FXML
    public void alter_DelClick(ActionEvent event) throws IOException{
       Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/PessoaOrProdutoAlter_DelForm.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        }
        catch (IOException e) {
            System.out.println("DEU RUIM");
        }
    }
    
    @FXML
    public void pesquisaAction(ActionEvent event){
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/Pesquisa.fxml"));
            Stage stage= new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        }catch(IOException e){
            System.out.println("DEU RUIM AQUI VIADO");
        }
    }
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

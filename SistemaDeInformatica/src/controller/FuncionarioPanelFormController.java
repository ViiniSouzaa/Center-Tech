/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import model.DAO.FuncionarioDAO;
import model.Funcionario;

/**
 * FXML Controller class
 *
 * @author vinicius
 */
public class FuncionarioPanelFormController implements Initializable {

     @FXML
    private TableView<Funcionario> table;

    @FXML
    private TableColumn<Funcionario, String> colCpf;

    @FXML
    private TableColumn<Funcionario, String> colNome;

    @FXML
    private TableColumn<Funcionario, String> colEndereco;

    @FXML
    private TableColumn<Funcionario, String> colTelefone;

    @FXML
    private TextField labelNome;

    @FXML
    private TextField labelCpf;
    
    private List<Funcionario> funcionarios;
    
    private ObservableList<Funcionario> obsFuncionarios;
    
    private FuncionarioDAO funcionarioDao;

    @FXML
    void atualizaAction(ActionEvent event) {
        carregaTable();
        table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionaItemTable(newValue));
    }

    @FXML
    void pesquisaAction(ActionEvent event) {
        if(!"".equals(labelCpf.getText())){
             funcionarios = funcionarioDao.getFuncionario(labelCpf.getText());
             obsFuncionarios = FXCollections.observableArrayList(funcionarios);
             table.setItems(obsFuncionarios);
             labelNome.setText("");
         }else if(!"".equals(labelNome.getText())){
             funcionarios = funcionarioDao.getFuncionarioNome(labelNome.getText());
             obsFuncionarios = FXCollections.observableArrayList(funcionarios);
             table.setItems(obsFuncionarios);
         } else if("".equals(labelNome.getText()) && "".equals(labelCpf.getText())) {
            carregaTable();
            table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionaItemTable(newValue));
         }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        funcionarios =  new ArrayList();
        funcionarioDao = new FuncionarioDAO();
        carregaTable();
        table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionaItemTable(newValue));
    }    
    
    public void carregaTable(){
        colCpf.setCellValueFactory(new PropertyValueFactory<>("CPF"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        colTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        
        funcionarios =  funcionarioDao.getAllFuncionario();
        
        obsFuncionarios =  FXCollections.observableArrayList(funcionarios);
        table.setItems(obsFuncionarios);
    }
    
    public Funcionario selecionaItemTable(Funcionario funcionario){
        JOptionPane.showMessageDialog(null, "Funcionario: " + funcionario.getNome() + "\nCPF : " + funcionario.getCPF() + "\nEndereço : " + funcionario.getEndereco() + "\nTelefone : " + funcionario.getTelefone());
        return funcionario;
    }
    
}

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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import model.Cliente;
import model.DAO.ClienteDAO;

public class ClientePanelFormController implements Initializable{

    @FXML
    private TableView<Cliente> table;

    @FXML
    private TableColumn<Cliente, String> tableColumnCpf;

    @FXML
    private TableColumn<Cliente, String> tableColumnNome;

    @FXML
    private TableColumn<Cliente, String> tableColumnEndereco;

    @FXML
    private TableColumn<Cliente, String> tableColumnTelefone;

    @FXML
    private Button atualizarButton;

    @FXML
    private Button pesquisaButton;

    @FXML
    private TextField labelNome;

    @FXML
    private TextField labelCpf;
    
    private List<Cliente> clientes;
    
    private ObservableList<Cliente> obsClientes;
    
    private ClienteDAO clienteDao;

    @FXML
    public void atualizarAction(ActionEvent event) {
         carregarTable();
         table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionaItemTable(newValue));
    }

    @FXML
    public void pesquisaAction(ActionEvent event) {
         if(!"".equals(labelCpf.getText())){
             clientes = clienteDao.getCliente(labelCpf.getText());
             obsClientes = FXCollections.observableArrayList(clientes);
             table.setItems(obsClientes);
             labelNome.setText("");
             return;
         }else if(!"".equals(labelNome.getText())){
             clientes = clienteDao.getClienteNome(labelNome.getText());
             obsClientes = FXCollections.observableArrayList(clientes);
             table.setItems(obsClientes);
             return;
         } else if("".equals(labelNome.getText()) && "".equals(labelCpf.getText())) {
            carregarTable();
            table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionaItemTable(newValue));
         }
    }
    
    public void carregarTable(){
        tableColumnCpf.setCellValueFactory(new PropertyValueFactory<>("CPF"));
        tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        tableColumnTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        
        clientes =  clienteDao.getAllCliente();
        
        obsClientes =  FXCollections.observableArrayList(clientes);
        table.setItems(obsClientes);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clientes =  new ArrayList();
        clienteDao = new ClienteDAO();
        carregarTable();
        table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionaItemTable(newValue));
    }
    
    public Cliente selecionaItemTable(Cliente cliente){
        JOptionPane.showMessageDialog(null, "Cliente: " + cliente.getNome() + "\nCPF : " + cliente.getCPF() + "\nEndereço : " + cliente.getEndereco() + "\nTelefone : " + cliente.getTelefone());
        return cliente;
    }

}

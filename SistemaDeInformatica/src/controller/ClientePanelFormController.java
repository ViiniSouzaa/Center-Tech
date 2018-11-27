package controller;

import java.net.URL;
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
import model.ClienteGenerico;

public class ClientePanelFormController implements Initializable{    
   /* private List<Cliente> clientes;
    
    private ClienteDAO clienteDao;*/
    
    ControladorTableCliente controlador;

    @FXML
    private TableView<ClienteGenerico> table;
    
    @FXML
    private TableColumn<ClienteGenerico, String> colCpf;

    @FXML
    private TableColumn<ClienteGenerico, String> colNome;

    @FXML
    private TableColumn<ClienteGenerico, String> colEnredeco;

    @FXML
    private TableColumn<ClienteGenerico, String> colTelefone;

    @FXML
    private Button atualizarButton;

    @FXML
    private Button pesquisaButton;

    @FXML
    private TextField labelNome;

    @FXML
    private TextField labelCpf;

    @FXML
    void atualizarAction(ActionEvent event) {
        
    }

    @FXML
    void pesquisaAction(ActionEvent event) {

    }

    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        carregarTable();
        table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionaItemTable(newValue));
    }
    
        public void carregarTable(){
        controlador = new ControladorTableCliente();
        colCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colEnredeco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        colTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        
        ObservableList<ClienteGenerico> genericos = FXCollections.observableArrayList(controlador.listaClientes());
        table.setItems(genericos);
    }
    
    public void selecionaItemTable(ClienteGenerico cliente){
        JOptionPane.showMessageDialog(null, "Cliente: " + cliente.getNome() + "\nCPF : " + cliente.getCpf() + "\nEndereço : " + cliente.getEndereco() + "\nTelefone : " + cliente.getTelefone());
    }

}

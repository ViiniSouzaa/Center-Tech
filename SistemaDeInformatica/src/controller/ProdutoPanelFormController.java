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
import model.Cliente;
import model.DAO.EstoqueDAO;
import model.DAO.ProdutoDAO;
import model.Produto;
import model.Produto_Estoque;

/**
 * FXML Controller class
 *
 * @author vinicius
 */
public class ProdutoPanelFormController implements Initializable {
    
    @FXML
    private TableView<Produto_Estoque> table;

    @FXML
    private TableColumn<Produto_Estoque, Integer> colId;

    @FXML
    private TableColumn<Produto_Estoque, String> colNome;

    @FXML
    private TableColumn<Produto_Estoque, String> colMarca;

    @FXML
    private TableColumn<Produto_Estoque, Float> colPreco;

    @FXML
    private TableColumn<Produto_Estoque, Integer> colQuantidade;
    
    @FXML
    private TextField labelId;

    @FXML
    private TextField labelNome;

    @FXML
    private TextField labelMarca;
    
    List<Produto> produtos;
    
    List<Produto_Estoque> produto_Estoque;
    
    ObservableList<Produto_Estoque> obsProduto_Estoque;
    
    ProdutoDAO produtoDao;
    
    EstoqueDAO estoqueDao;
    
    @FXML
    void atualizaAction(ActionEvent event) {
        carregaTable();
        table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionaItemTable(newValue));
    }

    @FXML
    void pesquisaAction(ActionEvent event) {
        
        if(!"".equals(labelId.getText())){
            produtos = new ArrayList();
            produtos.add(produtoDao.getProduto(Integer.parseInt(labelId.getText())));
        
            produtos.forEach((produto) -> {
            produto_Estoque.add(new Produto_Estoque(produto, estoqueDao.getEstoque(produto.getId())));
            });
        
            obsProduto_Estoque = FXCollections.observableArrayList(produto_Estoque);
            table.getItems().clear();
            table.setItems(obsProduto_Estoque);
            labelMarca.setText("");
            labelNome.setText("");
            return;
         }else if(!"".equals(labelNome.getText())){
            produtos = produtoDao.getProdutoNome(labelNome.getText());
            
            produtos.forEach((produto) -> {
            produto_Estoque.add(new Produto_Estoque(produto, estoqueDao.getEstoque(produto.getId())));
            });
        
            obsProduto_Estoque = FXCollections.observableArrayList(produto_Estoque);
            table.getItems().clear();
            table.setItems(obsProduto_Estoque);
            labelMarca.setText("");
            return;
         } else if(!"".equals(labelMarca.getText())){
            produtos = produtoDao.getProdutoMarca(labelMarca.getText());
            
            produtos.forEach((produto) -> {
            produto_Estoque.add(new Produto_Estoque(produto, estoqueDao.getEstoque(produto.getId())));
            });
        
            obsProduto_Estoque = FXCollections.observableArrayList(produto_Estoque);
            table.getItems().clear();
            table.setItems(obsProduto_Estoque);
            return;
         } else if("".equals(labelNome.getText()) && "".equals(labelId.getText()) && "".equals(labelMarca.getText())) {
            carregaTable();
            table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionaItemTable(newValue));
         }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        produtos = new ArrayList<>();
        produto_Estoque = new ArrayList<>();
        produtoDao = new ProdutoDAO();
        estoqueDao = new EstoqueDAO();
        carregaTable();
        table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionaItemTable(newValue));
    }    
    
    
    public void carregaTable(){ 
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        colQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
         
        produtos =  produtoDao.getAllProduto();
        
        produtos.forEach((produto) -> {
            produto_Estoque.add(new Produto_Estoque(produto, estoqueDao.getEstoque(produto.getId())));
        });
        
        obsProduto_Estoque = FXCollections.observableArrayList(produto_Estoque);
        table.setItems(obsProduto_Estoque);
    }
    
    public Produto_Estoque selecionaItemTable(Produto_Estoque cliente){
        JOptionPane.showMessageDialog(null, "Produto: " + cliente.getId() + "\nNome : " + cliente.getNome() + "\nMarca : " + cliente.getMarca() + "\nPreco : " + cliente.getPreco() + "\nQuantidade : "+ cliente.getQuantidade());
        return cliente;
    }
}

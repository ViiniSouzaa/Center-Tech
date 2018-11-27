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
import model.DAO.EstoqueDAO;
import model.DAO.ProdutoDAO;
import model.Estoque;
import model.Produto;

/**
 * FXML Controller class
 *
 * @author vinicius
 */
public class CadastroProdutoFormController implements Initializable {

    @FXML
    private Button adicionarButton;

    @FXML
    private Button cancelarButton;

    @FXML
    private TextField labelNome;

    @FXML
    private TextField labelMarca;

    @FXML
    private TextField labelPreco;

    @FXML
    private TextField labelQuant;
    
    ProdutoDAO produtoDao =  new ProdutoDAO();
    EstoqueDAO estoqueDao = new EstoqueDAO();

    @FXML
    void adicionarAction(ActionEvent event) {
        Produto produto = new Produto();
        Estoque estoque = new Estoque();
        produto.setNome(labelNome.getText());
        produto.setMarca(labelMarca.getText());
        produto.setPreco(Float.parseFloat(labelPreco.getText()));
        produtoDao.insert(produto);
 
        estoque.setQuantidade(Integer.parseInt(labelQuant.getText()));
        estoqueDao.insert(estoque);
        
        JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void cancelarAction(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

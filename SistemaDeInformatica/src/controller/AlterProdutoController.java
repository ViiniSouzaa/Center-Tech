/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.DAO.ProdutoDAO;
import model.Produto;

/**
 * FXML Controller class
 *
 * @author vinicius
 */
public class AlterProdutoController implements Initializable {

    
    @FXML
    private Button alterarButton;

    @FXML
    private Button cancelaButton;

    @FXML
    private TextField labelId;

    @FXML
    private Button procuraButton;

    @FXML
    private TextField labelNome;

    @FXML
    private TextField labelMarca;
    
    @FXML
    private TextField labelPreco;
    
    @FXML
    private TextField labelQuantidade;
    
    ProdutoDAO produtoDao = new ProdutoDAO();
    

    @FXML
    void alterarAction(ActionEvent event) {
        Produto produto = new Produto();
        produto.setId(Integer.parseInt(labelId.getText()));
        produto.setNome(labelNome.getText());
        produto.setMarca(labelMarca.getText());
        produto.setPreco(Float.parseFloat(labelPreco.getText()));
        produto.setQuantidade(Integer.parseInt(labelQuantidade.getText()));
        produtoDao.update(produto);
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    void cancelaAction(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void procuraAction(ActionEvent event) {
        List<Produto> produtos =  produtoDao.getProduto(Integer.parseInt(labelId.getText()));
        labelNome.setText(produtos.get(0).getNome());
        labelMarca.setText(produtos.get(0).getMarca());
        labelPreco.setText(String.valueOf(produtos.get(0).getPreco()));
        labelQuantidade.setText(String.valueOf(produtos.get(0).getQuantidade()));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

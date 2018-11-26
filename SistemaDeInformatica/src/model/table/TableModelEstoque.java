/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Estoque;
import model.Produto;

/**
 *
 * @author vinicius
 */
public class TableModelEstoque extends AbstractTableModel{

    List<Estoque> list;
    List<Produto> listProd;

    public TableModelEstoque(List<Estoque> list, List<Produto> listProd) {
        this.list = list;
        this.listProd = listProd;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return list.get(rowIndex).getId_Produto();
            case 1: return listProd.get(rowIndex).getNome();
            case 2: return listProd.get(rowIndex).getMarca();
            case 3: return list.get(rowIndex).getQuantidade();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "IDProduto";
            case 1: return "Nome";
            case 2: return "Marca";
            case 3: return "Quantidade em estoque";
            default : return null;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Produto;

/**
 *
 * @author vinicius
 */
public class TableModelProduto extends AbstractTableModel {
    List<Produto> list;

    public TableModelProduto(List<Produto> list) {
        this.list = list;
    }
    
    
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return list.get(rowIndex).getId();
            case 1: return list.get(rowIndex).getNome();
            case 2: return list.get(rowIndex).getMarca();
            case 3: return list.get(rowIndex).getPreco();
            default : return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Id";
            case 1: return "Nome";
            case 2: return "Descrição";
            case 3: return "Preço";
            case 4: return "Quantidade";
            default : return null;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Venda;

/**
 *
 * @author vinicius
 */
public class TableModelVenda extends AbstractTableModel{

    List<Venda> list;

    public TableModelVenda(List<Venda> list) {
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
        switch(columnIndex){
            case 0: return list.get(rowIndex).getId();
            case 1: return list.get(rowIndex).getCpfFuncionario();
            case 2: return list.get(rowIndex).getCpfCliente();
            case 3: return list.get(rowIndex).getIdProduto();
            case 4: return list.get(rowIndex).getQuant();
            default : return null;
        }
        
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Id";
            case 1: return "Cpf Cliente";
            case 2: return "Cpf Funcionario";
            case 3: return "Id Produto";
            case 4: return "Quant";
            default : return null;      
        }
    }
}

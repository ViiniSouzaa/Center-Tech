/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Funcionario;

/**
 *
 * @author vinicius
 */
public class TableModelFuncionario extends AbstractTableModel{
    List<Funcionario> list;

    public TableModelFuncionario(List<Funcionario> list) {
        this.list = list;
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
        switch (columnIndex){
            case 0: return list.get(rowIndex).getCPF();
            case 1: return list.get(rowIndex).getNome();
            case 2: return list.get(rowIndex).getEndereco();
            case 3: return list.get(rowIndex).getTelefone();
            default : return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "CPF";
            case 1: return "Nome";
            case 2: return "Endereço";
            case 3: return "Telefone";
            default : return null;
        }
    }
}

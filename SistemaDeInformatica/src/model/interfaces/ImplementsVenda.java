package model.interfaces;

import java.util.List;
import model.Venda;

/**
 *
 * @author vinicius
 */
public interface ImplementsVenda {
    public void insert(Venda notaFiscal);
    
    public void update(Venda notaFiscal);
    
    public void delete(int id);
    
    public List<Venda> getVenda(int id);
    
    public List<Venda> getAllVenda();
}

package model;

public class Venda {
    int id;
    String cpfCliente;
    String cpfFuncionario;
    int idProduto;
    int quant;

    public Venda(int id, String cpfCliente, String cpfFuncionario, int idProduto, int quant) {
        this.id = id;
        this.cpfCliente = cpfCliente;
        this.cpfFuncionario = cpfFuncionario;
        this.idProduto = idProduto;
        this.quant = quant;
    }

    public Venda() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }
    
    
}

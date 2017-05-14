package br.senac.tads3.pi03b.projetoautomata.models;

public class ItemServico {
    private int id;
    private int idTecnico;
    private String idServico;
    private int idServicoPrestado;
    private String DataServico;
    private int idVenda;
    private double valorTotal;
    private double valorUnitario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getIdServico() {
        return idServico;
    }

    public void setIdServico(String idServico) {
        this.idServico = idServico;
    }

    public String getDataServico() {
        return DataServico;
    }

    public void setDataServico(String DataServico) {
        this.DataServico = DataServico;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getIdServicoPrestado() {
        return idServicoPrestado;
    }

    public void setIdServicoPrestado(int idServicoPrestado) {
        this.idServicoPrestado = idServicoPrestado;
    }
}

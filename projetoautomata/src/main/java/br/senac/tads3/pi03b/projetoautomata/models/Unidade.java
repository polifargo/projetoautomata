package br.senac.tads3.pi03b.projetoautomata.models;

/**
 *
 * @author matheus_santo
 */
public class Unidade {

    private int id;
    private String endereco;
    private String nome;
    private String razao;
    private String cadastroNacional;

    public Unidade(int id, String endereco, String nome, String razao, String cadastroNacional) {
        this.id = id;
        this.endereco = endereco;
        this.nome = nome;
        this.razao = razao;
        this.cadastroNacional = cadastroNacional;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getCadastroNacional() {
        return cadastroNacional;
    }

    public void setCadastroNacional(String cadastroNacional) {
        this.cadastroNacional = cadastroNacional;
    }

}

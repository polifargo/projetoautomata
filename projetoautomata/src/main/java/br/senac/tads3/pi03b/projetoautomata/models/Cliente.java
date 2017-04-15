package br.senac.tads3.pi03b.projetoautomata.models;

/**
 *
 * @author matheus_santo
 */
public class Cliente {

    private int id;
    private String nome;
    private String tipo;
    private String cadastroNacional;
    private String endereco;
    private String email;
    private String telefone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCadastroNacional() {
        return cadastroNacional;
    }

    public void setCadastroNacional(String cadastroNacional) {
        this.cadastroNacional = cadastroNacional;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

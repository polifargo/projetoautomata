package br.senac.tads3.pi03b.projetoautomata.models;

/**
 *
 * @author matheus_santo
 */
public class Cliente {

    private long id;
    private String nome;
    private String tipo;
    private String cadastroNacional;
    private String endereco;
    private String email;
    private String telefone;

    public Cliente(long id, String nome, String tipo, String cadastroNacional,
            String endereco, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.cadastroNacional = cadastroNacional;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }

    public Cliente(String nome, String tipo, String cadastroNacional,
            String endereco, String email, String telefone) {
        this.nome = nome;
        this.tipo = tipo;
        this.cadastroNacional = cadastroNacional;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

package br.senac.tads3.pi03b.projetoautomata.models;

/**
 *
 * @author matheus_santo
 */
public class Unidade {

    private String id;
    private String fantasia;
    private String razao;
    private String uf;
    private String cep;
    private String cidade;
    private String logradouro;
    private String bairro;
    private String email;
    private String telefone;
    private String notasInternas;
    private int inativo;
    private String cadastroNacional;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
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

    public String getNotasInternas() {
        return notasInternas;
    }

    public void setNotasInternas(String notasInternas) {
        this.notasInternas = notasInternas;
    }

    public int getInativo() {
        return inativo;
    }

    public void setInativo(int inativo) {
        this.inativo = inativo;
    }

    public String getCadastroNacional() {
        return cadastroNacional;
    }

    public void setCadastroNacional(String cadastroNacional) {
        this.cadastroNacional = cadastroNacional;
    }

}

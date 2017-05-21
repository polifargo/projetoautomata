/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi03b.projetoautomata.models;

import java.util.LinkedHashMap;
import java.util.Map;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author mathe
 */
public class Usuario {

    private final static Map<String, Usuario> USUARIOS_CADASTRADOS;

    static {
        USUARIOS_CADASTRADOS = new LinkedHashMap<>();
        USUARIOS_CADASTRADOS.put("admin", new Usuario("admin",
                "Administrador", "admin", "ADMIN"));
        USUARIOS_CADASTRADOS.put("retaguarda", new Usuario("retaguarda",
                "Retaguarda", "retaguarda", "MEDIO"));
        USUARIOS_CADASTRADOS.put("loja", new Usuario("loja",
                "Vendedor", "loja", "BASICO"));
    }

    private int id;
    private String login;
    private String nome;
    private String senha;
    private String hashSenha;
    private String papel;
    private String email;

    public Usuario() {
    }

    public Usuario(String usuario, String nome, String senha, String papel) {
        this.login = usuario;
        this.nome = nome;
        this.setHashSenha(senha);
        this.setSenha(senha);
        this.papel = papel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHashSenha() {
        return hashSenha;
    }

    public final void setHashSenha(String senha) {
        this.hashSenha = BCrypt.hashpw(senha, BCrypt.gensalt());
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void cadastrarUsuario() {
        USUARIOS_CADASTRADOS.put(this.getLogin(), new Usuario(this.getLogin(),
                this.getNome(), this.getSenha(), this.getPapel()));
    }

    public boolean temPapel(String papel) {
        return (this.papel.equalsIgnoreCase(papel));
    }

    public static Usuario obterUsuario(String usuario, String senha) {
        Usuario usuarioEncontrado = USUARIOS_CADASTRADOS.get(usuario);
        if (usuarioEncontrado != null && BCrypt.checkpw(senha, usuarioEncontrado.getHashSenha())) {
            return usuarioEncontrado;
        }
        return null;
    }
}

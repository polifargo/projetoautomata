/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi03b.projetoautomata.models;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author mathe
 */
public class UsuarioSistema {

    private static Map<String, UsuarioSistema> USUARIOS_CADASTRADOS;
    static {
        USUARIOS_CADASTRADOS = new LinkedHashMap<>();
        USUARIOS_CADASTRADOS.put("admin", new UsuarioSistema("admin",
                "Administrador", "admin", "ADMIN"));
    }
    
    private int id;
    private String usuario;
    private String nomeCompleto;
    private String hashSenha;
    private String papel; // ROLES
    private String email;

    public UsuarioSistema() {
    }

    public UsuarioSistema(String usuario, String nomeCompleto, String senha, String papel) {
        this.usuario = usuario;
        this.nomeCompleto = nomeCompleto;
        setSenha(senha);
        this.papel = papel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getHashSenha() {
        return hashSenha;
    }

    public final void setSenha(String senha) {
        this.hashSenha = BCrypt.hashpw(senha, BCrypt.gensalt());
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

    public void cadastrarUsuario(String senha) {
        USUARIOS_CADASTRADOS = new LinkedHashMap<>();
        USUARIOS_CADASTRADOS.put(this.getUsuario(), new UsuarioSistema(this.getUsuario(),
                this.getNomeCompleto(), senha, this.getPapel()));
    }

    public boolean temPapel(String papel) {
        List<String> papeisUsuario = Arrays.asList(papel);
        return papeisUsuario.contains(papel);
    }

    public static UsuarioSistema obterUsuario(String usuario, String senha) {
        UsuarioSistema usuarioEncontrado = USUARIOS_CADASTRADOS.get(usuario);
        if (usuarioEncontrado != null && BCrypt.checkpw(senha, usuarioEncontrado.getHashSenha())) {
            return usuarioEncontrado;
        }
        return null;
    }
}

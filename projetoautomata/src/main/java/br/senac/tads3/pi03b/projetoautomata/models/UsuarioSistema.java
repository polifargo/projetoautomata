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

    private static final Map<String, UsuarioSistema> USUARIOS_CADASTRADOS;

    static {
        USUARIOS_CADASTRADOS = new LinkedHashMap<>();
        USUARIOS_CADASTRADOS.put("admin", new UsuarioSistema("admin",
                "Administrador", "admin", new String[]{"BASICO", "ADMIN"}));
        USUARIOS_CADASTRADOS.put("retaguarda", new UsuarioSistema("retaguarda",
                "Retaguarda", "retaguarda", new String[]{"BASICO"}));
    }

    private String usuario;

    private String nomeCompleto;

    private String hashSenha;

    private String[] papeis; // ROLES

    public UsuarioSistema() {

    }

    public UsuarioSistema(String usuario, String nomeCompleto, String senha, String[] papeis) {
        this.usuario = usuario;
        this.nomeCompleto = nomeCompleto;
        setSenha(senha);
        this.papeis = papeis;
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

    public String[] getPapeis() {
        return papeis;
    }

    public void setPapeis(String[] papeis) {
        this.papeis = papeis;
    }

    public boolean temPapel(String papel) {
        List<String> papeisUsuario = Arrays.asList(papeis);
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

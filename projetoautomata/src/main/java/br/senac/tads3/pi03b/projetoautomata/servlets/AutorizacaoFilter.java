/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi03b.projetoautomata.servlets;

import br.senac.tads3.pi03b.projetoautomata.models.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author matheus_santo1
 */
@WebFilter(filterName = "AutorizacaoFilter",
        servletNames = {"ClienteServlet", "ProdutoServlet", "UnidadeServlet", "ServicoServlet", "VendaServlet", 
            "UsuarioServlet", "PrestacaoServicoServlet", "EstoqueServlet"},
        urlPatterns = {"/protegido/*"}
)
public class AutorizacaoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 1) Verificar se usuário está autenticado
        // 1a) Cast dos objetos request e response
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // 2) Tenta obter a sessao do usuario
        HttpSession sessao = httpRequest.getSession();
        Usuario usuario
                = (Usuario) sessao.getAttribute("usuario");

        // Usuario nulo significa que não está logado
        // Redireciona para tela de login
        if (usuario == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            return;
        }

        // 3) Usuario está logado, então verifica se tem permissão
        // para acessar a página.
        if (verificarAcesso(usuario, httpRequest, httpResponse)) {
            // Acesso a página está liberado.
            chain.doFilter(request, response);
        } else {
            // Usuário não tem permissão de acesso a página.
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/naoautorizado");
        }
    }

    private static boolean verificarAcesso(Usuario usuario,
            HttpServletRequest request, HttpServletResponse response) {
        String paginaAcessada = request.getRequestURI();
        String pagina = paginaAcessada.replace(request.getContextPath(), "");

        if (pagina.contains("produtos") && usuario.temPapel("MEDIO")) {
            return true;
        } else if (pagina.contains("produtos") && usuario.temPapel("ADMIN")) {
            return true;
        } else if (pagina.contains("clientes") && usuario.temPapel("MEDIO")) {
            return true;
        } else if (pagina.contains("clientes") && usuario.temPapel("BASICO")) {
            return true;
        } else if (pagina.contains("clientes") && usuario.temPapel("ADMIN")) {
            return true;
        } else if (pagina.contains("unidades") && usuario.temPapel("ADMIN")) {
            return true;
        } else if (pagina.contains("usuarios") && usuario.temPapel("ADMIN")) {
            return true;
        } else if (pagina.contains("venda") && usuario.temPapel("ADMIN")) {
            return true;
        } else if (pagina.contains("venda") && usuario.temPapel("BASICO")) {
            return true;
        } else if (pagina.contains("servicos") && usuario.temPapel("MEDIO")) {
            return true;
        } else if (pagina.contains("prestacaoservico") && usuario.temPapel("BASICO")) {
            return true;
        } else if (pagina.contains("prestacaoservico") && usuario.temPapel("ADMIN")) {
            return true;
        } else {
            return pagina.contains("servicos") && usuario.temPapel("ADMIN");
        }
    }

    @Override
    public void destroy() {

    }

}

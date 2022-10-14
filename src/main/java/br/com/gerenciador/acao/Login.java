package br.com.gerenciador.acao;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login implements Acao {

    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        System.out.println("logado " + login);

        Banco banco = new Banco();
        Usuario usuario = banco.existeUsuario(login, senha);

        if(usuario != null) {
            System.out.println("Usuário existe");
            return "redirect:entrada?acao=ListaEmpresas";
        } else {
            return "redirect:entrada?acao=LoginForm";
        }
    }
}

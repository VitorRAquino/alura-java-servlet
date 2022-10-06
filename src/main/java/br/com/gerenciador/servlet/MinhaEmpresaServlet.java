package br.com.gerenciador.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MinhaEmpresaServlet", value = "/novaEmpresa")
public class MinhaEmpresaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Cadastrando nova Empresa");

        String nomeEmpresa = req.getParameter("nome");
        Empresa empresa = new Empresa();
        empresa.setNome(nomeEmpresa);

        Banco banco = new Banco();
        banco.adiciona(empresa);

       RequestDispatcher rd = req.getRequestDispatcher("/novaEmpresaCriada.jsp");
       req.setAttribute("empresa", empresa.getNome());
       rd.forward(req, resp);
    }
}

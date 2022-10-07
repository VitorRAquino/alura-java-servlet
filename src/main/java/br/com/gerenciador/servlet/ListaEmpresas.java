package br.com.gerenciador.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ListaEmpresas", value = "/ListaEmpresas")
public class ListaEmpresas extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Banco banco = new Banco();
        List<Empresa> lista = banco.getEmpresas();

        RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresa.jsp");
        request.setAttribute("empresas", lista);
        rd.forward(request, response);
    }
}

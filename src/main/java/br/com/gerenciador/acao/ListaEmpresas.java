package br.com.gerenciador.acao;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListaEmpresas {
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("listando empresas");

        Banco banco = new Banco();
        List<Empresa> lista = banco.getEmpresas();

        RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");

        request.setAttribute("empresas", lista);
        rd.forward(request, response);
    }
}

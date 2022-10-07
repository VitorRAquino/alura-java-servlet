package br.com.gerenciador.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "MinhaEmpresaServlet", value = "/novaEmpresa")
public class MinhaEmpresaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Cadastrando nova Empresa");

        String nomeEmpresa = req.getParameter("nome");
        String dataEmpresa = req.getParameter("data");

        Date dataEmpresaAsDate = null;
        Empresa empresa = null;
        Banco banco = null;
        String error = null;

        RequestDispatcher rd = req.getRequestDispatcher("/novaEmpresaCriada.jsp");

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataEmpresaAsDate = sdf.parse(dataEmpresa);

            empresa = new Empresa();
            empresa.setNome(nomeEmpresa);

            banco = new Banco();
            banco.adiciona(empresa);

            req.setAttribute("empresa", empresa.getNome());

        } catch (ParseException e) {
            error = e.getMessage();
            req.setAttribute("error", error);
        }

        rd.forward(req, resp);
    }
}

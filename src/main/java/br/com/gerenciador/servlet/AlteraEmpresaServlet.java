package br.com.gerenciador.servlet;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AlteraEmpresa", value = "/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String nomeEmpresa = req.getParameter("nome");
        String dataEmpresa = req.getParameter("data");
        String paramId = req.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        Date dataEmpresaAsDate = null;
        Empresa empresa = null;
        Banco banco = null;
        String error = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataEmpresaAsDate = sdf.parse(dataEmpresa);

            banco = new Banco();
            empresa = banco.buscaEmpresaPorId(id);
            empresa.setNome(nomeEmpresa);
            empresa.setDataAbertura(dataEmpresaAsDate);

            resp.sendRedirect("listaEmpresas");


        } catch (ParseException e) {
            error = e.getMessage();
            req.setAttribute("error", error);
        }


    }
}

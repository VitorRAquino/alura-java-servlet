package br.com.gerenciador.acao;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AlteraEmpresa implements Acao{

    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("alterando dados da empresa");

        String nomeEmpresa = request.getParameter("nome");
        String dataEmpresa = request.getParameter("data");
        String paramId = request.getParameter("id");
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




        } catch (ParseException e) {
            error = e.getMessage();
            request.setAttribute("error", error);
        }


        return "redirect:entrada?acao=ListaEmpresas";
    }
}

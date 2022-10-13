package br.com.gerenciador.acao;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NovaEmpresa implements Acao {

    public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String nomeEmpresa = request.getParameter("nome");
        String dataEmpresa = request.getParameter("data");

        Date dataEmpresaAsDate = null;
        Empresa empresa = null;
        Banco banco = null;
        String error = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataEmpresaAsDate = sdf.parse(dataEmpresa);

            empresa = new Empresa();
            empresa.setNome(nomeEmpresa);
            empresa.setDataAbertura(dataEmpresaAsDate);

            banco = new Banco();
            banco.adiciona(empresa);

            request.setAttribute("empresa", empresa.getNome());

        } catch (ParseException e) {
            error = e.getMessage();
            request.setAttribute("error", error);
        }

        return "redirect:entrada?acao=ListaEmpresas";
    }
}

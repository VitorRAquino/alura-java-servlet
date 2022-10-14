package br.com.gerenciador.acao;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NovaEmpresaForm implements Acao {

    public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {

        return "forward:formNovaEmpresa.jsp";
    }
}

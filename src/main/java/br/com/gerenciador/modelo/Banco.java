package br.com.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
    private static List<Empresa> lista = new ArrayList<Empresa>();
    private static List<Usuario> listaUsuarios = new ArrayList<Usuario>();
    private static Integer idSequencial = 1;

    static {
        Empresa empresa = new Empresa();
        empresa.setId(idSequencial++);
        empresa.setNome("Samsung");

        Empresa empresa2 = new Empresa();
        empresa2.setId(idSequencial++);
        empresa2.setNome("Apple");

        lista.add(empresa);
        lista.add(empresa2);


        Usuario u1 = new Usuario();
        u1.setLogin("vitor");
        u1.setSenha("12345");

        Usuario u2 = new Usuario();
        u2.setLogin("davi");
        u2.setSenha("12345");

        listaUsuarios.add(u1);
        listaUsuarios.add(u2);
    }

    public void adiciona(Empresa empresa) {
        empresa.setId(Banco.idSequencial++);
        Banco.lista.add(empresa);
    }

    public List<Empresa> getEmpresas() {
        return Banco.lista;
    }

    public void removeEmpresa(Integer id) {

        Iterator<Empresa> it = lista.iterator();

        while (it.hasNext()) {
            Empresa emp = it.next();

            if (emp.getId() == id) {
                it.remove();
            }
        }
    }

    public Empresa buscaEmpresaPorId(Integer id) {
        for (Empresa empresa : lista) {
            if (empresa.getId() == id) {
                return empresa;
            }

        }

        return null;
    }

    public Usuario existeUsuario(String login, String senha) {
        for (Usuario usuario : listaUsuarios) {

            System.out.println(usuario);
            System.out.println(usuario.getLogin());
            System.out.println(usuario.getSenha());

            if (usuario.ehIgual(login , senha)) {
                return usuario;
            }
        }
        return null;
    }
}

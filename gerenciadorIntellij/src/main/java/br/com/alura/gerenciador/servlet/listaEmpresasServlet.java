package br.com.alura.gerenciador.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/listaEmpresas")
public class listaEmpresasServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Banco banco = new Banco();
        Empresa empresa = new Empresa(req.getParameter("nome"));
        banco.adiciona(empresa);
        List<Empresa> list = banco.getEmpresas();


        //chamar o jsp
        req.setAttribute("empresas",list);
        RequestDispatcher rd = req.getRequestDispatcher("/listaEmpresasjsp.jsp");
        rd.forward(req,resp);
    }
}

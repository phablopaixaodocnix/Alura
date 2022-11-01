package br.com.alura.gerenciador.servlet;

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Banco banco = new Banco();
        List<Empresa> list = banco.getEmpresas();
        list.add(new Empresa(req.getParameter("nome")));
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<ul>");
        for (int i = 0 ; i < list.size();i++) out.println("<li>"+list.get(i).getNome()+"</li>");
        out.println("</ul>");
        out.println("</body></html>");

    }
}

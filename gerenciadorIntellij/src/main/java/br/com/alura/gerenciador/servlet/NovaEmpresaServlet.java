package br.com.alura.gerenciador.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/NovaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String nome = req.getParameter("nome");//pegando o parametro atravéz da url

        Empresa empresa = new Empresa();
        empresa.setNome(nome);

        Banco banco = new Banco();
        banco.adiciona(empresa);

        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html><body>Empresa "+nome + " cadastrada com sucesso</body></html>");
    }
}

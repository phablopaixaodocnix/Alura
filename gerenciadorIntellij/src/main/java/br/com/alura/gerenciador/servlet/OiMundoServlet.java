package br.com.alura.gerenciador.servlet;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/oi")
public class OiMundoServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter output = res.getWriter();
        output.println("<html>"); //este print imprime no fluxo de resposta para o navegador, não no console
        output.println("<body>");
        output.println("parabens deu certo");
        output.println("</body>");
        output.println("</html>");

    }
}

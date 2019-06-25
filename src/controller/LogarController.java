
package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Funcionario;

@WebServlet(name = "LoginController", urlPatterns = "/LoginController")
public class LogarController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        RequestDispatcher view = null;
        String mensagem = "ok";

        Funcionario funcionario = (Funcionario)Funcionario.findByParameter(login, "cpf");
        if (funcionario == null) {
            mensagem = "erro";
            request.setAttribute("mensagem", mensagem);
            view = request.getRequestDispatcher("index.jsp");
        } else if (!senha.equals(funcionario.getSenha())) {
            mensagem = "erro";
            request.setAttribute("mensagem", mensagem);
            view = request.getRequestDispatcher("index.jsp");

        } else {
            HttpSession session = request.getSession();
            session.setAttribute("id", funcionario.getId());
            session.setAttribute("cargo", funcionario.getCargo());
            session.setAttribute("nome", funcionario.getNome());
            request.setAttribute("mensagem", mensagem);
            view = request.getRequestDispatcher("HomeController");
        }
        view.forward(request, response);

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

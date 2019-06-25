
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Ferramenta;
import model.Fornecedor;


@WebServlet(name = "ManterFerramentaController", urlPatterns = "/ManterFerramentaController")
public class ManterFerramentaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, NoSuchMethodException {
        String acao = request.getParameter("acao");
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        } else {
            if (acao.equals("prepararOperacao")) {
                prepararOperacao(request, response);
            }
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String operacao = request.getParameter("operacao");
        request.setAttribute("operacao", operacao);
        request.setAttribute("fornecedores", Fornecedor.findAll());
        if (!operacao.equals("Incluir")) {
            Ferramenta ferramenta = Ferramenta.find(Long.parseLong(request.getParameter("id")));
            request.setAttribute("ferramenta", ferramenta);

        }
        request.getRequestDispatcher("cadastroFerramenta.jsp").forward(request, response);

    }

    protected void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, NoSuchMethodException, ClassNotFoundException {
        String operacao = request.getParameter("operacao");
        String nome = request.getParameter("nome");
        String tipo = request.getParameter("tipo");
        Double valorUnitario = Double.parseDouble(request.getParameter("valorUnitario"));
        Double qtdEstoque = Double.parseDouble(request.getParameter("qtdEstoque"));
        String unidade = request.getParameter("unidade");
        Long idFornecedor = Long.parseLong(request.getParameter("idFornecedor"));
        Long idFerramenta = null;
        if (!operacao.equals("Incluir")) {
            idFerramenta = Long.parseLong(request.getParameter("idFerramenta").trim());
        }

        try {
            Fornecedor fornecedor = null;
            if (idFornecedor != 0) {
                fornecedor = Fornecedor.find(idFornecedor);
            }
            Ferramenta ferramenta = new Ferramenta(nome, tipo, valorUnitario, qtdEstoque, unidade, fornecedor);
            if (operacao.equals("Incluir")) {
                ferramenta.save();
            } else if (operacao.equals("Editar")) {
                ferramenta.setId(idFerramenta);
                ferramenta.save();
                System.out.println("Bring edit");
            } else if (operacao.equals("Excluir")) {
                ferramenta.setId(idFerramenta);
                ferramenta.remove();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaController?classe=Ferramenta");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (ServletException e) {
            throw e;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            try {
                processRequest(request, response);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(ManterFerramentaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManterFerramentaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterFerramentaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            try {
                processRequest(request, response);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(ManterFerramentaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManterFerramentaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterFerramentaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

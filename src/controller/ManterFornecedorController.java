
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Fornecedor;


@WebServlet(name = "ManterFornecedorController", urlPatterns = "/ManterFornecedorController")
public class ManterFornecedorController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, NoSuchMethodException {
        try {
            String acao = request.getParameter("acao");
            if (acao.equals("confirmarOperacao")) {
                confirmarOperacao(request, response);
            } else {
                if (acao.equals("prepararOperacao")) {
                    prepararOperacao(request, response);
                }
            }
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException, ClassNotFoundException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            if (!operacao.equals("Incluir")) {
                Long idFornecedor = Long.parseLong(request.getParameter("id"));
                Fornecedor fornecedor = Fornecedor.find(idFornecedor);
                request.setAttribute("fornecedor", fornecedor);
            }
            RequestDispatcher view = request.getRequestDispatcher("cadastroFornecedor.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        }
    }

    protected void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, NoSuchMethodException {
        String operacao = request.getParameter("operacao");
        String nome = request.getParameter("nome");
        String cnpj = request.getParameter("cnpj");
        String email = request.getParameter("email");
        String cep = request.getParameter("cep");
        String logradouro = request.getParameter("logradouro");
        String numero = request.getParameter("numero");
        String complemento = request.getParameter("complemento");
        String bairro = request.getParameter("bairro");
        String uf = request.getParameter("uf");
        String cidade = request.getParameter("cidade");
        String telefone = request.getParameter("telefone");
        String celular = request.getParameter("celular");
        Long id = null;
        if (!operacao.equals("Incluir")) {
            id = Long.parseLong(request.getParameter("id"));
        }

        try {
            Fornecedor fornecedor = new Fornecedor(nome, cnpj, email, cep, logradouro, numero, complemento, bairro, uf, cidade, telefone, celular);
            if (operacao.equals("Incluir")) {
                fornecedor.save();
            } else if (operacao.equals("Editar")) {
                fornecedor.setId(id);
                fornecedor.save();
            } else if (operacao.equals("Excluir")) {
                fornecedor.setId(id);
                fornecedor.remove();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaController?classe=Fornecedor");
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
                Logger.getLogger(ManterFornecedorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManterFornecedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            try {
                processRequest(request, response);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(ManterFornecedorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManterFornecedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

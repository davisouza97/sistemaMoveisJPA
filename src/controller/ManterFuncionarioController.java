/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FuncionarioDAO;
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
import model.Funcionario;

/**
 *
 * @author Walter
 */
@WebServlet(name = "ManterFuncionarioController", urlPatterns = "/ManterFuncionarioController")
public class ManterFuncionarioController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException, NoSuchMethodException {
        String acao = request.getParameter("acao");
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        } else if (acao.equals("prepararOperacao")) {
            prepararOperacao(request, response);
        }
    }

    protected void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String operacao = request.getParameter("operacao");
        request.setAttribute("operacao", operacao);
        if (operacao.equalsIgnoreCase("Editar") || operacao.equalsIgnoreCase("Excluir")) {
            Funcionario funcionario = Funcionario.find(Long.parseLong(request.getParameter("id")));
            request.setAttribute("funcionario", funcionario);

        }
        request.getRequestDispatcher("cadastroFuncionario.jsp").forward(request, response);
    }

    protected void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, NoSuchMethodException {
        String operacao = request.getParameter("operacao");
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String dataNascimento = request.getParameter("dataNascimento");
        String email = request.getParameter("email");
        String cep = request.getParameter("cep");
        String logradouro = request.getParameter("logradouro");
        String numero = request.getParameter("numero");
        String complemento = request.getParameter("complemento");
        String bairro = request.getParameter("bairro");
        String uf = request.getParameter("uf");
        String cidade = request.getParameter("cidade");
        String cargo = request.getParameter("cargo");
        double salario = Double.parseDouble(request.getParameter("salario").trim());
        String comissao = request.getParameter("comissao");
        String senha = request.getParameter("senha");
        String telefone = request.getParameter("telefone");
        String celular = request.getParameter("celular");
        Long id = null;
        if (operacao.equals("Editar") || operacao.equals("Excluir")) {
            id = Long.parseLong(request.getParameter("id").trim());
        }

        try {
            Funcionario funcionario = new Funcionario(cargo, salario, comissao, senha, nome, cpf, dataNascimento, email, cep, logradouro, numero, complemento, bairro, uf, cidade, telefone, celular);
            if (operacao.equals("Incluir") || operacao.equals("Cadastrar")) {
                funcionario.save();
            } else if (operacao.equals("Editar")) {
                funcionario.setId(id);
                funcionario.save();
            } else if (operacao.equals("Excluir")) {
                funcionario.setId(id);
                funcionario.remove();
            }
            RequestDispatcher view = null;
            if (!operacao.equals("Cadastrar")) {
                view = request.getRequestDispatcher("PesquisaFuncionarioController");
            } else {
                view = request.getRequestDispatcher("DeslogarController");
            }

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
                Logger.getLogger(ManterFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManterFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            try {
                processRequest(request, response);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(ManterFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManterFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

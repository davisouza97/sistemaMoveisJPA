/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Fornecedor;
import model.Material;

/**
 *
 * @author Walter
 */
@WebServlet(name = "ManterMaterialController", urlPatterns = "/ManterMaterialController")
public class ManterMaterialController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String acao = request.getParameter("acao");
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        } else {
            if (acao.equals("prepararOperacao")) {
                prepararOperacao(request,response);
            }
        }

    }

    protected void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String operacao = request.getParameter("operacao");
        request.setAttribute("operacao", operacao);
        request.setAttribute("fornecedores", Fornecedor.findAll());
        if (!operacao.equals("Incluir")) {
           Material material = Material.find(Long.parseLong(request.getParameter("id")));
           request.setAttribute("material", material);
          
        }
        request.getRequestDispatcher("cadastroMaterial.jsp").forward(request, response);
    }
    
     protected void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        String operacao = request.getParameter("operacao");
         String nome = request.getParameter("nome");
         String tipo = request.getParameter("tipo");
         Double valorUnitario = Double.parseDouble(request.getParameter("valorUnitario"));
         Double qtdEstoque = Double.parseDouble(request.getParameter("qtdEstoque"));
         String unidade = request.getParameter("unidade");
         Long idFornecedor = Long.parseLong(request.getParameter("id"));
       
        try{
            Fornecedor fornecedor = null;
            if(idFornecedor != 0){
                fornecedor = Fornecedor.find(idFornecedor);
            }
            Material material = new Material(nome, tipo, valorUnitario, qtdEstoque, unidade, fornecedor);
            if(operacao.equals("Incluir")){
                material.save();
            }else if(operacao.equals("Editar")){
                material.save();
            }else if(operacao.equals("Excluir")){
                material.remove();
            }
            request.getRequestDispatcher("PesquisaMaterialController").forward(request, response);
        }catch(IOException e){
            throw new ServletException(e);
        }catch(ServletException e){
            throw e;
        }
        
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

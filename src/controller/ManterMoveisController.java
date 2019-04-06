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
import model.Funcionario;
import model.Material;
import model.Movel;
import model.Pedido;

@WebServlet(name = "ManterMoveisController", urlPatterns = "/ManterMoveisController")
public class ManterMoveisController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
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
        request.setAttribute("pedidos", Pedido.findAll());
        request.setAttribute("materiais", Material.findAll());
        if (!operacao.equals("Incluir")) {
            Movel movel = Movel.find(Long.parseLong(request.getParameter("id")));
            request.setAttribute("movel", movel);

        }
        request.getRequestDispatcher("cadastroMoveis.jsp").forward(request, response);

    }

    protected void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String operacao = request.getParameter("operacao");
        String nome = request.getParameter("nome");
        double preco = Double.parseDouble(request.getParameter("preco"));
        String tipo = request.getParameter("tipo");
        double altura = Double.parseDouble(request.getParameter("altura"));
        double largura = Double.parseDouble(request.getParameter("largura"));
        double comprimento = Double.parseDouble(request.getParameter("comprimento"));
        double peso = Double.parseDouble(request.getParameter("peso"));

        Long idMaterial = Long.parseLong(request.getParameter("idMaterial"));

       
        Long idPedido = Long.parseLong(request.getParameter("idPedidoMovel"));
      

        Long idMovel = null;
        if (!operacao.equals("Incluir")) {
            idMovel = Long.parseLong(request.getParameter("id"));
        }

        try {
            Material material = null;
            if (idMaterial != 0) {
                material = Material.find(idMaterial);
            }
            Pedido pedido = null;
            if (idPedido != 0) {
                pedido = Pedido.find(idPedido);
            }
            Movel movel = new Movel(nome, preco, tipo, altura, largura, comprimento, peso, material, pedido);
            if (operacao.equals("Incluir")) {
                movel.save();
            } else if (operacao.equals("Editar")) {
                movel.setId(idMovel);
                movel.save();
                System.out.println("Bring edit");
            } else if (operacao.equals("Excluir")) {
                movel.setId(idMovel);
                movel.remove();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaMovelController");
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
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterMoveisController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterMoveisController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterMoveisController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterMoveisController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

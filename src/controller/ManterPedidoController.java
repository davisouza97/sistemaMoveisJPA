package controller;

import dao.GeralDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Funcionario;
import model.Movel;
import model.MovelPedido;
import model.Pedido;
import utils.Strings;

@WebServlet(name = "ManterPedidoController", urlPatterns = "/ManterPedidoController")
public class ManterPedidoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException, ParseException, NoSuchMethodException {
        String acao = request.getParameter("acao");
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        } else if (acao.equals("prepararOperacao")) {
            prepararOperacao(request, response);
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String operacao = Strings.getOperacao(request);
        request.setAttribute("operacao", operacao);
        request.setAttribute("clientes", Cliente.findAll());
        request.setAttribute("moveis", Movel.findAll());
        request.setAttribute("funcionarios", Funcionario.findAll());
        if (!operacao.equals("Incluir")) {
            Pedido pedido = Pedido.find(Long.parseLong(request.getParameter("id")));
            request.setAttribute("pedido", pedido);
            request.setAttribute("moveisDoPedido", pedido.getMovelPedidos());
        }
        request.getRequestDispatcher("cadastroPedido.jsp").forward(request, response);
    }

    protected void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, ParseException, ClassNotFoundException, NoSuchMethodException {
        String operacao = request.getParameter("operacao");
        Long idFuncionario = Long.parseLong(request.getParameter("idFuncionario"));
        Long idCliente = Long.parseLong(request.getParameter("idCliente"));
        String dtCriado = request.getParameter("dataCriacao");
        String dtEntrega = request.getParameter("dataPrevista");
        Long id = null;
        int qtdMoveis = Movel.findAll().size();
        ArrayList<String> listaIdDosMoveis = new ArrayList();
        ArrayList<String> listaQuantidadePorMovel = new ArrayList();
        for (int i = 1; i <= qtdMoveis; i++) {
            String aux = request.getParameter("id" + i);
            if (aux == null) {
                break;
            }
            listaIdDosMoveis.add(aux);   //id dos moveis
        }
        for (int i = 1; i <= qtdMoveis; i++) {
            String aux = request.getParameter("qtd" + i);
            if (aux == null) {
                break;
            }
            listaQuantidadePorMovel.add(aux);   //qunatidade dos moveis
        }
        
        
        if (!operacao.equals("Incluir")) {
            id = Long.parseLong(request.getParameter("id"));
        }
        try {
            Cliente cliente = null;
            Funcionario funcionario = null;
            if (idFuncionario != 0) {
                funcionario = Funcionario.find(idFuncionario);
            }
            if (idCliente != 0) {
                cliente = Cliente.find(idCliente);
            }

            if (operacao.equals("Incluir")) {
                Pedido pedido = new Pedido(cliente, funcionario, dtCriado, dtEntrega);
                pedido.save();
                salvarMoveisDoPedido(listaIdDosMoveis, pedido, listaQuantidadePorMovel);
                pedido.save();
            } else if (operacao.equals("Editar")) {
                Pedido pedido = (Pedido) Pedido.find(id);
                pedido.removeMovelPedido();
                pedido.setMovelPedidos(new ArrayList<MovelPedido>());
                salvarMoveisDoPedido(listaIdDosMoveis, pedido, listaQuantidadePorMovel);
                pedido.setCliente(cliente);
                pedido.setFuncionario(funcionario);
                pedido.setDataEntrega(dtEntrega);
                pedido.setDataPedido(dtCriado);
                pedido.save();
            } else if (operacao.equals("Excluir")) {
                Pedido p = (Pedido) Pedido.find(id);
                p.remove();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaController?classe=Pedido");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (ServletException e) {
            throw e;
        }
    }

    private void salvarMoveisDoPedido(ArrayList<String> listaIdDosMoveis, Pedido pedido, ArrayList<String> listaQuantidadePorMovel) throws NumberFormatException, ClassNotFoundException, NoSuchMethodException {
        if (listaIdDosMoveis != null || listaQuantidadePorMovel!=null) {
            pedido.setMovelPedidos(new ArrayList<MovelPedido>());
            for (int i = 0; i < listaIdDosMoveis.size(); i++) {
                Movel m = (Movel)Movel.find(Long.parseLong(listaIdDosMoveis.get(i)));
                MovelPedido mp = new MovelPedido(m, pedido, Integer.parseInt(listaQuantidadePorMovel.get(i)));
                GeralDAO.getInstance().save(mp);
                pedido.getMovelPedidos().add(mp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            try {
                processRequest(request, response);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(ManterPedidoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ManterPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ManterPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            try {
                processRequest(request, response);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(ManterPedidoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManterPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ManterPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

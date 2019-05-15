package controller;

import dao.MovelDAO;
import dao.MovelPedidoDAO;
import dao.PedidoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException, ParseException {
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

    protected void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, ParseException {
        String operacao = request.getParameter("operacao");
        Long idFuncionario = Long.parseLong(request.getParameter("idFuncionario"));
        Long idCliente = Long.parseLong(request.getParameter("idCliente"));
        String dtCriado = request.getParameter("dataCriacao");
        String dtEntrega = request.getParameter("dataPrevista");
        Long id = null;
        if (!operacao.equals("Incluir")) {
            id = Long.parseLong(request.getParameter("id"));
        }
        //String[] listaMoveis = request.getParameterValues("listaMoveis");
        
        //qtd moveis banco
        int qtdMoveis = MovelDAO.getInstance().findAll().size();
        
        Map<String, String[]> all = request.getParameterMap();
        
        ArrayList<String> qt = new ArrayList();
        for (int i = 1; i <= qtdMoveis; i++) {
            String aux = request.getParameter("qtd"+i);
            if (aux == null) {
                break;
            }
            qt.add(aux);   //qunatidade dos moveis
        }
        
        ArrayList<String> ids = new ArrayList();
        for (int i = 1; i <= qtdMoveis; i++) {
            String aux = request.getParameter("id"+i);
            if (aux == null) {
                break;
            }
            ids.add(aux);   //id dos moveis
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
                
                if (ids != null) {
                    pedido.setMovelPedidos(new ArrayList<MovelPedido>());
                    for(int i = 0;i<ids.size();i++){
                        Movel m = MovelDAO.getInstance().find(Long.parseLong(ids.get(i)));
                        MovelPedido mp = new MovelPedido(m, pedido,Integer.parseInt(qt.get(i)));
                        MovelPedidoDAO.getInstance().save(mp);
                        pedido.getMovelPedidos().add(mp);
                    }
                }   
                pedido.save();
            } else if (operacao.equals("Editar")) {
                Pedido pedido = PedidoDAO.getInstance().find(id);
                pedido.removeMovelPedido();
                pedido.setMovelPedidos(new ArrayList<MovelPedido>());     //esvaziando o que tem no banco pra preencher com o que tem no jsp
                if (ids != null) {
                    pedido.setMovelPedidos(new ArrayList<MovelPedido>());
                    for(int i = 0;i<ids.size();i++){
                        Movel m = MovelDAO.getInstance().find(Long.parseLong(ids.get(i)));
                        MovelPedido mp = new MovelPedido(m, pedido,Integer.parseInt(qt.get(i)));
                        MovelPedidoDAO.getInstance().save(mp);
                        pedido.getMovelPedidos().add(mp);
                    }
                }      
                pedido.setCliente(cliente);
                pedido.setFuncionario(funcionario);
                pedido.setDataEntrega(dtEntrega);
                pedido.setDataPedido(dtCriado);
                pedido.save();
            } else if (operacao.equals("Excluir")) {
                PedidoDAO.getInstance().find(id).remove();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPedidoController");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (ServletException e) {
            throw e;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ManterPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ManterPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
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

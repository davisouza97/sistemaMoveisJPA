package controller;

import dao.ClienteDAO;
import dao.MovelDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
import model.Pedido;
import utils.Strings;

@WebServlet(name = "ManterPedidoController", urlPatterns = "/ManterPedidoController")
public class ManterPedidoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
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
        }
        request.getRequestDispatcher("cadastroPedido.jsp").forward(request, response);
    }

    protected void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String operacao = request.getParameter("operacao");
        Double valorTotal = Double.parseDouble(request.getParameter("valorTotal"));//criar um getMovelByIdPedido e calcular o preco(ou criar um metodo pra fazer isso pq vai repetir)
        Long idFuncionario = Long.parseLong(request.getParameter("idFuncionario"));
        Long idCliente = Long.parseLong(request.getParameter("idCliente"));
        Long id = null;
        if (!operacao.equals("Incluir")) {
            id = Long.parseLong(request.getParameter("id"));
        }
        String[] listaMoveisRemove = request.getParameterValues("listaMoveisRemove");
        String[] listaMoveisAdd = request.getParameterValues("listaMoveisAdd");
        try {
            Cliente cliente = null;
            Funcionario funcionario = null;
            if (idFuncionario != 0) {
                funcionario = Funcionario.find(idFuncionario);
            }
            if (idCliente != 0) {
                cliente = Cliente.find(idCliente);
            }

            Pedido pedido = new Pedido(valorTotal, cliente, funcionario);
            if (operacao.equals("Incluir")) {
                if (listaMoveisAdd != null) {
                    for (String movel : listaMoveisAdd) {
                        Movel m = MovelDAO.getInstance().find(Long.parseLong(movel));
                        m.setPedido(pedido);
                        m.save();
                    }
                }
                if (listaMoveisRemove != null) {
                    for (String movel : listaMoveisRemove) {
                        Movel m = MovelDAO.getInstance().find(Long.parseLong(movel));
                        m.setPedido(null);
                        m.save();
                    }
                }
                pedido.save();
            } else if (operacao.equals("Editar")) {
                pedido.setId(id);
               if (listaMoveisAdd != null) {
                    for (String movel : listaMoveisAdd) {
                        Movel m = MovelDAO.getInstance().find(Long.parseLong(movel));
                        m.setPedido(pedido);
                        m.save();
                    }
                }
                if (listaMoveisRemove != null) {
                    for (String movel : listaMoveisRemove) {
                        Movel m = MovelDAO.getInstance().find(Long.parseLong(movel));
                        m.setPedido(null);
                        m.save();
                    }
                }
                pedido.save();
            } else if (operacao.equals("Excluir")) {
                List<Movel> moveis = MovelDAO.getInstance().findAll();
                for (Movel movel : moveis) {
                    if (movel.getPedido()!=null) {
                        if (Objects.equals(movel.getPedido().getId(), id)) {
                            movel.setPedido(null);
                            movel.save();
                        }
                    }
                }
                pedido.setId(id);
                pedido.remove();
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
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

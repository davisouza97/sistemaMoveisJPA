package dao;

import model.Pedido;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Movel;
import model.MovelPedido;

public class PedidoDAO extends GeralDAO {

    private static PedidoDAO instance = new PedidoDAO();

    public static PedidoDAO getInstance() {
        return instance;
    }

    private PedidoDAO() {
    }
}

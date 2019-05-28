package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Cliente;
import model.MovelPedido;

public class MovelPedidoDAO extends GeralDAO {

    private static MovelPedidoDAO instance = new MovelPedidoDAO();

    public static MovelPedidoDAO getInstance() {
        return instance;
    }

    private MovelPedidoDAO() {

    }
}

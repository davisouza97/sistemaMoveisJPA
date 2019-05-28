package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Movel;
import model.Pedido;

public class MovelDAO extends GeralDAO{

    private static MovelDAO instance = new MovelDAO();

    public static MovelDAO getInstance() {
        return instance;
    }

    private MovelDAO() {
    }
}

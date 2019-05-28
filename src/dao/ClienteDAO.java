package dao;

import model.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class ClienteDAO extends GeralDAO {

    private static ClienteDAO instance = new ClienteDAO();

    public static ClienteDAO getInstance() {
        return instance;
    }

    private ClienteDAO() {

    }

}

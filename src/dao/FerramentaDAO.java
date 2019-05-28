package dao;

import model.Ferramenta;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Cliente;

public class FerramentaDAO extends GeralDAO {

    private static FerramentaDAO instance = new FerramentaDAO();

    public static FerramentaDAO getInstance() {
        return instance;
    }

    private FerramentaDAO() {

    }
}

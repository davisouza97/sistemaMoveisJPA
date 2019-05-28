package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Material;

public class MaterialDAO extends GeralDAO {

    private static MaterialDAO instance = new MaterialDAO();

    public static MaterialDAO getInstance() {
        return instance;
    }

    private MaterialDAO() {
        
    }
}

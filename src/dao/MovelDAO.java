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

    public List<Movel> findAllByPedido(Pedido pedido) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Movel> moveis = null;
        try {
            tx.begin();
            TypedQuery<Movel> query = em.createQuery("select p from Movel p", Movel.class);
            moveis = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return moveis;
    }

}

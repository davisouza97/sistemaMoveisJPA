package dao;

import model.Pedido;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Movel;
import model.MovelPedido;

public class PedidoDAO {

    private static PedidoDAO instance = new PedidoDAO();

    public static PedidoDAO getInstance() {
        return instance;
    }

    private PedidoDAO() {
    }

    public void save(Pedido pedido) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (pedido.getId() != null) {
                em.merge(pedido);
            } else {
                em.persist(pedido);
            }
            tx.commit();

        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
    }

    public void remove(Pedido pedido) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
//            for (MovelPedido mp : pedido.getMovelPedidos()) {
//                MovelPedidoDAO.getInstance().remove(mp);
//            }
            em.remove(em.getReference(Pedido.class, pedido.getId()));
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
    }

    public Pedido find(Long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Pedido pedido = null;
        try {
            tx.begin();
            pedido = em.find(Pedido.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return pedido;
    }

    public List<Pedido> findAll() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Pedido> pedidos = null;
        try {
            tx.begin();
            TypedQuery<Pedido> query
                    = em.createQuery("select p from Pedido p", Pedido.class);
            pedidos = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return pedidos;
    }
}

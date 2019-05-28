
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Cliente;
import model.MovelPedido;



public class MovelPedidoDAO extends GeralDAO{
    private static MovelPedidoDAO instance = new MovelPedidoDAO();
    public static MovelPedidoDAO getInstance(){
        return instance;
    }
    private MovelPedidoDAO(){
        
    }

   
    public MovelPedido find(Long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        MovelPedido cliente = null;
        try {
            tx.begin();
            cliente = em.find(MovelPedido.class, id);
            tx.commit();       
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return cliente;
        
    }
    public List<MovelPedido> findAll(){
       EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<MovelPedido> clientes = null;
        try {
           tx.begin();
           TypedQuery<MovelPedido> query = em.createQuery("select c From Cliente c", MovelPedido.class);
           clientes = query.getResultList();
         tx.commit();       
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return clientes;
        
    }

    
}

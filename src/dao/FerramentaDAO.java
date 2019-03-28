package dao;

import model.Ferramenta;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Cliente;

public class FerramentaDAO {

    private static FerramentaDAO instance = new FerramentaDAO();
    public static FerramentaDAO getInstance(){
        return instance;
    }
    private FerramentaDAO(){
        
    }

    public void save(Ferramenta ferramenta)  {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if(ferramenta.getId() != null){
                em.merge(ferramenta);
            }else{
            em.persist(ferramenta);
        }
         tx.commit();       
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
       
    }
    public void remove(Ferramenta ferramenta) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Ferramenta.class, ferramenta.getId()));
            tx.commit();       
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
    }

    public Ferramenta find(Long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Ferramenta ferramenta = null;
        try {
            tx.begin();
            ferramenta = em.find(Ferramenta.class, id);
            tx.commit();       
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return ferramenta;
        
    }
    public List<Ferramenta> findAll(){
       EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Ferramenta> ferramentas = null;
        try {
           tx.begin();
           TypedQuery<Ferramenta> query = em.createQuery("select f From Ferramenta f", Ferramenta.class);
           ferramentas = query.getResultList();
         tx.commit();       
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return ferramentas;
        
    }
}

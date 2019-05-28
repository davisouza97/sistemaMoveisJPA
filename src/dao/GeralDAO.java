package dao;

import java.lang.reflect.Method;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Ferramenta;
import model.Movel;

public abstract class GeralDAO {
    
    public void save(Object objeto) throws NoSuchMethodException {
        
        Method metodo = objeto.getClass().getMethod("getId", null);
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if(metodo != null){
                em.merge(objeto);
            }else{
            em.persist(objeto);
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
    
    public void remove(Object objeto) throws NoSuchMethodException {
        Method metodo = objeto.getClass().getMethod("getId", null);
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(objeto.getClass(), metodo.invoke(objeto)));
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
/*
    public Object find(Long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Object objeto = null;
        try {
            tx.begin();
            objeto = em.find(Movel.class, id);
            tx.commit();       
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return objeto;
    }
*/
    //objeto.getClass().getSimpleName();
}

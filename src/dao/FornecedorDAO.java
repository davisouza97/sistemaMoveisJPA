package dao;

import model.Fornecedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class FornecedorDAO extends GeralDAO{

    private static FornecedorDAO instance = new FornecedorDAO();

    public static FornecedorDAO getInstance() {
        return instance;
    }
    private FornecedorDAO(){
        
    }


    public Fornecedor find(Long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Fornecedor fornecedor = null;
        try {
            tx.begin();
            fornecedor = em.find(Fornecedor.class, id);
            tx.commit();       
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return fornecedor;
    }

    public List<Fornecedor> findAll(){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Fornecedor> fornecedores = null;
        try {
           tx.begin();
           TypedQuery<Fornecedor> query = em.createQuery("select f From Fornecedor f", Fornecedor.class);
           fornecedores = query.getResultList();
         tx.commit();       
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return fornecedores;
    }

}

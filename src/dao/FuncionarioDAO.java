package dao;

import model.Funcionario;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class FuncionarioDAO extends GeralDAO{

    private static FuncionarioDAO instance = new FuncionarioDAO();

    public static FuncionarioDAO getInstance() {
        return instance;
    }

    private FuncionarioDAO() {
    }

   
    public static Funcionario find(Long id){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Funcionario funcionario = null;
        try {
            tx.begin();
            funcionario = em.find(Funcionario.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return funcionario;
    }

    public static List<Funcionario> findAll() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Funcionario> funcionarios = null;
        try {
            tx.begin();
            TypedQuery<Funcionario> query = em.createQuery("select f From Funcionario f", Funcionario.class);
            funcionarios = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return funcionarios;
    }

    public static Funcionario findFuncionarioByCpf(String cpf) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Funcionario funcionario = null;
        try {
            tx.begin();
            TypedQuery<Funcionario> query = em.createQuery("select f From Funcionario f where f.cpf LIKE :cpf", Funcionario.class);
            query.setParameter("cpf", cpf);
            
            funcionario = query.getSingleResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            funcionario = null;
        } finally {
            PersistenceUtil.close(em);
        }
        return funcionario;
    }

}

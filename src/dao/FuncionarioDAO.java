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

}

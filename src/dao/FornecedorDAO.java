package dao;

import model.Fornecedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class FornecedorDAO extends GeralDAO {

    private static FornecedorDAO instance = new FornecedorDAO();

    public static FornecedorDAO getInstance() {
        return instance;
    }

    private FornecedorDAO() {

    }
}

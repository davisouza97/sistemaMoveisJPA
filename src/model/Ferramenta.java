package model;

import dao.FerramentaDAO;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class Ferramenta extends MaterialFerramenta {

    public Ferramenta(String nome, String tipo, double valorUnitario, double qtdEstoque, String unidade, Fornecedor fornecedor) {
        super(nome, tipo, valorUnitario, qtdEstoque, unidade, fornecedor);
    }

    public Ferramenta() {
    }

    public void save() throws NoSuchMethodException {
        FerramentaDAO.getInstance().save(this);
    }

    public void remove() throws NoSuchMethodException {
        FerramentaDAO.getInstance().remove(this);
    }

    public static Ferramenta find(Long id) throws ClassNotFoundException {
        return (Ferramenta) FerramentaDAO.getInstance().find(id);
    }

    public static List<Object> findAll() throws ClassNotFoundException {
        return FerramentaDAO.getInstance().findAll();
    }
}

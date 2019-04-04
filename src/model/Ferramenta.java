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
    
    public void save() {
        FerramentaDAO.getInstance().save(this);
    }

    public void remove() {
        FerramentaDAO.getInstance().remove(this);
    }

    public static Ferramenta find(Long id) {
        return FerramentaDAO.getInstance().find(id);
    }

    public static List<Ferramenta> findAll() {
        return FerramentaDAO.getInstance().findAll();
    }
}

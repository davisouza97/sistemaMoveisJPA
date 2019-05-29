package model;

import dao.GeralDAO;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class Material extends MaterialFerramenta {
      
    public Material(String nome, String tipo, double valorUnitario, double qtdEstoque, String unidade, Fornecedor fornecedor) {
        super(nome, tipo, valorUnitario, qtdEstoque, unidade, fornecedor);
    }

    public Material() {
    }

    
    public void save() throws NoSuchMethodException {
        GeralDAO.getInstance().save(this);
    }

    public void remove() throws NoSuchMethodException {
        GeralDAO.getInstance().remove(this);
    }
    
    public static Material find(Long id) throws ClassNotFoundException{
        return (Material) GeralDAO.getInstance().find(id);
    }
    
    public static List<Object> findAll() throws ClassNotFoundException{
        return GeralDAO.getInstance().findAll();
    } 
}

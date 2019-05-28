package model;

import dao.MaterialDAO;
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
        MaterialDAO.getInstance().save(this);
    }

    public void remove() throws NoSuchMethodException {
        MaterialDAO.getInstance().remove(this);
    }
    
    public static Material find(Long id){
        return MaterialDAO.getInstance().find(id);
    }
    
    public static List<Material> findAll(){
        return MaterialDAO.getInstance().findAll();
    } 
}

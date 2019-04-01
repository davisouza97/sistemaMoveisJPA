package model;

import dao.MaterialDAO;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.Entity;
@Entity
public class Material extends MaterialFerramenta {
      
    public Material(String nome, String tipo, double valorUnitario, double qtdEstoque, String unidade, Fornecedor fornecedor) {
        super(nome, tipo, valorUnitario, qtdEstoque, unidade, fornecedor);
    }

    public Material() {
    }

    
    public void save() {
        MaterialDAO.getInstance().save(this);
    }

    public void remove() {
        MaterialDAO.getInstance().remove(this);
    }
    
    public static Material find(Long id){
        return MaterialDAO.getInstance().findMaterial(id);
    }
    
    public static List<Material> findAll(){
        return MaterialDAO.getInstance().findAllMaterial();
    } 
}

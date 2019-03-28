package model;

import dao.MaterialDAO;

import java.sql.SQLException;
import java.util.List;

public class Material extends MaterialFerramenta {
      
    public Material(Long idMaterial, String nome, String tipo, double valorUnitario, double qtdEstoque, String unidade, Fornecedor fornecedor) {
        super(nome, tipo, valorUnitario, qtdEstoque, unidade, fornecedor);
    }

    
    public void save() {
        MaterialDAO.getInstance().save(this);
    }

    public void remove() {
        MaterialDAO.getInstance().remove(this);
    }
    
    public Material find(){
        return MaterialDAO.getInstance().findMaterial(this.getId());
    }
    
    public static List<Material> findAll(){
        return MaterialDAO.getInstance().findAllMaterial();
    } 
}

package model;

import dao.MaterialDAO;

import java.sql.SQLException;
import java.util.List;

public class Material extends MaterialFerramenta {
      
    public Material(Long idMaterial, String nome, String tipo, double valorUnitario, double qtdEstoque, String unidade, Fornecedor fornecedor) {
        super(nome, tipo, valorUnitario, qtdEstoque, unidade, fornecedor);
    }

    
}

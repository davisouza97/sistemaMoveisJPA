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
    
    public  void  gravar() throws SQLException, ClassNotFoundException{
        FerramentaDAO.gravar(this);
    }

    public void alterar() throws  SQLException, ClassNotFoundException{
        FerramentaDAO.alterar(this);
    }

    public  void excluir() throws  SQLException, ClassNotFoundException{
        FerramentaDAO.excluir(this);
    }

    public static Ferramenta obterFerramenta(Long idFerramenta) throws SQLException, ClassNotFoundException{
        return FerramentaDAO.obterFerramenta(idFerramenta);
    }

    public static List<Ferramenta> obterTodasFerramentas() throws ClassNotFoundException, SQLException{
        return FerramentaDAO.obterTodasFerramentas();
    }

}
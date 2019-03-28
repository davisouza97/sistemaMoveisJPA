package model;

import dao.FuncionarioDAO;
import java.io.Serializable;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Funcionario extends Pessoa implements Serializable {
    private String cargo;
    private double salario;
    private String comissao;
    private String senha;
    
    public  void  gravar() throws SQLException, ClassNotFoundException{
        FuncionarioDAO.gravar(this);
    }

    public void alterar() throws  SQLException, ClassNotFoundException{
        FuncionarioDAO.alterar(this);
    }

    public  void excluir() throws  SQLException, ClassNotFoundException{
        FuncionarioDAO.excluir(this);
    }

    public static Funcionario obterFuncionario(Long idFuncionario) throws  SQLException, ClassNotFoundException{
        return FuncionarioDAO.obterFuncionario(idFuncionario);
    }

    public static List<Funcionario> obterTodosFuncionarios() throws ClassNotFoundException, SQLException{
        return FuncionarioDAO.obterTodosFuncionarios();
    }
    
    
}

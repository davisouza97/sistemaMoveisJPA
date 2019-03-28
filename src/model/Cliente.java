package model;

import dao.ClienteDAO;
import java.io.Serializable;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa implements Serializable{

    public Cliente(String nome, String cpf, String dataNascimento, String email, String cep, String logradouro, String numero, String complemento, String bairro, String uf, String cidade, String telefone, String celular) {
        super(nome, cpf, dataNascimento, email, cep, logradouro, numero, complemento, bairro, uf, cidade, telefone, celular);
    }
    
    public  void  gravar() throws SQLException, ClassNotFoundException{
        ClienteDAO.gravar(this);
    }

    public void alterar() throws  SQLException, ClassNotFoundException{
        ClienteDAO.alterar(this);
    }

    public  void excluir() throws  SQLException, ClassNotFoundException{
        ClienteDAO.excluir(this);
    }

    public static Cliente obterCliente(Long idCliente) throws  SQLException, ClassNotFoundException{
        return ClienteDAO.obterCLiente(idCliente);
    }

    public static List<Cliente> obterTodosClientes() throws ClassNotFoundException, SQLException{
        return ClienteDAO.obterTodosClientes();
    }
}

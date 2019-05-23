package model;

import dao.FornecedorDAO;
import java.io.Serializable;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fornecedor extends Pessoa implements Serializable {

    private String cnpj;

    public Fornecedor(String cnpj) {
        this.cnpj = cnpj;
    }

    public Fornecedor(String nome, String cnpj, String email, String cep, String logradouro, String numero, String complemento, String bairro, String uf, String cidade, String telefone, String celular) {
        super(nome, email, cep, logradouro, numero, complemento, bairro, uf, cidade, telefone, celular);
        this.cnpj = cnpj;
    }

    public Fornecedor(String cnpj, Long id) {
        super(id);
        this.cnpj = cnpj;
    }

    public Fornecedor() {

    }

    public void save() {
        FornecedorDAO.getInstance().save(this);
    }

    public void remove() {
        FornecedorDAO.getInstance().remove(this);
    }

    public static Fornecedor find(Long id) {
        return FornecedorDAO.getInstance().find(id);
    }

    public static List<Fornecedor> findAll() {
        return FornecedorDAO.getInstance().findAll();
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}

package model;

import dao.GeralDAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;

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

    public void save() throws NoSuchMethodException {
        GeralDAO.getInstance().save(this);
    }

    public void remove() throws NoSuchMethodException {
        GeralDAO.getInstance().remove(this);
    }

    public static Fornecedor find(Long id) throws ClassNotFoundException {
        return (Fornecedor) GeralDAO.getInstance().find(id);
    }

    public static List<Object> findAll() throws ClassNotFoundException {
        return GeralDAO.getInstance().findAll();
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}

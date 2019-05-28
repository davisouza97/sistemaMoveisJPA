package model;

import dao.ClienteDAO;
import java.io.Serializable;

import java.util.List;
import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa implements Serializable {

    private String cpf;
    private String dataNascimento;

    public Cliente(String nome, String cpf, String dataNascimento, String email, String cep, String logradouro, String numero, String complemento, String bairro, String uf, String cidade, String telefone, String celular) {
        super(nome, email, cep, logradouro, numero, complemento, bairro, uf, cidade, telefone, celular);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public Cliente() {
    }

    public void save() throws NoSuchMethodException {
        ClienteDAO.getInstance().save(this);
    }

    public void remove() throws NoSuchMethodException {
        ClienteDAO.getInstance().remove(this);
    }

    public static Cliente find(Long id) throws ClassNotFoundException{
        return (Cliente) ClienteDAO.getInstance().find(id);
    }

    public static List<Object> findAll() throws ClassNotFoundException{
        return ClienteDAO.getInstance().findAll();
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Cliente(Long id) {
        super(id);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}

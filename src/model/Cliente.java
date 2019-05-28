package model;

import dao.GeralDAO;
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
        GeralDAO.getInstance().save(this);
    }

    public void remove() throws NoSuchMethodException {
        GeralDAO.getInstance().remove(this);
    }

    public static Cliente find(Long id) throws ClassNotFoundException{
        return (Cliente) GeralDAO.getInstance().find(id);
    }

    public static List<Object> findAll() throws ClassNotFoundException{
        return GeralDAO.getInstance().findAll();
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

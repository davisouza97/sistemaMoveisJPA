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
    
}

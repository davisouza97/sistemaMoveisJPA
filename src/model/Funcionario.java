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
    private String cpf;
    private String dataNascimento;

    public Funcionario() {
        
    }

    public Funcionario(String cargo, double salario, String comissao, String senha,
            String nome, String cpf, String dataNascimento, String email, String cep,
            String logradouro, String numero, String complemento, String bairro,
            String uf, String cidade, String telefone, String celular) {
        super(nome, email, cep, logradouro, numero, complemento, bairro, uf, cidade, telefone, celular);
        this.cargo = cargo;
        this.salario = salario;
        this.comissao = comissao;
        this.senha = senha;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public void save() throws NoSuchMethodException {
        FuncionarioDAO.getInstance().save(this);
    }

    public void remove() throws NoSuchMethodException {
        FuncionarioDAO.getInstance().remove(this);
    }
    
    public static Funcionario find(Long id) throws ClassNotFoundException{
        return (Funcionario) FuncionarioDAO.getInstance().find(id);
    }
    
    public static Object findByParameter(String parametro,String campo) throws ClassNotFoundException{
        return FuncionarioDAO.getInstance().findByParameter(parametro, campo);
    }
    
    public static List<Object> findAll() throws ClassNotFoundException{
        return FuncionarioDAO.getInstance().findAll();
    } 
    
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getComissao() {
        return comissao;
    }

    public void setComissao(String comissao) {
        this.comissao = comissao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}

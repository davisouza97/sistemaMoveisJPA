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

    public void save() {
        FuncionarioDAO.getInstance().save(this);
    }

    public void remove() {
        FuncionarioDAO.getInstance().remove(this);
    }
    
    public Funcionario find(){
        return FuncionarioDAO.getInstance().find(this.getId());
    }
    
    public static List<Funcionario> findAll(){
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

package model;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class MaterialFerramenta {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nome;
    private String tipo;
    private double valorUnitario;
    private double qtdEstoque;
    private String unidade;
    private Fornecedor fornecedor;
    private Long idFornecedor;

    public MaterialFerramenta(String nome, String tipo, double valorUnitario, double qtdEstoque, String unidade, Fornecedor fornecedor) {
        this.nome = nome;
        this.tipo = tipo;
        this.valorUnitario = valorUnitario;
        this.qtdEstoque = qtdEstoque;
        this.unidade = unidade;
        this.fornecedor = fornecedor;
        this.idFornecedor = 0l;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(double qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
}

package model;

import dao.MovelDAO;
import java.io.Serializable;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Movel implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Double preco;
    private String tipo;
    private Double altura;
    private Double largura;
    private Double comprimento;
    private String acabamento;
    private Double peso;
    @ManyToOne
    private Material material;
    @ManyToOne
    private Pedido pedido;

    public Movel(String nome, Double preco, String tipo, Double altura, Double largura, Double comprimento, String acabamento, Double peso, Material material, Pedido pedido) {
        
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
        this.acabamento = acabamento;
        this.peso = peso;
        this.material = material;
        this.pedido = pedido;
    }

    public void save() {
        MovelDAO.getInstance().save(this);
    }

    public void remove() {
        MovelDAO.getInstance().remove(this);
    }
    
    public Movel find(){
        return MovelDAO.getInstance().findMovel(this.id);
    }
    
    public static List<Movel> findAll(){
        return MovelDAO.getInstance().findAllMovel();
    } 
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public Double getComprimento() {
        return comprimento;
    }

    public void setComprimento(Double comprimento) {
        this.comprimento = comprimento;
    }

    public String getAcabamento() {
        return acabamento;
    }

    public void setAcabamento(String acabamento) {
        this.acabamento = acabamento;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

}

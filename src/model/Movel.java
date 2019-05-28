package model;

import dao.MovelDAO;
import java.io.Serializable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Movel implements Serializable {

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
    private Double peso;
    @ManyToOne
    private Ferramenta ferramenta;
    @ManyToOne
    private Material material;

    @OneToMany(mappedBy = "movel")
    private ArrayList<MovelPedido> movelPedidos;

    public Movel(String nome, Double preco, String tipo, Double altura, Double largura, Double comprimento, Double peso, Ferramenta ferramenta, Material material, ArrayList<MovelPedido> movelPedidos) {

        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
        this.peso = peso;
        this.ferramenta = ferramenta;
        this.material = material;
        this.movelPedidos = movelPedidos;
    }

    public Movel() {
    }

    public Movel(String nome, double preco, String tipo, double altura, double largura, double comprimento, double peso, Ferramenta ferramenta, Material material) {
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
        this.peso = peso;
        this.ferramenta = ferramenta;
        this.material = material;
    }

    public void save() throws NoSuchMethodException {
        MovelDAO.getInstance().save(this);
    }

    public void remove() throws NoSuchMethodException {
        MovelDAO.getInstance().remove(this);
    }

    public static Movel find(Long id) throws ClassNotFoundException {
        return (Movel) MovelDAO.getInstance().find(id);
    }

    public static List<Object> findAll() throws ClassNotFoundException {
        return MovelDAO.getInstance().findAll();
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

    public ArrayList<MovelPedido> getMovelPedidos() {
        return movelPedidos;
    }

    public void setMovelPedidos(ArrayList<MovelPedido> movelPedidos) {
        this.movelPedidos = movelPedidos;
    }

    @Override
    public String toString() {
        return "Movel{" + this.nome + '}';
    }

    public Ferramenta getFerramenta() {
        return ferramenta;
    }

    public void setFerramenta(Ferramenta ferramenta) {
        this.ferramenta = ferramenta;
    }

}

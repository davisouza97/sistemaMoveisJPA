package model;

import dao.PedidoDAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import utils.Data;

@Entity
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String codigoPedido;
    private Double valorTotal;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Funcionario funcionario;

    public Pedido(Double valorTotal, Cliente cliente, Funcionario funcionario) {
        this.valorTotal = valorTotal;
        this.codigoPedido = cliente.getNome()+"/"+funcionario.getNome();
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    public Pedido() {
    }

    
    
    public void save() {
        PedidoDAO.getInstance().save(this);
    }

    public void remove() {
        PedidoDAO.getInstance().remove(this);
    }
    
    public static Pedido find(Long id){
        return PedidoDAO.getInstance().find(id);
    }
    
    public static List<Pedido> findAll(){
        return PedidoDAO.getInstance().findAll();
    } 
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }
    
    
    
}

package model;

import dao.MovelPedidoDAO;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MovelPedido implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "movel_id")
    private Movel movel;
    
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
    
    private int quantidade;

    public MovelPedido(Long id, Movel movel, Pedido pedido , int quantidade) {
        this.id = id;
        this.movel = movel;
        this.pedido = pedido;
        this.quantidade = quantidade;
    }

    public MovelPedido() {
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public MovelPedido(Movel m, Pedido p , int quant) {
    this.movel = m;
    this.pedido = p;
    this.quantidade = quant;
    
    }

    public void delete() throws NoSuchMethodException{
        MovelPedidoDAO.getInstance().remove(this);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movel getMovel() {
        return movel;
    }

    public void setMovel(Movel movel) {
        this.movel = movel;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return  id +"-"+ movel + "-" + pedido;
    }
    
}

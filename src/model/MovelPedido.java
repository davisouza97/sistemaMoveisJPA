/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public MovelPedido(Long id, Movel movel, Pedido pedido) {
        this.id = id;
        this.movel = movel;
        this.pedido = pedido;
    }

    public MovelPedido() {
    }

    public MovelPedido(Movel m, Pedido p) {
    this.movel = m;
    this.pedido = p;
    }

    public void delete(){
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

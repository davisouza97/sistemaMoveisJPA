package model;

import dao.PedidoDAO;
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
import javax.persistence.ManyToOne;

@Entity
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPedido;
    private Double valorTotal;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Funcionario funcionario;

    public Pedido(Double valorTotal, Cliente cliente, Funcionario funcionario) {
        
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }
    
    public  void  gravar() throws SQLException, ClassNotFoundException{
        PedidoDAO.gravar(this);
    }

    public void alterar() throws  SQLException, ClassNotFoundException{
        PedidoDAO.alterar(this);
    }

    public  void excluir() throws  SQLException, ClassNotFoundException{
        PedidoDAO.excluir(this);
    }

    public static  Pedido obterPedido(Long idPedido) throws  SQLException, ClassNotFoundException{
        return PedidoDAO.obterPedido(idPedido);
    }

    public static List< Pedido> obterTodosPedidos() throws ClassNotFoundException, SQLException{
        return  PedidoDAO.obterTodosPedidos();
    }

}
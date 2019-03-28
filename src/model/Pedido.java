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
    
    public Pedido(Long idPedido, Double valorTotal, List<Movel> moveis, Funcionario funcionario, Cliente cliente) {
        this.idPedido = idPedido;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.idCliente = 0l;
        this.funcionario = funcionario;
        this.idFuncionario = 0l;
        this.moveis = moveis;    
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

    public Long getIdCliente() {
        return this.idCliente;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
         if (idCliente != 0 && cliente == null) {
          
             try {
                 cliente = Cliente.obterCliente(idCliente);
             } catch (SQLException ex) {
                 Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
             }
                    
    }
        
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setIdCliente(Long id) {
        this.idCliente = id;
    }

    public Funcionario getFuncionario() {
        if(idFuncionario != 0 && funcionario == null){
            try {
                funcionario = Funcionario.obterFuncionario(idFuncionario);
            } catch (SQLException ex) {
                Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdfuncionario(Long idfuncionaio) {
        this.idFuncionario = idfuncionaio;
    }

    public List<Movel> getMoveis() {
        return moveis;
    }

    public void setMoveis(List<Movel> moveis) {
        this.moveis = moveis;
    }
}
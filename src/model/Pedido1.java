package model;

import dao.MovelDAO1;
import dao.PedidoDAO;
import dao.PedidoDAO1;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Pedido1 {
    private Long idPedido;
    private Double valorTotal;
    private Cliente cliente;
    private Long idCliente;
    private List<Movel> moveis;
    private Funcionario funcionario;
    private Long idFuncionario;

    public Pedido1(Long idPedido, Double valorTotal, List<Movel> movel, Funcionario funcionario, Cliente cliente) {
        this.idPedido = idPedido;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.idCliente = 0l;
        this.moveis = movel;
        this.funcionario = funcionario;
        this.idFuncionario = 0l;
    }
    
 
   

    public  void  gravar() throws SQLException, ClassNotFoundException{
        PedidoDAO1.gravar(this);
    }

    public void alterar() throws  SQLException, ClassNotFoundException{
        PedidoDAO1.alterar(this);
    }

    public  void excluir() throws  SQLException, ClassNotFoundException{
        PedidoDAO1.excluir(this);
    }

    public static  Pedido1 obterPedido(Long idPedido) throws  SQLException, ClassNotFoundException{
        return PedidoDAO1.obterPedido(idPedido);
    }

    public static List< Pedido1> obterTodosPedidos() throws ClassNotFoundException, SQLException{
        return  PedidoDAO1.obterTodosPedidos();
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
                 Logger.getLogger(Pedido1.class.getName()).log(Level.SEVERE, null, ex);
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(Pedido1.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<Movel1> getMoveis() throws ClassNotFoundException {//mudar codigo para pegar movelById
        return MovelDAO1.obterMoveisById(this.idPedido);
    }

    public void setMovel(List<Movel> movel) {
        this.moveis = movel;
    }

    public Funcionario getFuncionario() {
        if(idFuncionario != 0 && funcionario == null){
            try {
                funcionario = Funcionario.obterFuncionario(idFuncionario);
            } catch (SQLException ex) {
                Logger.getLogger(Pedido1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Pedido1.class.getName()).log(Level.SEVERE, null, ex);
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
    
}
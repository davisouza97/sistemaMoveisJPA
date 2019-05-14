package model;

import dao.PedidoDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double valorTotal;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Funcionario funcionario;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.REMOVE)
    private ArrayList<MovelPedido> movelPedidos;

    private String dataPedido;
    private String dataEntrega;

    public Pedido(Double valorTotal, Cliente cliente, Funcionario funcionario, Movel movel, String dataPedido, String dataEntrega, ArrayList<MovelPedido> movelPedidos) {

        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.dataPedido = dataPedido;
        this.dataEntrega = dataEntrega;
        this.movelPedidos = movelPedidos;
    }

    public Pedido() {
        valorTotal = 0d;
    }

    public Pedido(Cliente cliente, Funcionario funcionario, String dtCriado, String dtEntrega) {
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.dataPedido = dtCriado;
        this.dataEntrega = dtEntrega;
        valorTotal = 0d;
    }

    public void save() {
        PedidoDAO.getInstance().save(this);
    }

    public void remove() {
        PedidoDAO.getInstance().remove(this);
    }

    public static Pedido find(Long id) {
        return PedidoDAO.getInstance().find(id);
    }

    public static List<Pedido> findAll() {
        return PedidoDAO.getInstance().findAll();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValorTotal() {
        updateValorTotal();
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

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public ArrayList<MovelPedido> getMovelPedidos() {
        return movelPedidos;
    }

    public void setMovelPedidos(ArrayList<MovelPedido> movelPedidos) {
        this.movelPedidos = movelPedidos;
    }

    private void updateValorTotal() {
        double x = 0;
        for (MovelPedido movelPedido : movelPedidos) {
            if (movelPedido.getMovel() == null) {//evitar inconsistencia do banco
               // movelPedido.delete();
            } else {
                x += movelPedido.getMovel().getPreco();
            }
        }
        this.valorTotal = x;
    }

    public void removeMovelPedido() {
        for (MovelPedido movelPedido : movelPedidos) {
            movelPedido.delete();
        }
    }

}

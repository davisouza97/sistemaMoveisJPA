package dao;

import model.Pedido;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Pedido1;

public class PedidoDAO1 {

    public static void gravar(Pedido1 pedido) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "insert into pedido1(idPedido,valorTotal, idMovel, idFuncionario, idCliente)" +
                    "VALUES (?,?,?,?,?)";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, pedido.getIdPedido());
            comando.setDouble(2, pedido.getValorTotal());
           
            if(pedido.getMovel() == null){
                comando.setNull(3, Types.NULL);
            }else{
                comando.setLong(3, pedido.getMovel().getIdMovel());
            }
             if(pedido.getFuncionario() == null){
                comando.setNull(4, Types.NULL);
            }else{
                comando.setLong(4, pedido.getFuncionario().getIdFuncionario());
            }
            
            if ( pedido.getCliente() == null){
                comando.setNull(5, Types.NULL);
            }else{
                comando.setLong(5, pedido.getCliente().getIdCliente());
            }
            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e) {
            throw e;
        }finally {
            BD.fecharConexao(conexao,comando);
        }
    }

    public static void alterar(Pedido1 pedido) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = ("UPDATE pedido SET  valorTotal=?, idMovel=?, idFuncionario=?, idCliente=? WHERE idPedido = ?");
            comando = conexao.prepareStatement(sql);

            comando.setDouble(1, pedido.getValorTotal());
             if(pedido.getMovel() == null){
                comando.setNull(2, Types.NULL);
            }else{
                comando.setLong(2, pedido.getMovel().getIdMovel());
            }
            if(pedido.getFuncionario() == null){
                comando.setNull(3, Types.NULL);
            }else{
                comando.setLong(3, pedido.getFuncionario().getIdFuncionario());
            }
            if ( pedido.getCliente() == null){
                comando.setNull(4, Types.NULL);
            }else{
                comando.setLong(4, pedido.getCliente().getIdCliente());
            }
            comando.setLong(5,pedido.getIdPedido());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        }finally {
            BD.fecharConexao(conexao,comando);
        }
    }

    public static void excluir (Pedido1 pedido)throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "delete from pedido where idPedido = ?";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, pedido.getIdPedido());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }

    public static Pedido1 obterPedido(Long idPedido) throws ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;
        Pedido1 pedido = null;
        try{
            conexao = BD.getConexao();
            String sql = "SELECT * FROM pedido WHERE pedido.idPedido = ?";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1,Math.toIntExact(idPedido));
            ResultSet rs = comando.executeQuery();
            rs.first();
            pedido = new Pedido1(
                    rs.getLong("idPedido"),
                    rs.getDouble("valorTotal"),
                    null,
                    null,
                    null);
            pedido.setIdfuncionario(rs.getLong("idFuncionario"));
            pedido.setIdCliente(rs.getLong("idCliente"));
            
        }catch(SQLException e){
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }

        return pedido;
    }

    public static List<Pedido1> obterTodosPedidos() throws ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        List<Pedido1> pedidos = new ArrayList<Pedido1>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String sql = "SELECT * FROM pedido";
            ResultSet rs = comando.executeQuery(sql);
            while (rs.next()){
                Pedido1 pedido = new Pedido1(
                        rs.getLong("idPedido"),
                        rs.getDouble("valorTotal"),
                        null,
                        null,
                        null);
                pedido.setIdfuncionario(rs.getLong("idFuncionario"));
                pedido.setIdCliente(rs.getLong("idCliente"));
                pedidos.add(pedido);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            BD.fecharConexao(conexao,comando);
        }
        return pedidos;
    }
}

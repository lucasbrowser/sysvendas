/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.sysvendas.model.dao;

import com.lucas.sysvendas.bd.ConexaoPostgres;
import com.lucas.sysvendas.control.VendaControl;
import com.lucas.sysvendas.model.domain.Venda;
import com.lucas.sysvendas.model.domain.VendaItem;
import com.lucas.sysvendas.model.enums.SituacaoEnum;
import com.lucas.sysvendas.util.exceptions.ErroException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class VendaDAO extends ConexaoPostgres {
    
    public void inserir(Venda venda) throws ErroException {
        try{
            this.conectar();
            
            String sql = "INSERT INTO VENDAS ("
                    + "CLIENTE, "
                    + "DATA_VENDA, "
                    + "VALOR_TOTAL, "
                    + "SITUACAO) "
                    + "VALUES (?, ?, ?, ?)";
            
            PreparedStatement ps = this.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, venda.getCliente().getCodigo());
            ps.setDate(2, new Date(venda.getDataVenda().getTime()));
            ps.setDouble(3, venda.getValorTotal());
            ps.setInt(4, venda.getSituacao().getId());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int idVenda = rs.getInt(1);

            for (VendaItem iv : venda.getItens()) {
                sql = "INSERT INTO VENDAS_ITENS ("
                        + "PRODUTO, "
                        + "VENDA, "
                        + "QUANTIDADE, "
                        + "VALOR_UNITARIO) "
                        + "VALUES (?, ?, ?, ?)";
                
                ps = this.getCon().prepareStatement(sql);
                ps.setLong(1, iv.getProduto().getCodigo());
                ps.setInt(2, idVenda);
                ps.setLong(3, iv.getQuantidade());
                ps.setDouble(4, iv.getValorUnitario());
                ps.execute();
                
                if (venda.getSituacao() == SituacaoEnum.FINALIZADA) {
                    ProdutoDAO produtoDAO = new ProdutoDAO();
                    produtoDAO.saidaEstoque(iv.getProduto().getCodigo(), iv.getQuantidade());
                }
        }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new ErroException(e.getMessage(), e.getCause());
        } finally {
            this.fecharConexao();
        }
    }

    public void alterar(Venda venda) throws ErroException {
        try{
            this.conectar();
            
            String sql = "UPDATE VENDAS SET "
                    + "CLIENTE = ?, "
                    + "DATA_VENDA = ?, "
                    + "VALOR_TOTAL = ?, "
                    + "SITUACAO = ? "
                    + "WHERE CODIGO = ?";
            
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setLong(1, venda.getCliente().getCodigo());
            ps.setDate(2, new Date(venda.getDataVenda().getTime()));
            ps.setDouble(3, venda.getValorTotal());
            ps.setInt(4, venda.getSituacao().getId());
            ps.setLong(5, venda.getCodigo());
            ps.execute();

            for (VendaItem vendaItem : venda.getItens()) {
                
                if (vendaItem.getCodigo() == 0) {
                    
                    sql = "INSERT INTO VENDAS_ITENS ("
                        + "PRODUTO, "
                        + "VENDA, "
                        + "QUANTIDADE, "
                        + "VALOR_UNITARIO) "
                        + "VALUES (?, ?, ?, ?)";
                    
                    ps = this.getCon().prepareStatement(sql);
                    ps.setLong(1, vendaItem.getProduto().getCodigo());
                    ps.setLong(2, vendaItem.getVenda().getCodigo());
                    ps.setLong(3, vendaItem.getQuantidade());
                    ps.setDouble(4, vendaItem.getValorUnitario());
                    ps.execute();
                    
                } else {
                    
                    sql = "UPDATE VENDAS_ITENS SET "
                            + "PRODUTO = ?, "
                            + "VENDA = ?, "
                            + "QUANTIDADE = ?, "
                            + "VALOR_UNITARIO = ? "
                            + "WHERE CODIGO = ?";
                    
                    ps = this.getCon().prepareStatement(sql);
                    ps.setLong(1, vendaItem.getProduto().getCodigo());
                    ps.setLong(2, vendaItem.getVenda().getCodigo());
                    ps.setLong(3, vendaItem.getQuantidade());
                    ps.setDouble(4, vendaItem.getValorUnitario());
                    ps.setLong(5, vendaItem.getCodigo());
                    ps.execute();
                }
                
                if (venda.getSituacao() == SituacaoEnum.FINALIZADA) {
                    ProdutoDAO produtoDAO = new ProdutoDAO();
                    produtoDAO.saidaEstoque(vendaItem.getProduto().getCodigo(), vendaItem.getQuantidade());
                }
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
            throw new ErroException(e.getMessage(), e.getCause());
        } finally {
            this.fecharConexao();
        }
    }


    public void excluir(Venda venda) throws ErroException {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                "UPDATE VENDAS SET "
                    + "CLIENTE = '" + venda.getCliente().getCodigo() + "',"
                    + "DATA_VENDA = '" + new Date(venda.getDataVenda().getTime()) + "',"
                    + "VALOR_TOTAL = '" + venda.getValorTotal() + "',"
                    + "SITUACAO = '" + SituacaoEnum.CANCELADA.getId() + "'"
                + " WHERE "
                    + "CODIGO = '" + venda.getCodigo() + "'"
                + ";"
            );
        } catch(Exception e) {
            e.printStackTrace();
            throw new ErroException(e.getMessage(), e.getCause());
        } finally {
            this.fecharConexao();
        }
    }

    public List<Venda> listarTodos() throws ErroException {
        List listaVendas = new LinkedList();
        try{
            this.conectar();
            ClienteDAO clienteDAO = new ClienteDAO();
            ProdutoDAO produtoDAO = new ProdutoDAO();
            VendaControl vendaControl = new VendaControl();

            String sql = "SELECT * FROM VENDAS ORDER BY CODIGO DESC";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda();
                venda.setCodigo(rs.getLong("CODIGO"));
                venda.setCliente(clienteDAO.recuperar(rs.getInt("CLIENTE")));
                venda.setDataVenda(rs.getDate("DATA_VENDA"));
                venda.setValorTotal(rs.getDouble("VALOR_TOTAL"));
                venda.setSituacao(vendaControl.gravarSituacao(rs.getInt("SITUACAO")));

                String sqlItem = "SELECT * FROM VENDAS_ITENS WHERE VENDA = ?";
                PreparedStatement psItem = this.getCon().prepareStatement(sqlItem);
                psItem.setLong(1, venda.getCodigo());
                ResultSet rsItem = psItem.executeQuery();

                while (rsItem.next()) {
                    VendaItem vendaItem = new VendaItem();
                    vendaItem.setCodigo(rsItem.getLong("CODIGO"));
                    vendaItem.setProduto(produtoDAO.recuperar(rsItem.getLong("PRODUTO")));
                    vendaItem.setVenda(venda);
                    vendaItem.setQuantidade(rsItem.getLong("QUANTIDADE"));
                    vendaItem.setValorUnitario(rsItem.getDouble("VALOR_UNITARIO"));
                    venda.getItens().add(vendaItem);
                }

                listaVendas.add(venda);
        }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new ErroException(e.getMessage(), e.getCause());
        } finally {
            this.fecharConexao();
        }
        return listaVendas;
    }
    
    public List<Venda> listarVendaSelecionada(Long codigoVenda) throws ErroException {
        List listaVendas = new LinkedList();
        try {
            this.conectar();
            ClienteDAO clienteDAO = new ClienteDAO();
            ProdutoDAO produtoDAO = new ProdutoDAO();
            VendaControl vendaControl = new VendaControl();

            String sql = "SELECT * FROM VENDAS WHERE CODIGO = ?";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setLong(1, codigoVenda);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda();
                venda.setCodigo(rs.getLong("CODIGO"));
                venda.setCliente(clienteDAO.recuperar(rs.getInt("CLIENTE")));
                venda.setDataVenda(rs.getDate("DATA_VENDA"));
                venda.setValorTotal(rs.getDouble("VALOR_TOTAL"));
                venda.setSituacao(vendaControl.gravarSituacao(rs.getInt("SITUACAO")));

                String sqlItem = "SELECT * FROM VENDAS_ITENS WHERE VENDA = ?";
                PreparedStatement psItem = this.getCon().prepareStatement(sqlItem);
                psItem.setLong(1, venda.getCodigo());
                ResultSet rsItem = psItem.executeQuery();

                while (rsItem.next()) {
                    VendaItem vendaItem = new VendaItem();
                    vendaItem.setCodigo(rsItem.getLong("CODIGO"));
                    vendaItem.setProduto(produtoDAO.recuperar(rsItem.getLong("PRODUTO")));
                    vendaItem.setVenda(venda);
                    vendaItem.setQuantidade(rsItem.getLong("QUANTIDADE"));
                    vendaItem.setValorUnitario(rsItem.getDouble("VALOR_UNITARIO"));
                    venda.getItens().add(vendaItem);
                }

                listaVendas.add(venda);
        }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new ErroException(e.getMessage(), e.getCause());
        } finally {
            this.fecharConexao();
        }
        
        return listaVendas;
    }

    public Venda recuperar() throws ErroException {
        Venda venda = new Venda();
        try {
            this.conectar();
            ClienteDAO clienteDAO = new ClienteDAO();
            ProdutoDAO produtoDAO = new ProdutoDAO();
            VendaControl vendaControl = new VendaControl();

            String sql = "SELECT * FROM VENDAS ORDER BY DATA_VENDA DESC";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                venda.setCodigo(rs.getLong("CODIGO"));
                venda.setCliente(clienteDAO.recuperar(rs.getInt("CLIENTE")));
                venda.setDataVenda(rs.getDate("DATA_VENDA"));
                venda.setValorTotal(rs.getDouble("VALOR_TOTAL"));
                venda.setSituacao(vendaControl.gravarSituacao(rs.getInt("SITUACAO")));

                String sqlItem = "SELECT * FROM VENDAS_ITENS WHERE VENDA = ?";
                PreparedStatement psItem = this.getCon().prepareStatement(sqlItem);
                psItem.setLong(1, venda.getCodigo());
                ResultSet rsItem = psItem.executeQuery();

                while (rsItem.next()) {
                    VendaItem vendaItem = new VendaItem();
                    vendaItem.setCodigo(rsItem.getLong("CODIGO"));
                    vendaItem.setProduto(produtoDAO.recuperar(rsItem.getLong("PRODUTO")));
                    vendaItem.setVenda(venda);
                    vendaItem.setQuantidade(rsItem.getLong("QUANTIDADE"));
                    vendaItem.setValorUnitario(rsItem.getDouble("VALOR_UNITARIO"));
                    venda.getItens().add(vendaItem);
                }

            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new ErroException(e.getMessage(), e.getCause());
        } finally {
            this.fecharConexao();
        }
        
        return venda;
    }
    
}

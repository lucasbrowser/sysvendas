/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.sysvendas.model.dao;

import com.lucas.sysvendas.bd.ConexaoPostgres;
import com.lucas.sysvendas.control.CompraControl;
import com.lucas.sysvendas.model.domain.Compra;
import com.lucas.sysvendas.model.domain.CompraItem;
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
public class CompraDAO extends ConexaoPostgres {
    
    ProdutoDAO produtoDAO = new ProdutoDAO();
    
    public void inserir(Compra compra) throws ErroException {
        try{
            this.conectar();
            
            String sql = "INSERT INTO COMPRAS ("
                    + "FORNECEDOR, "
                    + "DATA_COMPRA, "
                    + "VALOR_TOTAL, "
                    + "SITUACAO) "
                    + "VALUES (?, ?, ?, ?)";
            
            PreparedStatement ps = this.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, compra.getFornecedor().getCodigo());
            ps.setDate(2, new Date(compra.getDataCompra().getTime()));
            ps.setDouble(3, compra.getValorTotal());
            ps.setInt(4, compra.getSituacao().getId());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int idCompra = rs.getInt(1);

            for (CompraItem iv : compra.getItens()) {
                sql = "INSERT INTO COMPRAS_ITENS ("
                        + "PRODUTO, "
                        + "COMPRA, "
                        + "QUANTIDADE, "
                        + "VALOR_UNITARIO) "
                        + "VALUES (?, ?, ?, ?)";
                
                ps = this.getCon().prepareStatement(sql);
                ps.setLong(1, iv.getProduto().getCodigo());
                ps.setInt(2, idCompra);
                ps.setLong(3, iv.getQuantidade());
                ps.setDouble(4, iv.getValorUnitario());
                ps.execute();
                
                if (compra.getSituacao() == SituacaoEnum.FINALIZADA) {
                    produtoDAO.entradaEstoque(iv.getProduto().getCodigo(), iv.getQuantidade());
                }
        }
        }catch(SQLException e){
            e.printStackTrace();
            throw new ErroException(e.getMessage(), e.getCause());
        }finally{
            this.fecharConexao();
        }
    }

    public void alterar(Compra compra) throws ErroException {
        try{
            this.conectar();
            
            String sql = "UPDATE COMPRAS SET "
                    + "FORNECEDOR = ?, "
                    + "DATA_COMPRA = ?, "
                    + "VALOR_TOTAL = ?, "
                    + "SITUACAO = ? "
                    + "WHERE CODIGO = ?";
            
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setLong(1, compra.getFornecedor().getCodigo());
            ps.setDate(2, new Date(compra.getDataCompra().getTime()));
            ps.setDouble(3, compra.getValorTotal());
            ps.setInt(4, compra.getSituacao().getId());
            ps.setLong(5, compra.getCodigo());
            ps.execute();

            for (CompraItem compraItem : compra.getItens()) {
                
                if (compraItem.getCodigo() == 0) {
                    
                    sql = "INSERT INTO COMPRAS_ITENS ("
                        + "PRODUTO, "
                        + "COMPRA, "
                        + "QUANTIDADE, "
                        + "VALOR_UNITARIO) "
                        + "VALUES (?, ?, ?, ?)";
                    
                    ps = this.getCon().prepareStatement(sql);
                    ps.setLong(1, compraItem.getProduto().getCodigo());
                    ps.setLong(2, compraItem.getCompra().getCodigo());
                    ps.setLong(3, compraItem.getQuantidade());
                    ps.setDouble(4, compraItem.getValorUnitario());
                    ps.execute();
                    
                } else {
                    
                    sql = "UPDATE COMPRAS_ITENS SET "
                            + "PRODUTO = ?, "
                            + "COMPRA = ?, "
                            + "QUANTIDADE = ?, "
                            + "VALOR_UNITARIO = ? "
                            + "WHERE CODIGO = ?";
                    
                    ps = this.getCon().prepareStatement(sql);
                    ps.setLong(1, compraItem.getProduto().getCodigo());
                    ps.setLong(2, compraItem.getCompra().getCodigo());
                    ps.setLong(3, compraItem.getQuantidade());
                    ps.setDouble(4, compraItem.getValorUnitario());
                    ps.setLong(5, compraItem.getCodigo());
                    ps.execute();
                }
                
                if (compra.getSituacao() == SituacaoEnum.FINALIZADA) {
                    produtoDAO.entradaEstoque(compraItem.getProduto().getCodigo(), compraItem.getQuantidade());
                }
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
            throw new ErroException(e.getMessage(), e.getCause());
        } finally {
            this.fecharConexao();
        }
    }


    public void excluir(Compra compra) throws ErroException {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                "UPDATE COMPRAS SET "
                    + "FORNECEDOR = '" + compra.getFornecedor().getCodigo() + "',"
                    + "DATA_COMPRA = '" + new Date(compra.getDataCompra().getTime()) + "',"
                    + "VALOR_TOTAL = '" + compra.getValorTotal() + "',"
                    + "SITUACAO = '" + SituacaoEnum.CANCELADA.getId() + "'"
                + " WHERE "
                    + "CODIGO = '" + compra.getCodigo() + "'"
                + ";"
            );
        } catch(Exception e) {
            e.printStackTrace();
            throw new ErroException(e.getMessage(), e.getCause());
        } finally {
            this.fecharConexao();
        }
    }

    public List<Compra> listarTodos() throws ErroException {
        List listaCompras = new LinkedList();
        try {
            this.conectar();
            FornecedorDAO fornecedorDAO = new FornecedorDAO();
            ProdutoDAO produtoDAO = new ProdutoDAO();
            CompraControl compraControl = new CompraControl();

            String sql = "SELECT * FROM COMPRAS ORDER BY DATA_COMPRA DESC";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Compra compra = new Compra();
                compra.setCodigo(rs.getLong("CODIGO"));
                compra.setFornecedor(fornecedorDAO.recuperar(rs.getInt("FORNECEDOR")));
                compra.setDataCompra(rs.getDate("DATA_COMPRA"));
                compra.setValorTotal(rs.getDouble("VALOR_TOTAL"));
                compra.setSituacao(compraControl.gravarSituacao(rs.getInt("SITUACAO")));

                String sqlItem = "SELECT * FROM COMPRAS_ITENS WHERE COMPRA = ?";
                PreparedStatement psItem = this.getCon().prepareStatement(sqlItem);
                psItem.setLong(1, compra.getCodigo());
                ResultSet rsItem = psItem.executeQuery();

                while (rsItem.next()) {
                    CompraItem compraItem = new CompraItem();
                    compraItem.setCodigo(rsItem.getLong("CODIGO"));
                    compraItem.setProduto(produtoDAO.recuperar(rsItem.getLong("PRODUTO")));
                    compraItem.setCompra(compra);
                    compraItem.setQuantidade(rsItem.getLong("QUANTIDADE"));
                    compraItem.setValorUnitario(rsItem.getDouble("VALOR_UNITARIO"));
                    compra.getItens().add(compraItem);
                }

                listaCompras.add(compra);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new ErroException(e.getMessage(), e.getCause());
        } finally {
            this.fecharConexao();
        }
        
        return listaCompras;
    }

    public Compra recuperar() throws ErroException {
        Compra compra = new Compra();
        try {
            this.conectar();
            FornecedorDAO fornecedorDAO = new FornecedorDAO();
            CompraControl compraControl = new CompraControl();

            String sql = "SELECT * FROM COMPRAS ORDER BY DATA_COMPRA DESC";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                compra.setCodigo(rs.getLong("CODIGO"));
                compra.setFornecedor(fornecedorDAO.recuperar(rs.getInt("FORNECEDOR")));
                compra.setDataCompra(rs.getDate("DATA_COMPRA"));
                compra.setValorTotal(rs.getDouble("VALOR_TOTAL"));
                compra.setSituacao(compraControl.gravarSituacao(rs.getInt("SITUACAO")));

                String sqlItem = "SELECT * FROM COMPRAS_ITENS WHERE COMPRA = ?";
                PreparedStatement psItem = this.getCon().prepareStatement(sqlItem);
                psItem.setLong(1, compra.getCodigo());
                ResultSet rsItem = psItem.executeQuery();

                while (rsItem.next()) {
                    CompraItem compraItem = new CompraItem();
                    compraItem.setCodigo(rsItem.getLong("CODIGO"));
                    compraItem.setProduto(produtoDAO.recuperar(rsItem.getLong("PRODUTO")));
                    compraItem.setCompra(compra);
                    compraItem.setQuantidade(rsItem.getLong("QUANTIDADE"));
                    compraItem.setValorUnitario(rsItem.getDouble("VALOR_UNITARIO"));
                    compra.getItens().add(compraItem);
                }

            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new ErroException(e.getMessage(), e.getCause());
        } finally {
            this.fecharConexao();
        }
        
        return compra;
    }
    
}

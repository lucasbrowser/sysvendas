/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.sysvendas.model.dao;

import com.lucas.sysvendas.bd.ConexaoPostgres;
import com.lucas.sysvendas.model.domain.Produto;
import com.lucas.sysvendas.util.exceptions.ErroException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class ProdutoDAO extends ConexaoPostgres {
    
    public void inserir(Produto produto) throws ErroException {
        try{
            this.conectar();
            this.insertSQL("INSERT INTO PRODUTOS (DESCRICAO, PRECO_COMPRA, PRECO_VENDA, QUANTIDADE_ESTOQUE) "
                    + "VALUES ("
                    + "'" + produto.getDescricao() + "',"
                    + "'" + produto.getPrecoCompra() + "',"
                    + "'" + produto.getPrecoVenda() + "',"
                    + "'" + produto.getQuantidadeEstoque()+ "'"
                    + ");"
            );
        } catch(Exception e) {
            e.printStackTrace();
            throw new ErroException(e.getMessage(), e.getCause());
        } finally {
            this.fecharConexao();
        }
    }

    public void alterar(Produto produto) throws ErroException {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                "UPDATE PRODUTOS SET "
                    + "DESCRICAO = '" + produto.getDescricao() + "',"
                    + "PRECO_COMPRA = '" + produto.getPrecoCompra() + "',"
                    + "PRECO_VENDA = '" + produto.getPrecoVenda() + "',"
                    + "QUANTIDADE_ESTOQUE = '" + produto.getQuantidadeEstoque()+ "'"
                + " WHERE "
                    + "CODIGO = '" + produto.getCodigo() + "'"
                + ";"
            );
        } catch(Exception e) {
            e.printStackTrace();
            throw new ErroException(e.getMessage(), e.getCause());
        } finally {
            this.fecharConexao();
        }
    }

    public void entradaEstoque(Long codigo, Long quantidade) throws ErroException {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE PRODUTOS SET "
                    + "QUANTIDADE_ESTOQUE = QUANTIDADE_ESTOQUE  + '"+quantidade+"'"
                            + " WHERE CODIGO='"+codigo+"'");
        } catch(Exception e) {
            e.printStackTrace();
            throw new ErroException(e.getMessage(), e.getCause());
        } finally {
            this.fecharConexao();
        }
    }

    public void saidaEstoque(Long codigo, Long quantidade) throws ErroException {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE PRODUTOS SET "
                    + "QUANTIDADE_ESTOQUE= QUANTIDADE_ESTOQUE  - '"+quantidade+"'"
                            + " WHERE CODIGO='"+codigo+"'");
        } catch(Exception e) {
            e.printStackTrace();
            throw new ErroException(e.getMessage(), e.getCause());
        } finally {
            this.fecharConexao();
        }
    }

    public void excluir(Produto produto) throws ErroException {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                "DELETE FROM PRODUTOS "
                + " WHERE "
                    + "CODIGO = '" + produto.getCodigo() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            throw new ErroException(e.getMessage(), e.getCause());
        }finally{
            this.fecharConexao();
        }
    }

    public List<Produto> listarTodos() throws ErroException {
        List listaProdutos = new LinkedList();
        try {
            this.conectar();
            this.executarSQL("SELECT * FROM PRODUTOS ORDER BY CODIGO");
            while (this.getResultSet().next()) {
                Produto produto = new Produto();
                produto.setCodigo(this.getResultSet().getLong("CODIGO"));
                produto.setDescricao(this.getResultSet().getString("DESCRICAO"));
                produto.setPrecoCompra(this.getResultSet().getDouble("PRECO_COMPRA"));
                produto.setPrecoVenda(this.getResultSet().getDouble("PRECO_VENDA"));
                produto.setQuantidadeEstoque(this.getResultSet().getLong("QUANTIDADE_ESTOQUE"));
                listaProdutos.add(produto);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new ErroException(e.getMessage(), e.getCause());
        } finally {
            this.fecharConexao();
        }    
        return listaProdutos;
    }

    public Produto recuperar(Long codigo) throws ErroException {
        Produto produto = new Produto();
        try {
            this.conectar();
            this.executarSQL("SELECT * FROM PRODUTOS WHERE CODIGO='"+codigo+"'");
            while (this.getResultSet().next()) {
                produto.setCodigo(this.getResultSet().getLong("CODIGO"));
                produto.setDescricao(this.getResultSet().getString("DESCRICAO"));
                produto.setPrecoCompra(this.getResultSet().getDouble("PRECO_COMPRA"));
                produto.setPrecoVenda(this.getResultSet().getDouble("PRECO_VENDA"));
                produto.setQuantidadeEstoque(this.getResultSet().getLong("QUANTIDADE_ESTOQUE"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new ErroException(e.getMessage(), e.getCause());
        } finally {
            this.fecharConexao();
        }        
        return produto;
    }
    
}

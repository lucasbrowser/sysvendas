/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.sysvendas.model.dao;

import com.lucas.sysvendas.bd.ConexaoPostgres;
import com.lucas.sysvendas.model.domain.Produto;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class ProdutoDAO extends ConexaoPostgres {
    
    public void inserir(Produto produto) throws Exception {
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
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
    }

    public void alterar(Produto produto) throws Exception {
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
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
    }

    public void entradaEstoque(Long codigo, Long quantidade) throws Exception {
        try{
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE PRODUTOS SET "
                    + "QUANTIDADE_ESTOQUE = QUANTIDADE_ESTOQUE  + '"+quantidade+"'"
                            + " WHERE CODIGO='"+codigo+"'");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
    }

    public void saidaEstoque(Long codigo, Long quantidade) throws Exception {
        try{
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE PRODUTOS SET "
                    + "QUANTIDADE_ESTOQUE= QUANTIDADE_ESTOQUE  - '"+quantidade+"'"
                            + " WHERE CODIGO='"+codigo+"'");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
    }

    public void excluir(Produto produto) throws Exception {
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
        }finally{
            this.fecharConexao();
        }
    }

    public List<Produto> listarTodos() throws Exception {
        List listaProdutos = new LinkedList();
        try{
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
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }    
        return listaProdutos;
    }

    public Produto recuperar(Long codigo) throws Exception {
        Produto produto = new Produto();
        try{
            this.conectar();
            this.executarSQL("SELECT * FROM PRODUTOS WHERE CODIGO='"+codigo+"'");
            while (this.getResultSet().next()) {
                produto.setCodigo(this.getResultSet().getLong("CODIGO"));
                produto.setDescricao(this.getResultSet().getString("DESCRICAO"));
                produto.setPrecoCompra(this.getResultSet().getDouble("PRECO_COMPRA"));
                produto.setPrecoVenda(this.getResultSet().getDouble("PRECO_VENDA"));
                produto.setQuantidadeEstoque(this.getResultSet().getLong("QUANTIDADE_ESTOQUE"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }        
        return produto;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.sysvendas.control;



import com.lucas.sysvendas.model.dao.ProdutoDAO;
import com.lucas.sysvendas.model.domain.Produto;
import java.util.List;

/**
 *
 * @author lucas
 */
public class ProdutoControl {
    
    ProdutoDAO produtoDAO = new ProdutoDAO();
    
    public List<Produto> listarTodos() throws Exception {
        return produtoDAO.listarTodos();
    }
    
    public void inserirProduto(Produto produto) throws Exception {
        produtoDAO.inserir(produto);
    }
    
    public void alterarProduto(Produto produto) throws Exception {
        produtoDAO.alterar(produto);
    }
    
    public void excluirProduto(Produto produto) throws Exception {
        produtoDAO.excluir(produto);
    }
}

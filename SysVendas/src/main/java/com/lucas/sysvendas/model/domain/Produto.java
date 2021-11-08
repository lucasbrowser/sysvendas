/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.sysvendas.model.domain;

import com.towel.el.annotation.Resolvable;

/**
 *
 * @author lucas
 */
public class Produto {
    
    @Resolvable(colName = "Código")
    private Long codigo;
    
    @Resolvable(colName = "Descrição")
    private String descricao;
    
    @Resolvable(colName = "Preço Compra")
    private Double precoCompra;
    
    @Resolvable(colName = "Preço Venda")
    private Double precoVenda;
    
    @Resolvable(colName = "Qtd. Estoque")
    private Long quantidadeEstoque;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Long getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Long quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
    
    
    
}

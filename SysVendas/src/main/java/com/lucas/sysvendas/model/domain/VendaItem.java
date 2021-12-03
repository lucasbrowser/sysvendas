/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.sysvendas.model.domain;

import com.lucas.sysvendas.formatter.DoubleFormatoMoeda;
import com.towel.el.annotation.Resolvable;

/**
 *
 * @author lucas
 */
public class VendaItem {
    
    @Resolvable(colName = "Código")
    private Long codigo;
    
    @Resolvable(colName = "Produto")
    private Produto produto;
    
    @Resolvable(colName = "Venda")
    private Venda venda;
    
    @Resolvable(colName = "Quantidade")
    private Long quantidade;
    
    @Resolvable(colName = "Valor Unitário", formatter = DoubleFormatoMoeda.class)
    private Double valorUnitario;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    
    @Override
    public String toString() {
        return getProduto().getDescricao();
    }
    
}

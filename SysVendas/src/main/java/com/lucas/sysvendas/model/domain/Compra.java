/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.sysvendas.model.domain;

import com.lucas.sysvendas.model.enums.SituacaoEnum;
import com.towel.el.annotation.Resolvable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class Compra {
    
    @Resolvable(colName = "Código")
    private Long codigo;
    
    @Resolvable(colName = "Fornecedor")
    private Fornecedor fornecedor;
    
    @Resolvable(colName = "Data Compra")
    private Date dataCompra;
    
    @Resolvable(colName = "Valor Total")
    private Double valorTotal;
    
    @Resolvable(colName = "Situação")
    private SituacaoEnum situacao;
    
    private List<CompraItem> itens = new LinkedList<>();

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public SituacaoEnum getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoEnum situacao) {
        this.situacao = situacao;
    }

    public List<CompraItem> getItens() {
        return itens;
    }

    public void setItens(List<CompraItem> itens) {
        this.itens = itens;
    }
    
    

}

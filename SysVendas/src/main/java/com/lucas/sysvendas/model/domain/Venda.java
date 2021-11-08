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
public class Venda {
    
    @Resolvable(colName = "Código")
    private Long codigo;
    
    @Resolvable(colName = "Cliente")
    private Cliente cliente;
    
    @Resolvable(colName = "Data Venda")
    private Date dataVenda;
    
    @Resolvable(colName = "Valor Total")
    private Double valorTotal;
    
    @Resolvable(colName = "Situação")
    private SituacaoEnum situacao;
    
    private List<VendaItem> itens = new LinkedList<>();

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
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

    public List<VendaItem> getItens() {
        return itens;
    }

    public void setItens(List<VendaItem> itens) {
        this.itens = itens;
    }
    
}

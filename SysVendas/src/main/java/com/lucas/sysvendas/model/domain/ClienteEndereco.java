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
public class ClienteEndereco {
    
    @Resolvable(colName = "Código")
    private Long codigo;
    
    @Resolvable(colName = "Cliente")
    private Cliente cliente;
    
    @Resolvable(colName = "Endereço")
    private String endereco;
    
    @Resolvable(colName = "Número")
    private String numero;
    
    @Resolvable(colName = "Bairro")
    private String bairro;
    
    @Resolvable(colName = "Complemento")
    private String complemento;
    
    @Resolvable(colName = "Cidade")
    private String cidade;
    
    @Resolvable(colName = "Estado")
    private String estado;
    
    @Resolvable(colName = "CEP")
    private String cep;

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    
    
}

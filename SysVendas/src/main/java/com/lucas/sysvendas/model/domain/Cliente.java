/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.sysvendas.model.domain;

import com.towel.el.annotation.Resolvable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class Cliente {
    
    @Resolvable(colName = "Código")
    private Long codigo;
    
    @Resolvable(colName = "Nome Fantasia")
    private String nomeFantasia;
    
    @Resolvable(colName = "CPF/CNPJ")
    private String cpfCnpj;
    
    @Resolvable(colName = "Razão Social")
    private String razaoSocial;
    
    @Resolvable(colName = "Data Cadastro")
    private Date dataCadastro;
    
    @Resolvable(colName = "Documento")
    private String documento;
    
    @Resolvable(colName = "Tipo Pessoa")
    private String tipoPessoa;
    
    @Resolvable(colName = "Telefone")
    private String telefone;
    
    @Resolvable(colName = "Celular")
    private String celular;
    
    @Resolvable(colName = "Email")
    private String email;
    
    private List<ClienteEndereco> endereco = new LinkedList<>();

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ClienteEndereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<ClienteEndereco> endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return getNomeFantasia();
    }
    
    
    
}

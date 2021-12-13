/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.sysvendas.control;



import com.lucas.sysvendas.model.dao.FornecedorDAO;
import com.lucas.sysvendas.model.domain.Fornecedor;
import com.lucas.sysvendas.model.domain.FornecedorEndereco;
import com.lucas.sysvendas.util.exceptions.ErroException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lucas
 */
public class FornecedorControl {
    
    private FornecedorDAO fornecedorDAO = new FornecedorDAO();
    private Fornecedor fornecedor;
    private FornecedorEndereco fornecedorEndereco;
    
    
    public List<Fornecedor> listarTodos() throws ErroException {
        return fornecedorDAO.listarTodos();
    }
    
    public List<FornecedorEndereco> recuperarEndereco(Fornecedor fornecedor) throws ErroException {
        return fornecedorDAO.recuperarEndereco(fornecedor);
    }
    
    public void inserirFornecedor(Fornecedor fornecedor) throws ErroException {
        fornecedorDAO.inserir(fornecedor);
    }
    
    public void alterarFornecedor(Fornecedor fornecedor) throws ErroException {
        fornecedorDAO.alterar(fornecedor);
    }
    
    public void excluirFornecedor(Fornecedor fornecedor) throws ErroException {
        fornecedorDAO.excluir(fornecedor);
    }
    
    public Fornecedor novoFornecedor() {
        
        fornecedor = new Fornecedor();
        fornecedor.setCodigo(0l);
        fornecedor.setNomeFantasia("");
        fornecedor.setRazaoSocial("");
        fornecedor.setDataCadastro(new Date());
        fornecedor.setCnpj("");
        fornecedor.setDocumento("");
        fornecedor.setTelefone("");
        fornecedor.setCelular("");
        fornecedor.setEmail("");
        
        return fornecedor;
    }
    
    public FornecedorEndereco novoFornecedorEndereco() {
        
        fornecedorEndereco = new FornecedorEndereco();
        fornecedorEndereco.setCodigo(0l);
        fornecedorEndereco.setEndereco("");
        fornecedorEndereco.setNumero("");
        fornecedorEndereco.setBairro("");
        fornecedorEndereco.setComplemento("");
        fornecedorEndereco.setCidade("");
        fornecedorEndereco.setEstado("");
        fornecedorEndereco.setCep("");
        
        return fornecedorEndereco; 
    }
}

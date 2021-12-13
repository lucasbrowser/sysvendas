/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.sysvendas.control;



import com.lucas.sysvendas.model.dao.ClienteDAO;
import com.lucas.sysvendas.model.domain.Cliente;
import com.lucas.sysvendas.model.domain.ClienteEndereco;
import com.lucas.sysvendas.util.exceptions.ErroException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lucas
 */
public class ClienteControl {
    
    private ClienteDAO clienteDAO = new ClienteDAO();
    private Cliente cliente;
    private ClienteEndereco clienteEndereco;
    
    
    public List<Cliente> listarTodos() throws ErroException {
        return clienteDAO.listarTodos();
    }
    
    public List<ClienteEndereco> recuperarEndereco(Cliente cliente) throws ErroException {
        return clienteDAO.recuperarEndereco(cliente);
    }
    
    public void inserirCliente(Cliente cliente) throws ErroException {
        clienteDAO.inserir(cliente);
    }
    
    public void alterarCliente(Cliente cliente) throws ErroException {
        clienteDAO.alterar(cliente);
    }
    
    public void excluirCliente(Cliente cliente) throws ErroException {
        clienteDAO.excluir(cliente);
    }
    
    public Cliente novoCliente() {
        
        cliente = new Cliente();
        cliente.setCodigo(0l);
        cliente.setNomeFantasia("");
        cliente.setRazaoSocial("");
        cliente.setDataCadastro(new Date());
        cliente.setTipoPessoa("");
        cliente.setCpfCnpj("");
        cliente.setDocumento("");
        cliente.setTelefone("");
        cliente.setCelular("");
        cliente.setEmail("");
        
        return cliente;
    }
    
    public ClienteEndereco novoClienteEndereco() {
        
        clienteEndereco = new ClienteEndereco();
        clienteEndereco.setCodigo(0l);
        clienteEndereco.setEndereco("");
        clienteEndereco.setNumero("");
        clienteEndereco.setBairro("");
        clienteEndereco.setComplemento("");
        clienteEndereco.setCidade("");
        clienteEndereco.setEstado("");
        clienteEndereco.setCep("");
        
        return clienteEndereco; 
    }
}

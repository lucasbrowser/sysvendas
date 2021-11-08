/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.sysvendas.control;



import com.lucas.sysvendas.model.dao.ClienteDAO;
import com.lucas.sysvendas.model.domain.Cliente;
import java.util.List;

/**
 *
 * @author lucas
 */
public class ClienteControl {
    
    ClienteDAO clienteDAO = new ClienteDAO();
    
    public List<Cliente> listarTodos() throws Exception {
        return clienteDAO.listarTodos();
    }
    
    public void inserirCliente(Cliente cliente) throws Exception {
        clienteDAO.inserir(cliente);
    }
    
    public void alterarCliente(Cliente cliente) throws Exception {
        clienteDAO.alterar(cliente);
    }
    
    public void excluirCliente(Cliente cliente) throws Exception {
        clienteDAO.excluir(cliente);
    }
}

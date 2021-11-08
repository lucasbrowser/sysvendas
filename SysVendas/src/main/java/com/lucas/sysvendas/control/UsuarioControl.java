/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.sysvendas.control;



import com.lucas.sysvendas.model.dao.UsuarioDAO;
import com.lucas.sysvendas.model.domain.Usuario;
import java.util.List;

/**
 *
 * @author lucas
 */
public class UsuarioControl {
    
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    public List<Usuario> listarTodos() throws Exception {
        return usuarioDAO.listarTodos();
    }
    
    public Usuario logarUsuario(String login, String senha) throws Exception {
        return usuarioDAO.logar(login, senha);
    }
    
    public void inserirUsuario(Usuario usuario) throws Exception {
        usuarioDAO.inserir(usuario);
    }
    
    public void alterarUsuario(Usuario usuario) throws Exception {
        usuarioDAO.alterar(usuario);
    }
    
    public void excluirUsuario(Usuario usuario) throws Exception {
        usuarioDAO.excluir(usuario);
    }
}

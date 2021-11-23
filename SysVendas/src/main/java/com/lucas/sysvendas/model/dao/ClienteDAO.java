/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.sysvendas.model.dao;

import com.lucas.sysvendas.bd.ConexaoPostgres;
import com.lucas.sysvendas.model.domain.Cliente;
import com.lucas.sysvendas.model.domain.ClienteEndereco;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class ClienteDAO extends ConexaoPostgres {
    
    public void inserir(Cliente cliente) throws Exception {
        try{           
            this.conectar();
            
            String sql = "INSERT INTO CLIENTES ("
                    + "NOME_FANTASIA, "
                    + "CPF_CNPJ, "
                    + "RAZAO_SOCIAL, "
                    + "DATA_CADASTRO, "
                    + "DOCUMENTO, "
                    + "TIPO_PESSOA, "
                    + "TELEFONE, "
                    + "CELULAR, "
                    + "EMAIL) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = this.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getNomeFantasia());
            ps.setString(2, cliente.getCpfCnpj());
            ps.setString(3, cliente.getRazaoSocial());
            ps.setDate(4, new Date(cliente.getDataCadastro().getTime()));
            ps.setString(5, cliente.getDocumento());
            ps.setString(6, cliente.getTipoPessoa());
            ps.setString(7, cliente.getTelefone());
            ps.setString(8, cliente.getCelular());
            ps.setString(9, cliente.getEmail());
            ps.execute();
            
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int idCliente = rs.getInt(1);
            
            for (ClienteEndereco endereco : cliente.getEndereco()) {
                
                sql = "INSERT INTO CLIENTES_ENDERECOS ("
                        + "CLIENTE, "
                        + "ENDERECO, "
                        + "NUMERO, "
                        + "BAIRRO,"
                        + "COMPLEMENTO,"
                        + "CIDADE,"
                        + "ESTADO,"
                        + "CEP)"
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                
                ps = this.getCon().prepareStatement(sql);
                ps.setInt(1, idCliente);
                ps.setString(2, endereco.getEndereco());
                ps.setString(3, endereco.getNumero());
                ps.setString(4, endereco.getBairro());
                ps.setString(5, endereco.getComplemento());
                ps.setString(6, endereco.getCidade());
                ps.setString(7, endereco.getEstado());
                ps.setString(8, endereco.getCep());
                ps.execute();
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
    }

    public void alterar(Cliente cliente) throws Exception {
        try{
            this.conectar();
            String sql = "UPDATE CLIENTES SET "
                    + "NOME_FANTASIA = ?, "
                    + "CPF_CNPJ = ?, "
                    + "RAZAO_SOCIAL = ?, "
                    + "DATA_CADASTRO = ?, "
                    + "DOCUMENTO = ?,"
                    + "TIPO_PESSOA = ?, "
                    + "TELEFONE = ?, "
                    + "CELULAR = ?, "
                    + "EMAIL = ? "
                    + "WHERE CODIGO = ?";
            
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setString(1, cliente.getNomeFantasia());
            ps.setString(2, cliente.getCpfCnpj());
            ps.setString(3, cliente.getRazaoSocial());
            ps.setDate(4, new Date(cliente.getDataCadastro().getTime()));
            ps.setString(5, cliente.getDocumento());
            ps.setString(6, cliente.getTipoPessoa());
            ps.setString(7, cliente.getTelefone());
            ps.setString(8, cliente.getCelular());
            ps.setString(9, cliente.getEmail());
            ps.setLong(10, cliente.getCodigo());
            ps.execute();
            
            for (ClienteEndereco endereco : cliente.getEndereco()) {
                
                sql = "UPDATE CLIENTES_ENDERECOS SET "
                        + "CLIENTE = ?, "
                        + "ENDERECO = ?, "
                        + "NUMERO = ?, "
                        + "BAIRRO = ?, "
                        + "COMPLEMENTO = ?, "
                        + "CIDADE = ?, "
                        + "ESTADO = ?, "
                        + "CEP = ? "
                        + "WHERE CODIGO = ? ";
                
                ps = this.getCon().prepareStatement(sql);
                ps.setLong(1, endereco.getCliente().getCodigo());
                ps.setString(2, endereco.getEndereco());
                ps.setString(3, endereco.getNumero());
                ps.setString(4, endereco.getBairro());
                ps.setString(5, endereco.getComplemento());
                ps.setString(6, endereco.getCidade());
                ps.setString(7, endereco.getEstado());
                ps.setString(8, endereco.getCep());
                ps.setLong(9, endereco.getCodigo());
                ps.execute();
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
    }

    public void excluir(Cliente cliente) throws Exception {
        try{
            this.conectar();
            String sql = "DELETE FROM CLIENTES WHERE CODIGO = ?";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setLong(1, cliente.getCodigo());
            ps.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
    }

    public List<Cliente> listarTodos() throws Exception {
        List listaClientes = new LinkedList();
        try{
            this.conectar();
            String sql = "SELECT * FROM CLIENTES ORDER BY NOME_FANTASIA";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodigo(rs.getLong("CODIGO"));
                cliente.setNomeFantasia(rs.getString("NOME_FANTASIA"));
                cliente.setCpfCnpj(rs.getString("CPF_CNPJ"));
                cliente.setRazaoSocial(rs.getString("RAZAO_SOCIAL"));
                cliente.setDataCadastro(rs.getDate("DATA_CADASTRO"));
                cliente.setDocumento(rs.getString("DOCUMENTO"));
                cliente.setTipoPessoa(rs.getString("TIPO_PESSOA"));
                cliente.setTelefone(rs.getString("TELEFONE"));
                cliente.setCelular(rs.getString("CELULAR"));
                cliente.setEmail(rs.getString("EMAIL"));
                listaClientes.add(cliente);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listaClientes;
    }

    public Cliente recuperar(int codigo) throws Exception {
        Cliente cliente = new Cliente();
        try{
            this.conectar();
            String sql = "SELECT * FROM CLIENTES WHERE CODIGO = ?";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente.setCodigo(rs.getLong("CODIGO"));
                cliente.setNomeFantasia(rs.getString("NOME_FANTASIA"));
                cliente.setCpfCnpj(rs.getString("CPF_CNPJ"));
                cliente.setRazaoSocial(rs.getString("RAZAO_SOCIAL"));
                cliente.setDataCadastro(rs.getDate("DATA_CADASTRO"));
                cliente.setDocumento(rs.getString("DOCUMENTO"));
                cliente.setTipoPessoa(rs.getString("TIPO_PESSOA"));
                cliente.setTelefone(rs.getString("TELEFONE"));
                cliente.setCelular(rs.getString("CELULAR"));
                cliente.setEmail(rs.getString("EMAIL"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return cliente;
    }
    
    public List<ClienteEndereco> recuperarEndereco(Cliente cliente) throws Exception {
        List<ClienteEndereco> lEndereco = new LinkedList<>();
        try{
            this.conectar();
            String sql = "SELECT * FROM CLIENTES_ENDERECOS WHERE CLIENTE = ?";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setLong(1, cliente.getCodigo());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ClienteEndereco endereco = new ClienteEndereco();
                endereco.setCodigo(rs.getLong("CODIGO"));
                endereco.setCliente(cliente);
                endereco.setEndereco(rs.getString("ENDERECO"));
                endereco.setNumero(rs.getString("NUMERO"));
                endereco.setBairro(rs.getString("BAIRRO"));
                endereco.setComplemento(rs.getString("COMPLEMENTO"));
                endereco.setCidade(rs.getString("CIDADE"));
                endereco.setEstado(rs.getString("ESTADO"));
                endereco.setCep(rs.getString("CEP"));
                lEndereco.add(endereco);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return lEndereco;
    }
    
}

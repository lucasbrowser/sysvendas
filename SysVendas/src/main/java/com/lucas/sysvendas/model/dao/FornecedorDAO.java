/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.sysvendas.model.dao;

import com.lucas.sysvendas.bd.ConexaoPostgres;
import com.lucas.sysvendas.model.domain.Fornecedor;
import com.lucas.sysvendas.model.domain.FornecedorEndereco;
import com.lucas.sysvendas.util.exceptions.ErroException;
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
public class FornecedorDAO extends ConexaoPostgres {
    
    public void inserir(Fornecedor fornecedor) throws ErroException {
        try {           
            this.conectar();
            
            String sql = "INSERT INTO FORNECEDORES ("
                    + "NOME_FANTASIA, "
                    + "CNPJ, "
                    + "RAZAO_SOCIAL, "
                    + "DATA_CADASTRO, "
                    + "DOCUMENTO, "
                    + "TELEFONE, "
                    + "CELULAR, "
                    + "EMAIL) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = this.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, fornecedor.getNomeFantasia());
            ps.setString(2, fornecedor.getCnpj());
            ps.setString(3, fornecedor.getRazaoSocial());
            ps.setDate(4, new Date(fornecedor.getDataCadastro().getTime()));
            ps.setString(5, fornecedor.getDocumento());
            ps.setString(6, fornecedor.getTelefone());
            ps.setString(7, fornecedor.getCelular());
            ps.setString(8, fornecedor.getEmail());
            ps.execute();
            
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int idCliente = rs.getInt(1);
            
            for (FornecedorEndereco endereco : fornecedor.getEndereco()) {
                
                sql = "INSERT INTO FORNECEDORES_ENDERECOS ("
                        + "FORNECEDOR, "
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
            
        } catch(SQLException e) {
            e.printStackTrace();
            throw new ErroException(e.getMessage(), e.getCause());
        } finally {
            this.fecharConexao();
        }
    }

    public void alterar(Fornecedor fornecedor) throws ErroException {
        try {
            this.conectar();
            String sql = "UPDATE FORNECEDORES SET "
                    + "NOME_FANTASIA = ?, "
                    + "CNPJ = ?, "
                    + "RAZAO_SOCIAL = ?, "
                    + "DATA_CADASTRO = ?, "
                    + "DOCUMENTO = ?,"
                    + "TELEFONE = ?, "
                    + "CELULAR = ?, "
                    + "EMAIL = ? "
                    + "WHERE CODIGO = ?";
            
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setString(1, fornecedor.getNomeFantasia());
            ps.setString(2, fornecedor.getCnpj());
            ps.setString(3, fornecedor.getRazaoSocial());
            ps.setDate(4, new Date(fornecedor.getDataCadastro().getTime()));
            ps.setString(5, fornecedor.getDocumento());
            ps.setString(6, fornecedor.getTelefone());
            ps.setString(7, fornecedor.getCelular());
            ps.setString(8, fornecedor.getEmail());
            ps.setLong(9, fornecedor.getCodigo());
            ps.execute();
            
            for (FornecedorEndereco endereco : fornecedor.getEndereco()) {
                
                sql = "UPDATE FORNECEDORES_ENDERECOS SET "
                        + "FORNECEDOR = ?, "
                        + "ENDERECO = ?, "
                        + "NUMERO = ?, "
                        + "BAIRRO = ?, "
                        + "COMPLEMENTO = ?, "
                        + "CIDADE = ?, "
                        + "ESTADO = ?, "
                        + "CEP = ? "
                        + "WHERE CODIGO = ? ";
                
                ps = this.getCon().prepareStatement(sql);
                ps.setLong(1, endereco.getFornecedor().getCodigo());
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
            
        } catch(SQLException e) {
            e.printStackTrace();
            throw new ErroException(e.getMessage(), e.getCause());
        } finally {
            this.fecharConexao();
        }
    }

    public void excluir(Fornecedor fornecedor) throws ErroException {
        try {
            this.conectar();
            String sql = "DELETE FROM FORNECEDORES WHERE CODIGO = ?";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setLong(1, fornecedor.getCodigo());
            ps.execute();
        } catch(SQLException e) {
            e.printStackTrace();
            throw new ErroException(e.getMessage(), e.getCause());
        } finally {
            this.fecharConexao();
        }
    }

    public List<Fornecedor> listarTodos() throws ErroException {
        List listaFornecedores = new LinkedList();
        try{
            this.conectar();
            String sql = "SELECT * FROM FORNECEDORES ORDER BY NOME_FANTASIA";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCodigo(rs.getLong("CODIGO"));
                fornecedor.setNomeFantasia(rs.getString("NOME_FANTASIA"));
                fornecedor.setCnpj(rs.getString("CNPJ"));
                fornecedor.setRazaoSocial(rs.getString("RAZAO_SOCIAL"));
                fornecedor.setDataCadastro(rs.getDate("DATA_CADASTRO"));
                fornecedor.setDocumento(rs.getString("DOCUMENTO"));
                fornecedor.setTelefone(rs.getString("TELEFONE"));
                fornecedor.setCelular(rs.getString("CELULAR"));
                fornecedor.setEmail(rs.getString("EMAIL"));
                listaFornecedores.add(fornecedor);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new ErroException(e.getMessage(), e.getCause());
        } finally {
            this.fecharConexao();
        }
        
        return listaFornecedores;
    }

    public Fornecedor recuperar(int codigo) throws ErroException {
        Fornecedor fornecedor = new Fornecedor();
        try {
            this.conectar();
            String sql = "SELECT * FROM FORNECEDORES WHERE CODIGO = ?";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                fornecedor.setCodigo(rs.getLong("CODIGO"));
                fornecedor.setNomeFantasia(rs.getString("NOME_FANTASIA"));
                fornecedor.setCnpj(rs.getString("CNPJ"));
                fornecedor.setRazaoSocial(rs.getString("RAZAO_SOCIAL"));
                fornecedor.setDataCadastro(rs.getDate("DATA_CADASTRO"));
                fornecedor.setDocumento(rs.getString("DOCUMENTO"));
                fornecedor.setTelefone(rs.getString("TELEFONE"));
                fornecedor.setCelular(rs.getString("CELULAR"));
                fornecedor.setEmail(rs.getString("EMAIL"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new ErroException(e.getMessage(), e.getCause());
        } finally {
            this.fecharConexao();
        }
        
        return fornecedor;
    }
    
    public List<FornecedorEndereco> recuperarEndereco(Fornecedor fornecedor) throws ErroException {
        List<FornecedorEndereco> lEndereco = new LinkedList<>();
        try {
            this.conectar();
            String sql = "SELECT * FROM FORNECEDORES_ENDERECOS WHERE FORNECEDOR = ?";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setLong(1, fornecedor.getCodigo());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                FornecedorEndereco endereco = new FornecedorEndereco();
                endereco.setCodigo(rs.getLong("CODIGO"));
                endereco.setFornecedor(fornecedor);
                endereco.setEndereco(rs.getString("ENDERECO"));
                endereco.setNumero(rs.getString("NUMERO"));
                endereco.setBairro(rs.getString("BAIRRO"));
                endereco.setComplemento(rs.getString("COMPLEMENTO"));
                endereco.setCidade(rs.getString("CIDADE"));
                endereco.setEstado(rs.getString("ESTADO"));
                endereco.setCep(rs.getString("CEP"));
                lEndereco.add(endereco);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new ErroException(e.getMessage(), e.getCause());
        } finally {
            this.fecharConexao();
        }
        
        return lEndereco;
    }
    
}

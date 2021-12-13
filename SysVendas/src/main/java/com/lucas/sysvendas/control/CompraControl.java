/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.sysvendas.control;



import com.lucas.sysvendas.model.dao.CompraDAO;
import com.lucas.sysvendas.model.domain.Compra;
import com.lucas.sysvendas.model.enums.SituacaoEnum;
import com.lucas.sysvendas.util.exceptions.ErroException;
import java.util.List;

/**
 *
 * @author lucas
 */
public class CompraControl {
    
    private CompraDAO compraDAO = new CompraDAO();
    private Compra compra;

    
    
    public List<Compra> listarTodos() throws ErroException {
        return compraDAO.listarTodos();
    }
    
    public void inserirCompra(Compra compra) throws ErroException {
        compraDAO.inserir(compra);
    }
    
    public void alterarCompra(Compra compra) throws ErroException {
        compraDAO.alterar(compra);
    }
    
    public void excluirCompra(Compra compra) throws ErroException {
        compraDAO.excluir(compra);
    }
    
    public Compra recuperar() throws ErroException {
        return compraDAO.recuperar();
    }
    
    public Compra novaCompra() {
        
        compra = new Compra();
        compra.setCodigo(0l);
        
        return compra;
    }
    
    public SituacaoEnum gravarSituacao(int situacao) {
        
        SituacaoEnum getSituacao = null;
        
        if (situacao == SituacaoEnum.ABERTA.getId()) {
            getSituacao = SituacaoEnum.ABERTA;
        } else if (situacao == SituacaoEnum.FINALIZADA.getId()) {
            getSituacao = SituacaoEnum.FINALIZADA;
        } else if (situacao == SituacaoEnum.CANCELADA.getId()) {
            getSituacao = SituacaoEnum.CANCELADA;
        }
        
        return getSituacao;
    }

}

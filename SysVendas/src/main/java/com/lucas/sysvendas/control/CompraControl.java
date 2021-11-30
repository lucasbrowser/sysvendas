/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.sysvendas.control;



import com.lucas.sysvendas.model.dao.CompraDAO;
import com.lucas.sysvendas.model.domain.Compra;
import com.lucas.sysvendas.model.enums.SituacaoEnum;
import java.util.List;

/**
 *
 * @author lucas
 */
public class CompraControl {
    
    private CompraDAO compraDAO = new CompraDAO();
    private Compra compra;

    
    
    public List<Compra> listarTodos() throws Exception {
        return compraDAO.listarTodos();
    }
    
    public void inserirCompra(Compra compra) throws Exception {
        compraDAO.inserir(compra);
    }
    
    public void alterarCompra(Compra compra) throws Exception {
        compraDAO.alterar(compra);
    }
    
    public void excluirCompra(Compra compra) throws Exception {
        compraDAO.excluir(compra);
    }
    
    public Compra recuperar() throws Exception {
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

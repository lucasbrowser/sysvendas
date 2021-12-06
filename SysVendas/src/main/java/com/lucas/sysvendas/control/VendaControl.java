/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.sysvendas.control;



import com.lucas.sysvendas.model.dao.VendaDAO;
import com.lucas.sysvendas.model.domain.Venda;
import com.lucas.sysvendas.model.enums.SituacaoEnum;
import java.util.List;

/**
 *
 * @author lucas
 */
public class VendaControl {
    
    private VendaDAO vendaDAO = new VendaDAO();
    private Venda venda;

    
    
    public List<Venda> listarTodos() throws Exception {
        return vendaDAO.listarTodos();
    }
    
    public List<Venda> listarVendaSelecionada(Long codigoVenda) throws Exception {
        return vendaDAO.listarVendaSelecionada(codigoVenda);
    }
    
    public void inserirVenda(Venda venda) throws Exception {
        vendaDAO.inserir(venda);
    }
    
    public void alterarVenda(Venda venda) throws Exception {
        vendaDAO.alterar(venda);
    }
    
    public void excluirVenda(Venda venda) throws Exception {
        vendaDAO.excluir(venda);
    }
    
    public Venda recuperar() throws Exception {
        return vendaDAO.recuperar();
    }
    
    public Venda novaVenda() {
        
        venda = new Venda();
        venda.setCodigo(0l);
        
        return venda;
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

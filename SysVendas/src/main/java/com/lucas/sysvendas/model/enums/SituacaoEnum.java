/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.sysvendas.model.enums;

/**
 *
 * @author lucas
 */
public enum SituacaoEnum {
    
    ABERTA(1, "Aberta"),
    FINALIZADA(2, "Finalizada"),
    CANCELADA(3, "Cancelada");

    private final int id;
    private final String descricao;

    private SituacaoEnum(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
    
}

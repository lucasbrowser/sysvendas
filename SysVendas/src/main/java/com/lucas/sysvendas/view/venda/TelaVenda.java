/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.sysvendas.view.venda;

import com.lucas.sysvendas.control.VendaControl;
import com.lucas.sysvendas.model.domain.Cliente;
import com.lucas.sysvendas.model.domain.Venda;
import com.lucas.sysvendas.model.domain.VendaItem;
import com.lucas.sysvendas.model.domain.Produto;
import com.lucas.sysvendas.model.enums.SituacaoEnum;
import com.lucas.sysvendas.view.consultas.TelaBuscaCliente;
import com.lucas.sysvendas.view.consultas.TelaBuscaProduto;
import com.towel.swing.table.ObjectTableModel;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class TelaVenda extends javax.swing.JInternalFrame {
    
    private final ObjectTableModel<Venda> otmVenda = new ObjectTableModel<>(Venda.class, "cliente,dataVenda,valorTotal,situacao");
    private final ObjectTableModel<VendaItem> otmVendaItem = new ObjectTableModel<>(VendaItem.class, "produto,quantidade,valorUnitario");
    
    private final VendaControl vendaControl = new VendaControl();
    
    private Venda venda;
    private VendaItem vendaItem;
    
    private String statusBotoes;

    /**
     * Creates new form TelaFuncionario
     */
    public TelaVenda() {
        
        initComponents();
        
        habilitarFormulario(false);
        
        carregarGrade();
        
    }
    
    public void setCliente(Cliente cliente) {
        ftfCliente.setValue(cliente);
    }
    
    public void setProduto(Produto produto) {
        ftfProduto.setValue(produto);
        ftfValorUnitario.setValue(produto.getPrecoVenda());
    }
    
    
    private void carregarGrade() {
        
        try {      
            otmVenda.setData(vendaControl.listarTodos());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar grade.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgClienteTipo = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pBarraFerramentas = new javax.swing.JPanel();
        bNovo = new javax.swing.JButton();
        bSalvar = new javax.swing.JButton();
        bFinalizar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        bRemover = new javax.swing.JButton();
        tpConteudoVenda = new javax.swing.JTabbedPane();
        paDadosVenda = new javax.swing.JPanel();
        lblCliente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tpVenda = new javax.swing.JTable();
        ftfCliente = new javax.swing.JFormattedTextField();
        bBuscarCliente = new javax.swing.JButton();
        lblDataVenda = new javax.swing.JLabel();
        ftfDataVenda = new javax.swing.JFormattedTextField();
        lblValorTotal = new javax.swing.JLabel();
        ftfValorTotal = new javax.swing.JFormattedTextField();
        paItensVenda = new javax.swing.JPanel();
        lblProduto = new javax.swing.JLabel();
        bAdicionarItem = new javax.swing.JButton();
        bRemoverItem = new javax.swing.JButton();
        ftfProduto = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tpVendaItem = new javax.swing.JTable();
        bBuscarProduto = new javax.swing.JButton();
        lblQuantidade = new javax.swing.JLabel();
        spQuantidade = new javax.swing.JSpinner();
        lblValorUnitario = new javax.swing.JLabel();
        ftfValorUnitario = new javax.swing.JFormattedTextField();

        jButton1.setText("jButton1");

        jLabel1.setText("jLabel1");

        setClosable(true);
        setResizable(true);
        setTitle("Lançamento de Venda");

        bNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/novo.png"))); // NOI18N
        bNovo.setMnemonic(KeyEvent.VK_N);
        bNovo.setText("Novo");
        bNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNovoActionPerformed(evt);
            }
        });

        bSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salvar.png"))); // NOI18N
        bSalvar.setMnemonic(KeyEvent.VK_S);
        bSalvar.setText("Salvar");
        bSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalvarActionPerformed(evt);
            }
        });

        bFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/finalizar.png"))); // NOI18N
        bFinalizar.setMnemonic(KeyEvent.VK_R);
        bFinalizar.setText("Finalizar");
        bFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFinalizarActionPerformed(evt);
            }
        });

        bCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancelar.png"))); // NOI18N
        bCancelar.setMnemonic(KeyEvent.VK_C);
        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        bRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excluir.png"))); // NOI18N
        bRemover.setMnemonic(KeyEvent.VK_R);
        bRemover.setText("Remover");
        bRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pBarraFerramentasLayout = new javax.swing.GroupLayout(pBarraFerramentas);
        pBarraFerramentas.setLayout(pBarraFerramentasLayout);
        pBarraFerramentasLayout.setHorizontalGroup(
            pBarraFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBarraFerramentasLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(bNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bFinalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRemover)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bCancelar)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        pBarraFerramentasLayout.setVerticalGroup(
            pBarraFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBarraFerramentasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pBarraFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pBarraFerramentasLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(pBarraFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                            .addComponent(bRemover, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)))
                    .addComponent(bNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        lblCliente.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCliente.setText("Cliente:");

        tpVenda.setModel(otmVenda);
        tpVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tpVendaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tpVenda);

        bBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        bBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarClienteActionPerformed(evt);
            }
        });

        lblDataVenda.setText("Data da Venda:");

        ftfDataVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        lblValorTotal.setText("Valor Total:");

        ftfValorTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));

        javax.swing.GroupLayout paDadosVendaLayout = new javax.swing.GroupLayout(paDadosVenda);
        paDadosVenda.setLayout(paDadosVendaLayout);
        paDadosVendaLayout.setHorizontalGroup(
            paDadosVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
            .addGroup(paDadosVendaLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(paDadosVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblValorTotal)
                    .addComponent(lblDataVenda)
                    .addComponent(lblCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paDadosVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paDadosVendaLayout.createSequentialGroup()
                        .addComponent(ftfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paDadosVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ftfValorTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                        .addComponent(ftfDataVenda, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paDadosVendaLayout.setVerticalGroup(
            paDadosVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paDadosVendaLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(paDadosVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(paDadosVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCliente)
                        .addComponent(ftfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paDadosVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataVenda)
                    .addComponent(ftfDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paDadosVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorTotal)
                    .addComponent(ftfValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        tpConteudoVenda.addTab("Dados da Venda", paDadosVenda);

        lblProduto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblProduto.setText("Produto:");

        bAdicionarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/novo.png"))); // NOI18N
        bAdicionarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAdicionarItemActionPerformed(evt);
            }
        });

        bRemoverItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excluir.png"))); // NOI18N
        bRemoverItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRemoverItemActionPerformed(evt);
            }
        });

        tpVendaItem.setModel(otmVendaItem);
        jScrollPane2.setViewportView(tpVendaItem);

        bBuscarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        bBuscarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarProdutoActionPerformed(evt);
            }
        });

        lblQuantidade.setText("Quantidade:");

        lblValorUnitario.setText("Valor Unitário:");

        ftfValorUnitario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("¤#,##0.00"))));

        javax.swing.GroupLayout paItensVendaLayout = new javax.swing.GroupLayout(paItensVenda);
        paItensVenda.setLayout(paItensVendaLayout);
        paItensVendaLayout.setHorizontalGroup(
            paItensVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paItensVendaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(paItensVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(paItensVendaLayout.createSequentialGroup()
                        .addComponent(bAdicionarItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bRemoverItem, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paItensVendaLayout.createSequentialGroup()
                        .addGroup(paItensVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblValorUnitario)
                            .addComponent(lblQuantidade)
                            .addComponent(lblProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paItensVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paItensVendaLayout.createSequentialGroup()
                                .addComponent(ftfProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(spQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ftfValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(paItensVendaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                .addContainerGap())
        );
        paItensVendaLayout.setVerticalGroup(
            paItensVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paItensVendaLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(paItensVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paItensVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblProduto)
                        .addComponent(ftfProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paItensVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantidade)
                    .addComponent(spQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paItensVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorUnitario)
                    .addComponent(ftfValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paItensVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(bRemoverItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bAdicionarItem))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        tpConteudoVenda.addTab("Itens da Venda", paItensVenda);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pBarraFerramentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tpConteudoVenda)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pBarraFerramentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(451, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(63, 63, 63)
                    .addComponent(tpConteudoVenda)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovoActionPerformed
        venda = vendaControl.novaVenda();
        habilitarFormulario(true);
        bFinalizar.setEnabled(false);
    }//GEN-LAST:event_bNovoActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        habilitarFormulario(false);
        
        otmVendaItem.clear();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void tpVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tpVendaMouseClicked
        if (evt.getClickCount() >= 2) {
            venda = otmVenda.getValue(tpVenda.getSelectedRow());
            
            if (venda.getSituacao() == SituacaoEnum.FINALIZADA) {
                JOptionPane.showMessageDialog(this, "Venda finalizada não pode ser alterada.", "Alerta", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (venda.getSituacao() == SituacaoEnum.CANCELADA) {
                JOptionPane.showMessageDialog(this, "Venda cancelada não pode ser alterada.", "Alerta", JOptionPane.WARNING_MESSAGE);
                return;
            }

            ftfCliente.setValue(venda.getCliente());
            ftfDataVenda.setValue(venda.getDataVenda());
            ftfValorTotal.setValue(venda.getValorTotal());
            
            otmVendaItem.setData(venda.getItens());

            habilitarFormulario(true);

        }
    }//GEN-LAST:event_tpVendaMouseClicked

    private void bSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalvarActionPerformed
        if (validarFormulario()) {
            
            salvarVenda(false);
            
            otmVendaItem.clear();
        }
    }//GEN-LAST:event_bSalvarActionPerformed

    private void bFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFinalizarActionPerformed
        int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente finalizar a venda?");
        if (opcao == 0) {
            salvarVenda(true);
        }
    }//GEN-LAST:event_bFinalizarActionPerformed

    private void bAdicionarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAdicionarItemActionPerformed
        
        if (validarFormularioItens()) {
            
            setarVendaItens();

            otmVendaItem.setData(venda.getItens());
            
            Double valorTotal = venda.getItens().stream().mapToDouble(v -> v.getValorUnitario() * v.getQuantidade()).sum();

            ftfValorTotal.setValue(valorTotal);

            limpaFormularioItens();
            
        }
        
        
    }//GEN-LAST:event_bAdicionarItemActionPerformed

    private void bRemoverItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRemoverItemActionPerformed
        if (tpVendaItem.getSelectedRowCount() > 0) {
            
            int linhaSelecionada = tpVendaItem.getSelectedRow();
            VendaItem itemRemover = otmVendaItem.getValue(linhaSelecionada);

            if (JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o item da venda " + itemRemover + "?", "Confirmação", JOptionPane.YES_NO_OPTION) == 0) {
                venda.getItens().remove(itemRemover);
                otmVendaItem.setData(venda.getItens());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma linha para remover.", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bRemoverItemActionPerformed

    private void bRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRemoverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bRemoverActionPerformed

    private void bBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarClienteActionPerformed
        TelaBuscaCliente buscaCliente = new TelaBuscaCliente(this);
        buscaCliente.setVisible(true);
    }//GEN-LAST:event_bBuscarClienteActionPerformed

    private void bBuscarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarProdutoActionPerformed
        TelaBuscaProduto buscaProduto = new TelaBuscaProduto(this);
        buscaProduto.setVisible(true);
    }//GEN-LAST:event_bBuscarProdutoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAdicionarItem;
    private javax.swing.JButton bBuscarCliente;
    private javax.swing.JButton bBuscarProduto;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bFinalizar;
    private javax.swing.JButton bNovo;
    private javax.swing.JButton bRemover;
    private javax.swing.JButton bRemoverItem;
    private javax.swing.JButton bSalvar;
    private javax.swing.ButtonGroup bgClienteTipo;
    private javax.swing.JFormattedTextField ftfCliente;
    private javax.swing.JFormattedTextField ftfDataVenda;
    private javax.swing.JFormattedTextField ftfProduto;
    private javax.swing.JFormattedTextField ftfValorTotal;
    private javax.swing.JFormattedTextField ftfValorUnitario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDataVenda;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblValorTotal;
    private javax.swing.JLabel lblValorUnitario;
    private javax.swing.JPanel pBarraFerramentas;
    private javax.swing.JPanel paDadosVenda;
    private javax.swing.JPanel paItensVenda;
    private javax.swing.JSpinner spQuantidade;
    private javax.swing.JTabbedPane tpConteudoVenda;
    private javax.swing.JTable tpVenda;
    private javax.swing.JTable tpVendaItem;
    // End of variables declaration//GEN-END:variables

private void habilitarFormulario(boolean b) {
    
        bNovo.setEnabled(!b);
        bSalvar.setEnabled(b);
        bFinalizar.setEnabled(b);
        bRemover.setEnabled(b);
        bCancelar.setEnabled(b);
        ftfCliente.setEnabled(b);
        bBuscarCliente.setEnabled(b);
        ftfDataVenda.setEnabled(b);
        ftfValorTotal.setEnabled(b);
        ftfProduto.setEnabled(b);
        bBuscarProduto.setEnabled(b);
        spQuantidade.setEnabled(b);
        ftfValorUnitario.setEnabled(b);
        bAdicionarItem.setEnabled(b);
        bRemoverItem.setEnabled(b);
        tpVenda.setEnabled(!b);
        
        if (!b) {
            limpaFormulario();
        }

    }
    
    private void setarVendaItens() {
        
        VendaItem vendaItem = new VendaItem();
        vendaItem.setProduto((Produto) ftfProduto.getValue());
        vendaItem.setVenda(venda);
        vendaItem.setQuantidade(Long.parseLong(String.valueOf(spQuantidade.getValue())));
        vendaItem.setValorUnitario(Double.parseDouble(String.valueOf(ftfValorUnitario.getValue())));

        venda.getItens().add(vendaItem);
    } 
    
    private void salvarVenda(boolean finalizar) {
        
        if (validarFormulario()) {
            venda.setCliente((Cliente) ftfCliente.getValue());
            venda.setDataVenda((Date) ftfDataVenda.getValue());
            venda.setValorTotal((Double) ftfValorTotal.getValue());
            if (finalizar) {
                venda.setSituacao(SituacaoEnum.FINALIZADA);
            } else {
                venda.setSituacao(SituacaoEnum.ABERTA);
            }

            if (venda.getCodigo() == 0) {
                try {
                    vendaControl.inserirVenda(venda);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao inserir a venda.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else {
                try {
                    vendaControl.alterarVenda(venda);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao alterar a venda.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            habilitarFormulario(false);
            carregarGrade();
        }
    }
    
    private boolean validarFormulario() {
        if (ftfCliente.getValue() == null) {
            JOptionPane.showMessageDialog(this, "Fornecedor inválido.", "Alerta", JOptionPane.WARNING_MESSAGE);
            ftfCliente.requestFocus();
            return false;
        }
        if (venda.getItens().size() == 0) {
            JOptionPane.showMessageDialog(this, "Quantidade de itens inválida.", "Alerta", JOptionPane.WARNING_MESSAGE);
            tpConteudoVenda.setSelectedIndex(1);
            return false;
        }
        return true;
    }

    private boolean validarFormularioItens() {
        if (ftfProduto.getValue() == null) {
            JOptionPane.showMessageDialog(this, "Produto inválido.", "Alerta", JOptionPane.WARNING_MESSAGE);
            ftfProduto.requestFocus();
            return false;
        }
        return true;
    }
    
    private void limpaFormulario() {
        venda = null;
        ftfCliente.setValue(null);
        ftfDataVenda.setValue(new Date());
        ftfValorTotal.setValue(new Double(0));
        ftfProduto.setValue(null);
        spQuantidade.setValue(1);
        ftfValorUnitario.setValue(new Double(0));
        tpVendaItem.setModel(otmVendaItem);
        limpaFormularioItens();
    }
    
    private void limpaFormularioItens() {
        ftfProduto.setValue(null);
        spQuantidade.setValue(1);
        ftfValorUnitario.setValue(new Double(0));
    }

}

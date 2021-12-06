package com.lucas.sysvendas.view.relatorios;


import com.lucas.sysvendas.control.VendaControl;
import com.lucas.sysvendas.model.domain.Venda;
import com.lucas.sysvendas.model.domain.VendaItem;
import com.lucas.sysvendas.report.Relatorio;
import com.towel.swing.table.ObjectTableModel;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Janela de Relatório de Venda
 *
 * @author Lucas
 */
public class TelaRelatorioVenda extends javax.swing.JInternalFrame {
    
    private final ObjectTableModel<Venda> otmVenda = new ObjectTableModel<>(Venda.class, "codigo,cliente,dataVenda,valorTotal,situacao");
    private final ObjectTableModel<VendaItem> otmVendaItem = new ObjectTableModel<>(VendaItem.class, "produto,quantidade,valorUnitario");
    
    private final VendaControl vendaControl = new VendaControl();
    
    private Venda venda;
    
    private VendaItem vendaItem;
    
    private Relatorio relatorio;
    
    int codVenda;

    public TelaRelatorioVenda() {
        initComponents();
        habilitarFormulario(false);
        carregarGrade();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        tpConteudo = new javax.swing.JTabbedPane();
        pnCabecalho = new javax.swing.JPanel();
        pnForm = new javax.swing.JPanel();
        lblCliente = new javax.swing.JLabel();
        lbValorTotal = new javax.swing.JLabel();
        lblDataVenda = new javax.swing.JLabel();
        ftfCliente = new javax.swing.JFormattedTextField();
        ftfDataVenda = new javax.swing.JFormattedTextField();
        ftfValorTotal = new javax.swing.JFormattedTextField();
        bImprimirVenda = new javax.swing.JButton();
        spGrade = new javax.swing.JScrollPane();
        tpVenda = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        spGradeItens = new javax.swing.JScrollPane();
        tpVendaItem = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setTitle("Relatório de Vendas");

        pnCabecalho.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 10, 10));

        pnForm.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 5, 0), javax.swing.BorderFactory.createTitledBorder(null, "Formulário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 153, 255)))); // NOI18N
        pnForm.setOpaque(false);
        pnForm.setPreferredSize(new java.awt.Dimension(393, 150));

        lblCliente.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCliente.setText("Cliente:");

        lbValorTotal.setText("Valor Total:");

        lblDataVenda.setText("Data Venda:");

        ftfCliente.setEditable(false);
        ftfCliente.setColumns(25);

        ftfDataVenda.setEditable(false);
        ftfDataVenda.setColumns(10);
        ftfDataVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        ftfDataVenda.setValue(new Date());

        ftfValorTotal.setEditable(false);
        ftfValorTotal.setColumns(10);
        ftfValorTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        ftfValorTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ftfValorTotal.setValue(new Double(0));

        bImprimirVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impressora.png"))); // NOI18N
        bImprimirVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bImprimirVendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnFormLayout = new javax.swing.GroupLayout(pnForm);
        pnForm.setLayout(pnFormLayout);
        pnFormLayout.setHorizontalGroup(
            pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDataVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnFormLayout.createSequentialGroup()
                        .addComponent(ftfDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(lbValorTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftfValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ftfCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(bImprimirVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        pnFormLayout.setVerticalGroup(
            pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bImprimirVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnFormLayout.createSequentialGroup()
                        .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCliente)
                            .addComponent(ftfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbValorTotal)
                            .addComponent(ftfValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDataVenda)
                            .addComponent(ftfDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        tpVenda.setModel(otmVenda);
        tpVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tpVendaMouseClicked(evt);
            }
        });
        spGrade.setViewportView(tpVenda);

        jLabel1.setText("Itens da Venda");

        tpVendaItem.setModel(otmVendaItem);
        spGradeItens.setViewportView(tpVendaItem);

        javax.swing.GroupLayout pnCabecalhoLayout = new javax.swing.GroupLayout(pnCabecalho);
        pnCabecalho.setLayout(pnCabecalhoLayout);
        pnCabecalhoLayout.setHorizontalGroup(
            pnCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCabecalhoLayout.createSequentialGroup()
                .addGroup(pnCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(spGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnForm, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spGradeItens, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 1, Short.MAX_VALUE))
        );
        pnCabecalhoLayout.setVerticalGroup(
            pnCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCabecalhoLayout.createSequentialGroup()
                .addComponent(pnForm, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spGradeItens, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        tpConteudo.addTab("Dados da venda", pnCabecalho);

        getContentPane().add(tpConteudo, java.awt.BorderLayout.CENTER);

        setBounds(10, 10, 543, 483);
    }// </editor-fold>//GEN-END:initComponents

    private void tpVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tpVendaMouseClicked
        if (evt.getClickCount() >= 2) {
            
            venda = otmVenda.getValue(tpVenda.getSelectedRow());
            
            ftfCliente.setValue(venda.getCliente());
            ftfDataVenda.setValue(venda.getDataVenda());
            ftfValorTotal.setValue(venda.getValorTotal());           

            otmVendaItem.setData(venda.getItens());

        }
    }//GEN-LAST:event_tpVendaMouseClicked

    private void bImprimirVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bImprimirVendaActionPerformed
        // TODO add your handling code here:
        gerarRelatorioVendas();
    }//GEN-LAST:event_bImprimirVendaActionPerformed


    private void habilitarFormulario(boolean ativo) {
        ftfCliente.setEnabled(ativo);
        ftfDataVenda.setEnabled(ativo);
        ftfValorTotal.setEnabled(ativo);
        tpVenda.setEnabled(!ativo);
        if (!ativo) {
            limpaFormulario();
        }
    }

    private void limpaFormulario() {
        venda = null;
        ftfCliente.setValue(null);
        ftfDataVenda.setValue(new Date());
        ftfValorTotal.setValue(new Double(0));
    }

    private void carregarGrade() {
        try {      
            otmVenda.setData(vendaControl.listarTodos());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar grade.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private void gerarRelatorioVendas() {
        try {
            venda = otmVenda.getValue(tpVenda.getSelectedRow());
            relatorio = new Relatorio();
            List<Venda> lVendas = vendaControl.listarVendaSelecionada(venda.getCodigo());
            String pathRelatorio = "src/main/resources/reports/Vendas.jasper";
            relatorio.gerarRelatorio(lVendas, null, pathRelatorio);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao imprimir o relatório.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bImprimirVenda;
    private javax.swing.JFormattedTextField ftfCliente;
    private javax.swing.JFormattedTextField ftfDataVenda;
    private javax.swing.JFormattedTextField ftfValorTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbValorTotal;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDataVenda;
    private javax.swing.JPanel pnCabecalho;
    private javax.swing.JPanel pnForm;
    private javax.swing.JScrollPane spGrade;
    private javax.swing.JScrollPane spGradeItens;
    private javax.swing.JTabbedPane tpConteudo;
    private javax.swing.JTable tpVenda;
    private javax.swing.JTable tpVendaItem;
    // End of variables declaration//GEN-END:variables
}

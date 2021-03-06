/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.sysvendas.view.consultas;

import com.lucas.sysvendas.control.FornecedorControl;
import com.lucas.sysvendas.model.domain.Fornecedor;
import com.lucas.sysvendas.util.exceptions.ErroException;
import com.lucas.sysvendas.view.cadastro.TelaCompra;
import com.towel.swing.table.ObjectTableModel;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author lucas
 */
public class TelaBuscaFornecedor extends javax.swing.JDialog {
    
    JInternalFrame parent;
    
    private final ObjectTableModel<Fornecedor> otmFiltroFornecedor = new ObjectTableModel<>(Fornecedor.class, "codigo,nomeFantasia,cnpj,telefone,celular,email");
    
    private final FornecedorControl fornecedorControl = new FornecedorControl();

    /**
     * Creates new form TelaModalDepartamento
     * @param parent
     */
    public TelaBuscaFornecedor(JInternalFrame parent) {
        super();
        this.parent = parent;
        initComponents();
        carregarGrade();
    }
    
    private void carregarGrade() {
        
        try {      
            otmFiltroFornecedor.setData(fornecedorControl.listarTodos());
        } catch (ErroException ex) {
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

        pFiltro = new javax.swing.JPanel();
        lblFiltroFornecedor = new javax.swing.JLabel();
        txtFiltroFornecedor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tpFiltroFornecedor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Departamento");
        setModal(true);

        lblFiltroFornecedor.setText("Filtro:");

        txtFiltroFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroFornecedorKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pFiltroLayout = new javax.swing.GroupLayout(pFiltro);
        pFiltro.setLayout(pFiltroLayout);
        pFiltroLayout.setHorizontalGroup(
            pFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFiltroFornecedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFiltroFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        pFiltroLayout.setVerticalGroup(
            pFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFiltroFornecedor)
                    .addComponent(txtFiltroFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        tpFiltroFornecedor.setModel(otmFiltroFornecedor);
        tpFiltroFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tpFiltroFornecedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tpFiltroFornecedor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFiltroFornecedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroFornecedorKeyReleased
        TableRowSorter rs = new TableRowSorter(otmFiltroFornecedor);
        rs.setRowFilter(RowFilter.regexFilter("(?i)" + txtFiltroFornecedor.getText().trim()));
        tpFiltroFornecedor.setRowSorter(rs);
    }//GEN-LAST:event_txtFiltroFornecedorKeyReleased

    private void tpFiltroFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tpFiltroFornecedorMouseClicked
        if (evt.getClickCount() >= 2) {
            
            Fornecedor fornecedor = null;
            
            if (tpFiltroFornecedor.getRowSorter() != null) {
                int linhaSelecionada = tpFiltroFornecedor.getRowSorter().convertRowIndexToModel(tpFiltroFornecedor.getSelectedRow());
                fornecedor = otmFiltroFornecedor.getValue(linhaSelecionada);
            } else {
                fornecedor = otmFiltroFornecedor.getValue(tpFiltroFornecedor.getSelectedRow());
            }

            if (parent instanceof TelaCompra) {
                TelaCompra tc = (TelaCompra) parent;
                tc.setFornecedor(fornecedor);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Campo de destino inv??lido.", "Alerta", JOptionPane.WARNING_MESSAGE);
            }

        }
    }//GEN-LAST:event_tpFiltroFornecedorMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaBuscaFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaBuscaFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaBuscaFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaBuscaFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaBuscaFornecedor dialog = new TelaBuscaFornecedor(new javax.swing.JInternalFrame());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFiltroFornecedor;
    private javax.swing.JPanel pFiltro;
    private javax.swing.JTable tpFiltroFornecedor;
    private javax.swing.JTextField txtFiltroFornecedor;
    // End of variables declaration//GEN-END:variables
}

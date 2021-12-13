package com.lucas.sysvendas.view;


import com.lucas.sysvendas.model.domain.Usuario;
import com.lucas.sysvendas.view.cadastro.TelaCliente;
import com.lucas.sysvendas.view.cadastro.TelaCompra;
import com.lucas.sysvendas.view.cadastro.TelaFornecedor;
import com.lucas.sysvendas.view.cadastro.TelaProduto;
import com.lucas.sysvendas.view.cadastro.TelaUsuario;
import com.lucas.sysvendas.view.relatorios.TelaRelatorioVenda;
import com.lucas.sysvendas.view.venda.TelaVenda;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * 
 *
 * @author lucas
 */
public class TelaPrincipal extends javax.swing.JFrame {
    

    public TelaPrincipal(Usuario usuario) {
        initComponents();
        perfilUsuario(usuario);
        Locale locale = new Locale("pt","BR"); 
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat dataHora = new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'.'",locale); 
        lblData.setText("Diamantino-MT, "+dataHora.format(calendar.getTime()));
        UIManager.put("OptionPane.yesButtonText", "Sim"); 
        UIManager.put("OptionPane.noButtonText", "Não"); 
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        toolBar = new javax.swing.JToolBar();
        bClientes = new javax.swing.JButton();
        bProdutos = new javax.swing.JButton();
        bCompras = new javax.swing.JButton();
        bVendas = new javax.swing.JButton();
        bRelatorios = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        desktopPane = new javax.swing.JDesktopPane();
        pStatusBar = new javax.swing.JPanel();
        lblUsuarioTitle = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        mCadastro = new javax.swing.JMenu();
        miCliente = new javax.swing.JMenuItem();
        miFornecedor = new javax.swing.JMenuItem();
        miUsuario = new javax.swing.JMenuItem();
        miProduto = new javax.swing.JMenuItem();
        mMovimento = new javax.swing.JMenu();
        miCompras = new javax.swing.JMenuItem();
        miVendas = new javax.swing.JMenuItem();
        mRelatorio = new javax.swing.JMenu();
        mVendas = new javax.swing.JMenu();
        miVendaSelecionada = new javax.swing.JMenuItem();
        mFerramentas = new javax.swing.JMenu();
        miCalculadora = new javax.swing.JMenuItem();
        miBlocoNotas = new javax.swing.JMenuItem();
        mSistema = new javax.swing.JMenu();
        miSair = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Empresarial");
        setIconImages(null);

        toolBar.setFloatable(false);

        bClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cliente.png"))); // NOI18N
        bClientes.setText("Clientes");
        bClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bClientes.setFocusable(false);
        bClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bClientes.setMargin(new java.awt.Insets(2, 12, 2, 12));
        bClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miClienteActionPerformed(evt);
            }
        });
        toolBar.add(bClientes);

        bProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lancamento-do-produto.png"))); // NOI18N
        bProdutos.setText("Produtos");
        bProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bProdutos.setFocusable(false);
        bProdutos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bProdutos.setMargin(new java.awt.Insets(2, 12, 2, 12));
        bProdutos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miProdutoActionPerformed(evt);
            }
        });
        toolBar.add(bProdutos);

        bCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/compra.png"))); // NOI18N
        bCompras.setText("Compras");
        bCompras.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bCompras.setFocusable(false);
        bCompras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bCompras.setMargin(new java.awt.Insets(2, 12, 2, 12));
        bCompras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miComprasActionPerformed(evt);
            }
        });
        toolBar.add(bCompras);

        bVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/venda.png"))); // NOI18N
        bVendas.setText("Vendas");
        bVendas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bVendas.setFocusable(false);
        bVendas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bVendas.setMargin(new java.awt.Insets(2, 12, 2, 12));
        bVendas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miVendasActionPerformed(evt);
            }
        });
        toolBar.add(bVendas);

        bRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/report.png"))); // NOI18N
        bRelatorios.setText("Relatórios");
        bRelatorios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bRelatorios.setFocusable(false);
        bRelatorios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bRelatorios.setMargin(new java.awt.Insets(2, 12, 2, 12));
        bRelatorios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miVendaSelecionadaActionPerformed(evt);
            }
        });
        toolBar.add(bRelatorios);

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sair.png"))); // NOI18N
        btSair.setText("Sair");
        btSair.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btSair.setFocusable(false);
        btSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSair.setMargin(new java.awt.Insets(2, 12, 2, 12));
        btSair.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sair.png"))); // NOI18N
        btSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSairActionPerformed(evt);
            }
        });
        toolBar.add(btSair);

        getContentPane().add(toolBar, java.awt.BorderLayout.PAGE_START);

        desktopPane.setOpaque(false);
        getContentPane().add(desktopPane, java.awt.BorderLayout.CENTER);

        pStatusBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblUsuarioTitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsuarioTitle.setText("Usuário:");

        lblUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblData.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblData.setText("........");

        javax.swing.GroupLayout pStatusBarLayout = new javax.swing.GroupLayout(pStatusBar);
        pStatusBar.setLayout(pStatusBarLayout);
        pStatusBarLayout.setHorizontalGroup(
            pStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pStatusBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuarioTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
                .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pStatusBarLayout.setVerticalGroup(
            pStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pStatusBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblUsuarioTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(pStatusBar, java.awt.BorderLayout.PAGE_END);

        mCadastro.setText("Cadastro");

        miCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        miCliente.setMnemonic('V');
        miCliente.setText("Cliente");
        miCliente.setToolTipText("");
        miCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miClienteActionPerformed(evt);
            }
        });
        mCadastro.add(miCliente);

        miFornecedor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        miFornecedor.setText("Fornecedor");
        miFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFornecedorActionPerformed(evt);
            }
        });
        mCadastro.add(miFornecedor);

        miUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        miUsuario.setText("Usuário");
        miUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miUsuarioActionPerformed(evt);
            }
        });
        mCadastro.add(miUsuario);

        miProduto.setText("Produto");
        miProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miProdutoActionPerformed(evt);
            }
        });
        mCadastro.add(miProduto);

        menuBar.add(mCadastro);

        mMovimento.setText("Movimento");

        miCompras.setText("Compras");
        miCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miComprasActionPerformed(evt);
            }
        });
        mMovimento.add(miCompras);

        miVendas.setText("Vendas");
        miVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miVendasActionPerformed(evt);
            }
        });
        mMovimento.add(miVendas);

        menuBar.add(mMovimento);

        mRelatorio.setText("Relatorios");

        mVendas.setText("Vendas");

        miVendaSelecionada.setText("Vendas Gerais");
        miVendaSelecionada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miVendaSelecionadaActionPerformed(evt);
            }
        });
        mVendas.add(miVendaSelecionada);

        mRelatorio.add(mVendas);

        menuBar.add(mRelatorio);

        mFerramentas.setText("Ferramentas");

        miCalculadora.setText("Calculadora");
        miCalculadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCalculadoraActionPerformed(evt);
            }
        });
        mFerramentas.add(miCalculadora);

        miBlocoNotas.setText("Bloco de Notas");
        miBlocoNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBlocoNotasActionPerformed(evt);
            }
        });
        mFerramentas.add(miBlocoNotas);

        menuBar.add(mFerramentas);

        mSistema.setText("Sistema");

        miSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        miSair.setText("Sair");
        miSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSairActionPerformed(evt);
            }
        });
        mSistema.add(miSair);

        menuBar.add(mSistema);

        setJMenuBar(menuBar);

        setSize(new java.awt.Dimension(1040, 735));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void miSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSairActionPerformed
        int q = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair do sistema?", "Atenção",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (q==JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_miSairActionPerformed

    private void miClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miClienteActionPerformed
        // TODO add your handling code here:
        TelaCliente c = new TelaCliente();
        desktopPane.add(c);
        c.setVisible(true);
    }//GEN-LAST:event_miClienteActionPerformed

    private void miUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miUsuarioActionPerformed
        TelaUsuario c = new TelaUsuario();
        desktopPane.add(c);
        c.setVisible(true);
    }//GEN-LAST:event_miUsuarioActionPerformed

    private void miFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFornecedorActionPerformed
        TelaFornecedor c = new TelaFornecedor();
        desktopPane.add(c);
        c.setVisible(true);
    }//GEN-LAST:event_miFornecedorActionPerformed

    private void miProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miProdutoActionPerformed
        TelaProduto c = new TelaProduto();
        desktopPane.add(c);
        c.setVisible(true);
    }//GEN-LAST:event_miProdutoActionPerformed

    private void miComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miComprasActionPerformed
        TelaCompra c = new TelaCompra();
        desktopPane.add(c);
        c.setVisible(true);
    }//GEN-LAST:event_miComprasActionPerformed

    private void miVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miVendasActionPerformed
        TelaVenda c = new TelaVenda();
        desktopPane.add(c);
        c.setVisible(true);
    }//GEN-LAST:event_miVendasActionPerformed

    private void miVendaSelecionadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miVendaSelecionadaActionPerformed
        TelaRelatorioVenda c = new TelaRelatorioVenda();
        desktopPane.add(c);
        c.setVisible(true);
    }//GEN-LAST:event_miVendaSelecionadaActionPerformed

    private void miCalculadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCalculadoraActionPerformed
        try {
            Runtime.getRuntime().exec("calc");
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_miCalculadoraActionPerformed

    private void miBlocoNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBlocoNotasActionPerformed
        try {
            Runtime.getRuntime().exec("notepad");
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_miBlocoNotasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClientes;
    private javax.swing.JButton bCompras;
    private javax.swing.JButton bProdutos;
    private javax.swing.JButton bRelatorios;
    private javax.swing.JButton bVendas;
    private javax.swing.JButton btSair;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblData;
    public javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuarioTitle;
    private javax.swing.JMenu mCadastro;
    private javax.swing.JMenu mFerramentas;
    private javax.swing.JMenu mMovimento;
    private javax.swing.JMenu mRelatorio;
    private javax.swing.JMenu mSistema;
    private javax.swing.JMenu mVendas;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem miBlocoNotas;
    private javax.swing.JMenuItem miCalculadora;
    private javax.swing.JMenuItem miCliente;
    private javax.swing.JMenuItem miCompras;
    private javax.swing.JMenuItem miFornecedor;
    private javax.swing.JMenuItem miProduto;
    private javax.swing.JMenuItem miSair;
    private javax.swing.JMenuItem miUsuario;
    private javax.swing.JMenuItem miVendaSelecionada;
    private javax.swing.JMenuItem miVendas;
    private javax.swing.JPanel pStatusBar;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
    
    
    public void perfilUsuario(Usuario usuario) {
        String nivel = usuario.getPerfil().substring(0,1);
        if (nivel.equals("B")) {
            miCliente.setEnabled(false);
            miUsuario.setEnabled(false);
        } else if (nivel.equals("S")) {
            miUsuario.setEnabled(false);
        }
    }
    
    




}

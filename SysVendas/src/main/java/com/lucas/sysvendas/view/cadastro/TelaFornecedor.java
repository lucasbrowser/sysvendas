/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.sysvendas.view.cadastro;

import com.lucas.sysvendas.control.FornecedorControl;
import com.lucas.sysvendas.model.domain.Fornecedor;
import com.lucas.sysvendas.model.domain.FornecedorEndereco;
import com.towel.swing.table.ObjectTableModel;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class TelaFornecedor extends javax.swing.JInternalFrame {
    
    private final ObjectTableModel<Fornecedor> otmFornecedor = new ObjectTableModel<>(Fornecedor.class, "codigo,nomeFantasia,cnpj,telefone,celular,email");
    private final ObjectTableModel<FornecedorEndereco> otmFornecedorEndereco = new ObjectTableModel<>(FornecedorEndereco.class, "endereco,numero,bairro,complemento,cidade,estado,cep");
    
    private final FornecedorControl fornecedorControl = new FornecedorControl();
    
    private Fornecedor fornecedor;
    private FornecedorEndereco fornecedorEndereco;
    
    private String statusBotoes;

    /**
     * Creates new form TelaFuncionario
     */
    public TelaFornecedor() {
        
        initComponents();
        
        habilitarFormulario(false);
        
        carregarGrade();
        
        if (tpFornecedor.getSelectedRowCount() > 0) {
            
            int linhaSelecionada = tpFornecedor.getRowSorter().convertRowIndexToModel(tpFornecedor.getSelectedRow());
            Fornecedor fornecedorSelecionado = otmFornecedor.getValue(linhaSelecionada);

            try {
                otmFornecedorEndereco.setData(fornecedorControl.recuperarEndereco(fornecedorSelecionado));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao carregar o endereço do fornecedor.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } 
    }
    
    
    private void carregarGrade() {
        
        try {      
            otmFornecedor.setData(fornecedorControl.listarTodos());
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
        pBarraFerramentas = new javax.swing.JPanel();
        bNovo = new javax.swing.JButton();
        bSalvar = new javax.swing.JButton();
        bRemover = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        tpConteudoFornecedor = new javax.swing.JTabbedPane();
        paDadosFornecedor = new javax.swing.JPanel();
        lblNomeFantasia = new javax.swing.JLabel();
        txtNomeFantasia = new javax.swing.JTextField();
        lblRazaoSocial = new javax.swing.JLabel();
        txtRazaoSocial = new javax.swing.JTextField();
        lblCpfCnpj = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tpFornecedor = new javax.swing.JTable();
        lblDocumento = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        lblCelular = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        ftfCnpj = new javax.swing.JFormattedTextField();
        paDadosFornecedorEndereco = new javax.swing.JPanel();
        lblEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        lblNumero = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        lblBairro = new javax.swing.JLabel();
        lblComplemento = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tpFornecedorEndereco = new javax.swing.JTable();
        txtBairro = new javax.swing.JTextField();
        txtComplemento = new javax.swing.JTextField();
        lblCidade = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        lblUf = new javax.swing.JLabel();
        txtUf = new javax.swing.JTextField();
        lblCep = new javax.swing.JLabel();
        txtCep = new javax.swing.JTextField();
        bAdicionarEndereco = new javax.swing.JButton();
        bRemoverEndereco = new javax.swing.JButton();
        bEditarEndereco = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setClosable(true);
        setResizable(true);
        setTitle("Cadastro de Fornecedores");

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

        bRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excluir.png"))); // NOI18N
        bRemover.setMnemonic(KeyEvent.VK_R);
        bRemover.setText("Remover");
        bRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRemoverActionPerformed(evt);
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

        javax.swing.GroupLayout pBarraFerramentasLayout = new javax.swing.GroupLayout(pBarraFerramentas);
        pBarraFerramentas.setLayout(pBarraFerramentasLayout);
        pBarraFerramentasLayout.setHorizontalGroup(
            pBarraFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBarraFerramentasLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(bNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRemover)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bCancelar)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        pBarraFerramentasLayout.setVerticalGroup(
            pBarraFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBarraFerramentasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pBarraFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pBarraFerramentasLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(bRemover, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                    .addComponent(bNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        lblNomeFantasia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNomeFantasia.setText("Nome Fantasia:");

        txtNomeFantasia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeFantasiaKeyPressed(evt);
            }
        });

        lblRazaoSocial.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRazaoSocial.setText("Razão Social:");

        txtRazaoSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRazaoSocialKeyPressed(evt);
            }
        });

        lblCpfCnpj.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCpfCnpj.setText("CNPJ:");

        lblTelefone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTelefone.setText("Telefone:");

        tpFornecedor.setModel(otmFornecedor);
        tpFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tpFornecedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tpFornecedor);

        lblDocumento.setText("I.E.:");

        lblCelular.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCelular.setText("Celular:");

        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEmail.setText("Email:");

        javax.swing.GroupLayout paDadosFornecedorLayout = new javax.swing.GroupLayout(paDadosFornecedor);
        paDadosFornecedor.setLayout(paDadosFornecedorLayout);
        paDadosFornecedorLayout.setHorizontalGroup(
            paDadosFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
            .addGroup(paDadosFornecedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paDadosFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTelefone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCpfCnpj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNomeFantasia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRazaoSocial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paDadosFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNomeFantasia)
                    .addComponent(txtRazaoSocial)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paDadosFornecedorLayout.createSequentialGroup()
                        .addComponent(ftfCnpj)
                        .addGap(18, 18, 18)
                        .addComponent(lblDocumento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paDadosFornecedorLayout.createSequentialGroup()
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCelular, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                    .addComponent(txtEmail))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paDadosFornecedorLayout.setVerticalGroup(
            paDadosFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paDadosFornecedorLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(paDadosFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeFantasia)
                    .addComponent(txtNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paDadosFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRazaoSocial)
                    .addComponent(txtRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paDadosFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpfCnpj)
                    .addComponent(lblDocumento)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paDadosFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefone)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCelular)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paDadosFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        tpConteudoFornecedor.addTab("Dados", paDadosFornecedor);

        lblEndereco.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEndereco.setText("Endereço:");

        lblNumero.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumero.setText("Número:");

        lblBairro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBairro.setText("Bairro:");

        lblComplemento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblComplemento.setText("Complemento:");

        tpFornecedorEndereco.setModel(otmFornecedorEndereco);
        tpFornecedorEndereco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tpFornecedorEnderecoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tpFornecedorEndereco);

        lblCidade.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCidade.setText("Cidade:");

        lblUf.setText("UF:");

        lblCep.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCep.setText("CEP:");

        bAdicionarEndereco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/novo.png"))); // NOI18N
        bAdicionarEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAdicionarEnderecoActionPerformed(evt);
            }
        });

        bRemoverEndereco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excluir.png"))); // NOI18N
        bRemoverEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRemoverEnderecoActionPerformed(evt);
            }
        });

        bEditarEndereco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        bEditarEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditarEnderecoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paDadosFornecedorEnderecoLayout = new javax.swing.GroupLayout(paDadosFornecedorEndereco);
        paDadosFornecedorEndereco.setLayout(paDadosFornecedorEnderecoLayout);
        paDadosFornecedorEnderecoLayout.setHorizontalGroup(
            paDadosFornecedorEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
            .addGroup(paDadosFornecedorEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paDadosFornecedorEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(paDadosFornecedorEnderecoLayout.createSequentialGroup()
                        .addGroup(paDadosFornecedorEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                        .addGap(5, 5, 5)
                        .addGroup(paDadosFornecedorEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paDadosFornecedorEnderecoLayout.createSequentialGroup()
                                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(paDadosFornecedorEnderecoLayout.createSequentialGroup()
                        .addGroup(paDadosFornecedorEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblComplemento, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paDadosFornecedorEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtComplemento)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paDadosFornecedorEnderecoLayout.createSequentialGroup()
                                .addComponent(txtCidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblUf)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCep, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paDadosFornecedorEnderecoLayout.createSequentialGroup()
                                .addComponent(bAdicionarEndereco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bEditarEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bRemoverEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paDadosFornecedorEnderecoLayout.setVerticalGroup(
            paDadosFornecedorEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paDadosFornecedorEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paDadosFornecedorEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndereco)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paDadosFornecedorEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumero)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBairro)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paDadosFornecedorEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblComplemento)
                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paDadosFornecedorEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCidade)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUf)
                    .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCep)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paDadosFornecedorEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(bRemoverEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bEditarEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bAdicionarEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        tpConteudoFornecedor.addTab("Endereço", paDadosFornecedorEndereco);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pBarraFerramentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tpConteudoFornecedor)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pBarraFerramentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(439, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(63, 63, 63)
                    .addComponent(tpConteudoFornecedor)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovoActionPerformed
        fornecedor = fornecedorControl.novoFornecedor();
        habilitarFormulario(true);
        bRemover.setEnabled(false);
        txtNomeFantasia.requestFocus();
    }//GEN-LAST:event_bNovoActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        habilitarFormulario(false);
        
        otmFornecedorEndereco.clear();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void tpFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tpFornecedorMouseClicked
        if (evt.getClickCount() >= 2) {
            fornecedor = otmFornecedor.getValue(tpFornecedor.getSelectedRow());
            
            txtNomeFantasia.setText(fornecedor.getNomeFantasia());
            txtRazaoSocial.setText(fornecedor.getRazaoSocial());
            ftfCnpj.setValue(fornecedor.getCnpj());
            txtDocumento.setText(fornecedor.getDocumento());
            txtTelefone.setText(fornecedor.getTelefone());
            txtCelular.setText(fornecedor.getCelular());
            txtEmail.setText(fornecedor.getEmail());
            
            try {
                otmFornecedorEndereco.setData(fornecedorControl.recuperarEndereco(fornecedor));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao carregar o endereço do fornecedor.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }

            habilitarFormulario(true);

        }
    }//GEN-LAST:event_tpFornecedorMouseClicked

    private void bSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalvarActionPerformed
        if (validarFormulario()) {
            
            fornecedor.setNomeFantasia(txtNomeFantasia.getText().trim());
            fornecedor.setRazaoSocial(txtRazaoSocial.getText());
            fornecedor.setDataCadastro(new Date());
            fornecedor.setCnpj((String) ftfCnpj.getValue());
            fornecedor.setDocumento(txtDocumento.getText());
            fornecedor.setTelefone(txtTelefone.getText());
            fornecedor.setCelular(txtCelular.getText());
            fornecedor.setEmail(txtEmail.getText());


            if (fornecedor.getCodigo() == 0) {
                try {
                    fornecedorControl.inserirFornecedor(fornecedor);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao cadastrar o fornecedor.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else {
                try {
                    fornecedorControl.alterarFornecedor(fornecedor);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao alterar o fornecedor.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } 

            habilitarFormulario(false);
            carregarGrade();
            
            otmFornecedorEndereco.clear();
        }
    }//GEN-LAST:event_bSalvarActionPerformed

    private void txtNomeFantasiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeFantasiaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
          txtRazaoSocial.requestFocus();
        }
    }//GEN-LAST:event_txtNomeFantasiaKeyPressed

    private void txtRazaoSocialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazaoSocialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
          ftfCnpj.requestFocus();
        }
    }//GEN-LAST:event_txtRazaoSocialKeyPressed

    private void bRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRemoverActionPerformed
        int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o fornecedor " + fornecedor + "?");
        if (opcao == 0) {
            try {
                fornecedorControl.excluirFornecedor(fornecedor);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir o fornecedor.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            habilitarFormulario(false);
            carregarGrade();
        }
    }//GEN-LAST:event_bRemoverActionPerformed

    private void tpFornecedorEnderecoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tpFornecedorEnderecoMouseClicked
        if (evt.getClickCount() >= 2) {
            
            fornecedorEndereco = otmFornecedorEndereco.getValue(tpFornecedorEndereco.getSelectedRow());
            
            txtEndereco.setText(fornecedorEndereco.getEndereco());
            txtNumero.setText(fornecedorEndereco.getNumero());
            txtBairro.setText(fornecedorEndereco.getBairro());
            txtComplemento.setText(fornecedorEndereco.getComplemento());
            txtCidade.setText(fornecedorEndereco.getCidade());
            txtUf.setText(fornecedorEndereco.getEstado());
            txtCep.setText(fornecedorEndereco.getCep());

            habilitarFormulario(true);

        }
    }//GEN-LAST:event_tpFornecedorEnderecoMouseClicked

    private void bAdicionarEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAdicionarEnderecoActionPerformed
        
        statusBotoes = "Adicionando";
        
        setarFornecedorEndereco();
        
        otmFornecedorEndereco.setData(fornecedor.getEndereco());
        
        limpaFormularioFornecedorEndereco();
        
    }//GEN-LAST:event_bAdicionarEnderecoActionPerformed

    private void bRemoverEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRemoverEnderecoActionPerformed
        if (tpFornecedorEndereco.getSelectedRowCount() > 0) {
            
            int linhaSelecionada = tpFornecedorEndereco.getSelectedRow();
            FornecedorEndereco enderecoRemover = otmFornecedorEndereco.getValue(linhaSelecionada);

            if (JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o endereço " + enderecoRemover + "?", "Confirmação", JOptionPane.YES_NO_OPTION) == 0) {
                fornecedor.getEndereco().remove(enderecoRemover);
                otmFornecedorEndereco.setData(fornecedor.getEndereco());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma linha para remover.", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bRemoverEnderecoActionPerformed

    private void bEditarEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditarEnderecoActionPerformed
        statusBotoes = "Alterando";
        
        setarFornecedorEndereco();
        
        otmFornecedorEndereco.setData(fornecedor.getEndereco());
        
        limpaFormularioFornecedorEndereco();
    }//GEN-LAST:event_bEditarEnderecoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAdicionarEndereco;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bEditarEndereco;
    private javax.swing.JButton bNovo;
    private javax.swing.JButton bRemover;
    private javax.swing.JButton bRemoverEndereco;
    private javax.swing.JButton bSalvar;
    private javax.swing.ButtonGroup bgClienteTipo;
    private javax.swing.JFormattedTextField ftfCnpj;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblComplemento;
    private javax.swing.JLabel lblCpfCnpj;
    private javax.swing.JLabel lblDocumento;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNomeFantasia;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblRazaoSocial;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblUf;
    private javax.swing.JPanel pBarraFerramentas;
    private javax.swing.JPanel paDadosFornecedor;
    private javax.swing.JPanel paDadosFornecedorEndereco;
    private javax.swing.JTabbedPane tpConteudoFornecedor;
    private javax.swing.JTable tpFornecedor;
    private javax.swing.JTable tpFornecedorEndereco;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNomeFantasia;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRazaoSocial;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtUf;
    // End of variables declaration//GEN-END:variables

private void habilitarFormulario(boolean b) {
    
        bNovo.setEnabled(!b);
        bSalvar.setEnabled(b);
        bRemover.setEnabled(b);
        bCancelar.setEnabled(b);
        txtNomeFantasia.setEnabled(b);
        txtRazaoSocial.setEnabled(b);
        ftfCnpj.setEnabled(b);
        txtDocumento.setEnabled(b);
        txtTelefone.setEnabled(b);
        txtCelular.setEnabled(b);
        txtEmail.setEnabled(b);
        txtEndereco.setEnabled(b);
        txtNumero.setEnabled(b);
        txtBairro.setEnabled(b);
        txtComplemento.setEnabled(b);
        txtCidade.setEnabled(b);
        txtUf.setEnabled(b);
        txtCep.setEnabled(b);
        tpFornecedor.setEnabled(!b);

        if (!b) {
            
            limpaFormulario();
            limpaFormularioFornecedorEndereco();
        }
    }

    private void limpaFormulario() {
        
        fornecedor = null;
        txtNomeFantasia.setText("");
        txtRazaoSocial.setText("");
        ftfCnpj.setValue("");
        txtDocumento.setText("");
        txtTelefone.setText("");
        txtCelular.setText("");
        txtEmail.setText("");
        
    }
    
    private void limpaFormularioFornecedorEndereco() {

        txtEndereco.setText("");
        txtNumero.setText("");
        txtBairro.setText("");
        txtComplemento.setText("");
        txtCidade.setText("");
        txtUf.setText("");
        txtCep.setText("");
    }
    
    private void setarFornecedorEndereco() {
        
        if (statusBotoes.equals("Adicionando")) {
            fornecedorEndereco = fornecedorControl.novoFornecedorEndereco();
        }
        
        fornecedorEndereco.setEndereco(txtEndereco.getText());
        fornecedorEndereco.setNumero(txtNumero.getText());
        fornecedorEndereco.setBairro(txtBairro.getText());
        fornecedorEndereco.setComplemento(txtComplemento.getText());
        fornecedorEndereco.setCidade(txtCidade.getText());
        fornecedorEndereco.setEstado(txtUf.getText());
        fornecedorEndereco.setCep(txtCep.getText());
        
        fornecedor.getEndereco().add(fornecedorEndereco);
    }
    
    
    private boolean validarFormulario() {
        if (txtNomeFantasia.getText().trim().length() < 3) {
            JOptionPane.showMessageDialog(this, "Nome inválido.", "Alerta", JOptionPane.WARNING_MESSAGE);
            txtNomeFantasia.requestFocus();
            return false;
        }

        return true;
    }

}
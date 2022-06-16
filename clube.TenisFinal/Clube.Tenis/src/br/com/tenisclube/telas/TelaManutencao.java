package br.com.tenisclube.telas;

import br.com.tenisclube.dal.ManutencaoDAO;
import java.sql.*;
import interDAO.manutencaoInterDAO;
import java.text.DateFormat;
import javax.swing.JOptionPane;
import java.util.Date;

/**
 *
 * @author cintia - debora - isabela
 */
public class TelaManutencao extends javax.swing.JFrame { 
    
     
            
    public TelaManutencao() {
        initComponents();
            
        
            }
     
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDia = new javax.swing.JLabel();
        btnUsuDelete = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblAgendar = new javax.swing.JLabel();
        lblHorario = new javax.swing.JLabel();
        txtAgendarPara = new javax.swing.JTextField();
        txtHorario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNumeroQuadra = new javax.swing.JTextField();
        txtDia = new javax.swing.JFormattedTextField();
        lblId = new javax.swing.JLabel();
        btnUsuUpdate = new javax.swing.JButton();
        btnUsuCreate = new javax.swing.JButton();
        txtIdManutencao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAgendamento = new javax.swing.JTable();
        btnUsuDelete1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Controle de Manutenção das Quadras");
        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(640, 480));
        setPreferredSize(new java.awt.Dimension(640, 480));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        lblDia.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblDia.setText("Dia");

        btnUsuDelete.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnUsuDelete.setText("Excluir");
        btnUsuDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuDeleteActionPerformed(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da quadra em manutenção"));
        jPanel1.setToolTipText("");
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblAgendar.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblAgendar.setText("Agendar para");

        lblHorario.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblHorario.setText("Horário");

        txtAgendarPara.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N

        txtHorario.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel2.setText("Número da quadra");

        txtNumeroQuadra.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 235, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAgendarPara)
                    .addComponent(txtHorario, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(txtNumeroQuadra))
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNumeroQuadra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAgendarPara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );

        try {
            txtDia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDia.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N

        lblId.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblId.setText("Id");

        btnUsuUpdate.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnUsuUpdate.setText("Alterar");
        btnUsuUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuUpdateActionPerformed(evt);
            }
        });

        btnUsuCreate.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnUsuCreate.setText("Adicionar");
        btnUsuCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuCreateActionPerformed(evt);
            }
        });

        txtIdManutencao.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txtIdManutencao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdManutencaoKeyReleased(evt);
            }
        });

        tblAgendamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAgendamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAgendamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAgendamento);

        btnUsuDelete1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnUsuDelete1.setText("Consultar");
        btnUsuDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuDelete1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblDia, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSair))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnUsuDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnUsuCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnUsuUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btnUsuDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(230, 230, 230))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtIdManutencao, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDia)
                    .addComponent(btnSair)
                    .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdManutencao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUsuCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        setSize(new java.awt.Dimension(656, 524));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
                
        // ao abrir a tela manutenção a hora é gerada automaticamente
        Date dia = new Date ();
        DateFormat mudador = DateFormat.getDateInstance(DateFormat.SHORT);
        txtDia.setText(mudador.format(dia));     

    }//GEN-LAST:event_formWindowActivated

    private void btnUsuDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuDeleteActionPerformed
        // chamando o método para remover
       // remover();
       int idManutencao = Integer.parseInt(txtIdManutencao.getText());
        ManutencaoDAO miDAO = new ManutencaoDAO();
        miDAO.apagar(idManutencao);
        txtNumeroQuadra.setText("");
        txtAgendarPara.setText("");
        txtHorario.setText("");
     
    }//GEN-LAST:event_btnUsuDeleteActionPerformed

    private void btnUsuUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuUpdateActionPerformed
        // chamando o método para alterar
        //alterar();
        int idManutencao = Integer.parseInt(txtIdManutencao.getText());
         manutencaoInterDAO mi = new manutencaoInterDAO(); 
        mi.setIdManutencao(idManutencao);
        mi.setNumeroQuadra(txtNumeroQuadra.getText()); 
        mi.setAgendarPara(txtAgendarPara.getText()); 
        mi.setHorario(txtHorario.getText());
        
        ManutencaoDAO miDAO = new ManutencaoDAO();
        miDAO.alterar(mi);
    
    }//GEN-LAST:event_btnUsuUpdateActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // chamando o comando para sair
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnUsuCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuCreateActionPerformed
        // chamando o método para adicionar
        //adicionar();
         manutencaoInterDAO mi = new manutencaoInterDAO(); 
                
        mi.setNumeroQuadra(txtNumeroQuadra.getText()); 
        mi.setAgendarPara(txtAgendarPara.getText()); 
        mi.setHorario(txtHorario.getText());
        
        ManutencaoDAO miDAO = new ManutencaoDAO();
        miDAO.cadastrar(mi);
    }//GEN-LAST:event_btnUsuCreateActionPerformed

//evento que será usado para setar os campos da tabela (quando clicar com o mouse)
    private void tblAgendamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAgendamentoMouseClicked
        // metodo para setar os campos
        
        int setar = tblAgendamento.getSelectedRow();
        txtDia.setText(tblAgendamento.getModel().getValueAt(setar, 1).toString());
        txtNumeroQuadra.setText(tblAgendamento.getModel().getValueAt(setar, 2).toString());
        txtAgendarPara.setText(tblAgendamento.getModel().getValueAt(setar, 3).toString());
        txtHorario.setText(tblAgendamento.getModel().getValueAt(setar, 4).toString());
    }//GEN-LAST:event_tblAgendamentoMouseClicked

    private void txtIdManutencaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdManutencaoKeyReleased
        // método para consultar os dados das manutenções agendadas
       
        
    }//GEN-LAST:event_txtIdManutencaoKeyReleased

    private void btnUsuDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuDelete1ActionPerformed
        // TODO add your handling code here:
        //consultar
        int idManutencao = Integer.parseInt(txtIdManutencao.getText());
        ManutencaoDAO miDAO = new ManutencaoDAO();
        manutencaoInterDAO mi = miDAO.consultar(idManutencao);
        if (mi == null){
            JOptionPane.showMessageDialog(this, "Quadra não cadastrado");
        }else{
        txtNumeroQuadra.setText(mi.getNumeroQuadra());
        txtAgendarPara.setText(mi.getAgendarPara());
        txtHorario.setText(mi.getHorario());
        }
    }//GEN-LAST:event_btnUsuDelete1ActionPerformed

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaManutencao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaManutencao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaManutencao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaManutencao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaManutencao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnUsuCreate;
    private javax.swing.JButton btnUsuDelete;
    private javax.swing.JButton btnUsuDelete1;
    private javax.swing.JButton btnUsuUpdate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAgendar;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblId;
    private javax.swing.JTable tblAgendamento;
    private javax.swing.JTextField txtAgendarPara;
    private javax.swing.JFormattedTextField txtDia;
    private javax.swing.JTextField txtHorario;
    private javax.swing.JTextField txtIdManutencao;
    private javax.swing.JTextField txtNumeroQuadra;
    // End of variables declaration//GEN-END:variables

   
}

package br.com.tenisclube.telas;

import br.com.tenisclube.dal.ManutencaoDAO;
import java.sql.*;
import br.com.tenisclube.dal.ModuloConexao;
import interDAO.manutencaoInterDAO;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.List;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author cintia - debora - isabela
 */
public class TelaManutencao extends javax.swing.JFrame { 
    
    // usando a variavel conexao do DAO 
    Connection conexao = null;
    // criando variaveis especiais para conexão com o banco
    //Prepared Statemente e ResultSet são frameworks do pacote java.sql
    // e servem para preparar e executar as instruções SQL
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    
            
    public TelaManutencao() {
        initComponents();
            
        //estabelecendo a conexão com o banco sempre nesse ponto
        conexao = ModuloConexao.conector();
    }
     
    private void adicionar(){
        String sql = "insert into tbmanutencao (numeroQuadra, agendarPara, horario) values (?,?,?)";
        try{            
            pst=conexao.prepareStatement(sql);
            pst.setString(1,txtNumeroQuadra.getText());
            pst.setString(2,txtAgendarPara.getText());
            pst.setString(3,txtHorario.getText());
            
            
                       
            //Validação dos campos obrigatorios
             if ((txtNumeroQuadra.getText().isEmpty())||(txtAgendarPara.getText().isEmpty())||(txtHorario.getText().isEmpty()))
                {
                JOptionPane.showMessageDialog(null,"Preencha todos os campos obrigatorios!");
            } else {
            
            //a linha abaixo atualiza a tabela manutenção com os dados do formulario 
                int adicionada = pst.executeUpdate();
                
                //a linha abaixo confirma a inserção de dados
                if(adicionada > 0){
                    JOptionPane.showMessageDialog(null,"Manutenção adicionada com sucesso!");
                    
                //as linhas abaixo "limpa" os campos
                txtIdManutencao.setText(null);
                txtNumeroQuadra.setText(null);
                txtAgendarPara.setText(null);
                txtHorario.setText(null);
                
                }
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void consultarManutencao(){
        String sql = "select * from tbmanutencao where idManutencao like ?";
        try{
            pst = conexao.prepareStatement(sql);
            
            //passando o conteudo da caixa de pesquisa id para o ?
            //atenção ao "%" - continuação da String sql
            pst.setString(1,txtIdManutencao.getText()+ "%");
            rs = pst.executeQuery();
            //utilizando a biblioteca rs2xml.jar para preencher a tabela
            tblAgendamento.setModel(DbUtils.resultSetToTableModel(rs));
            
           /* if (rs.next()) {
               txtAgendarPara.setText(rs.getString(2));  
               txtHorario.setText(rs.getString(3));
               cbAlterarData.setSelectedItem(rs.getString(4));
               cbCancelarManutencao.setSelectedItem(rs.getString(5));
                        
            } else {
                JOptionPane.showMessageDialog(null,"Manutenção não localizada");
                
                //as linhas abaixo "limpa" os campos
                txtIdQuad.setText(null);
                txtAgendarPara.setText(null);
                txtHorario.setText(null);
                cbAlterarData.setSelectedItem(null);
                cbCancelarManutencao.setSelectedItem(null);
                
                
            }*/
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    //criando metodo para setar os campos do formulario com o conteudo da tabela
    public void setarCampos (){
        int setar = tblAgendamento.getSelectedRow();
        txtDia.setText(tblAgendamento.getModel().getValueAt(setar, 1).toString());
        txtNumeroQuadra.setText(tblAgendamento.getModel().getValueAt(setar, 2).toString());
        txtAgendarPara.setText(tblAgendamento.getModel().getValueAt(setar, 3).toString());
        txtHorario.setText(tblAgendamento.getModel().getValueAt(setar, 4).toString());
        
    }
    // criando o metodo para alterar dados da manutenção
    private void alterar(){
        String sql="update tbmanutencao set numeroQuadra=?, agendarPara=?, horario=?";
        try {
            pst=conexao.prepareStatement(sql);
            pst.setString(1,txtNumeroQuadra.getText());
            pst.setString(2,txtAgendarPara.getText());
            pst.setString(3,txtHorario.getText());
            
            
           
         //Validação dos campos obrigatorios
             if ((txtNumeroQuadra.getText().isEmpty())||(txtAgendarPara.getText().isEmpty())||(txtHorario.getText().isEmpty()))
                {
                JOptionPane.showMessageDialog(null,"Preencha todos os campos obrigatorios!");
            } else {
            
            //a linha abaixo atualiza a tabela manutenção com os dados do formulario 
                int alterada = pst.executeUpdate();
                
                //a linha abaixo confirma a inserção de dados
                if(alterada>0){
                    JOptionPane.showMessageDialog(null,"Manutenção alterada com sucesso!");
                    
                //as linhas abaixo "limpa" os campos
                txtIdManutencao.setText(null);
                txtNumeroQuadra.setText(null);
                txtAgendarPara.setText(null);
                txtHorario.setText(null);
               
                }
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //metodo Responsavel pela remoção da manutenção no banco
    private void remover(){
    //a estrutura abaixo confirma a remoção de manutenção
    int confirma = JOptionPane.showConfirmDialog(null," Tem certeza que deseja cancelar a manutenção?" ,"Atenção", JOptionPane.YES_NO_OPTION);
    if (confirma==JOptionPane.YES_OPTION){
        String sql="delete from tbmanutencao where idManutencao=?";
        try {
            pst=conexao.prepareStatement(sql);
            pst.setString(1,txtIdManutencao.getText());
            int apagado = pst.executeUpdate();
            if(apagado>0){
                JOptionPane.showMessageDialog(null,"Manutenção cancelada com sucesso");
                
                //as linhas abaixo "limpa" os campos
                txtIdManutencao.setText(null);
                txtNumeroQuadra.setText(null);
                txtAgendarPara.setText(null);
                txtHorario.setText(null);
                
            }
            
           
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        }
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Controle de Manutenção das Quadras");
        setResizable(false);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAgendarPara)
                    .addComponent(txtHorario, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(txtNumeroQuadra))
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdManutencao, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnUsuCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUsuUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUsuDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(286, 286, 286)))))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDia)
                    .addComponent(btnSair)
                    .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdManutencao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUsuCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        setSize(new java.awt.Dimension(1104, 552));
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
       
    
    }//GEN-LAST:event_btnUsuUpdateActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // chamando o comando para sair
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnUsuCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuCreateActionPerformed
        // chamando o método para adicionar
        //adicionar();
        ManutencaoDAO mi = new ManutencaoDAO();
        
        mi.setNumeroQuadra(txtNumeroQuadra.getText()); 
        mi.setAgendarPara(txtAgendarPara.getText()); 
        mi.setHorario(txtHorario.getText());
    }//GEN-LAST:event_btnUsuCreateActionPerformed

//evento que será usado para setar os campos da tabela (quando clicar com o mouse)
    private void tblAgendamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAgendamentoMouseClicked
        // metodo para setar os campos
        setarCampos ();
    }//GEN-LAST:event_tblAgendamentoMouseClicked

    private void txtIdManutencaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdManutencaoKeyReleased
        // método para consultar os dados das manutenções agendadas
        consultarManutencao ();
        
    }//GEN-LAST:event_txtIdManutencaoKeyReleased

   
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

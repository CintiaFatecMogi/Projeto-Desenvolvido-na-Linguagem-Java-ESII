
package br.com.tenisclube.telas;

import br.com.tenisclube.dal.QuadraDAO;
import interDAO.quadraInterDAO;
import javax.swing.JOptionPane;



/**
 *
 * @author debor
 */
public class TelaQuadra extends javax.swing.JInternalFrame {
   
     
    public TelaQuadra() {
        initComponents();
       
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txt = new javax.swing.JLabel();
        cboQTipo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cboQBanJog = new javax.swing.JComboBox<>();
        cboQArqb = new javax.swing.JComboBox<>();
        btnAlterar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        txt2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtQNome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtQId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtQPreco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cboQCob = new javax.swing.JComboBox<>();

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

        jLabel5.setText("jLabel5");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastra Quadras");
        setPreferredSize(new java.awt.Dimension(640, 480));

        txt.setText("Tipos de quadra *");

        cboQTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Saibro", "Beach" }));

        jLabel2.setText("Quadra Coberta *");

        cboQBanJog.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não" }));

        cboQArqb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não" }));

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnApagar.setText("Excluir");
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        txt2.setText("Banco para Jogadores *");

        jLabel6.setText("Nome da Quadra *");

        jLabel7.setText("Numero da Quadra  *");

        jLabel8.setText("Preço Aluguel  *");

        jLabel3.setText("Arquibancada *");

        cboQCob.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQId, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt)
                    .addComponent(cboQTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(cboQArqb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboQCob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtQPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQNome, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt2)
                            .addComponent(cboQBanJog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(214, Short.MAX_VALUE)
                .addComponent(btnConsultar)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnApagar)
                        .addGap(85, 85, 85))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAlterar)
                        .addGap(247, 247, 247))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtQNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt)
                    .addComponent(txt2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboQBanJog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboQTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboQArqb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboQCob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar)
                    .addComponent(btnAdicionar)
                    .addComponent(btnApagar)
                    .addComponent(btnConsultar))
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 640, 480);
    }// </editor-fold>//GEN-END:initComponents

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        //Chamar metodo Remover
        int idquad = Integer.parseInt(txtQId.getText());
        QuadraDAO qDAO = new QuadraDAO();
        qDAO.apagar(idquad);
            txtQId.setText("");
            txtQNome.setText("");
            txtQPreco.setText("");
            cboQTipo.setSelectedItem("");
            cboQBanJog.setSelectedItem("");
            cboQArqb.setSelectedItem("");
            cboQCob.setSelectedItem("");
    }//GEN-LAST:event_btnApagarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // Chamando metodo consultar
        int idquad = Integer.parseInt(txtQId.getText());
        QuadraDAO qDAO = new QuadraDAO();
        quadraInterDAO q = qDAO.consultar(idquad);
        if (q == null){
            JOptionPane.showMessageDialog(this, "Quadra não cadastrado");
        }else{
            //preencher o form com os dados
            
            txtQNome.setText(q.getNomequadra());
            txtQPreco.setText(q.getPreco());
            cboQTipo.setSelectedItem(q.getTipoquad());
            cboQBanJog.setSelectedItem(q.getBancoquad());
            cboQArqb.setSelectedItem(q.getArquibancada());
            cboQCob.setSelectedItem(q.getQuadcoberta());
    }//GEN-LAST:event_btnConsultarActionPerformed
    }
    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        // Chamando metodo adicionar
        quadraInterDAO q = new quadraInterDAO();
       
        q.setNomequadra(txtQNome.getText());
        q.setPreco(txtQPreco.getText());
        q.setIdquad(Integer.parseInt(txtQId.getText()));
        q.setTipoquad(cboQTipo.getSelectedItem().toString());
        q.setArquibancada(cboQArqb.getSelectedItem().toString());
        q.setBancoquad(cboQBanJog.getSelectedItem().toString());
        q.setQuadcoberta(cboQCob.getSelectedItem().toString());
        
        QuadraDAO qDAO = new QuadraDAO();
        qDAO.cadastrar(q);
       
       
    }//GEN-LAST:event_btnAdicionarActionPerformed
    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // Chamando metodo editar
        int idquad = Integer.parseInt(txtQId.getText());
        quadraInterDAO q = new quadraInterDAO();
        q.setIdquad(idquad);
        q.setNomequadra(txtQNome.getText());
        q.setPreco(txtQPreco.getText());
        q.setTipoquad(cboQTipo.getSelectedItem().toString());
        q.setArquibancada(cboQArqb.getSelectedItem().toString());
        q.setBancoquad(cboQBanJog.getSelectedItem().toString());
        q.setQuadcoberta(cboQCob.getSelectedItem().toString());
        
        QuadraDAO qDAO = new QuadraDAO();
        qDAO.alterar(q);
       
        
        
    }//GEN-LAST:event_btnAlterarActionPerformed
    
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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaQuadra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JComboBox<String> cboQArqb;
    private javax.swing.JComboBox<String> cboQBanJog;
    private javax.swing.JComboBox<String> cboQCob;
    private javax.swing.JComboBox<String> cboQTipo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel txt;
    private javax.swing.JLabel txt2;
    public static javax.swing.JTextField txtQId;
    private javax.swing.JTextField txtQNome;
    private javax.swing.JTextField txtQPreco;
    // End of variables declaration//GEN-END:variables


}

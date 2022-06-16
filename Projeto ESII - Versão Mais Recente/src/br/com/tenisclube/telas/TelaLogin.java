
package br.com.tenisclube.telas;


import br.com.tenisclube.dal.UsuarioDAO;
import interDAO.usuarioInterDAO;
import javax.swing.JOptionPane;
/**
 *
 * @author debor
 */
public class TelaLogin extends javax.swing.JFrame {
    
 
     public TelaLogin(){
        initComponents();
        //estabelecendo a conexão com o banco sempre nesse poto
       // conexao = ModuloConexao.getConector();
        //a linha abaixo serve de apoio ao status da conexao
       // System.out.println(conexao);
       /* if (conexao != null){
            //lblStatus.setText("conectado");
            lblStatus.setIcon(new javax.swing.ImageIcon(getClass(). getResource("/br/com/tenisclube/icones/dbyes.png")));
        }else{
            //lblStatus.setText("Não conectado");
             lblStatus.setIcon(new javax.swing.ImageIcon(getClass(). getResource("/br/com/tenisclube/icones/dbno.png")));
        }
       */
     }
    
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        LblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tenis Clube  -  Tela Login");
        setResizable(false);

        LblUsuario.setText("Usuario *");

        LblSenha.setText("Senha *");

        btnLogin.setBackground(new java.awt.Color(255, 0, 0));
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Entrar");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tenisclube/icones/dbno.png"))); // NOI18N
        lblStatus.setMaximumSize(new java.awt.Dimension(28, 28));
        lblStatus.setMinimumSize(new java.awt.Dimension(28, 28));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogin))
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblUsuario)
                    .addComponent(LblSenha)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(LblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // chamando o metodo logar
        UsuarioDAO uDAO = new UsuarioDAO();
        usuarioInterDAO u = uDAO.login(txtUsuario.getText(), txtSenha.getText());
       if(u.getIdUser()> 0){
           TelaPrincipal principal = new TelaPrincipal(u);
           principal.setVisible(true);
           /*if (perfil.equals ("HU 13 a 15 - Relatorios"))
                       {
                        //abaixo vai abrir a tela principal se o usuario e senha estiver certa
                        TelaPrincipal principal = new TelaPrincipal();
                        principal.setVisible(true);
                        //Linha abaixo permissões de acesso
                        TelaPrincipal.menRelSer.setEnabled(true);
                        TelaPrincipal.menRelPlan.setEnabled(true);
                        TelaPrincipal.menRelRec.setEnabled(true);
                        TelaPrincipal.menCadUsu.setEnabled(true);
                        TelaPrincipal.menCadQua.setEnabled(true);
                        TelaPrincipal.menCadManut.setEnabled(true);
                        //abaixo imprime na tela quem é o usuario que esta acessando
                        TelaPrincipal.lblUsuario.setText(rs.getString(2));
                        TelaPrincipal.jlblPerfil.setText(rs.getString(6));
                        // abaixo mudar a cor da letra quando for adm
                        TelaPrincipal.lblUsuario.setForeground(Color.RED);
                        this.dispose();
                        conexao.close();                           
                       }
          
                       else if (perfil.equals ("HU 1 a 6 - gerir de quadras"))
                           {
                            //abaixo vai abrir a tela principal se o usuario e senha estiver certa
                            TelaPrincipal principal = new TelaPrincipal();
                            principal.setVisible(true);
                            //Linha abaixo permissões de acesso                          
                            TelaPrincipal.menCadQua.setEnabled(true);
                            TelaPrincipal.menCadManut.setEnabled(true);
                            //abaixo imprime na tela quem é o usuario que esta acessando
                            TelaPrincipal.lblUsuario.setText(rs.getString(2));
                            TelaPrincipal.jlblPerfil.setText(rs.getString(6));
                            // abaixo mudar a cor da letra quando for adm
                            TelaPrincipal.lblUsuario.setForeground(Color.BLUE);
                            this.dispose();
                            conexao.close();       
                            }
                            
                           else if (perfil.equals ( "HU 7 a 12 - gerir de usuarios"))
                               {
                               //abaixo vai abrir a tela principal se o usuario e senha estiver certa
                               TelaPrincipal principal = new TelaPrincipal();
                               principal.setVisible(true);
                               //Linha abaixo permissões de acesso
                               TelaPrincipal.menCadUsu.setEnabled(true);
                               //abaixo imprime na tela quem é o usuario que esta acessando
                               TelaPrincipal.lblUsuario.setText(rs.getString(2));
                               TelaPrincipal.jlblPerfil.setText(rs.getString(6));
                               // abaixo mudar a cor da letra quando for adm
                               TelaPrincipal.lblUsuario.setForeground(Color.GREEN);
                               this.dispose();
                               conexao.close();
                               }
                               else 
                                   {
                                    //abaixo vai abrir a tela principal se o usuario e senha estiver certa
                                    TelaPrincipal principal = new TelaPrincipal();
                                    principal.setVisible(true);
                                    //Linha abaixo permissões de acesso
                                    TelaPrincipal.menCadQua.setEnabled(true);
                                    TelaPrincipal.menCadManut.setEnabled(true);
                                    TelaPrincipal.menCadUsu.setEnabled(true);
                                    //abaixo imprime na tela quem é o usuario que esta acessando
                                    TelaPrincipal.lblUsuario.setText(rs.getString(2));
                                    TelaPrincipal.jlblPerfil.setText(rs.getString(6));
                                    // abaixo mudar a cor da letra quando for adm
                                    TelaPrincipal.lblUsuario.setForeground(Color.YELLOW);
                                    this.dispose();
                                    conexao.close();
                                   }
           */
           this.dispose();
       }else{
           JOptionPane.showMessageDialog(null,"Usuario ou senha incorreta!");
       }
    }//GEN-LAST:event_btnLoginActionPerformed

    
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
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblSenha;
    private javax.swing.JLabel LblUsuario;
    private javax.swing.JButton btnLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

}

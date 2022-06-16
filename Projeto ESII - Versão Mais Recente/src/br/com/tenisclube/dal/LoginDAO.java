
package br.com.tenisclube.dal;


import br.com.tenisclube.telas.TelaPrincipal;
import interDAO.usuarioInterDAO;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author debor
 */

/*
public class LoginDAO {
    
    public usuarioInterDAO logar() {
// as linhas abaixo preparam as consultas ao banco em funcao
            // do que foi digitado nas caixas de texto. Os ? é substituido pelo
            //conteudo das variaveis
        Connection conexao = ModuloConexao.getConector();
        usuarioInterDAO u = new usuarioInterDAO();
        String sql = "select * from tbusuarios where login = ? and senha = mds(?)";
        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1,u.getUsuario());
            pst.setString(2,u.getSenha());
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                 String perfil = rs.getString(6);
            
                switch (u.getPerfil()) {
                    case "HU 13 a 15 - Relatorios":
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
                            TelaPrincipal.lblPerfil.setText(rs.getString(6));
                            // abaixo mudar a cor da letra quando for adm
                            TelaPrincipal.lblUsuario.setForeground(Color.RED);
                            //this.dispose();
                            conexao.close();
                            break;
                        }
                    case "HU 1 a 6 - gerir de quadras":
                        {
                            //abaixo vai abrir a tela principal se o usuario e senha estiver certa
                            TelaPrincipal principal = new TelaPrincipal();
                            principal.setVisible(true);
                            //Linha abaixo permissões de acesso
                            TelaPrincipal.menCadQua.setEnabled(true);
                            TelaPrincipal.menCadManut.setEnabled(true);
                            //abaixo imprime na tela quem é o usuario que esta acessando
                            TelaPrincipal.lblUsuario.setText(rs.getString(2));
                            TelaPrincipal.lblPerfil.setText(rs.getString(6));
                            // abaixo mudar a cor da letra quando for adm
                            TelaPrincipal.lblUsuario.setForeground(Color.BLUE);
                            // this.dispose();
                            conexao.close();
                            break;
                        }
                    case "HU 7 a 12 - gerir de usuarios":
                        {
                            //abaixo vai abrir a tela principal se o usuario e senha estiver certa
                            TelaPrincipal principal = new TelaPrincipal();
                            principal.setVisible(true);
                            //Linha abaixo permissões de acesso
                            TelaPrincipal.menCadUsu.setEnabled(true);
                            //abaixo imprime na tela quem é o usuario que esta acessando
                            TelaPrincipal.lblUsuario.setText(rs.getString(2));
                            TelaPrincipal.lblPerfil.setText(rs.getString(6));
                            // abaixo mudar a cor da letra quando for adm
                            TelaPrincipal.lblUsuario.setForeground(Color.GREEN);
                            // this.dispose();
                            conexao.close();
                            break;
                        }
                    default:
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
                            TelaPrincipal.lblPerfil.setText(rs.getString(6));
                            // abaixo mudar a cor da letra quando for adm
                            TelaPrincipal.lblUsuario.setForeground(Color.YELLOW);
                            //this.dispose();
                            conexao.close();
                            break;
                        }
                }

           
                
            }
           
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Usuario ou senha incorreta!");
        }
    
    return u;
    
    
 
    } 
}*/
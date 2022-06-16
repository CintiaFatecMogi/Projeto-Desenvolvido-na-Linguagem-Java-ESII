
package br.com.tenisclube.dal;

import interDAO.usuarioInterDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author debor
 */
public class UsuarioDAO extends javax.swing.JFrame {
    Connection conexao = null;
    
    ResultSet rs = null;
    
    public UsuarioDAO(){
        
        conexao = ModuloConexao.getConector();
        
    }

    public usuarioInterDAO cadastrar(usuarioInterDAO u ){
        
        String sql;
        sql = "insert into tbusuarios (usuario,fone,login,senha,perfil,cpf,endereco,bairro,email,cidade,rg,estado,cep,iduser)"
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            
           PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(14,u.getIdUser());
            pst.setString(1,u.getNome());
            pst.setString (2,u.getFone());
            pst.setString(3,u.getUsuario());
            pst.setString(4,u.getSenha());
            pst.setString(5,u.getPerfil());
            pst.setString (6,u.getCpf());
            pst.setString(7,u.getEndereco());
            pst.setString(8,u.getBairro());
            pst.setString(9,u.getEmail());
            pst.setString(10,u.getCidade());
            pst.setString (11,u.getRg());
            pst.setString(12,u.getEstado());
            pst.setString (13,u.getCep());
            //pst.setDate(15,u.getCadastro());
            int adicionado = pst.executeUpdate();
           
            if(adicionado>0){
                JOptionPane.showMessageDialog(null,"usuario adicionado com sucesso");
            return u;
            }
                       
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e + "cadastrar");
        }
        return u;
    }
            
    public void alterar (usuarioInterDAO u){
     
        String sql="update tbusuarios set usuario=?,fone=?,login=?,senha=?,perfil=?,cpf=?,endereco=?,bairro=?,email=?,cidade=?,rg=?,estado=?,cep=? where iduser=?";
    
      try{
           PreparedStatement pst = this.conexao.prepareStatement(sql);
            pst.setInt(14,u.getIdUser());
            pst.setString(1,u.getNome());
            pst.setString (2,u.getFone());
            pst.setString(3,u.getUsuario());
            pst.setString(4,u.getSenha());
            pst.setString(5,u.getPerfil());
            pst.setString (6,u.getCpf());
            pst.setString(7,u.getEndereco());
            pst.setString(8,u.getBairro());
            pst.setString(9,u.getEmail());
            pst.setString(10,u.getCidade());
            pst.setString (11,u.getRg());
            pst.setString(12,u.getEstado());
            pst.setString (13,u.getCep());
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Alterado com sucesso");
          
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e+"editar usuario");
        }
   
   }
    
    public usuarioInterDAO consultar(int iduser){
        
        usuarioInterDAO u = new usuarioInterDAO();
        String sql = "select * from tbusuarios where iduser=?";
        
         try{
           PreparedStatement pst = conexao.prepareStatement(sql);
           pst.setInt(1, iduser);
           ResultSet rs = pst.executeQuery();
           if(rs.next()){
            u.setIdUser(iduser);
            u.setNome(rs.getString(1)); 
            u.setFone(rs.getString (2));
            u.setUsuario(rs.getString(3));
            u.setSenha (rs.getString(4));
            u.setPerfil(rs.getString(5));
            u.setCpf(rs.getString (6));
            u.setEndereco(rs.getString(7));
            u.setBairro(rs.getString(8));
            u.setEmail(rs.getString(9));
            u.setCidade(rs.getString(10));
            u.setRg(rs.getString (11));
            u.setEstado(rs.getString(12));
            u.setCep(rs.getString (13));

            }else{
               JOptionPane.showMessageDialog(null,"usuario não cadastrado");
            }

              
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e);
         return null;
        }

      return u;
    }
        
    public void apagar(int iduser){
                
        String sql="delete from tbusuarios where iduser=?";
       int confirma = JOptionPane.showConfirmDialog(null," Tem certeza que deseja Excluir esse usuário?" ,"Atenção", JOptionPane.YES_NO_OPTION);
    if (confirma==JOptionPane.YES_OPTION){
            try{
               PreparedStatement pst = this.conexao.prepareStatement(sql);
               pst.setInt(1,iduser);
               pst.executeUpdate();
               pst.close();
               conexao.close();
              JOptionPane.showMessageDialog(null,"Usuário removido com sucesso");
              
            } catch (Exception e) {
              JOptionPane.showMessageDialog(null, e+ "erro ao excluir");
                    }

    }}
    
    public usuarioInterDAO login(String usuario , String senha){
       // Connection conexao = ModuloConexao.getConector();
        usuarioInterDAO u = new usuarioInterDAO();
        String sql="select * from tbusuarios where login = ? and senha = ? ";
        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1,usuario);
            pst.setString(2,senha);
            
            ResultSet rs = pst.executeQuery();
            rs.next();
            if(rs.getInt("IdUser") > 0){
               u.setIdUser(rs.getInt(14)); 
               u.setNome(rs.getString(1)); 
               u.setFone(rs.getString (2));
               u.setUsuario(rs.getString(3));
               u.setSenha (rs.getString(4));
               u.setPerfil(rs.getString(5));
               u.setCpf(rs.getString (6));
               u.setEndereco(rs.getString(7));
               u.setBairro(rs.getString(8));
               u.setEmail(rs.getString(9));
               u.setCidade(rs.getString(10));
               u.setRg(rs.getString (11));
               u.setEstado(rs.getString(12));
               u.setCep(rs.getString (13));
               //u.setCadastro(rs.getDate(15));
            }else{
                JOptionPane.showMessageDialog(null,"uUsuario ou senha incorreta!");
            }
            
                       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "aUsuario ou senha incorreta!");
        }



    return u;
    }

   
        
    }

   

    
  


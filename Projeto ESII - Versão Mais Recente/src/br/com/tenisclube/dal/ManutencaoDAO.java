package br.com.tenisclube.dal;

import interDAO.manutencaoInterDAO;
import br.com.tenisclube.telas.TelaManutencao;
import interDAO.usuarioInterDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import javax.swing.JOptionPane;

/**
 *
 * @author Cintia - Deborah - Isabela
 */
public class ManutencaoDAO extends javax.swing.JFrame {
    Connection conexao = null;
    
    ResultSet rs = null;
    
    public ManutencaoDAO(){
        
        conexao = ModuloConexao.getConector();
        
    }

    public manutencaoInterDAO cadastrar(manutencaoInterDAO mi ){
        
        //chama a conexao 
         //Connection conexao = ModuloConexao.getConector();
       //comando no banco
       
       String sql;
        sql = "insert into tbmanutencao (numeroQuadra, agendarPara, horario)"
                + "values (?,?,?)";
        try{
            
           PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1,mi.getNumeroQuadra());
            pst.setString (2,mi.getAgendarPara());
            pst.setString(3,mi.getHorario());
          
            //pst.setDate(15,u.getCadastro());
            int agendada = pst.executeUpdate();
           
            if(agendada>0){
                JOptionPane.showMessageDialog(null,"Manutenção agendada com sucesso");
            return mi;
            }
                       
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e + "cadastrar");
        }
        return mi;
    }
            
    public void alterar (manutencaoInterDAO mi){
     
        String sql="update tbmanutencao set numeroQuadra=?,agendarPara=?,horario=? where idManutencao=?";
    
      try{
           PreparedStatement pst = this.conexao.prepareStatement(sql);
            pst.setString(1,mi.getNumeroQuadra());
            pst.setString (2,mi.getAgendarPara());
            pst.setString (3,mi.getHorario());
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Manutenção alterada com sucesso");
          
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e+"Editar manutenção");
        }
   
   }
    
    public manutencaoInterDAO consultar(int idManutencao){
        
        manutencaoInterDAO mi = new manutencaoInterDAO();
        String sql = "select * from tbmanutencao where idManutencao=?";
        
         try{
           PreparedStatement pst = conexao.prepareStatement(sql);
           pst.setInt(1, idManutencao);
           ResultSet rs = pst.executeQuery();
           if(rs.next()){
            mi.setIdManutencao(idManutencao);
            mi.setNumeroQuadra(rs.getString(1)); 
            mi.setAgendarPara(rs.getString (2));
            mi.setHorario(rs.getString(3));
       

            }else{
               JOptionPane.showMessageDialog(null,"Manutenção não cadastrado");
            }

              
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e);
         return null;
        }

      return mi;
    }
        
    public void apagar(int idManutencao){
                
        String sql="delete from tbmanutencao where idManutencao=?";
       int confirma = JOptionPane.showConfirmDialog(null," Tem certeza que deseja Excluir esta manutenção?" ,"Atenção", JOptionPane.YES_NO_OPTION);
    if (confirma==JOptionPane.YES_OPTION){
            try{
               PreparedStatement pst = this.conexao.prepareStatement(sql);
               pst.setInt(1,idManutencao);
               pst.executeUpdate();
               pst.close();
               conexao.close();
              JOptionPane.showMessageDialog(null,"Manutencao removida com sucesso");
              
            } catch (Exception e) {
              JOptionPane.showMessageDialog(null, e+ "Erro ao excluir");
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

    public void setNumeroQuadra(String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setAgendarPara(String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setHorario(String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
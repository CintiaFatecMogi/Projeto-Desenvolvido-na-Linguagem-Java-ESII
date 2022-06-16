
package br.com.tenisclube.dal;

import interDAO.quadraInterDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

// @author debor
 public class QuadraDAO extends javax.swing.JFrame {
    Connection conexao = null;
    
    ResultSet rs = null;
    
    public QuadraDAO(){
        
        conexao = ModuloConexao.getConector();
    }

  
    public quadraInterDAO cadastrar(quadraInterDAO q){
        
        String sql;
        sql = "insert into tbquadras (idquad,nomequadra,preco,bancoquad,arquibancada,quadcoberta,tipoquad) values (?,?,?,?,?,?,?)";
        try{
           PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1,q.getIdquad());
            pst.setString(2,q.getNomequadra());
            pst.setString(3,q.getPreco());
            pst.setString(4,q.getBancoquad());
            pst.setString(5,q.getArquibancada());
            pst.setString(6,q.getQuadcoberta());
            pst.setString(7,q.getTipoquad());
            
            int adicionado = pst.executeUpdate();
            if (adicionado > 0){
          
            JOptionPane.showMessageDialog(null,"Adicionado com sucesso");
            return q;}
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e);
        }
    return q;
    }
    public void alterar (quadraInterDAO q){
        
        String sql="update tbquadras set nomequadra=?,preco=?,bancoquad=?,arquibancada=?,quadcoberta=?,tipoquad=? where idquad=?";
      try{
           PreparedStatement pst = this.conexao.prepareStatement(sql);
            pst.setInt(7,q.getIdquad());
            pst.setString(1,q.getNomequadra());
            pst.setString(2,q.getPreco());
            pst.setString(3,q.getBancoquad());
            pst.setString(4,q.getArquibancada());
            pst.setString(5,q.getQuadcoberta());
            pst.setString(6,q.getTipoquad());
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Alterado com sucesso");
            
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e+ "erro ao alterar");
        }
    }   
    public quadraInterDAO consultar(int idquad){
        
        quadraInterDAO q = new quadraInterDAO();
        String sql = "select * from tbquadras where idquad=?";
        
         try{
           PreparedStatement pst = conexao.prepareStatement(sql);
           pst.setInt(1,idquad);
           ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                q.setIdquad(idquad); 
                q.setNomequadra(rs.getString(2)); 
                q.setPreco(rs.getString(3));
                q.setBancoquad(rs.getString(4));
                q.setArquibancada(rs.getString(5));
                q.setQuadcoberta(rs.getString(6));
                q.setTipoquad(rs.getString(7));
          
            }else{
               JOptionPane.showMessageDialog(null,"Quadra não cadastrado");
           }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e+ "erro cadastro quadra");
         
         return null;
        }
    return q;
    }
    public void apagar(int idquad){
        
        String sql="delete from tbquadras where idquad=?";
        int confirma = JOptionPane.showConfirmDialog(null," Tem certeza que deseja Excluir essa quadra?" ,"Atenção", JOptionPane.YES_NO_OPTION);
            if (confirma==JOptionPane.YES_OPTION){
            try{
               PreparedStatement pst = this.conexao.prepareStatement(sql);
               pst.setInt(1,idquad);
               pst.executeUpdate();
               pst.close();
               conexao.close();
              
                JOptionPane.showMessageDialog(null,"Quadra removida com sucesso");
                

            } catch (Exception e) {
              JOptionPane.showMessageDialog(null, e+"erro ao excluir");
                    }
            
    }}
}
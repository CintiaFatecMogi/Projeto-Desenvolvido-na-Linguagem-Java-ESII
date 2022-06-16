package br.com.tenisclube.dal;
import java.sql.*;
/**
 *
 * @author Cintia - Deborah - Isabela
 */
public class ModuloConexao {
    //Metodo responsavel para estabelecer conexao com o banco de dados
    public static Connection getConector(){
        Connection conexao = null;
        
       
        // a linha abaixo chama o Drive
        String driver = "com.mysql.cj.jdbc.Driver";
        
        // armazenando informacoes referente ao banco
        String url = "jdbc:mysql://localhost:3306/dbclube";
        String user = "root" ;
        String password = "Palmeiras$14" ;
        
        // estabelecendo conexao com o banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,user,password);
            return conexao;
           }catch (Exception e) {
               //a linha abaixo serve para saber onde estou errando
               //System.out.println(e);
               return null;
           }
    }

    public static Connection conector() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

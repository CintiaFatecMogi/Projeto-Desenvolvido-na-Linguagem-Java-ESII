/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tenisclube.dal;
import java.sql.*;
/**
 *
 * @author debor
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
        String password = "21041998" ;
        
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
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interDAO;

import java.sql.Date;

/**
 *
 * @author debor
 */
public class usuarioInterDAO {

    
    
    private int idUser;
    private String usuario;
    private String senha;
    private String nome;
    private String endereco;
    private String cidade;
    private String cpf;
    private String cep;
    private String fone;
    private String perfil;
    private String bairro;
    private String rg;
    private String estado;
   
    private String email;
    
    public usuarioInterDAO() {
    
}

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String  getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String  getCep() {
        return cep;
    }

    public void setCep(String  cep) {
        this.cep = cep;
    }

    public String  getFone() {
        return fone;
    }

    public void setFone(String  fone) {
        this.fone = fone;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String  getRg() {
        return rg;
    }

    public void setRg(String  rg) {
        this.rg = rg;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

   
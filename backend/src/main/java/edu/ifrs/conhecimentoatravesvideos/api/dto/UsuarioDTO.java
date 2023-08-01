package edu.ifrs.conhecimentoatravesvideos.api.dto;

import java.sql.Timestamp;

public class UsuarioDTO extends EntidadeDTO {
    
    private String nome;

    private String senha;

    private boolean status;

    private String email;

    private String telefone;

    private Timestamp codigoRecuperacao;

    private Timestamp horarioRecuperacao;

    private Timestamp dataAssinaturaTermos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Timestamp getCodigoRecuperacao() {
        return codigoRecuperacao;
    }

    public void setCodigoRecuperacao(Timestamp codigoRecuperacao) {
        this.codigoRecuperacao = codigoRecuperacao;
    }

    public Timestamp getHorarioRecuperacao() {
        return horarioRecuperacao;
    }

    public void setHorarioRecuperacao(Timestamp horarioRecuperacao) {
        this.horarioRecuperacao = horarioRecuperacao;
    }

    public Timestamp getDataAssinaturaTermos() {
        return dataAssinaturaTermos;
    }

    public void setDataAssinaturaTermos(Timestamp dataAssinaturaTermos) {
        this.dataAssinaturaTermos = dataAssinaturaTermos;
    }

}

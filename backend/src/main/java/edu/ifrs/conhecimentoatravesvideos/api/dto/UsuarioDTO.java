package edu.ifrs.conhecimentoatravesvideos.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UsuarioDTO extends EntidadeDTO {
    
    @NotNull
    private String nome;
    
    @Size(min = 5, max = 255)
    @NotNull
    private String senha;

    @NotNull
    private boolean ativo;

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

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}

package edu.ifrs.conhecimentoatravesvideos.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Fonte extends Entidade {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Blob dados;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Blob getDados() {
        return this.dados;
    }

    public void setDados(Blob dados) {
        this.dados = dados;
    }
}

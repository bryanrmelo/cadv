package edu.ifrs.conhecimentoatravesvideos.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Video extends Entidade {

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private boolean privado;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "playlist_id", nullable = false)
    private Playlist playlist;

    @OneToOne
    @JoinColumn(name = "fonte_id", nullable = false)
    private Fonte fonte;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "verificacao_id")
    private Verificacao verificacao;

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isPrivado() {
        return this.privado;
    }

    public void setPrivado(boolean privado) {
        this.privado = privado;
    }

    public Usuario getAutor() {
        return this.autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Playlist getPlaylist() {
        return this.playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public Fonte getFonte() {
        return this.fonte;
    }

    public void setFonte(Fonte fonte) {
        this.fonte = fonte;
    }

    public Verificacao getVerificacao() {
        return this.verificacao;
    }

    public void setVerificacao(Verificacao verificacao) {
        this.verificacao = verificacao;
    }

    @Override
    public String toString() {
        return "{" +
                " titulo='" + getTitulo() + "'" +
                ", link='" + getLink() + "'" +
                ", categoria='" + getCategoria() + "'" +
                ", privado='" + isPrivado() + "'" +
                ", autor='" + getAutor() + "'" +
                ", playlist='" + getPlaylist() + "'" +
                ", fonte='" + getFonte() + "'" +
                ", verificacao='" + getVerificacao() + "'" +
                "}";
    }

}
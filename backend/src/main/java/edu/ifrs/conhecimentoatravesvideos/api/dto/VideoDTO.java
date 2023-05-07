package edu.ifrs.conhecimentoatravesvideos.api.dto;

import javax.persistence.Column;

public class VideoDTO extends EntidadeDTO {

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private boolean privado;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private Long playlist;

    @Column(nullable = false)
    private Long verificacao;

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

    public boolean getPrivado() {
        return this.privado;
    }

    public void setPrivado(boolean privado) {
        this.privado = privado;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Long getPlaylist() {
        return this.playlist;
    }

    public void setPlaylist(Long playlist) {
        this.playlist = playlist;
    }

    public Long getVerificacao() {
        return this.verificacao;
    }

    public void setVerificacao(Long verificacao) {
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
                "}";
    }

}

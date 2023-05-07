package edu.ifrs.conhecimentoatravesvideos.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.springframework.hateoas.server.core.Relation;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Relation(collectionRelation = "usuarios")
public class Usuario extends Entidade {

    @Column(nullable = false)
    private String nome;

    @JsonIgnore
    @Size(min = 5, max = 255)
    @Column(nullable = false)
    private String senha;

    @JsonIgnore
    @Column(nullable = false)
    private String hash;

    @Column(nullable = false)
    private boolean ativo;

    @JsonIgnore
    @OneToMany(mappedBy = "autor")
    private List<Video> videos;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Playlist> playlists;

    @JsonIgnore
    @OneToMany(mappedBy = "especialista")
    private List<Verificacao> verificacoes;

    public Usuario() {

    }

    public Usuario(String autor) {
        this.nome = autor;
    }

    public String getNome() {
        return nome;
    }

    public boolean getAtivo() {
        return this.ativo;
    }

    public List<Video> getVideos() {
        return this.videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
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

    public void encodeSenha(String senha, String hash) {
        // generateHash();
        this.senha = BCrypt.hashpw(senha, hash);
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = BCrypt.gensalt(hash);
    }

    public void generateHash() {
        this.hash = BCrypt.gensalt();

    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Playlist> getPlaylists() {
        return this.playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    public List<Verificacao> getVerificacoes() {
        return this.verificacoes;
    }

    public void setVerificacoes(List<Verificacao> verificacoes) {
        this.verificacoes = verificacoes;
    }

    @Override
    public String toString() {
        return "{" +
                " nome='" + getNome() + "'" +
                ", senha='" + getSenha() + "'" +
                ", ativo='" + isAtivo() + "'" +
                "}";
    }

}
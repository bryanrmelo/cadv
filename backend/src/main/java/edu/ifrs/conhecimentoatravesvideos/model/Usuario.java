package edu.ifrs.conhecimentoatravesvideos.model;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

import org.springframework.hateoas.server.core.Relation;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Relation(collectionRelation = "usuarios")
public class Usuario extends Entidade implements UserDetailsService {

    @Column(nullable = false)
    private String nome;

    @JsonIgnore
    @Size(min = 5, max = 255)
    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private boolean status;

    @Column(nullable = false)
    private String email;

    @Column
    private String telefone;

    @Column(name="codigorecuperacao")
    private Timestamp codigoRecuperacao;

    @Column(name="horariorecuperacao")
    private Timestamp horarioRecuperacao;

    @Column(name="dataassinaturatermos")
    private Timestamp dataAssinaturaTermos;

    public Usuario() {
    }

    public Usuario(String autor) {
        this.nome = autor;
    }

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ADMIN"));
    }

    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", senha='" + getSenha() + "'" +
            ", status='" + isStatus() + "'" +
            ", email='" + getEmail() + "'" +
            ", telefone='" + getTelefone() + "'" +
            ", codigoRecuperacao='" + getCodigoRecuperacao() + "'" +
            ", horarioRecuperacao='" + getHorarioRecuperacao() + "'" +
            ", dataAssinaturaTermos='" + getDataAssinaturaTermos() + "'" +
            "}";
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");
    }

}
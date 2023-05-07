package edu.ifrs.conhecimentoatravesvideos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Verificacao extends Entidade {

    @Column(nullable = false)
    private boolean verificado;

    @ManyToOne
    @JoinColumn(name = "especialista_id")
    private Usuario especialista;

    @OneToOne(mappedBy = "verificacao")
    private Video video;

    public Verificacao() {

    }

    public Verificacao(Long id) {
        this.setId(id);
    }

    public Verificacao(Video video) {
        this.video = video;
        this.verificado = false;
    }

    public Usuario getEspecialista() {
        return this.especialista;
    }

    public void setEspecialista(Usuario especialista) {
        this.especialista = especialista;
    }

    public Video getVideo() {
        return this.video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public boolean isVerificado() {
        return this.verificado;
    }

    public boolean getVerificado() {
        return this.verificado;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }

    @Override
    public String toString() {
        return "{" +
                " especialista='" + getEspecialista() + "'" +
                ", video='" + getVideo() + "'" +
                ", verificado='" + isVerificado() + "'" +
                "}";
    }

}

package edu.ifrs.conhecimentoatravesvideos.api.dto;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class FonteDTO extends EntidadeDTO {

    @Column(nullable = false)
    private Blob texto;

    public Blob getTexto() {
        return this.texto;
    }

    public void setTexto(Blob texto) {
        this.texto = texto;
    }
}

package edu.ifrs.conhecimentoatravesvideos.api.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.Id;
import org.springframework.hateoas.RepresentationModel;

import edu.ifrs.conhecimentoatravesvideos.model.Entidade;

@MappedSuperclass
public abstract class EntidadeDTO extends RepresentationModel<EntidadeDTO> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Entidade other = (Entidade) obj;
        if (id == null) {
            if (other.getId() != null)
                return false;
        } else if (!id.equals(other.getId()))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s [id=%d]", this.getClass().getName(), getId());
    }
    
}

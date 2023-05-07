package edu.ifrs.conhecimentoatravesvideos.repositorios;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ifrs.conhecimentoatravesvideos.model.Fonte;

@Repository
@Transactional
public interface FonteRepositorio extends JpaRepository<Fonte, Long> {
    
}

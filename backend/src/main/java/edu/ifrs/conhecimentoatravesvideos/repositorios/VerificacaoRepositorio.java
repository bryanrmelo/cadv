package edu.ifrs.conhecimentoatravesvideos.repositorios;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ifrs.conhecimentoatravesvideos.model.Verificacao;

@Repository
@Transactional
public interface VerificacaoRepositorio extends JpaRepository<Verificacao, Long> {

}
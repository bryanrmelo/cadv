package edu.ifrs.conhecimentoatravesvideos.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.ifrs.conhecimentoatravesvideos.model.Video;

@Repository
@Transactional
public interface VideoRepositorio extends JpaRepository<Video, Long> {

    @Query(value = "SELECT * FROM video WHERE titulo = ?1", nativeQuery = true)
    Optional<List<Video>> findByNome(String nome);

    @Query(value = "SELECT * FROM video WHERE id = ?1", nativeQuery = true)
    Optional<Video> buscarPorId(Long id);

    @Query(value = "SELECT * FROM video WHERE link = ?1", nativeQuery = true)
    Optional<Video> buscarPorLink(String link);

    // Pageable findAll(Pageable page);
}

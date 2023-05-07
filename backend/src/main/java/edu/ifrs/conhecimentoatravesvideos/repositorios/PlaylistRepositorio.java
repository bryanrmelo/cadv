package edu.ifrs.conhecimentoatravesvideos.repositorios;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.ifrs.conhecimentoatravesvideos.model.Playlist;
import edu.ifrs.conhecimentoatravesvideos.model.Usuario;

@Repository
@Transactional
public interface PlaylistRepositorio extends JpaRepository<Playlist, Long> {

    //Pageable findAll(Pageable page);

    @Query("SELECT p FROM Playlist p JOIN Usuario u ON p.usuario = u.id WHERE p.usuario = :id")
    List<Playlist> findPlaylistByUsuario(@Param("id") Usuario usuario);

    @Query(value = "SELECT * FROM playlist WHERE nome = ?1 AND usuario_id = ?2", nativeQuery = true)
    Playlist getByNome(String nome, long id);

    @Query(value = "SELECT * FROM playlist WHERE id = ?1", nativeQuery = true)
    Optional<Playlist> buscarPorId(Long id);
}

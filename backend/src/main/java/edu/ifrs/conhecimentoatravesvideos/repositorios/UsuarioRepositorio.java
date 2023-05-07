package edu.ifrs.conhecimentoatravesvideos.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.ifrs.conhecimentoatravesvideos.model.Usuario;

@Repository
@Transactional
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT u FROM Usuario u WHERE nome = ?1", nativeQuery = true)
    Optional<Usuario> findByNome(String nome);

    @Query(value = "SELECT count(*) FROM usuario WHERE nome = ?1 AND senha = ?2 AND ativo = true", nativeQuery = true)
    int exists(String nome, String senha);

    @Query(value = "SELECT * FROM usuario WHERE nome = ?1", nativeQuery = true)
    Usuario getByNomeUsuario(String nome);

}

package edu.ifrs.conhecimentoatravesvideos.servicos;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.ifrs.conhecimentoatravesvideos.model.Playlist;
import edu.ifrs.conhecimentoatravesvideos.model.Usuario;
import edu.ifrs.conhecimentoatravesvideos.repositorios.PlaylistRepositorio;

@Service
public class PlaylistServico {
    
    @Autowired
    private PlaylistRepositorio playlistRepositorio;

    public List<Playlist> buscarPorUsuario(Usuario usuario) {
        return playlistRepositorio.findPlaylistByUsuario(usuario);
    }

    public Page<Playlist> buscarTodos(Pageable paginacao) {
        return playlistRepositorio.findAll(paginacao);
    }

    public Playlist buscarPorId(Long id) {
        Optional<Playlist> p = playlistRepositorio.buscarPorId(id);

        try {
            return p.get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public Playlist buscarPorNome(String nome, long id) {
        Playlist p = playlistRepositorio.getByNome(nome, id);

        try {
            return p;
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}

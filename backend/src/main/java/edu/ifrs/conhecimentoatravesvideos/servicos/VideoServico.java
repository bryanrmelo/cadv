package edu.ifrs.conhecimentoatravesvideos.servicos;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.ifrs.conhecimentoatravesvideos.api.dto.VideoDTO;
import edu.ifrs.conhecimentoatravesvideos.api.mapeadores.VideoMapeador;
import edu.ifrs.conhecimentoatravesvideos.model.Verificacao;
import edu.ifrs.conhecimentoatravesvideos.model.Video;
import edu.ifrs.conhecimentoatravesvideos.repositorios.VideoRepositorio;

@Service
public class VideoServico {

    @Autowired
    private VideoRepositorio videoRepositorio;

    @Autowired
    private UsuarioServico usuarioServico;

    @Autowired
    private PlaylistServico playlistServico;

    @Autowired
    private VerificacaoServico verificacaoServico;

    @Autowired
    private VideoMapeador videoMapeador;

    public Video salvar(VideoDTO videoDTO) {

        Video video = videoMapeador.converterParaEntidade(videoDTO);

        video.setAutor(usuarioServico.buscarPorNome(video.getAutor().getNome()));
        video.setPlaylist(playlistServico.buscarPorId(video.getPlaylist().getId()));
        video.setVerificacao(new Verificacao(video));

        return videoRepositorio.save(video);
    }

    public List<Video> buscarVariosPorNome(String nome) {
        Optional<List<Video>> v = videoRepositorio.findByNome(nome);
        try {
            return v.get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public Page<Video> buscarTodos(Pageable paginacao) {
        return videoRepositorio.findAll(paginacao);
    }

    public Video buscarPorId(Long id) {
        Optional<Video> v = videoRepositorio.buscarPorId(id);
        try {
            return v.get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public Video buscarPorLink(String link) {
        Optional<Video> v = videoRepositorio.buscarPorLink(link);
        try {
            return v.get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public Video atualizar(VideoDTO videoDTO) {
        Video video = videoMapeador.converterParaEntidade(videoDTO);

        video.setAutor(usuarioServico.buscarPorNome(video.getAutor().getNome()));
        video.setPlaylist(playlistServico.buscarPorId(video.getPlaylist().getId()));

        return videoRepositorio.save(atualizarDadosVideo(video));
    }

    private Video atualizarDadosVideo(Video video) {
        Video videoDb = videoRepositorio.buscarPorLink(video.getLink()).get();

        videoDb.setTitulo(video.getTitulo());
        videoDb.setLink(video.getLink());
        videoDb.setCategoria(video.getCategoria());
        videoDb.setPrivado(video.isPrivado());
        videoDb.setPlaylist(video.getPlaylist());
        videoDb.setFonte(video.getFonte());
        videoDb.setVerificacao(video.getVerificacao());

        return videoDb;
    }

}

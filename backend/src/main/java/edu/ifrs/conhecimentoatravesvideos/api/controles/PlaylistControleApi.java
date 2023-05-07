package edu.ifrs.conhecimentoatravesvideos.api.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ifrs.conhecimentoatravesvideos.api.hateoas.PlaylistAssembler;
import edu.ifrs.conhecimentoatravesvideos.model.Playlist;
import edu.ifrs.conhecimentoatravesvideos.servicos.PlaylistServico;
import edu.ifrs.conhecimentoatravesvideos.servicos.UsuarioServico;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("api/v1/video/playlist")
public class PlaylistControleApi {
    
    @Autowired
    private UsuarioServico usuarioServico;

    @Autowired
    private PlaylistServico playlistServico;

    @Autowired
    private PlaylistAssembler playlistAssembler;

    @Autowired
    private PagedResourcesAssembler<Playlist> pagedResourcesAssembler;

    @GetMapping
	public PagedModel<EntityModel<Playlist>> buscarTodos(@PageableDefault(sort = {"id"}, direction = Direction.ASC) Pageable paginacao) {
		Page<Playlist> playlists = playlistServico.buscarTodos(paginacao);
        
        return pagedResourcesAssembler.toModel(playlists, playlistAssembler);
	}

    @GetMapping("/{id}")
    public CollectionModel<EntityModel<Playlist>> buscarPlaylistPorId(@PathVariable Long id) {
        List<Playlist> playlists = usuarioServico.buscarPorId(id).getPlaylists();

        return playlistAssembler.toCollectionModel(playlists);
    }

    public EntityModel<Playlist> buscarPorId(@PathVariable Long id) {
        Playlist playlist = playlistServico.buscarPorId(id);
        
        return playlistAssembler.toModel(playlist);
    }

}

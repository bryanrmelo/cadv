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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.ifrs.conhecimentoatravesvideos.api.dto.VideoDTO;
import edu.ifrs.conhecimentoatravesvideos.api.hateoas.VideoAssembler;
import edu.ifrs.conhecimentoatravesvideos.model.Video;
import edu.ifrs.conhecimentoatravesvideos.servicos.VideoServico;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("api/v1/video")
public class VideoControleApi {

    @Autowired
    private VideoServico videoServico;

    @Autowired
    private VideoAssembler videoAssembler;

    @Autowired
    private PagedResourcesAssembler<Video> pagedResourcesAssembler;

    @GetMapping()
    public CollectionModel<EntityModel<Video>> buscarTodos(
            @PageableDefault(sort = { "id" }, direction = Direction.ASC) Pageable paginacao) {
        Page<Video> videos = videoServico.buscarTodos(paginacao);
        //System.out.println(videos.getContent().get(0).getVerificacao().toString());
        return pagedResourcesAssembler.toModel(videos, videoAssembler);

    }

    @GetMapping(params = "link")
    public EntityModel<Video> buscarPorNome(@RequestParam("link") String link) {
        Video video = videoServico.buscarPorLink(link);

        return videoAssembler.toModel(video);
    }

    @GetMapping(params = "id")
    public EntityModel<Video> buscarPorId(@RequestParam("id") String idUrl) {
        Long id = new Long(idUrl);

        Video video = videoServico.buscarPorId(id);

        return videoAssembler.toModel(video);
    }

    @GetMapping(params = "search")
    public CollectionModel<EntityModel<Video>> buscarVariosPorNome(@RequestParam("search") String nome) {
        List<Video> videos = videoServico.buscarVariosPorNome(nome);

        return videoAssembler.toCollectionModel(videos);
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(code = HttpStatus.CREATED)
    public EntityModel<Video> salvar(@RequestBody VideoDTO videoDTO) {
        Video video = videoServico.salvar(videoDTO);

        return videoAssembler.toModel(video);
    }

    @GetMapping("/id")
    public EntityModel<Video> buscarPorId(Long id) {
        Video video = videoServico.buscarPorId(id);

        return videoAssembler.toModel(video);
    }

    @PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
    public EntityModel<Video> atualizar(@RequestBody VideoDTO videoDTO) {
        Video video = videoServico.salvar(videoDTO);

        return videoAssembler.toModel(video);
    }
}

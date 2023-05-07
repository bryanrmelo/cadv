package edu.ifrs.conhecimentoatravesvideos.api.hateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.stereotype.Component;

import edu.ifrs.conhecimentoatravesvideos.api.controles.PlaylistControleApi;
import edu.ifrs.conhecimentoatravesvideos.model.Playlist;

@Component
public class PlaylistAssembler implements SimpleRepresentationModelAssembler<Playlist> {

    @Override
    public void addLinks(EntityModel<Playlist> resource) {
        Long id = resource.getContent().getId();

        Link selfLink = linkTo(methodOn(PlaylistControleApi.class).buscarPlaylistPorId(id))
                .withSelfRel()
                .withType("GET");

        resource.add(selfLink);
        
    }

    @Override
    public void addLinks(CollectionModel<EntityModel<Playlist>> resources) {
        Link selfLink = linkTo(methodOn(PlaylistControleApi.class).buscarTodos(null))
                .withSelfRel()
                .withType("GET");

        resources.add(selfLink);
        
    }
    
}

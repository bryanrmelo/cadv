package edu.ifrs.conhecimentoatravesvideos.api.hateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.stereotype.Component;

import edu.ifrs.conhecimentoatravesvideos.api.controles.UsuarioControleApi;
import edu.ifrs.conhecimentoatravesvideos.model.Usuario;

@Component
public class UsuarioAssembler implements SimpleRepresentationModelAssembler<Usuario> {

    @Override
    public void addLinks(EntityModel<Usuario> resource) {
        Long id = resource.getContent().getId();

        Link selfLink = linkTo(methodOn(UsuarioControleApi.class).buscarPorId(id))
                .withSelfRel()
                .withType("GET");

        resource.add(selfLink);
    }

    @Override
    public void addLinks(CollectionModel<EntityModel<Usuario>> resources) {

        Link selfLink = linkTo(methodOn(UsuarioControleApi.class).buscarTodos(null))
                .withSelfRel()
                .withType("GET");

        resources.add(selfLink);

    }
}

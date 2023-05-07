package edu.ifrs.conhecimentoatravesvideos.api.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.ifrs.conhecimentoatravesvideos.api.hateoas.UsuarioAssembler;
import edu.ifrs.conhecimentoatravesvideos.model.Usuario;
import edu.ifrs.conhecimentoatravesvideos.servicos.UsuarioServico;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1")
public class UsuarioControleApi {

    @Autowired
    private UsuarioServico usuarioServico;

    @Autowired
    private UsuarioAssembler usuarioAssembler;

    @Autowired
    private PagedResourcesAssembler<Usuario> pagedResourcesAssembler;

    @GetMapping
    public CollectionModel<EntityModel<Usuario>> buscarTodos(
            @PageableDefault(sort = { "id" }, direction = Direction.ASC) Pageable paginacao) {
        Page<Usuario> usuarios = usuarioServico.buscarTodos(paginacao);

        return pagedResourcesAssembler.toModel(usuarios, usuarioAssembler);
    }

    @GetMapping(value = "/usuarios", params = "id")
    public EntityModel<Usuario> buscarPorId(@RequestParam Long id) {
        Usuario usuario = usuarioServico.buscarPorId(id);

        return usuarioAssembler.toModel(usuario);
    }

}
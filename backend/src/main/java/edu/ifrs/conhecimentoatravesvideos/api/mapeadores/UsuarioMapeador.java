package edu.ifrs.conhecimentoatravesvideos.api.mapeadores;

import org.springframework.stereotype.Component;

import edu.ifrs.conhecimentoatravesvideos.api.dto.UsuarioDTO;
import edu.ifrs.conhecimentoatravesvideos.model.Usuario;

@Component
public class UsuarioMapeador {

    public Usuario converterParaEntidade(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();

        usuario.setNome(usuarioDTO.getNome());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setAtivo(usuarioDTO.getAtivo());

        return usuario;
    }

}
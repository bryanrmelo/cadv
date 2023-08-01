package edu.ifrs.conhecimentoatravesvideos.servicos;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.ifrs.conhecimentoatravesvideos.Constants;
import edu.ifrs.conhecimentoatravesvideos.api.dto.UsuarioDTO;
import edu.ifrs.conhecimentoatravesvideos.api.mapeadores.UsuarioMapeador;
import edu.ifrs.conhecimentoatravesvideos.excecoes.LoginInvalidoException;
import edu.ifrs.conhecimentoatravesvideos.functions.Functions;
import edu.ifrs.conhecimentoatravesvideos.model.Usuario;
import edu.ifrs.conhecimentoatravesvideos.repositorios.UsuarioRepositorio;

@Service
public class LoginServico {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private UsuarioMapeador usuarioMapeador;

    public ResponseEntity<Usuario> validar(UsuarioDTO usuarioDTO) throws LoginInvalidoException {
        Usuario usuario = usuarioMapeador.converterParaEntidade(usuarioDTO);
        Usuario usuarioDb = usuarioRepositorio.getByNomeUsuario(usuario.getNome());
        
        usuario.setSenha(Functions.convertToMd5((usuario.getSenha() + Constants.SALT).toUpperCase()));
                 
        if (usuario.getSenha().equals(usuarioDb.getSenha())) {
            return new ResponseEntity<Usuario>(usuarioDb, HttpStatus.OK);
        } else {
            throw new LoginInvalidoException();
        }
        
    }

}

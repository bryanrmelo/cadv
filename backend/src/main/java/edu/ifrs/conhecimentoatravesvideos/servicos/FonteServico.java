package edu.ifrs.conhecimentoatravesvideos.servicos;

import org.springframework.beans.factory.annotation.Autowired;

import edu.ifrs.conhecimentoatravesvideos.api.dto.FonteDTO;
import edu.ifrs.conhecimentoatravesvideos.api.mapeadores.FonteMapeador;
import edu.ifrs.conhecimentoatravesvideos.repositorios.FonteRepositorio;

public class FonteServico {

    @Autowired
    private FonteRepositorio fonteRepositorio;

    @Autowired
    private FonteMapeador fonteMapeador;

    public void salvarFonte(FonteDTO fonteDTO) {

    }
    
}

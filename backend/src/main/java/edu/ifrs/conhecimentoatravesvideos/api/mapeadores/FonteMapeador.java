package edu.ifrs.conhecimentoatravesvideos.api.mapeadores;

import org.springframework.stereotype.Component;

import edu.ifrs.conhecimentoatravesvideos.api.dto.FonteDTO;
import edu.ifrs.conhecimentoatravesvideos.model.Fonte;

@Component
public class FonteMapeador {
    public Fonte converterParaEntidade(FonteDTO fonteDTO) {
        Fonte fonte = new Fonte();

        fonte.setDados(fonteDTO.getTexto());

        return fonte;
    }
}

package edu.ifrs.conhecimentoatravesvideos.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifrs.conhecimentoatravesvideos.model.Verificacao;
import edu.ifrs.conhecimentoatravesvideos.repositorios.VerificacaoRepositorio;

@Service
public class VerificacaoServico {

    @Autowired
    private VerificacaoRepositorio verificacaoRepositorio;

    public Verificacao salvar(Verificacao verificacao) {
        try {
            return verificacaoRepositorio.save(verificacao);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

}
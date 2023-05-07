package edu.ifrs.conhecimentoatravesvideos.api.controles;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.ifrs.conhecimentoatravesvideos.excecoes.FonteInvalidaException;
import edu.ifrs.conhecimentoatravesvideos.servicos.FonteServico;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/fonte")
public class FonteControleApi {
    
    
    private FonteServico fonteServico;

    @PostMapping
    @ResponseBody
    public void salvarFonte(@RequestParam("file") MultipartFile file) throws FonteInvalidaException {
        //fonteServico.salvarFonte(fonteDTO);
        System.out.println(file.getOriginalFilename());
        System.out.println("ok");

    }
}

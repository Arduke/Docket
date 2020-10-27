package com.dockettest.docket.Controller;

import com.dockettest.docket.Model.Certidao;
import com.dockettest.docket.repository.CertidaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class CertidaoController {
    
    @Autowired
    CertidaoRepository certidaoRepositorio;


    @GetMapping("/listarCertidoes/{id}")
    public String pageListarCertidoes(Model model,  @PathVariable(name="id") Long id, Certidao certidao) {
        //Pensando em como pegar o resultado do findall e retirar somente os dados com id semelhante ao parametro.        
        certidaoRepositorio.findAll()
        
        model.addAttribute("certidoes", )
        return "listCertidoes";
    }
    
}

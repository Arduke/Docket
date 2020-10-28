package com.dockettest.docket.Controller;

import java.util.ArrayList;
import java.util.List;

import com.dockettest.docket.Model.Certidao;
import com.dockettest.docket.repository.CartorioRepository;
import com.dockettest.docket.repository.CertidaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CertidaoController {
    
    @Autowired
    CertidaoRepository certidaoRepositorio; 
    @Autowired   
    CartorioRepository cartorioRepositorio;

    
    private Long idCartorio = (long) 1;
   
    //Tela para listar certidões
    @GetMapping("/listarCertidoes/{id}")
    public String pageListarCertidoes(Model model,  @PathVariable(name="id") Long id) {       
        List<Certidao> listaDeCertidoesDoCartorio = new ArrayList<Certidao>();
        if (id != null) {
        idCartorio = id;
        }
        certidaoRepositorio.findAll().forEach(certidaoRepo -> {
            if ( certidaoRepo.getCartorio_id() == idCartorio){
                listaDeCertidoesDoCartorio.add(certidaoRepo);
            }
        });
        
        model.addAttribute("idCartorio", id);
        model.addAttribute("certidoes", listaDeCertidoesDoCartorio );
        return "listCertidoes";
    }
    //Tela para criar certidões
    @RequestMapping("/criarCertidao")
    public String pageCriarCartorio(Model model, Certidao certidao){
        
        model.addAttribute("idCartorio", idCartorio);
        model.addAttribute("certidao", new Certidao());
        return "createCertidao";
    }

    //Tela para editar certidão
    @GetMapping("/editarCertidao/{id}")
    public String editarCertidao(Model model, @PathVariable(name="id") Long id){
        Certidao certidaoParaEditar = certidaoRepositorio.findById(id).get();
                
        model.addAttribute("certidao", certidaoParaEditar);
        return "editCertidao";
    }  

    //Métodos para requisitar dados no H2BD

    
    //Método Post para criar certidão
    @PostMapping("/criarCertidao")
    public String metodoCriarCertidao(Model model, Certidao certidao){
        certidao.setCartorio_id(idCartorio);
        
        certidaoRepositorio.save(certidao);        
         
        model.addAttribute("certidao", new Certidao());
        model.addAttribute("cartorios", cartorioRepositorio.findAll() );
        return "index";
    }

    //Método para deletar certidão
    //Obs: Não consegui retornar para a lista de certidões com dados.
    @GetMapping("/deletarCertidao/{id}")
    public String deletarCertidao(Model model, @PathVariable(name="id") Long id) {
        Certidao CertidaoParaDeletar = certidaoRepositorio.findById(id).get();
        
        certidaoRepositorio.deleteById(CertidaoParaDeletar.getId());
        model.addAttribute("cartorios", cartorioRepositorio.findAll());
        return "index";
    }


    
    
}

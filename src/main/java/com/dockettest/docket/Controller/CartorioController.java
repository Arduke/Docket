package com.dockettest.docket.Controller;

import java.util.List;

import com.dockettest.docket.Model.Cartorio;
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
public class CartorioController {

    @Autowired
    CartorioRepository cartorioRepositorio;

    @Autowired
    CertidaoRepository certidaoRepositorio;
    //Request para as telas

    //Tela para criar cartório
    @RequestMapping("/criarCartorio")
    public String pageCriarCartorio(Model model, Cartorio cartorio){
        model.addAttribute("cartorio", new Cartorio());
        return "createCartorio";
    }
    //Tela inicial apresentando a lista de cartórios
    @GetMapping
    public String index(Model model) {
        model.addAttribute("cartorios", cartorioRepositorio.findAll() );
        return "index";
    }  
    //Tela para editar cartório selecionado
    @GetMapping("/editarCartorio/{id}")
    public String editarCartorio(Model model, @PathVariable(name="id") Long id){
        
        Cartorio cartorioParaEditar = cartorioRepositorio.findById(id).get();
        
        
        model.addAttribute("cartorio", cartorioParaEditar);
        model.addAttribute("cartorios", cartorioRepositorio.findAll());
        return "editCartorio";
    }    
    
    //Request para alterar banco de dados

    //Criar e editar cartório no banco de dados    
    //Nota: ainda preciso descobrir como retornar um endereço "/"
    @PostMapping("/criarCartorio")
    public String metodoCriarCartorio(Model model, Cartorio cartorio){
        cartorioRepositorio.save(cartorio);        
        
        model.addAttribute("cartorio", new Cartorio());
        model.addAttribute("cartorios", cartorioRepositorio.findAll() );
        return "index";
    }
    
    //Deletar cartório no banco de dados
    //Nota: ainda preciso descobrir como retornar um endereço "/"
    @GetMapping("/deletarCartorio/{id}")
    public String deletarCartorio(Model model, @PathVariable(name="id") Long id) {
        Cartorio cartorioParaDeletar = cartorioRepositorio.findById(id).get();
        
        cartorioRepositorio.deleteById(cartorioParaDeletar.getId());
        model.addAttribute("cartorios", cartorioRepositorio.findAll());
        return "index";
    }
}

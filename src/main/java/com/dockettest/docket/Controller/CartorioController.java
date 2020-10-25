package com.dockettest.docket.Controller;

import com.dockettest.docket.entity.Cartorio;
import com.dockettest.docket.repository.CartorioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartorioController {

    @Autowired
    CartorioRepository cartorioRepositorio;

    @GetMapping
    public String index(Model model, Cartorio cartorio) {
        model.addAttribute("cartorio", new Cartorio());
        model.addAttribute("cartorios", cartorioRepositorio.findAll() );
        return "index";
    }

    @PostMapping("/criarCartorio")
    public String criarCartorio(Model model, Cartorio cartorio){
        cartorioRepositorio.save(cartorio);        
        
        model.addAttribute("cartorio", new Cartorio());
        model.addAttribute("cartorios", cartorioRepositorio.findAll() );
        return "index";
    }
    @GetMapping("/editarCartorio/{id}")
    public String editarCartorio(Model model, @PathVariable(name="id") Long id){
        Cartorio cartorioParaEditar = cartorioRepositorio.findById(id).get();
        
        
        model.addAttribute("cartorio", cartorioParaEditar);
        model.addAttribute("cartorios", cartorioRepositorio.findAll());
        return "index";
    }


    @GetMapping("/deletarCartorio/{id}")
    public String deletarCartorio(Model model, @PathVariable(name="id") Long id) {
        Cartorio cartorioParaDeletar = cartorioRepositorio.findById(id).get();
        
        cartorioRepositorio.deleteById(cartorioParaDeletar.getId());
        model.addAttribute("cartorio", new Cartorio());
        model.addAttribute("cartorios", cartorioRepositorio.findAll());
        return "index";
    }
}

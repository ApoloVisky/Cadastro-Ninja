package dev.java10x.cadastrodeninjas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NinjaController {


    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Esse é minha primeira mensagem utilizando as rotas";
    }
}

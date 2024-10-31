package dev.java10x.cadastrodeninjas.Missoes;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {


    // GET - Manda uma requisição para listar as missoes
    @GetMapping("/listar")
    public String listarMissoes(){
        return "Missões listadas com sucesso";
    }

    // POST - Manda uma requisição para criar as missoes
    @PostMapping("/criar")
    public String criarMissao(){
        return "Missão criada com sucesso!";
    }

    // PUT - Manda uma requisição para alterar as missoes
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missão alterada com sucesso!";
    }

    // DELETE - Manda uma requisição para deletar as missoes
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missão deletada com sucesso!";
    }
}

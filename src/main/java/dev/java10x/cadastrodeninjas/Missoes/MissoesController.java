package dev.java10x.cadastrodeninjas.Missoes;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // GET - Manda uma requisição para listar as missoes
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes(){
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public  MissoesModel listarMissoesPorID(@PathVariable Long id) {
        return missoesService.listarMissoesPorID(id);
    }

    // POST - Manda uma requisição para criar as missoes
    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missoesModel){
        return missoesService.criarMissoes(missoesModel);
    }

    // PUT - Manda uma requisição para alterar as missoes
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missão alterada com sucesso!";
    }

    // DELETE - Manda uma requisição para deletar as missoes
    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id){
        missoesService.deletarNinja(id);
    }
}

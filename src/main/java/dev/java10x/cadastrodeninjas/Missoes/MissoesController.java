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
    public List<MissoesDTO> listarMissoes(){
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public  MissoesDTO listarMissoesPorID(@PathVariable Long id) {
        return missoesService.listarMissoesPorID(id);
    }

    // POST - Manda uma requisição para criar as missoes
    @PostMapping("/criar")
    public MissoesDTO criarMissao(@RequestBody MissoesDTO missoesDTO){
        return missoesService.criarMissoes(missoesDTO);
    }

    // PUT - Manda uma requisição para alterar as missoes
    @PutMapping("/alterar/{id}")
    public MissoesDTO alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missoesDTO){
        return missoesService.alterarMissoes(id, missoesDTO);
    }

    // DELETE - Manda uma requisição para deletar as missoes
    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id){
        missoesService.deletarMissoes(id);
    }
}

package dev.java10x.cadastrodeninjas.Missoes;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public List<MissoesDTO> listarMissoes(){
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public  MissoesDTO listarMissoesPorID(@PathVariable Long id) {
        return missoesService.listarMissoesPorID(id);
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missoesDTO){
        MissoesDTO missoesNovas = missoesService.criarMissoes(missoesDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso: " + missoesNovas.getNome() + " (ID) " + missoesNovas.getId());
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missoesDTO){
        if(missoesService.listarMissoesPorID(id) != null) {
            MissoesDTO missoes = missoesService.alterarMissoes(id, missoesDTO);

            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body("Missão com o ID " + id + " alterado com sucesso para " + missoesDTO.getNome());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Não foi possível alterar a missão com o ID " + id + " pois esse ID não existe");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id){
        if(missoesService.listarMissoesPorID(id) != null){
            missoesService.listarMissoesPorID(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Missão com o ID " + id + " deletada com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Não foi possível excluir a missão com o ID "+ id + " pois ela não existe");
    }
}

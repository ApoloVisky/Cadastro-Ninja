package dev.java10x.cadastrodeninjas.Missoes;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/listar/{id}")
    public  ResponseEntity<?> listarMissoesPorID(@PathVariable Long id) {
        MissoesDTO missoes = missoesService.listarMissoesPorID(id);

        if (missoes != null) {
            return ResponseEntity.ok(missoes);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Missão com o ID "+ id + " não localizada em nossos registros;");
    }

    @PostMapping("/criar")
    public ResponseEntity<MissoesDTO> criarMissao(@RequestBody MissoesDTO missoesDTO){
        MissoesDTO missoesNovas = missoesService.criarMissoes(missoesDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(missoesNovas);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missoesDTO){
        if(missoesService.listarMissoesPorID(id) != null) {
            MissoesDTO missoes = missoesService.alterarMissoes(id, missoesDTO);

            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(missoes);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Missão com o ID "+ id + " não localizada em nossos registros;");

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id){
        if(missoesService.listarMissoesPorID(id) != null){
            missoesService.deletarMissoes(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Missão com o ID " + id + " deletada com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Não foi possível excluir a missão com o ID "+ id + " pois ela não existe");
    }
}

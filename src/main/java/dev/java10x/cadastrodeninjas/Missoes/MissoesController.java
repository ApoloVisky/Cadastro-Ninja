package dev.java10x.cadastrodeninjas.Missoes;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Lista as missões", description = "Lista todas as missões presentes no banco de dados")
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }


    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista a missão pelo ID", description = "Lista a missão filtrando pelo seu ID")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão Listado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Erro na listagem da missão!")
    })
    public  ResponseEntity<?> listarMissoesPorID(
            @Parameter(description = "Usuário passa o id da missão no caminho da requisição")
            @PathVariable Long id) {
        MissoesDTO missoes = missoesService.listarMissoesPorID(id);

        if (missoes != null) {
            return ResponseEntity.ok(missoes);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Missão com o ID "+ id + " não localizada em nossos registros;");
    }

    @PostMapping("/criar")
    @Operation(summary = "Lista a missão pelo ID", description = "Lista a missão filtrando pelo seu ID")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão Listado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Erro na listagem da missão!")
    })
    public ResponseEntity<MissoesDTO> criarMissao(@RequestBody MissoesDTO missoesDTO){
        MissoesDTO missoesNovas = missoesService.criarMissoes(missoesDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(missoesNovas);
    }



    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera a missão", description = "Altera a missão filtrada pelo seu ID")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão Listado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Erro na listagem da missão!")
    })
    public ResponseEntity<?> alterarMissao(
            @Parameter(description = "Usuário passa o id da missão no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuário manda os dados da missão a ser atualizado no corpo da requisição")
            @RequestBody MissoesDTO missoesDTO){
        if(missoesService.listarMissoesPorID(id) != null) {
            MissoesDTO missoes = missoesService.alterarMissoes(id, missoesDTO);

            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(missoes);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Missão com o ID "+ id + " não localizada em nossos registros;");

    }



    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deletar missão", description = "Deleta a missão seleciada pelo ID")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "MIssão deletada com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Não localizado a missão com o ID informado")
    })
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

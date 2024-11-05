package dev.java10x.cadastrodeninjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota da uma mensagem de boas vindas para quem acessa ela")
    public String boasVindas(){
        return "Esse é minha primeira mensagem utilizando as rotas";
    }


    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Cria um novo ninja e insere no banco de dados")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja!")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " ID: " + novoNinja.getId());
    }


    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista o ninja pelo ID", description = "Lista o ninja filtrando pelo seu ID")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja Listado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Erro na listagem do ninja!")
    })
    public ResponseEntity<?> listarNinjaPorId(
            @Parameter(description = "Usuário passa o id do ninja no caminho da requisição")
            @PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);
        if(ninja!= null) {
          return ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com o ID "+ id + " não existe em nossos regitros!");
    }



    @GetMapping("/listar")
    @Operation(summary = "Lista todos os ninjas", description = "Lista todos os ninjas do banco de dados")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninjas listados com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Erro na listagem dos ninjas!")
    })
    public ResponseEntity<List<NinjaDTO>> mostrarTodosOsNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.status(HttpStatus.OK)
                .body(ninjas);
    }




    @PatchMapping("/alterar/{id}")
    @Operation(summary = "Alterar ninjas", description = "Altera um ninja já criado. É preciso passar o ID do ninja e o Body da requisição")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninjas Alterado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Não localizado ninja com o ID informado")
    })
    public ResponseEntity<?> alterarNinja(
            @Parameter(description = "Usuário manda o id no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuário manda os dados do ninja a ser atualizado no corpo da requisição")
            @RequestBody NinjaDTO ninjaDTO ){

        ninjaService.alterarNinja(id, ninjaDTO);

        if (ninjaDTO != null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(ninjaDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com o ID "+ id + " não existe em nossos regitros!");
    }



    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deletar ninjas", description = "Deleleta o ninja seleciado pelo ID")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninjas deletado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Não localizado ninja com o ID informado")
    })
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
        if (ninjaService.listarNinjaPorId(id) != null){
            ninjaService.deletarNinjaPoriD(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Ninja com ID " + id + " deletado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Não foi possível excluir o ninja com o ID "+ id + " pois ele não existe");
    }
}

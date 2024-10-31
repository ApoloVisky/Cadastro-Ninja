package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Esse é minha primeira mensagem utilizando as rotas";
    }


    // Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado com sucesso";
    }

    // Procurar Ninja por ID (READ)
    @GetMapping("/listarID")
    public String procurarNinjaPorId(){
        return "Ninja encontrado";
    }

    // Mostrar todos os Ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> mostrarTodosOsNinjas(){
        return ninjaService.listarNinjas();
    }

    // Alterar dados do ninja (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorID(){
        return "Ninja alterado com sucesso";
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return "Ninja deletado por ID";
    }
}

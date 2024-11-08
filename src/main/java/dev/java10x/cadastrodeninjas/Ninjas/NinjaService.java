package dev.java10x.cadastrodeninjas.Ninjas;



import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();

        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    public NinjaDTO listarNinjaPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);

        return ninjaPorId.map(ninjaMapper::map).orElse(null);

    }

   public void deletarNinjaPoriD(Long id) {
        ninjaRepository.deleteById(id);
   }

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    public void alterarNinja(Long id, NinjaDTO ninjaDTO) {
      NinjaModel ninjaExistente = ninjaRepository.findById(id)
              .orElseThrow(() -> new OpenApiResourceNotFoundException("Ninja com o ID" + id + " não encontrado"));
     ninjaMapper.updateNinjaFromDto(ninjaDTO, ninjaExistente);

      ninjaRepository.save(ninjaExistente);

        ninjaMapper.map(ninjaExistente);
    }
}

package dev.java10x.cadastrodeninjas.Missoes;

import dev.java10x.cadastrodeninjas.Ninjas.NinjaDTO;
import dev.java10x.cadastrodeninjas.Ninjas.NinjaMapper;
import dev.java10x.cadastrodeninjas.Ninjas.NinjaModel;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;


    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public MissoesDTO criarMissoes(MissoesDTO missoesDTO) {
        MissoesModel missoes = missoesMapper.map(missoesDTO);
        missoes = missoesRepository.save(missoes);
        return missoesMapper.map(missoes);

    }

    public List<MissoesDTO> listarMissoes() {
       List<MissoesModel> missoes = missoesRepository.findAll();

       return missoes.stream()
               .map(missoesMapper::map)
               .collect(Collectors.toList());
    }

    public MissoesDTO listarMissoesPorID(Long id) {
        Optional<MissoesModel> missoesPoriD = missoesRepository.findById(id);

        return missoesPoriD.map(missoesMapper::map).orElse(null);

    }

    public void deletarMissoes(Long id) {
        missoesRepository.deleteById(id);
    }

    public MissoesDTO alterarMissoes(Long id, MissoesDTO missoesDTO) {
        MissoesModel missoes = missoesRepository.findById(id)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Ninja com o ID" + id + " não encontrado"));

        missoesMapper.updateMissiomFromDto(missoesDTO, missoes);
        missoesRepository.save(missoes);

        return missoesMapper.map(missoes);
    }
}

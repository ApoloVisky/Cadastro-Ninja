package dev.java10x.cadastrodeninjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public MissoesModel criarMissoes(MissoesModel missoesModel) {
        return missoesRepository.save(missoesModel);
    }

    public List<MissoesModel> listarMissoes() {
        return  missoesRepository.findAll();
    }

    public MissoesModel listarMissoesPorID(Long id) {
        Optional<MissoesModel> ninjaPorId = missoesRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    public void deletarMissoes(Long id) {
        missoesRepository.deleteById(id);
    }

    public MissoesModel alterarMissoes(Long id, MissoesModel missoesAtualizadas) {
        if (missoesRepository.existsById(id)){
            missoesAtualizadas.setId(id);
            missoesRepository.save(missoesAtualizadas);

        }
        return null;
    }
}

package dev.java10x.cadastrodeninjas.Ninjas;


import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    public NinjaModel listarNinjaPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    public NinjaModel deletarNinjaPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        ninjaPorId.ifPresent(ninjaModel -> ninjaRepository.findById(id));
        return ninjaPorId.orElse(null);
    }

    public NinjaModel adicionarNinjas(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }
}

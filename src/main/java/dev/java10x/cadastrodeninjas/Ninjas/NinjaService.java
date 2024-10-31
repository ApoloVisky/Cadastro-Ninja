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

    public Optional<NinjaModel> listarNinjaPorId(Long id) {
        return ninjaRepository.findById(id);
    }
}

package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map (NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = new NinjaModel();

        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setImgURL(ninjaDTO.getImgURL());
        ninjaModel.setRank(ninjaDTO.getRank());
        ninjaModel.setMissoes(ninjaDTO.getMissoes());

        return ninjaModel;
    }

    public NinjaDTO map (NinjaModel ninjaModel) {
        NinjaDTO ninjaDTO = new NinjaDTO();

        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setImgURL(ninjaModel.getImgURL());
        ninjaDTO.setRank(ninjaModel.getRank());
        ninjaDTO.setMissoes(ninjaModel.getMissoes());

        return ninjaDTO;
    }

    public void updateNinjaFromDto(NinjaDTO ninjaDTO, NinjaModel ninjaModel) {
        if (ninjaDTO.getNome() != null) {
            ninjaModel.setNome(ninjaDTO.getNome());
        }
        if (ninjaDTO.getIdade() != null) {
            ninjaModel.setIdade(ninjaDTO.getIdade());
        }
        if (ninjaDTO.getEmail() != null) {
            ninjaModel.setEmail(ninjaDTO.getEmail());
        }
        if (ninjaDTO.getImgURL() != null) {
            ninjaModel.setImgURL(ninjaDTO.getImgURL());
        }
        if (ninjaDTO.getRank() != null) {
            ninjaModel.setRank(ninjaDTO.getRank());
        }
        if (ninjaDTO.getMissoes() != null) {
            ninjaModel.setMissoes(ninjaDTO.getMissoes());
        }
    }
}

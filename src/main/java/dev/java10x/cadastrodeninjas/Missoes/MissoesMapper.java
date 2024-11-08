package dev.java10x.cadastrodeninjas.Missoes;


import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesDTO map ( MissoesModel missoesModel) {
        MissoesDTO missoesDTO = new MissoesDTO();

        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNome(missoesModel.getNome());
        missoesDTO.setDificuldade(missoesModel.getDificuldade());
        missoesDTO.setNinja(missoesModel.getNinja());


        return missoesDTO;
    }

    public MissoesModel map (MissoesDTO missoesDTO) {
        MissoesModel missoesModel = new MissoesModel();

        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNome(missoesDTO.getNome());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());
        missoesModel.setNinja(missoesDTO.getNinja());

        return missoesModel;
    }

    public void updateMissiomFromDto(MissoesDTO missoesDTO, MissoesModel missoes) {

        if (missoesDTO.getNome() != null) {
            missoes.setNome(missoesDTO.getNome());
        }
        if (missoesDTO.getDificuldade() != null) {
            missoes.setDificuldade(missoesDTO.getDificuldade());
        }
        if (missoesDTO.getNinja() != null) {
            missoes.setNinja(missoesDTO.getNinja());
        }
    }

}

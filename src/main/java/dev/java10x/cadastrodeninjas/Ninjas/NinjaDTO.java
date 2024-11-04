package dev.java10x.cadastrodeninjas.Ninjas;

import dev.java10x.cadastrodeninjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaDTO {


    private Long id;
    private String nome;
    private String email;
    private String imgURL;
    private int idade;
    private String rank;
    private MissoesModel missoes;


}

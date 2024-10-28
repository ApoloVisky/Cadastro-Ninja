package dev.java10x.cadastrodeninjas.Missoes.Model;

import dev.java10x.cadastrodeninjas.Ninjas.controller.model.NinjaModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name="tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;


    @OneToMany(mappedBy = "missoes") // @OneToMany  uma missao tem varios ninjas
    private List<NinjaModel> ninja;

}




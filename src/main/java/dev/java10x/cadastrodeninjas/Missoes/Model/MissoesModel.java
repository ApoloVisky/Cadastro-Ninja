package dev.java10x.cadastrodeninjas.Missoes.Model;

import dev.java10x.cadastrodeninjas.Ninjas.controller.model.NinjaModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;


    @OneToMany(mappedBy = "missoes") // @OneToMany  uma missao tem varios ninjas
    private List<NinjaModel> ninja;




    public MissoesModel() {
    }

    public MissoesModel(Long id, String nome, String dificuldade) {
        this.id = id;
        this.nome = nome;
        this.dificuldade = dificuldade;
    }
}

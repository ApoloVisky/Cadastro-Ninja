package dev.java10x.cadastrodeninjas.Ninjas.controller.model;


import dev.java10x.cadastrodeninjas.Missoes.Model.MissoesModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="tb_cadastro")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;

    @ManyToOne // @ManyToOne  um ninja tem uma unica missao
    @JoinColumn(name = "missoes_id") //ForeignKey que faz a ligação entre as tabelas Ninja e Missoes pelo id da missao
    private MissoesModel missoes;

    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }


}

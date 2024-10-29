package dev.java10x.cadastrodeninjas.Missoes.Repository;

import dev.java10x.cadastrodeninjas.Missoes.Model.MissoesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {
}

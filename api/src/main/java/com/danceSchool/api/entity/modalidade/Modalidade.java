package com.danceSchool.api.entity.modalidade;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="modalidade")
public class Modalidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Size(max = 100)
    @Column(name="nome", length = 100)
    private String nome;

    Modalidade(DataModalidade dataModalidade) {
        this(dataModalidade.id(), dataModalidade.nome());
    }
}

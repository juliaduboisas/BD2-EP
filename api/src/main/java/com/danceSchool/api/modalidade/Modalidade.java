package com.danceSchool.api.modalidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name="id")
    private Integer id;

    @Size(max = 100)
    @Column(name="nome", length = 100)
    private String nome;

}

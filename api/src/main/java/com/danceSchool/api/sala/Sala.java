package com.danceSchool.api.sala;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="sala")
public class Sala {
    @Id
    @Column(name="numero")
    private Integer numero;

    @Column(name="title")
    private String title;

    @Column(name="capacidade")
    private Integer capacidade;

    public Sala(DataSala dataSala) {
        this.numero = dataSala.numero();
        this.title = dataSala.title();
        this.capacidade = dataSala.capacidade();
    }
}

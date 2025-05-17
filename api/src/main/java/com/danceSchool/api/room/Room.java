package com.danceSchool.api.room;

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
public class Room {
    @Id
    @Column(name="numero")
    private Integer numero;

    @Column(name="title")
    private String title;

    @Column(name="capacidade")
    private Integer capacidade;

    public Room(DataRoom dataRoom) {
        this.numero = dataRoom.numero();
        this.title = dataRoom.title();
        this.capacidade = dataRoom.capacidade();
    }
}

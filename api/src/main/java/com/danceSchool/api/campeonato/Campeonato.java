package com.danceSchool.api.campeonato;

import com.danceSchool.api.sala.Sala;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "campeonato")
public class Campeonato {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "data")
    private Instant data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sala")
    private Sala sala;

    @Column(name = "categoria", length = Integer.MAX_VALUE)
    private String categoria;

    @Column(name = "premiacao", length = Integer.MAX_VALUE)
    private String premiacao;

    @Column(name = "valor_premiacao")
    private Double valorPremiacao;

    @Column(name = "status", length = Integer.MAX_VALUE)
    private String status;

}
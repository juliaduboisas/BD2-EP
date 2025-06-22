package com.danceSchool.api.entity.campeonato;

import com.danceSchool.api.entity.sala.Sala;
import com.danceSchool.api.enums.Nivel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "campeonato")
public class Campeonato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "data")
    private Date data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sala")
    private Sala sala;

    @Column(name = "categoria", length = Integer.MAX_VALUE)
    private Nivel categoria;

    @Column(name = "premiacao", length = Integer.MAX_VALUE)
    private String premiacao;

    @Column(name = "valor_premiacao")
    private Double valorPremiacao;

    @Column(name = "status", length = Integer.MAX_VALUE)
    private String status;

    public Campeonato(DataCampeonato data) {
        this.id = data.id();
        this.data = data.data();
        if (data.salaId() != null) {
            this.sala = new Sala();
            this.sala.setNumero(data.salaId());
        }
        this.categoria = data.categoria();
        this.premiacao = data.premiacao();
        this.valorPremiacao = data.valorPremiacao();
        this.status = data.status();
    }

}
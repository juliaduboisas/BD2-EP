package com.danceSchool.api.administrativo;

import com.danceSchool.api.funcionario.Funcionario;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "administrativo")
public class Administrativo {
    @Id
    @Size(max = 11)
    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cpf", nullable = false)
    private Funcionario funcionario;

    @Column(name = "nivel_acessos")
    private Integer nivelAcessos;

}
package com.danceSchool.api.entity.administrativo;

import com.danceSchool.api.enums.Nivel;
import com.danceSchool.api.entity.funcionario.Funcionario;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private Nivel nivelAcessos;

}
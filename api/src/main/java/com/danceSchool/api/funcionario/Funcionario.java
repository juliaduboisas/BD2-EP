package com.danceSchool.api.funcionario;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.danceSchool.api.administrativo.*;

@Getter
@Setter
@Entity
@Table(name = "funcionario")
public class Funcionario {
    @Id
    @Size(max = 11)
    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;

    @Size(max = 70)
    @Column(name = "nome", length = 70)
    private String nome;

    @Column(name = "genero", length = Integer.MAX_VALUE)
    private String genero;

    @Column(name = "data_admissao")
    private LocalDate dataAdmissao;

    @Column(name = "cargo", length = Integer.MAX_VALUE)
    private String cargo;

    @Column(name = "salario", precision = 10, scale = 2)
    private BigDecimal salario;

    @Size(max = 100)
    @Column(name = "email", length = 100)
    private String email;

    @Size(max = 8)
    @Column(name = "cep", length = 8)
    private String cep;

    @Column(name = "numero")
    private Integer numero;

    @Size(max = 100)
    @Column(name = "complemento", length = 100)
    private String complemento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpf_adm")
    private Administrativo cpfAdm;

}
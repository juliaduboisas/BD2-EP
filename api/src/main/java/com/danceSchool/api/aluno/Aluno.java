package com.danceSchool.api.aluno;

import com.danceSchool.api.enums.Genero;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="aluno")
public class Aluno {
    @Id
    @Size(min=11, max=11)
    @Column(name="cpf", length=11)
    private String cpf;

    @Size(max=70)
    @Column(name="nome", length=70)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name="genero", length=1)
    private Genero genero;

    @Column(name="data_nasc")
    private LocalDate dataNasc;

    @Email
    @Size(max=100)
    @Column(name="email", length=100)
    private String email;

    public Aluno(DataAluno dataAluno) {
        this.cpf= dataAluno.cpf();
        this.nome= dataAluno.nome();
        this.genero= dataAluno.genero();
        this.dataNasc= dataAluno.dataNasc();
        this.email= dataAluno.email();
    }
}

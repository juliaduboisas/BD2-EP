package com.danceSchool.api.student;

import com.danceSchool.api.enums.Gender;

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
public class Student {
    @Id
    @Size(min=11, max=11)
    @Column(name="cpf", length=11)
    private String cpf;

    @Size(max=70)
    @Column(name="nome", length=70)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name="genero", length=1)
    private Gender genero;

    @Column(name="data_nasc")
    private LocalDate dataNasc;

    @Email
    @Size(max=100)
    @Column(name="email", length=100)
    private String email;

    public Student(DataStudent dataStudent) {
        this.cpf= dataStudent.cpf();
        this.nome= dataStudent.nome();
        this.genero= dataStudent.genero();
        this.dataNasc= dataStudent.dataNasc();
        this.email= dataStudent.email();
    }
}

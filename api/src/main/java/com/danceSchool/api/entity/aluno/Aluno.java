package com.danceSchool.api.entity.aluno;

import java.time.LocalDate;
import java.util.Set;

import com.danceSchool.api.entity.inscricao.Inscricao;
import com.danceSchool.api.entity.matricula.Matricula;
import com.danceSchool.api.enums.Genero;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
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

    @OneToMany(mappedBy = "cpfAluno", cascade = CascadeType.ALL, orphanRemoval = true) 
    private Set<Inscricao> inscricoes;

    @OneToMany(mappedBy = "cpfAluno", cascade = CascadeType.ALL, orphanRemoval = true) 
    private Set<Matricula> matriculas;

    public Aluno(DataAluno dataAluno) {
        this.cpf= dataAluno.cpf();
        this.nome= dataAluno.nome();
        this.genero= dataAluno.genero();
        this.dataNasc= dataAluno.dataNasc();
        this.email= dataAluno.email();
    }
}

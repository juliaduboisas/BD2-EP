package com.danceSchool.api.turma;

import com.danceSchool.api.enums.Gender;
import com.danceSchool.api.enums.Nivel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="turma")
public class Turma {
    @Id
    @Column(name="id")
    private Integer id;

    @Column(name = "qtd_aulas_semanais")
    private Integer qtdAulasSemanais;

    @Column(name = "horario_inicio")
    private LocalTime horarioInicio;

    @Column(name = "horario_fim")
    private LocalTime horarioFim;

    @Column(name = "tamanho")
    private Integer tamanho;

    @Enumerated(EnumType.STRING)
    @Column(name = "genero")
    private Gender genero;

    @Enumerated(EnumType.STRING)
    @Column(name = "nivel")
    private Nivel nivel;

    @Column(name = "id_modalidade")
    private Integer idModalidade;

    @Size(min=11, max=11)
    @Column(name = "cpf_instrutor", length = 11)
    private String cpfInstrutor;

    public Turma(DataTurma dataTurma) {
        this.id = dataTurma.id();
        this.qtdAulasSemanais = dataTurma.qtdAulasSemanais();
        this.horarioInicio = dataTurma.horarioInicio();
        this.horarioFim = dataTurma.horarioFim();
        this.tamanho = dataTurma.tamanho();
        this.genero = dataTurma.genero();
        this.nivel = dataTurma.nivel();
        this.idModalidade = dataTurma.idModalidade();
        this.cpfInstrutor = dataTurma.cpfInstrutor();
    }
}

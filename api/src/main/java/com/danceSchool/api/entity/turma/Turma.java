package com.danceSchool.api.entity.turma;

import java.time.LocalTime;
import java.util.Set;

import com.danceSchool.api.entity.matricula.Matricula;
import com.danceSchool.api.enums.Genero;
import com.danceSchool.api.enums.Nivel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name="turma")
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Genero genero;

    @Enumerated(EnumType.STRING)
    @Column(name = "nivel")
    private Nivel nivel;

    @Column(name = "id_modalidade")
    private Integer idModalidade;

    @Size(min=11, max=11)
    @Column(name = "cpf_instrutor", length = 11)
    private String cpfInstrutor;

    @OneToMany(mappedBy = "idTurma", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Matricula> matriculas;


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

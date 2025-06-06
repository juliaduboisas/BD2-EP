package com.danceSchool.api.funcionario;

import com.danceSchool.api.enums.Genero;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="modalidade")
public class Funcionario {
    @Id
    @Size(min = 11, max = 11)
    @Column(name = "cpf", length = 11)
    private String cpf;

    @Size(max = 70)
    @Column(name = "nome")
    private String nome;

    @Size(min = 1, max = 1)
    @Column(name = "genero", length = 1)
    private Genero genero;

    @Column(name = "data_admissao")
    private LocalDate dataAdmissao;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "salario")
    private Double salario;

    @Size(max = 100)
    @Column(name = "email", length = 100)
    private String email;

    @Size(min = 8, max = 8)
    @Column(name = "cep", length = 8)
    private String cep;

    @Column(name = "numero")
    private Integer numero;

    @Size(max = 100)
    @Column(name = "complemento", length = 100)
    private String complemento;

    // FAZER A LIGAÇÃO MANY_TO_MANY COM A TABELA ADMINISTRATIVO AQUI!!!
    @Size(min = 11, max = 11)
    @Column(name = "cpf_adm", length = 11)
    private String cpfAdm;

    public Funcionario(DataFuncionario dataFuncionario){
        this(dataFuncionario.cpf(), dataFuncionario.nome(), dataFuncionario.genero(), dataFuncionario.dataAdmissao(), dataFuncionario.cargo(), dataFuncionario.salario(), dataFuncionario.email(), dataFuncionario.cep(), dataFuncionario.numero(), dataFuncionario.complemento(), dataFuncionario.cpfAdm());
    }
}

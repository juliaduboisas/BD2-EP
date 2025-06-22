package com.danceSchool.api.entity.funcionario;

import com.danceSchool.api.entity.administrativo.Administrativo;
import com.danceSchool.api.entity.administrativo.AdministrativoRepository;
import com.danceSchool.api.enums.Genero;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private Genero genero;

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

    public Funcionario(DataFuncionario dataFuncionario) {
        this.cpf = dataFuncionario.cpf();
        this.nome = dataFuncionario.nome();
        this.genero = dataFuncionario.genero();
        this.dataAdmissao = dataFuncionario.dataAdmissao();
        this.cargo = dataFuncionario.cargo();
        this.salario = dataFuncionario.salario();
        this.email = dataFuncionario.email();
        this.cep = dataFuncionario.cep();
        this.numero = dataFuncionario.numero();
        this.complemento = dataFuncionario.complemento();
        this.cpfAdm = new Administrativo(dataFuncionario.cpfAdm());
    }
}
package com.danceSchool.api.entity.instrutor;

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
@Table(name = "instrutor")
public class Instrutor {
    @Id
    @Size(max = 11)
    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "cpf", nullable = false)
    private Funcionario funcionario;

    public Instrutor(DataInstrutor data) {
        this.cpf = data.cpf();
        if (data.funcionarioCpf() != null) {
            this.funcionario = new Funcionario();
            this.funcionario.setCpf(data.funcionarioCpf());
        }
    }

}
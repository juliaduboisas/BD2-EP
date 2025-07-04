package com.danceSchool.api.entity.pagamento;

import com.danceSchool.api.entity.funcionario.Funcionario;
import com.danceSchool.api.entity.transacaoSaida.TransacaoSaida;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pagamentos")
public class Pagamento {
    @Id
    @Column(name = "id_transacao", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_transacao", nullable = false)
    private TransacaoSaida transacaoSaida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpf_func")
    private Funcionario cpfFunc;

    public Pagamento(DataPagamento data) {
        this.id = data.id();
        if (data.idTransacaoSaida() != null) {
            this.transacaoSaida = new TransacaoSaida();
            this.transacaoSaida.setId(data.idTransacaoSaida());
        }
        if (data.cpfFuncionario() != null) {
            this.cpfFunc = new Funcionario();
            this.cpfFunc.setCpf(data.cpfFuncionario());
        }
    }

}
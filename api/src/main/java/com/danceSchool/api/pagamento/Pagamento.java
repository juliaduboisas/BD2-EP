package com.danceSchool.api.pagamento;

import com.danceSchool.api.funcionario.Funcionario;
import com.danceSchool.api.transacaoSaida.TransacaoSaida;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

}
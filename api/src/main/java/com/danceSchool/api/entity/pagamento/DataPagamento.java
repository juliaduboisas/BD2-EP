package com.danceSchool.api.entity.pagamento;

public record DataPagamento(
        Integer id,
        Integer idTransacaoSaida, // Represents the ID from TransacaoSaida
        String cpfFuncionario     // Represents the CPF from Funcionario
) {

    public DataPagamento(Pagamento pagamento) {
        this(
                pagamento.getId(),
                pagamento.getTransacaoSaida().getId(),
                pagamento.getCpfFunc().getCpf()
        );
    }
}

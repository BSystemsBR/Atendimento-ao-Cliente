package br.com.invext.atendimento.model;

import lombok.Getter;

@Getter
public enum TipoSolicitacao {

    // Enum para representar os diferentes tipos de solicitações
    CARTAO("Problemas com cartão"),
    EMPRESTIMO("Contratação de empréstimo"),
    OUTROS("Outros assuntos");

    // Descrição do tipo de solicitação
    private final String descricao;

    TipoSolicitacao(String descricao) {
        this.descricao = descricao;
    }
}

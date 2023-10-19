package br.com.invext.atendimento.model;

import lombok.Getter;

@Getter
public enum TipoSolicitacao {
    CARTAO("Problemas com cartão"),
    EMPRESTIMO("Contratação de empréstimo"),
    OUTROS("Outros assuntos");

    private final String descricao;

    TipoSolicitacao(String descricao) {
        this.descricao = descricao;
    }

}

package br.com.invext.atendimento.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SolicitacaoResposta {

    // Status geral da resposta
    private String status;

    // Assunto da solicitação
    private String assunto;

    // Status do atendimento (encaminhado ou enfileirado)
    private String atendimentoStatus;

    // Posição na fila, se aplicável
    private Integer posicaoNaFila;
}

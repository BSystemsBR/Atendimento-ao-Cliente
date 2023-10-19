package br.com.invext.atendimento.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SolicitacaoResposta {
    private String status;
    private String assunto;
    private String atendimentoStatus;
    private Integer posicaoNaFila;
}

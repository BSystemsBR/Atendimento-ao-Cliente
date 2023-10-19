package br.com.invext.atendimento.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public record Solicitacao(String assunto) {

    @JsonCreator
    public Solicitacao(@JsonProperty("assunto") String assunto) {
        this.assunto = assunto;
    }

    public String getAssunto() {
        return this.assunto;
    }
}

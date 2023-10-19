package br.com.invext.atendimento.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Solicitacao {
    private String assunto;

    // Jackson usa este construtor para deserialização
    @JsonCreator
    public Solicitacao(@JsonProperty("assunto") String assunto) {
        this.assunto = assunto;
    }

    // Construtor vazio necessário para a deserialização do Jackson
    public Solicitacao() {
    }

    // Getter necessário para a serialização do Jackson
    public String getAssunto() {
        return assunto;
    }

    // Setter necessário para a deserialização do Jackson
    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
}

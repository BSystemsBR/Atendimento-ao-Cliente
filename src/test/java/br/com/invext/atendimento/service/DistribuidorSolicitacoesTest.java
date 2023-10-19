package br.com.invext.atendimento.service;

import br.com.invext.atendimento.model.Solicitacao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DistribuidorSolicitacoesTest {

    private DistribuidorSolicitacoes distribuidor;

    @BeforeEach
    public void setUp() {
        distribuidor = new DistribuidorSolicitacoes(1); // 1 atendente por time para teste
    }

    @Test
    public void testDistribuirSolicitacaoCartao() {
        Solicitacao solicitacao1 = new Solicitacao("Problemas com cartão");
        Solicitacao solicitacao2 = new Solicitacao("Problemas com cartão");
        Solicitacao solicitacao3 = new Solicitacao("Problemas com cartão");
        Solicitacao solicitacao4 = new Solicitacao("Problemas com cartão");

        distribuidor.distribuirSolicitacao(solicitacao1);
        distribuidor.distribuirSolicitacao(solicitacao2);
        distribuidor.distribuirSolicitacao(solicitacao3);
        distribuidor.distribuirSolicitacao(solicitacao4);

        // Como temos 1 atendente por time, as tres primeiras solicitações devem ser atendidas imediatamente,
        // e a quarta solicitação deve ser enfileirada.
        Assertions.assertEquals(1, distribuidor.tamanhoFilaCartoes());
    }

}

package br.com.invext.atendimento.service;

import br.com.invext.atendimento.model.Atendente;
import br.com.invext.atendimento.model.Solicitacao;
import br.com.invext.atendimento.model.TipoSolicitacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DistribuidorSolicitacoes {

    private final List<Atendente> atendentesCartoes;
    private final List<Atendente> atendentesEmprestimos;
    private final List<Atendente> atendentesOutros;

    private final Queue<Solicitacao> filaCartoes;
    private final Queue<Solicitacao> filaEmprestimos;
    private final Queue<Solicitacao> filaOutros;

    public DistribuidorSolicitacoes(int qtdAtendentesPorTime) {
        atendentesCartoes = new ArrayList<>();
        atendentesEmprestimos = new ArrayList<>();
        atendentesOutros = new ArrayList<>();

        for (int i = 0; i < qtdAtendentesPorTime; i++) {
            atendentesCartoes.add(new Atendente("Cartões"));
            atendentesEmprestimos.add(new Atendente("Empréstimos"));
            atendentesOutros.add(new Atendente("Outros Assuntos"));
        }

        filaCartoes = new LinkedList<>();
        filaEmprestimos = new LinkedList<>();
        filaOutros = new LinkedList<>();
    }

    public void distribuirSolicitacao(Solicitacao solicitacao) {
        TipoSolicitacao tipo = TipoSolicitacao.OUTROS; // default
        for (TipoSolicitacao t : TipoSolicitacao.values()) {
            if (t.getDescricao().equals(solicitacao.getAssunto())) {
                tipo = t;
                break;
            }
        }

        switch (tipo) {
            case CARTAO:
                encaminharOuEnfileirar(solicitacao, atendentesCartoes, filaCartoes);
                break;
            case EMPRESTIMO:
                encaminharOuEnfileirar(solicitacao, atendentesEmprestimos, filaEmprestimos);
                break;
            case OUTROS:
                encaminharOuEnfileirar(solicitacao, atendentesOutros, filaOutros);
                break;
        }
    }

    private void encaminharOuEnfileirar(Solicitacao solicitacao, List<Atendente> atendentes, Queue<Solicitacao> fila) {
        for (Atendente atendente : atendentes) {
            if (atendente.estaDisponivel()) {
                atendente.iniciarAtendimento();
                agendarFinalizacaoAtendimento(atendente, fila);
                return;
            }
        }
        fila.add(solicitacao);
    }

    private void agendarFinalizacaoAtendimento(Atendente atendente, Queue<Solicitacao> fila) {
        scheduler.schedule(() -> {
            atendente.finalizarAtendimento();
            if (!fila.isEmpty()) {
                Solicitacao proximaSolicitacao = fila.poll();
                if (proximaSolicitacao != null) {
                    encaminharOuEnfileirar(proximaSolicitacao, List.of(atendente), fila);
                }
            }
        }, 1, TimeUnit.MINUTES); // Simula um atendimento finalizando em 1 minuto
    }

    public List<Solicitacao> obterSolicitacoesPendentes() {
        List<Solicitacao> todasPendentes = new ArrayList<>();
        todasPendentes.addAll(filaCartoes);
        todasPendentes.addAll(filaEmprestimos);
        todasPendentes.addAll(filaOutros);
        return todasPendentes;
    }

    public Integer tamanhoFilaCartoes() {
        return filaCartoes.size();
    }

    public Integer tamanhoFilaEmprestimos() {
        return filaEmprestimos.size();
    }

    public Integer tamanhoFilaOutros() {
        return filaOutros.size();
    }

    // 10 threads para simular atendimentos simultâneos
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);

}

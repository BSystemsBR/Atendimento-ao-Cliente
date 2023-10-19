package br.com.invext.atendimento.controller;

import br.com.invext.atendimento.model.Solicitacao;
import br.com.invext.atendimento.model.SolicitacaoResposta;
import br.com.invext.atendimento.service.DistribuidorSolicitacoes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/solicitacoes")
public class SolicitacaoController {
    private final DistribuidorSolicitacoes distribuidor;

    public SolicitacaoController() {
        this.distribuidor = new DistribuidorSolicitacoes(1); // Exemplo com 1 atendente por time.
    }

    @PostMapping
    public ResponseEntity<SolicitacaoResposta> adicionarSolicitacao(@RequestBody Solicitacao solicitacao) {
        SolicitacaoResposta response = distribuidor.distribuirSolicitacao(solicitacao);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/pendentes")
    public ResponseEntity<List<Solicitacao>> solicitacoesPendentes() {
        // Supondo um método para obter as solicitações pendentes no serviço de distribuição
        List<Solicitacao> pendentes = distribuidor.obterSolicitacoesPendentes();
        return ResponseEntity.ok(pendentes);
    }

    @GetMapping("/status")
    public ResponseEntity<Map<String, Integer>> statusDasFilas() {
        HashMap<String, Integer> status = new HashMap<>();
        status.put("Fila Cartões", distribuidor.tamanhoFilaCartoes());
        status.put("Fila Empréstimos", distribuidor.tamanhoFilaEmprestimos());
        status.put("Fila Outros Assuntos", distribuidor.tamanhoFilaOutros());
        return ResponseEntity.ok(status);
    }

}

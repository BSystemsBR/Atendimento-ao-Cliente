package br.com.invext.atendimento.controller;

import br.com.invext.atendimento.model.Solicitacao;
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

    @GetMapping("/pendentes")
    public ResponseEntity<List<Solicitacao>> solicitaçõesPendentes() {
        // Supondo um método para obter as solicitações pendentes no serviço de Distribuição
        List<Solicitacao> pendentes = distribuidor.obterSolicitacoesPendentes();
        return ResponseEntity.ok(pendentes);
    }

    @PostMapping
    public ResponseEntity<String> adicionarSolicitacao(@RequestBody Solicitacao solicitacao) {
        distribuidor.distribuirSolicitacao(solicitacao);
        return ResponseEntity.ok("Solicitação recebida!");
    }

    @GetMapping("/status")
    public ResponseEntity<Map<String, Integer>> statusDasFilas() {
        Map<String, Integer> status = new HashMap<>();
        status.put("Fila Cartões", distribuidor.tamanhoFilaCartoes());
        status.put("Fila Empréstimos", distribuidor.tamanhoFilaEmprestimos());
        status.put("Fila Outros Assuntos", distribuidor.tamanhoFilaOutros());
        return ResponseEntity.ok(status);
    }

}

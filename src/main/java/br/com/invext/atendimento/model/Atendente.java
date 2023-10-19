package br.com.invext.atendimento.model;

public class Atendente {
    private int clientesAtendendo;

    public Atendente() {
        this.clientesAtendendo = 0;
    }

    public boolean estaDisponivel() {
        return clientesAtendendo < 3;
    }

    public void iniciarAtendimento() {
        this.clientesAtendendo++;
    }

    public void finalizarAtendimento() {
        this.clientesAtendendo--;
    }

}

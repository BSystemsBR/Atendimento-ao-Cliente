package br.com.invext.atendimento.model;

public class Atendente {
    private String time;
    private int clientesAtendendo;

    public Atendente(String time) {
        this.time = time;
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

    public String getTime() {
        return time;
    }
}

package com.github.britooo.looca.api.group.servicos;

import oshi.software.os.OSService;

/**
 *
 * @author Diego Brito diego.lima@bandtec.com.br  @Britooo on Github
 * @author Giuliana Miniguiti giuliana.franca@bandtec.com.br  @miniguiti on Github
 */
public class Servico {

    private final OSService servico;

    public Servico(OSService servico) {
        this.servico = servico;
    }

    public Integer getPid() {
        return this.servico.getProcessID();
    }

    public String getNome() {
        return this.servico.getName();
    }

    public String getEstado() {
        return this.servico.getState().toString();
    }

    @Override
    public String toString() {
        return String.format("PID:%d\nNome: %s\nEstado: %s",
                this.getPid(), this.getNome(), this.getEstado());
    }
}

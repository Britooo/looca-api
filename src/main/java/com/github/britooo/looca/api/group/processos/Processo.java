package com.github.britooo.looca.api.group.processos;

import oshi.software.os.OSProcess;
import com.github.britooo.looca.api.group.memoria.Memoria;

public class Processo {

    private final OSProcess processo;
    private final Memoria memoria;

    public Processo(OSProcess processo, Memoria memoria) {
        this.processo = processo;
        this.memoria = memoria;
    }

    public Integer getPid() {
        return this.processo.getProcessID();
    }

    public String getNome() {
        return this.processo.getName();
    }

    public Double getUsoCpu() {
        return (100d * (processo.getKernelTime() + processo.getUserTime()) / processo.getUpTime());
    }

    public Double getUsoMemoria() {
        return (100d * processo.getResidentSetSize() / memoria.getTotal());
    }

    public Long getBytesUtilizados() {
        return processo.getResidentSetSize();
    }

    public Long getMemoriaVirtualUtilizada() {
        return processo.getVirtualSize();
    }

    @Override
    public String toString() {
        return String.format("PID:%d\nNome: %s\nUso CPU: %.1f\nUso memória: %.1f\nBytes utilizados: %s\nMemória virtual utilizada: %s",
                this.getPid(), this.getNome(), this.getUsoCpu(), this.getUsoMemoria(), this.getBytesUtilizados(), this.getMemoriaVirtualUtilizada());
    }
}

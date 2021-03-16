package com.github.britooo.looca.api.group.processos;

import java.util.List;
import oshi.SystemInfo;
import oshi.software.os.OSProcess;
import java.util.stream.Collectors;
import oshi.software.os.OperatingSystem;
import com.github.britooo.looca.api.group.memoria.Memoria;

/**
 *
 * @author Diego Brito diego.lima@bandtec.com.br  @Britooo on Github
 * @author Giuliana Miniguiti giuliana.franca@bandtec.com.br  @miniguiti on Github
 */
public class ProcessosGroup {

    private final OperatingSystem os = new SystemInfo().getOperatingSystem();

    public Integer getTotalThreads() {
        return this.os.getThreadCount();
    }

    public Integer getTotalProcessos() {
        return this.os.getProcessCount();
    }

    public List<Processo> getProcessos() {
        return this.os.getProcesses()
                .stream()
                .map(ProcessosGroup::of)
                .collect(Collectors.toList());
    }

    private static Processo of(OSProcess processo) {
        if (processo == null) {
            return null;
        }
        Memoria memoria = new Memoria();
        return new Processo(processo, memoria);
    }

    @Override
    public String toString() {
        return String.format("\nLista de processos\nTotal de processos ativos: %d\nTotal de threads: %d\nProcessos: %s",
                this.getTotalProcessos(), this.getTotalThreads(), this.getProcessos());
    }
}

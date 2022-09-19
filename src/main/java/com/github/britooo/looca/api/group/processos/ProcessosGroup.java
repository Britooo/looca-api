package com.github.britooo.looca.api.group.processos;

import java.util.List;
import oshi.SystemInfo;
import oshi.software.os.OSProcess;
import java.util.stream.Collectors;
import oshi.software.os.OperatingSystem;
import com.github.britooo.looca.api.group.memoria.Memoria;

public class ProcessosGroup {

    private final OperatingSystem os = new SystemInfo().getOperatingSystem();

    /**
     * Retorna o número de threads em execução.
     * @return Número de threads em execução.
     */
    public Integer getTotalThreads() {
        return this.os.getThreadCount();
    }

    /**
     * Retorna o número de processos em execução.
     * @return Número de processos em execução.
     */
    public Integer getTotalProcessos() {
        return this.os.getProcessCount();
    }

    /**
     * Retorna os processos em execução no momento. Nenhum pedido é garantido.
     * Sendo uma lista de objetos OSProcess para o número especificado (ou todos) de processos atualmente em execução,
     * classificados conforme especificado.
     * A lista pode conter elementos nulos ou processos com estado OSProcess.State.INVALID se um processo for encerrado durante a iteração.
     * @return Lista com os processos em execução no momento. Nenhum pedido é garantido.
     */
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

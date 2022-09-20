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

    /**
     *
     * <p><b>Retorna o ID do processo.</b></p>
     * <br/>
     * <p>Embora seja um valor de 32 bits, ele não é assinado no Windows e,
     * em circunstâncias extremamente raras, pode retornar um valor negativo.</p>
     * @return ID do processo.
     */
    public Integer getPid() {
        return this.processo.getProcessID();
    }

    /**
     * <b>Retorna o nome do processo, geralmente o programa executável.</b>
     * @return Nome do processo, geralmente o programa executável.
     */
    public String getNome() {
        return this.processo.getName();
    }

    /**
     * <p><b>Retorna o valor percentual de uso da CPU pelo processo.</b></p>
     * <br/>
     * <p>
     * Por meio do cálculo: (100d * (o número de milissegundos que o processo executou no modo kernel/sistema.
     * +
     * Obtém o tempo do usuário usado pelo processo.)
     * /
     * o número de milissegundos desde o início do processo).
     * Assim conseguimos a porcentagem do uso de CPU pelo processo.
     * </p>
     *
     * @return Valor percentual de uso da CPU pelo processo.
     */
    public Double getUsoCpu() {
        return (100d * (processo.getKernelTime() + processo.getUserTime()) / processo.getUpTime());
    }

    /**
     * <p><b>Retorna no Windows o tamanho do Conjunto de Trabalho Privado, que deve corresponder à coluna "Memória" no Gerenciador de Tarefas do Windows.</b></p>
     * <p><b>Retorna no Linux o valor RSS de /proc/[pid]/stat, que pode ser impreciso devido a uma otimização de escalabilidade interna do kernel. Se forem necessários valores precisos, leia /proc/[pid]/smaps usando <code>FileUtil.getKeyValueMapFromFile(String, String)</code>.</b></p>
     * <br/>
     * <p>E por meio do cálculo: (100d * Obtém o tamanho do conjunto residente (RSS). Usado para mostrar quanta memória está alocada para esse processo e está na RAM. Não inclui memória que é trocada. Inclui memória de bibliotecas compartilhadas, desde que as páginas dessas bibliotecas estejam realmente na memória. Inclui toda a memória de pilha e heap.
     * Retorna (o tamanho do conjunto residente / A quantidade de memória física real, em bytes).</p>
     * @return Valor percentual de uso da Memória RAM pelo processo.
     */
    public Double getUsoMemoria() {
        return (100d * processo.getResidentSetSize() / memoria.getTotal());
    }

    /**
     * <p><b>Retorna o tamanho do conjunto residente (RSS). Usado para mostrar quanta memória está alocada para esse processo e está na RAM.</b></p>
     * <br/>
     * <p>Não inclui memória que é trocada. Inclui memória de bibliotecas compartilhadas,
     * desde que as páginas dessas bibliotecas estejam realmente na memória.
     * Inclui toda a memória de pilha e heap.
     * No Windows, retorna o tamanho do Conjunto de Trabalho Privado,
     * que deve corresponder à coluna "Memória" no Gerenciador de Tarefas do Windows.</p>
     * <br/>
     * <p>
     * No Linux, retorna o valor RSS de /proc/[pid]/stat,
     * que pode ser impreciso devido a uma otimização de escalabilidade interna do kernel.
     * Se forem necessários valores precisos, leia /proc/[pid]/smaps usando
     * <code>FileUtil.getKeyValueMapFromFile(String, String)</code>.
     * </p>
     * @return Tamanho do conjunto residente (ou Quantidade de bytes utilizados).
     */
    public Long getBytesUtilizados() {
        return processo.getResidentSetSize();
    }

    /**
     * <p><b>Retorna o tamanho da memória virtual (VSZ).</b></p>
     * <br/>
     * <p>Inclui toda a memória que o processo pode acessar,
     * incluindo memória que é trocada e memória que é de bibliotecas compartilhadas.</p>
     * @return Tamanho da memória virtual.
     */
    public Long getMemoriaVirtualUtilizada() {
        return processo.getVirtualSize();
    }

    @Override
    public String toString() {
        return String.format("PID:%d\nNome: %s\nUso CPU: %.1f\nUso memória: %.1f\nBytes utilizados: %s\nMemória virtual utilizada: %s",
                this.getPid(), this.getNome(), this.getUsoCpu(), this.getUsoMemoria(), this.getBytesUtilizados(), this.getMemoriaVirtualUtilizada());
    }
}

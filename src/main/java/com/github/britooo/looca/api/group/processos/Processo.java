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
   * <p>Retorna o <b>ID do processo</b>.</p>
   * <br>
   * <p>Embora seja um valor de 32 bits, ele não é assinado no Windows e,
   * em circunstâncias extremamente raras, pode retornar um valor negativo.</p>
   *
   * @return ID do processo.
   */
  public Integer getPid() {
    return this.processo.getProcessID();
  }

  /**
   * Retorna o <b>nome do processo</b>, geralmente o programa executável.
   *
   * @return Nome do processo, geralmente o programa executável.
   */
  public String getNome() {
    return this.processo.getName();
  }

  /**
   * <p>Retorna o valor percentual de <b>uso da CPU pelo processo</b>.</p>
   * <br>
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
   * <p>Retorna no <b>Windows</b> o tamanho do Conjunto de Trabalho Privado, que deve corresponder à coluna "Memória" no Gerenciador de Tarefas do Windows.</p>
   * <p>Retorna no <b>Linux</b> o valor RSS de /proc/[pid]/stat, que pode ser impreciso devido a uma otimização de escalabilidade interna do kernel. Se forem necessários valores precisos, leia /proc/[pid]/smaps usando <code>FileUtil.getKeyValueMapFromFile(String, String)</code>.</p>
   * <br>
   * <p>E por meio do cálculo: (100d * Obtém o tamanho do conjunto residente (RSS). Usado para mostrar quanta memória está alocada para esse processo e está na RAM. Não inclui memória que é trocada. Inclui memória de bibliotecas compartilhadas, desde que as páginas dessas bibliotecas estejam realmente na memória. Inclui toda a memória de pilha e heap.
   * Retorna (o tamanho do conjunto residente / A quantidade de memória física real, em bytes).</p>
   *
   * @return Valor percentual de uso da Memória RAM pelo processo.
   */
  public Double getUsoMemoria() {
    return (100d * processo.getResidentSetSize() / memoria.getTotal());
  }

  /**
   * <p>Retorna o tamanho do conjunto residente (RSS). Usado para mostrar quanta memória está alocada para esse processo e está na RAM.</p>
   * <br>
   * <p>Não inclui memória que é trocada. Inclui memória de bibliotecas compartilhadas,
   * desde que as páginas dessas bibliotecas estejam realmente na memória.
   * Inclui toda a memória de pilha e heap.
   * No <b>Windows</b>, retorna o tamanho do Conjunto de Trabalho Privado,
   * que deve corresponder à coluna "Memória" no Gerenciador de Tarefas do Windows.</p>
   * <br>
   * <p>
   * No <b>Linux</b>, retorna o valor RSS de /proc/[pid]/stat,
   * que pode ser impreciso devido a uma otimização de escalabilidade interna do kernel.
   * Se forem necessários valores precisos, leia /proc/[pid]/smaps usando
   * <code>FileUtil.getKeyValueMapFromFile(String, String)</code>.
   * </p>
   *
   * @return Tamanho do conjunto residente (ou Quantidade de <b>bytes</b> utilizados).
   */
  public Long getBytesUtilizados() {
    return processo.getResidentSetSize();
  }

  /**
   * <p>Retorna o <b>tamanho da memória virtual (VSZ)</b>.</p>
   * <br>
   * <p>Inclui toda a memória que o processo pode acessar,
   * incluindo memória que é trocada e memória que é de bibliotecas compartilhadas.</p>
   *
   * @return Tamanho da memória virtual.
   */
  public Long getMemoriaVirtualUtilizada() {
    return processo.getVirtualSize();
  }

  /**
   * Retorna uma <code>String</code> com todas as informações relacionadas ao <b>Processo</b>.
   * @return <code>String</code> com todas as informações relacionadas ao <b>Grupo de Processos</b>.
   */
  @Override
  public String toString() {

    final StringBuilder sb = new StringBuilder();

    sb.append("PID: ").append(getPid())
        .append("\n");

    sb.append("Uso CPU: ")
        .append(String.format("%.1f", getUsoCpu()))
        .append("\n");

    sb.append("Uso memória: ")
        .append(String.format("%.1f", getUsoMemoria()))
        .append("\n");

    sb.append("Bytes utilizados: ")
        .append(getBytesUtilizados())
        .append("\n");

    sb.append("Memória virtual utilizada: ")
        .append(getMemoriaVirtualUtilizada())
        .append("\n");

    return sb.toString();
  }

}

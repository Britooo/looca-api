package com.github.britooo.looca.api.group.processos;

import java.util.List;

import oshi.SystemInfo;
import oshi.software.os.OSProcess;

import java.util.stream.Collectors;

import oshi.software.os.OperatingSystem;
import com.github.britooo.looca.api.group.memoria.Memoria;

public class ProcessoGrupo {

  private final OperatingSystem os = new SystemInfo().getOperatingSystem();

  /**
   * Retorna o número de <b>threads em execução</b>.
   *
   * @return Número de threads em execução.
   */
  public Integer getTotalThreads() {
    return this.os.getThreadCount();
  }

  /**
   * Retorna o número de <b>processos em execução</b>.
   *
   * @return Número de processos em execução.
   */
  public Integer getTotalProcessos() {
    return this.os.getProcessCount();
  }

  /**
   * <p>Retorna os <b>processos em execução no momento</b>. Nenhum pedido é garantido.</p>
   * <br>
   * <p>Sendo uma lista de objetos <code>OSProcess</code> para o número especificado (ou todos) de processos atualmente em execução,
   * classificados conforme especificado.
   * A lista pode conter elementos nulos ou processos com estado <code>OSProcess.State.INVALID</code> se um processo for encerrado durante a iteração.</p>
   *
   * @return Lista com os processos em execução no momento. Nenhum pedido é garantido.
   */
  public List<Processo> getProcessos() {
    return this.os.getProcesses()
        .stream()
        .map(ProcessoGrupo::of)
        .collect(Collectors.toList());
  }

  private static Processo of(OSProcess processo) {
    if (processo == null) {
      return null;
    }
    Memoria memoria = new Memoria();
    return new Processo(processo, memoria);
  }

  /**
   * Retorna uma <code>String</code> com todas as informações relacionadas ao <b>Grupo de Processos</b>.
   * @return <code>String</code> com todas as informações relacionadas ao <b>Grupo de Processos</b>.
   */
  @Override
  public String toString() {
    return String.format("\nLista de processos\nTotal de processos ativos: %d\nTotal de threads: %d\nProcessos: %s",
        this.getTotalProcessos(), this.getTotalThreads(), this.getProcessos());
  }
}

package com.github.britooo.looca.api.group.servicos;

import java.util.List;

import oshi.SystemInfo;

import java.util.stream.Collectors;

import oshi.software.os.OSService;

public class ServicoGrupo {

  enum STATUS {
    RUNNING,
    STOPPED
  }

  private final SystemInfo sistema = new SystemInfo();

  /**
   * Devolve uma lista com todos os serviços
   *
   * @return Lista com todos os serviços
   */
  public List<Servico> getServicos() {
    return recuperarServicosOshi().stream().map(ServicoGrupo::of).collect(Collectors.toList());
  }

  /**
   * Retorna a quantidade de serviços
   *
   * @return Quantidade de serviços
   */
  public Integer getTotalDeServicos() {
    return this.getServicos().size();
  }

  /**
   * Lista todos os serviços cujo o status é <code>RUNNING</code> (ou em execução)
   *
   * @return Lista de serviços ativos
   */
  public List<Servico> getServicosAtivos() {
    return this.getServicos().stream()
        .filter(servico -> servico.getEstado()
            .equals(STATUS.RUNNING.toString()))
        .collect(Collectors.toList());
  }

  /**
   * Retorna a quantidade de serviços em execução
   *
   * @return Quantidade de serviços em execução
   */
  public Integer getTotalServicosAtivos() {
    return this.getServicosAtivos().size();
  }

  /**
   * Lista todos os serviços cujo o status é <code>STOPPED</code> (ou inativo)
   *
   * @return Lista de serviços inativos
   */
  public List<Servico> getServicosInativos() {
    return this.getServicos().stream()
        .filter(servico -> servico.getEstado()
            .equals(STATUS.STOPPED.toString()))
        .collect(Collectors.toList());
  }

  /**
   * Retorna a quantidade de <b>serviços inativos</b>.
   *
   * @return Quantidade de serviços inativos.
   */
  public Integer getTotalServicosInativos() {
    return this.getServicosInativos().size();
  }

  private List<OSService> recuperarServicosOshi() {
    return this.sistema.getOperatingSystem().getServices();
  }

  private static Servico of(OSService servico) {
    if (servico == null) {
      return null;
    }

    return new Servico(servico);
  }
}

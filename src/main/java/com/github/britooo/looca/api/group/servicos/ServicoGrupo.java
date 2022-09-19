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

  public List<Servico> getServicos() {
    return recuperarServicosOshi().stream().map(ServicoGrupo::of).collect(Collectors.toList());
  }

  public Integer getTotalDeServicos() {
    return this.getServicos().size();
  }

  public List<Servico> getServicosAtivos() {
    return this.getServicos().stream()
        .filter(servico -> servico.getEstado()
            .equals(STATUS.RUNNING.toString()))
        .collect(Collectors.toList());
  }

  public Integer getTotalServicosAtivos() {
    return this.getServicosAtivos().size();
  }

  public List<Servico> getServicosInativos() {
    return this.getServicos().stream()
        .filter(servico -> servico.getEstado()
            .equals(STATUS.STOPPED.toString()))
        .collect(Collectors.toList());
  }

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

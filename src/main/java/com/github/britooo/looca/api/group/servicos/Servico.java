package com.github.britooo.looca.api.group.servicos;

import oshi.software.os.OSService;

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

    final StringBuilder sb = new StringBuilder();

    sb.append("PID: ")
        .append(getPid())
        .append("\n");

    sb.append("Nome: ")
        .append(getNome())
        .append("\n");

    sb.append("Estado: ")
        .append(getEstado())
        .append("\n");

    return sb.toString();
  }
}

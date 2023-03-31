package com.github.britooo.looca.api.group.servicos;

import oshi.software.os.OSService;

public class Servico {

  private final OSService servico;

  public Servico(OSService servico) {
    this.servico = servico;
  }

  /**
   * Obtém o <b>ID do processo atual</b>.
   * 
   * @return ID do processo.
   */
  public Integer getPid() {
    return this.servico.getProcessID();
  }

  /**
   * Retorna o <b>nome do serviço</b>.
   * 
   * @return Nome do serviço.
   */
  public String getNome() {
    return this.servico.getName();
  }

  /**
   * <p>
   *  Retorna o <b>estado do serviço</b>.
   * </p>
   * 
   * Ex: <code>STOPPED</code>, <code>RUNNING</code>.
   * 
   * @return Estado do serviço.
   */
  public String getEstado() {
    return this.servico.getState().toString();
  }

  /**
   * Retorna uma <code>String</code> com todas as informações relacionadas ao <b>Serviço</b>.
   * @return <code>String</code> com todas as informações relacionadas ao <b>Serviço</b>.
   */
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

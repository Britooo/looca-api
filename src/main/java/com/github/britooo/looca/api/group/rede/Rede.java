package com.github.britooo.looca.api.group.rede;

import oshi.SystemInfo;

public class Rede {

  private final SystemInfo si;

  public Rede(SystemInfo si) {
    this.si = si;
  }

  /**
   * Retorna um <b>Objeto de RedeInterfaceGroup</b> que contém métodos relacionados a coleta de informações de
   * <b>Interfaces de Rede</b> físicas e virtuais disponíveis para uso no computador.
   * @return Objeto RedeInterfaceGroup.
   */
  public RedeInterfaceGroup getGrupoDeInterfaces() {
    return new RedeInterfaceGroup(si);
  }

  /**
   * Retorna um <b>Objeto de RedeParametros</b> que contém métodos relacionados a coleta de informações
   * de <b>Parâmetros de Rede</b> do sistema operacional como username e domínio.
   * @return Objeto RedeParametros.
   */
  public RedeParametros getParametros() {
    return new RedeParametros(si);
  }
}

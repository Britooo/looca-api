package com.github.britooo.looca.api.group.rede;

import oshi.SystemInfo;

public class Rede {

  private final SystemInfo si;

  public Rede(SystemInfo si) {
    this.si = si;
  }

  public RedeInterfaceGroup getGrupoDeInterfaces() {
    return new RedeInterfaceGroup(si);
  }

  public RedeParametros getParametros() {
    return new RedeParametros(si);
  }
}

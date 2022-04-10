package com.github.britooo.looca.api.group.rede;

import oshi.SystemInfo;
import oshi.hardware.NetworkIF;

import java.util.List;
import java.util.stream.Collectors;

public class RedeInterfaceGroup {

  private final List<NetworkIF> interfaces;

  public RedeInterfaceGroup(SystemInfo si) {
    this.interfaces = si.getHardware().getNetworkIFs();
  }

  public List<RedeInterface> getInterfaces() {
    return this.interfaces.stream().map(RedeInterface::new).collect(Collectors.toList());
  }
}

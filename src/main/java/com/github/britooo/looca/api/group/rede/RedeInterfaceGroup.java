package com.github.britooo.looca.api.group.rede;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;

import java.util.List;
import java.util.stream.Collectors;

public class RedeInterfaceGroup {

  private final HardwareAbstractionLayer hal;

  public RedeInterfaceGroup(SystemInfo si) {
    this.hal = si.getHardware();
  }

  public List<RedeInterface> getInterfaces() {
    return this.hal.getNetworkIFs().stream()
        .map(RedeInterface::of)
        .collect(Collectors.toList());
  }
}

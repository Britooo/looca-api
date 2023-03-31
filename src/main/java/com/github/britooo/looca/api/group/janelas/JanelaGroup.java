package com.github.britooo.looca.api.group.janelas;

import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

import java.util.List;
import java.util.stream.Collectors;

public class JanelaGroup {

  private final OperatingSystem so;

  public JanelaGroup(SystemInfo si) {
    this.so = si.getOperatingSystem();
  }

  public List<Janela> getJanelas() {
    return so.getDesktopWindows(false).stream()
        .map(Janela::of)
        .collect(Collectors.toList());
  }

  public List<Janela> getJanelasVisiveis() {
    return so.getDesktopWindows(true).stream()
        .map(Janela::of)
        .collect(Collectors.toList());
  }

  public Integer getTotalJanelas() {
    return so.getDesktopWindows(false).size();
  }

  public Integer getTotalJanelasVisiveis() {
    return so.getDesktopWindows(true).size();
  }
}

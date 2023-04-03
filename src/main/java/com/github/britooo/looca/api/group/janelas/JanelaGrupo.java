package com.github.britooo.looca.api.group.janelas;

import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

import java.util.List;
import java.util.stream.Collectors;

public class JanelaGrupo {

  private final OperatingSystem so;

  public JanelaGrupo(SystemInfo si) {
    this.so = si.getOperatingSystem();
  }

  /**
   * Retorna uma lista de <b>Janelas</b> visíveis e invisíveis abertas no sistema operacional.
   *
   * @return Lista de janelas.
   */
  public List<Janela> getJanelas() {
    return so.getDesktopWindows(false).stream()
        .map(Janela::of)
        .collect(Collectors.toList());
  }

  /**
   * Retorna uma lista de <b>Janelas</b>, apenas com as janelas visíveis no sistema operacional.
   *
   * @return Lista de janelas.
   */
  public List<Janela> getJanelasVisiveis() {
    return so.getDesktopWindows(true).stream()
        .map(Janela::of)
        .collect(Collectors.toList());
  }

  /**
   * Retorna a quantidade total de <b>Janelas</b> visíveis e invisíveis no sistema operacional.
   *
   * @return Total de janelas.
   */
  public Integer getTotalJanelas() {
    return so.getDesktopWindows(false).size();
  }

  /**
   * Retorna a quantidade total de <b>Janelas</b> visíveis no sistema operacional.
   *
   * @return Total de janelas.
   */
  public Integer getTotalJanelasVisiveis() {
    return so.getDesktopWindows(true).size();
  }
}

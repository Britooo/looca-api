package com.github.britooo.looca.api.group.temperatura;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;

public class Temperatura {

  private final HardwareAbstractionLayer hardware;

  public Temperatura() {
    hardware = new SystemInfo().getHardware();
  }

  /**
   * <p>
   *   Retorna a temperatura da CPU em graus Celsius se disponível, caso contrário retorna 0 ou Double.NaN.
   * </p>
   *
   * <p>
   *   No Windows, se não estiver executando o Open Hardware Monitor, 
   *   requer permissões elevadas e BIOS de hardware que ofereça suporte à publicação no WMI. 
   *   Neste caso, retorna a temperatura da "Zona Térmica" que pode ser diferente da temperatura da CPU 
   *   obtida de outras fontes.
   * </p>
   * 
   * <p>
   *   Além disso, algumas placas-mãe só podem atualizar esse valor em determinados eventos.
   * <p>
   * 
   * @return Temperatura em graus Celsius caso disponível
   */
  public Double getTemperatura() {
    return this.hardware.getSensors().getCpuTemperature();
  }

  @Override
  public String toString() {
    return String.format("Temperatura: %.1f", getTemperatura());
  }
}

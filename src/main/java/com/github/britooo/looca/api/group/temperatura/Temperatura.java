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
   * Retorna a <b>temperatura</b> da CPU em <b>graus Celsius</b> se disponível, caso contrário <b>retorna 0 ou Double.NaN</b>.
   * </p>
   *
   * <p>
   * No <b>Windows</b>, se não estiver executando o Open Hardware Monitor,
   * requer permissões elevadas e BIOS de hardware que ofereça suporte à publicação no WMI.
   * Neste caso, retorna a temperatura da "Zona Térmica" que pode ser diferente da temperatura da CPU
   * obtida de outras fontes.
   * </p>
   *
   * <p>
   * Além disso, <b>algumas placas-mãe só podem atualizar esse valor em determinados eventos</b>.
   * <p>
   *
   * @return Temperatura em graus Celsius caso disponível
   */
  public Double getTemperatura() {
    return this.hardware.getSensors().getCpuTemperature();
  }

  /**
   * Retorna uma <code>String</code> com todas as informações relacionadas a <b>Temperatura</b>.
   * @return <code>String</code> com todas as informações relacionadas a <b>Temperatura</b>.
   */
  @Override
  public String toString() {
    return String.format("Temperatura: %.1f", getTemperatura());
  }
}

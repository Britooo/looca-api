package com.github.britooo.looca.api.group.memoria;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import com.github.britooo.looca.api.util.Conversor;

public class Memoria {


  private final HardwareAbstractionLayer hardware = new SystemInfo().getHardware();

  /**
   * Retorna a quantidade de <b>memória física</b> atualmente <b>disponível</b>, <b>em bytes</b>.
   *
   * @return Quantidade de memória física atualmente disponível, <b>em bytes</b>.
   */
  public Long getDisponivel() {
    return this.hardware.getMemory().getAvailable();
  }

  /**
   * Retorna a quantidade de <b>memória física real</b>, <b>em bytes</b>.
   *
   * @return Quantidade de memória física real, <b>em bytes</b>.
   */
  public Long getTotal() {
    return this.hardware.getMemory().getTotal();
  }

  /**
   * Retorna a quantidade de <b>memória em uso</b>, <b>em bytes</b>.
   *
   * @return Quantidade de memória em uso, <b>em bytes</b>.
   */
  public Long getEmUso() {
    return this.getTotal() - this.getDisponivel();
  }

  /**
   * Retorna uma <code>String</code> com todas as informações relacionadas a <b>Memória</b>.
   * @return <code>String</code> com todas as informações relacionadas a <b>Memória</b>.
   */
  @Override
  public String toString() {

    final StringBuilder sb = new StringBuilder("Memoria").append("\n");

    sb.append("Em uso: ")
        .append(Conversor.formatarBytes(getEmUso()))
        .append("\n");

    sb.append("Disponível: ")
        .append(Conversor.formatarBytes(getDisponivel()))
        .append("\n");

    sb.append("Total: ")
        .append(Conversor.formatarBytes(getTotal()))
        .append("\n");

    return sb.toString();
  }

}

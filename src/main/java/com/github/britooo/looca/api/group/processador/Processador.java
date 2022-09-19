package com.github.britooo.looca.api.group.processador;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;

public class Processador {

  private final CentralProcessor processador = new SystemInfo().getHardware().getProcessor();
  private final ProcessadorCacheLoader processadorCacheLoader = new ProcessadorCacheLoader();

  public String getFabricante() {
    return this.processador.getProcessorIdentifier().getVendor();
  }

  public String getNome() {
    return this.processador.getProcessorIdentifier().getName();
  }

  public String getId() {
    return this.processador.getProcessorIdentifier().getProcessorID();
  }

  public String getIdentificador() {
    return this.processador.getProcessorIdentifier().getIdentifier();
  }

  public String getMicroarquitetura() {
    return this.processador.getProcessorIdentifier().getMicroarchitecture();
  }

  public Long getFrequencia() {
    return this.processador.getProcessorIdentifier().getVendorFreq();
  }

  public Integer getNumeroPacotesFisicos() {
    return this.processador.getPhysicalPackageCount();
  }

  public Integer getNumeroCpusFisicas() {
    return this.processador.getPhysicalProcessorCount();
  }

  public Integer getNumeroCpusLogicas() {
    return this.processador.getLogicalProcessorCount();
  }

  public Double getUso() {
    return this.processadorCacheLoader.getUso();
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();

    sb.append("Fabricante: ")
        .append(getFabricante())
        .append("\n");

    sb.append("Nome: ")
        .append(getNome())
        .append("\n");

    sb.append("ID: ")
        .append(getId())
        .append("\n");

    sb.append("Identificador: ")
        .append(getIdentificador())
        .append("\n");

    sb.append("Microarquitetura: ")
        .append(getMicroarquitetura())
        .append("\n");

    sb.append("Frequência: ")
        .append(getFrequencia())
        .append("\n");

    sb.append("Número de Pacotes Físicos: ")
        .append(getNumeroPacotesFisicos())
        .append("\n");

    sb.append("Número de CPUs Fisícas: ")
        .append(getNumeroCpusFisicas())
        .append("\n");

    sb.append("Número de CPUs Lógicas: ")
        .append(getNumeroCpusLogicas())
        .append("\n");

    sb.append("Em Uso: ")
        .append(String.format("%.1f", getUso()))
        .append("\n");

    return sb.toString();
  }
}

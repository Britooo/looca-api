package com.github.britooo.looca.api.group.discos;

import oshi.hardware.HWDiskStore;

public class Disco {

  private final HWDiskStore disco;

  public Disco(HWDiskStore disco) {
    this.disco = disco;
  }

  public String getNome() {
    return disco.getName();
  }

  public String getModelo() {
    return disco.getModel();
  }

  public String getSerial() {
    return disco.getSerial();
  }

  public Long getTamanho() {
    return disco.getSize();
  }

  public Long getLeituras() {
    return disco.getReads();
  }

  public Long getBytesDeLeitura() {
    return disco.getReadBytes();
  }

  public Long getEscritas() {
    return disco.getWrites();
  }

  public Long getBytesDeEscritas() {
    return disco.getWriteBytes();
  }

  public Long getTamanhoAtualDaFila() {
    return disco.getCurrentQueueLength();
  }

  public Long getTempoDeTransferencia() {
    return disco.getTransferTime();
  }

  @Override
  public String toString() {

    StringBuilder sb = new StringBuilder();

    sb.append("\nNome: ")
        .append(getNome())
        .append("\n");

    sb.append("Modelo: ")
        .append(getModelo())
        .append("\n");

    sb.append("Serial: ")
        .append(getSerial())
        .append("\n");

    sb.append("Tamanho: ")
        .append(getTamanho())
        .append("\n");

    sb.append("Leituras: ")
        .append(getLeituras())
        .append("\n");

    sb.append("Bytes de leitura: ")
        .append(getBytesDeLeitura())
        .append("\n");

    sb.append("Escritas: ")
        .append(getEscritas())
        .append("\n");

    sb.append("Bytes de escritas: ")
        .append(getBytesDeEscritas())
        .append("\n");

    sb.append("Tamanho atual da fila: ")
        .append(getTamanhoAtualDaFila())
        .append("\n");

    sb.append("Tempo de transferência: ")
        .append(getTempoDeTransferencia())
        .append("\n");

    return sb.toString();
  }
}

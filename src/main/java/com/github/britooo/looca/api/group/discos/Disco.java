package com.github.britooo.looca.api.group.discos;

import oshi.hardware.HWDiskStore;

public class Disco {

  private final HWDiskStore disco;

  public Disco(HWDiskStore disco) {
    this.disco = disco;
  }

  /**
   * <b>Retorna o nome do disco.</b>
   *
   * @return Nome do disco.
   */
  public String getNome() {
    return disco.getName();
  }

  /**
   * <b>Retorna o modelo do disco.</b>
   *
   * @return Modelo do disco.
   */
  public String getModelo() {
    return disco.getModel();
  }

  /**
   * <b>Retorna o número do serial do disco, se disponível.</b>
   *
   * @return Número serial do disco, se disponível.
   */
  public String getSerial() {
    return disco.getSerial();
  }

  /**
   * <b>Retorna o tamanho do disco em bytes.</b>
   *
   * @return Tamanho do disco em bytes.
   */
  public Long getTamanho() {
    return disco.getSize();
  }

  /**
   * <b>Retorna o número de leituras do disco.</b>
   *
   * @return Número de leituras do disco.
   */
  public Long getLeituras() {
    return disco.getReads();
  }

  /**
   * <b>Retorna o número de bytes lidos pelo disco.</b>
   *
   * @return Número de bytes lidos pelo disco.
   */
  public Long getBytesDeLeitura() {
    return disco.getReadBytes();
  }

  /**
   * <b>Retorna o número de escritas no disco.</b>
   *
   * @return Número de escritas no disco.
   */
  public Long getEscritas() {
    return disco.getWrites();
  }

  /**
   * <b>Retorna o número de bytes escritos no disco.</b>
   *
   * @return Número de bytes escritos no disco.
   */
  public Long getBytesDeEscritas() {
    return disco.getWriteBytes();
  }

  /**
   * <p><b>Retorna o comprimento da fila de disco (E/S's em andamento).</b></p>
   * <br/>
   * <p>Inclui solicitações de E/S que foram emitidas para o driver de dispositivo,
   * mas ainda não foram concluídas. Não compatível com macOS.</p>
   *
   * @return Comprimento da fila de disco (E/S's em andamento).
   */
  public Long getTamanhoAtualDaFila() {
    return disco.getCurrentQueueLength();
  }

  /**
   * <b>Retorna o tempo gasto lendo ou escrevendo no disco, em milissegundos.</b>
   *
   * @return Tempo gasto lendo ou escrevendo no disco, em milissegundos.
   */

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

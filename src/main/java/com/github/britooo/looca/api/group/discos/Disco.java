package com.github.britooo.looca.api.group.discos;

import oshi.hardware.HWDiskStore;

public class Disco {

  private final HWDiskStore disco;

  public Disco(HWDiskStore disco) {
    this.disco = disco;
  }

  /**
   * Retorna o <b>nome</b> do disco.
   *
   * @return Nome do disco.
   */
  public String getNome() {
    return disco.getName();
  }

  /**
   * Retorna o <b>modelo</b> do disco.
   *
   * @return Modelo do disco.
   */
  public String getModelo() {
    return disco.getModel();
  }

  /**
   * Retorna o <b>número do serial</b> do disco, <b>se disponível</b>.
   *
   * @return Número serial do disco, se disponível.
   */
  public String getSerial() {
    return disco.getSerial();
  }

  /**
   * Retorna o <b>tamanho</b> do disco em <b>bytes</b>.
   *
   * @return Tamanho do disco em <b>bytes</b>.
   */
  public Long getTamanho() {
    return disco.getSize();
  }

  /**
   * Retorna o <b>número de leituras</b> do disco.
   *
   * @return Número de leituras do disco.
   */
  public Long getLeituras() {
    return disco.getReads();
  }

  /**
   * Retorna o <b>número de bytes lidos</b> pelo disco.
   *
   * @return Número de bytes lidos pelo disco.
   */
  public Long getBytesDeLeitura() {
    return disco.getReadBytes();
  }

  /**
   * Retorna o <b>número de escritas</b> no disco.
   *
   * @return Número de escritas no disco.
   */
  public Long getEscritas() {
    return disco.getWrites();
  }

  /**
   * Retorna o <b>número de bytes escritos</b> no disco.
   *
   * @return Número de bytes escritos no disco.
   */
  public Long getBytesDeEscritas() {
    return disco.getWriteBytes();
  }

  /**
   * <p>Retorna o <b>comprimento da fila</b> de disco (E/S's em andamento).</p>
   * <br>
   * <p>Inclui solicitações de E/S que foram emitidas para o driver de dispositivo,
   * mas ainda não foram concluídas. <b>Não compatível com macOS</b>.</p>
   *
   * @return Comprimento da fila de disco (E/S's em andamento).
   */
  public Long getTamanhoAtualDaFila() {
    return disco.getCurrentQueueLength();
  }

  /**
   * Retorna o <b>tempo gasto lendo ou escrevendo</b> no disco, em <b>milissegundos</b>.
   *
   * @return Tempo gasto lendo ou escrevendo no disco, em <b>milissegundos</b>.
   */

  public Long getTempoDeTransferencia() {
    return disco.getTransferTime();
  }


  /**
   * Retorna uma <code>String</code> com todas as informações relacionadas ao <b>Disco</b>.
   * @return <code>String</code> com todas as informações relacionadas ao <b>Disco</b>.
   */
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

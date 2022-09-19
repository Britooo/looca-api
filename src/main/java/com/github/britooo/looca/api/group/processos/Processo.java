package com.github.britooo.looca.api.group.processos;

import oshi.software.os.OSProcess;
import com.github.britooo.looca.api.group.memoria.Memoria;

public class Processo {

  private final OSProcess processo;
  private final Memoria memoria;

  public Processo(OSProcess processo, Memoria memoria) {
    this.processo = processo;
    this.memoria = memoria;
  }

  public Integer getPid() {
    return this.processo.getProcessID();
  }

  public String getNome() {
    return this.processo.getName();
  }

  public Double getUsoCpu() {
    return (100d * (processo.getKernelTime() + processo.getUserTime()) / processo.getUpTime());
  }

  public Double getUsoMemoria() {
    return (100d * processo.getResidentSetSize() / memoria.getTotal());
  }

  public Long getBytesUtilizados() {
    return processo.getResidentSetSize();
  }

  public Long getMemoriaVirtualUtilizada() {
    return processo.getVirtualSize();
  }

  @Override
  public String toString() {

    final StringBuilder sb = new StringBuilder();

    sb.append("PID: ").append(getPid())
        .append("\n");

    sb.append("Uso CPU: ")
        .append(String.format("%.1f", getUsoCpu()))
        .append("\n");

    sb.append("Uso memória: ")
        .append(String.format("%.1f", getUsoMemoria()))
        .append("\n");

    sb.append("Bytes utilizados: ")
        .append(getBytesUtilizados())
        .append("\n");

    sb.append("Memória virtual utilizada: ")
        .append(getMemoriaVirtualUtilizada())
        .append("\n");

    return sb.toString();
  }
}

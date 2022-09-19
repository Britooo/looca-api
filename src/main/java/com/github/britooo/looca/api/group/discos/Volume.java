package com.github.britooo.looca.api.group.discos;

import oshi.software.os.OSFileStore;

public class Volume {

  private final OSFileStore volume;

  public Volume(OSFileStore volume) {
    this.volume = volume;
  }

  public String getUUID() {
    return this.volume.getUUID();
  }

  public Long getTotal() {
    return this.volume.getTotalSpace();
  }

  public Long getDisponivel() {
    return this.volume.getFreeSpace();
  }

  public String getTipo() {
    return this.volume.getType();
  }

  public String getPontoDeMontagem() {
    return this.volume.getMount();
  }

  @Override
  public String toString() {

    StringBuilder str = new StringBuilder();

    str.append("UUID: ").append(this.getUUID()).append("\n");
    str.append("total: ").append(this.getTotal()).append("\n");
    str.append("disponível: ").append(this.getDisponivel()).append("\n");
    str.append("tipo: ").append(this.getTipo()).append("\n");
    str.append("ponto de montagem: ").append(this.getPontoDeMontagem()).append("\n");

    return str.toString();
  }
}

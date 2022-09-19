package com.github.britooo.looca.api.group.discos;

import java.util.List;
import java.util.stream.Collectors;

import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;

public class DiscoGrupo {

  private SystemInfo system = new SystemInfo();
  private final OperatingSystem os = system.getOperatingSystem();
  private final HardwareAbstractionLayer hal = system.getHardware();

  public List<Volume> getVolumes() {
    return this.os.getFileSystem().getFileStores()
        .stream()
        .map(DiscoGrupo::of)
        .collect(Collectors.toList());
  }

  public List<Disco> getDiscos() {
    return this.hal.getDiskStores().stream()
        .map(DiscoGrupo::of)
        .collect(Collectors.toList());
  }

  public Long getTamanhoTotal() {
    return this.getDiscos().stream()
        .mapToLong(Disco::getTamanho).sum();
  }

  public Integer getQuantidadeDeDiscos() {
    return this.getDiscos().size();
  }

  public Integer getQuantidadeDeVolumes() {
    return this.getVolumes().size();
  }

  private static Volume of(OSFileStore volume) {
    if (volume == null) {
      return null;
    }

    return new Volume(volume);
  }

  private static Disco of(HWDiskStore disco) {
    if (disco == null) {
      return null;
    }

    return new Disco(disco);
  }
}

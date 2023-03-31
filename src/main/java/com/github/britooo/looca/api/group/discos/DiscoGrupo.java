package com.github.britooo.looca.api.group.discos;

import java.util.List;
import java.util.stream.Collectors;

import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;

public class DiscoGrupo {

  private final SystemInfo system = new SystemInfo();
  private final OperatingSystem os = system.getOperatingSystem();
  private final HardwareAbstractionLayer hal = system.getHardware();

  /**
   * Retorna uma <b>lista de <code>Volume</code></b>.
   *
   * @return Lista de Volume.
   */
  public List<Volume> getVolumes() {
    return this.os.getFileSystem()
        .getFileStores()
        .stream()
        .map(DiscoGrupo::of)
        .collect(Collectors.toList());
  }

  /**
   * Retorna uma <b>lista de <code>Disco</code></b>.
   *
   * @return Lista de Disco.
   */
  public List<Disco> getDiscos() {
    return this.hal.getDiskStores().stream()
        .map(DiscoGrupo::of)
        .collect(Collectors.toList());
  }

  /**
   * Retorna o <b>tamanho dos discos somados</b> em <b>bytes</b>.
   *
   * @return Tamanho dos discos somados em <b>bytes</b>.
   */
  public Long getTamanhoTotal() {
    return this.getDiscos().stream()
        .mapToLong(Disco::getTamanho).sum();
  }

  /**
   * Retorna a <b>quantidade de discos existentes</b> citados na lista de discos <b>(Contagem total de discos)</b>.
   *
   * @return Soma total de discos.
   */
  public Integer getQuantidadeDeDiscos() {
    return this.getDiscos().size();
  }

  /**
   * Retorna a <b>quantidade de volumes existentes</b> citados na lista de volumes <b>(Contagem total de volumes)</b>.
   *
   * @return Soma total de volumes.
   */
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

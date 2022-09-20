package com.github.britooo.looca.api.group.discos;

import java.util.List;
import java.util.stream.Collectors;

import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;

public class DiscosGroup {

    private SystemInfo system = new SystemInfo();
    private final OperatingSystem os = system.getOperatingSystem();
    private final HardwareAbstractionLayer hal = system.getHardware();

    /**
     * <b>Retorna uma lista de <code>Volume</code>.</b>
     * @return Lista de Volume.
     */
    public List<Volume> getVolumes() {
        return this.os.getFileSystem().getFileStores()
                .stream()
                .map(DiscosGroup::of)
                .collect(Collectors.toList());
    }

    /**
     * <b>Retorna uma lista de <code>Disco</code>.</b>
     * @return Lista de Disco.
     */
    public List<Disco> getDiscos() {
        return this.hal.getDiskStores().stream()
                .map(DiscosGroup::of)
                .collect(Collectors.toList());
    }

    /**
     * <b>Retorna o tamanho dos discos somados em bytes.</b>
     * @return Tamanho dos discos somados em bytes.
     */
    public Long getTamanhoTotal() {
        return this.getDiscos().stream()
                .mapToLong(disco -> disco.getTamanho()).sum();
    }

    /**
     * <b>Retorna a quantidade de discos existentes citados na lista de discos (Contagem total de discos).</b>
     * @return Soma total de discos.
     */
    public Integer getQuantidadeDeDiscos() {
        return this.getDiscos().size();
    }

    /**
     * <b>Retorna a quantidade de volumes existentes citados na lista de volumes (Contagem total de volumes).</b>
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

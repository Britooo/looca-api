package com.github.britooo.looca.api.group.discos;

import oshi.software.os.OSFileStore;

public class Volume {

    private final OSFileStore volume;

    public Volume(OSFileStore volume) {
        this.volume = volume;
    }

    /**
     * <b>Retorna o UUID/GUID do sistema de arquivos.</b>
     * @return UUID/GUID do sistema de arquivos.
     */
    public String getUUID() {
        return this.volume.getUUID();
    }

    /**
     * <b>Retorna espaço/capacidade total da unidade (Em bytes).</b>
     * @return Espaço/capacidade total da unidade (Em bytes).
     */
    public Long getTotal() {
        return this.volume.getTotalSpace();
    }

    /**
     * <p><b>Retorna o espaço livre na unidade.</b></p>
     * <br/>
     * <p>Esse espaço não é alocado, mas pode exigir permissões elevadas para gravação (Em bytes).</p>
     * @return Espaço livre na unidade (Em bytes).
     */
    public Long getDisponivel() {
        return this.volume.getFreeSpace();
    }

    /**
     * <b>Retorna o tipo do sistema de arquivos <i>(FAT, NTFS, etx2, ext4, etc...)</i>.</b>
     * @return sistema de arquivos (FAT, NTFS, etx2, ext4, etc...).
     */
    public String getTipo() {
        return this.volume.getType();
    }

    /**
     * <p><b>Retorna o ponto de montagem do sistema de arquivos.</b></p>
     * <br/>
     * <p>O diretório que os usuários normalmente usarão para interagir com o armazenamento de arquivos.
     * <i>(Exemplo C: no Windows ou / no Linux)</i>.</p>
     * @return Ponto de montagem do sistema de arquivos.
     */
    public String getPontoDeMontagem() {
        return this.volume.getMount();
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();

        str.append("UUID: " + this.getUUID() + "\n");
        str.append("total: " + this.getTotal() + "\n");
        str.append("disponível: " + this.getDisponivel() + "\n");
        str.append("tipo: " + this.getTipo() + "\n");
        str.append("ponto de montagem: " + this.getPontoDeMontagem() + "\n");

        return str.toString();
    }
}

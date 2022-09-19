package com.github.britooo.looca.api.group.discos;

import oshi.software.os.OSFileStore;

public class Volume {

    private final OSFileStore volume;

    public Volume(OSFileStore volume) {
        this.volume = volume;
    }

    /**
     * Retorna o UUID/GUID do sistema de arquivos.
     * @return UUID/GUID do sistema de arquivos.
     */
    public String getUUID() {
        return this.volume.getUUID();
    }

    /**
     * Retorna espaço/capacidade total da unidade (Em bytes).
     * @return Espaço/capacidade total da unidade (Em bytes).
     */
    public Long getTotal() {
        return this.volume.getTotalSpace();
    }

    /**
     * Retorna o espaço livre na unidade.
     * Esse espaço não é alocado, mas pode exigir permissões elevadas para gravação (Em bytes).
     * @return Espaço livre na unidade (Em bytes).
     */
    public Long getDisponivel() {
        return this.volume.getFreeSpace();
    }

    /**
     * Retorna o tipo do sistema de arquivos (FAT, NTFS, etx2, ext4, etc...).
     * @return sistema de arquivos (FAT, NTFS, etx2, ext4, etc...).
     */
    public String getTipo() {
        return this.volume.getType();
    }

    /**
     * Retorna o ponto de montagem do sistema de arquivos.
     * O diretório que os usuários normalmente usarão para interagir com o armazenamento de arquivos.
     * (Exemplo C: no Windows ou / no Linux).
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

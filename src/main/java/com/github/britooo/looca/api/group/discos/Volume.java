package com.github.britooo.looca.api.group.discos;

import oshi.software.os.OSFileStore;

public class Volume {

  private final OSFileStore volume;

  public Volume(OSFileStore volume) {
    this.volume = volume;
  }


  /**
   * <b>Retorna o UUID/GUID do sistema de arquivos.</b>
   *
   * @return UUID/GUID do sistema de arquivos.
   */
  public String getUUID() {
    return this.volume.getUUID();
  }

  /**
   * <p>
   *  Nome do sistema de arquivos. Um identificador legível que não necessariamente corresponde
   *  a um caminho no sistema de arquivos.
   * </p>
   * 
   * @return Nome do sistema de arquivos
   */
  public String getNome() {
    return this.volume.getName();
  }

  /**
   * <p>
   *  Nome do volume do sistema de arquivos. Geralmente um caminho que representa o dispositivo
   *  (ex: /dev/foo) que foi montado.
   * </p>
   * 
   * @return Nome do volume do sistema de arquivos
   */
  public String getVolume() {
    return this.volume.getVolume();
  }

  /**
   * <b>Retorna espaço/capacidade total da unidade (Em bytes).</b>
   *
   * @return Espaço/capacidade total da unidade (Em bytes).
   */
  public Long getTotal() {
    return this.volume.getTotalSpace();
  }

  /**
   * <p><b>Retorna o espaço livre na unidade.</b></p>
   * <br>
   * <p>Esse espaço não é alocado, mas pode exigir permissões elevadas para gravação (Em bytes).</p>
   *
   * @return Espaço livre na unidade (Em bytes).
   */
  public Long getDisponivel() {
    return this.volume.getFreeSpace();
  }

  /**
   * <b>Retorna o tipo do sistema de arquivos <i>(FAT, NTFS, etx2, ext4, etc...)</i>.</b>
   *
   * @return sistema de arquivos (FAT, NTFS, etx2, ext4, etc...).
   */
  public String getTipo() {
    return this.volume.getType();
  }

  /**
   * <p><b>Retorna o ponto de montagem do sistema de arquivos.</b></p>
   * <br>
   * <p>O diretório que os usuários normalmente usarão para interagir com o armazenamento de arquivos.
   * <i>(Exemplo C: no Windows ou / no Linux)</i>.</p>
   *
   * @return Ponto de montagem do sistema de arquivos.
   */
  public String getPontoDeMontagem() {
    return this.volume.getMount();
  }


  @Override
  public String toString() {

    StringBuilder str = new StringBuilder();

    str.append("UUID: ").append(this.getUUID()).append("\n");
    str.append("nome: ").append(this.getNome()).append("\n");
    str.append("volume: ").append(this.getVolume()).append("\n");
    str.append("total: ").append(this.getTotal()).append("\n");
    str.append("disponível: ").append(this.getDisponivel()).append("\n");
    str.append("tipo: ").append(this.getTipo()).append("\n");
    str.append("ponto de montagem: ").append(this.getPontoDeMontagem()).append("\n");


    return str.toString();
  }
}

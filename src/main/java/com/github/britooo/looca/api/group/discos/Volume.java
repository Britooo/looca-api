package com.github.britooo.looca.api.group.discos;

import oshi.software.os.OSFileStore;

public class Volume {

  private final OSFileStore volume;

  public Volume(OSFileStore volume) {
    this.volume = volume;
  }


  /**
   * Retorna o <b>UUID/GUID</b> do sistema de arquivos.
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
   * @return Espaço/capacidade total da unidade <b>(Em bytes)</b>.
   */
  public Long getTotal() {
    return this.volume.getTotalSpace();
  }

  /**
   * <p>Retorna o <b>espaço livre</b> na unidade.</p>
   * <br>
   * <p>Esse espaço não é alocado, mas pode exigir permissões elevadas para gravação <b>(Em bytes)</b>.</p>
   *
   * @return Espaço livre na unidade <b>(Em bytes)</b>.
   */
  public Long getDisponivel() {
    return this.volume.getFreeSpace();
  }

  /**
   * Retorna o tipo do <b>sistema de arquivos</b> <i>(FAT, NTFS, etx2, ext4, etc...)</i>.
   *
   * @return sistema de arquivos (FAT, NTFS, etx2, ext4, etc...).
   */
  public String getTipo() {
    return this.volume.getType();
  }

  /**
   * <p>Retorna o <b>ponto de montagem</b> do sistema de arquivos.</p>
   * <br>
   * <p>O diretório que os usuários normalmente usarão para interagir com o armazenamento de arquivos.
   * <i>(Exemplo C: no Windows ou / no Linux)</i>.</p>
   *
   * @return Ponto de montagem do sistema de arquivos.
   */
  public String getPontoDeMontagem() {
    return this.volume.getMount();
  }


  /**
   * Retorna uma <code>String</code> com todas as informações relacionadas ao <b>Volume</b>.
   * @return <code>String</code> com todas as informações relacionadas ao <b>Volume</b>.
   */
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

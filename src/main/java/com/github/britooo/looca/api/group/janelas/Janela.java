package com.github.britooo.looca.api.group.janelas;

import oshi.software.os.OSDesktopWindow;

import java.awt.*;

public class Janela {

  private final OSDesktopWindow janela;

  public Janela(OSDesktopWindow janela) {
    this.janela = janela;
  }

  public static Janela of(OSDesktopWindow janela) {
    if (janela == null) {
      return null;
    }

    return new Janela(janela);
  }

  /**
   * Retorna o <b>ID do processo</b> do qual essa janela pertence.
   *
   * @return ID do processo.
   */
  public Long getPid() {
    return this.janela.getOwningProcessId();
  }

  /**
   * Retorna o identificador do sistema operacional, ID da janela ou outro identificador exclusivo para esta janela.
   *
   * @return Identificador da janela.
   */
  public Long getJanelaId() {
    return this.janela.getWindowId();
  }

  /**
   * Retorna o <b>título da janela</b> se existir.
   *
   * @return Título da janela.
   */
  public String getTitulo() {
    return this.janela.getTitle();
  }

  /**
   * Retorna o <b>nome do comando</b> (possivelmente o caminho completo do arquivo) do programa executável da janela,
   * se conhecido.
   *
   * @return Comando do programa executável ou caminho do arquivo executável.
   */
  public String getComando() {
    return this.janela.getCommand();
  }

  /**
   * Retorna um <b>Objeto {@link Rectangle}</b> que representa a localização e o tamanho da janela.
   *
   * @return Localização e tamanho da janela.
   * @see Rectangle
   */
  public Rectangle getLocalizacaoETamanho() {
    return this.janela.getLocAndSize();
  }

  /**
   * Retorna se a janela está visível para o usuário.
   *
   * @return <code>true</code> se a janela está visível para o usuário, caso contrário <code>false</code>.
   */
  public Boolean isVisivel() {
    return this.janela.isVisible();
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("\n");
    sb.append("PID: ").append(getPid()).append("\n");
    sb.append("Id da janela: ").append(getJanelaId()).append("\n");
    sb.append("Título: ").append(getTitulo()).append("\n");
    sb.append("Comando: ").append(getComando()).append("\n");
    sb.append("Localização: ").append(getLocalizacaoETamanho()).append("\n");
    sb.append("Visível: ").append(isVisivel()).append("\n");
    return sb.toString();
  }
}

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

  public Long getPid() {
    return this.janela.getOwningProcessId();
  }

  public Long getJanelaId() {
    return this.janela.getWindowId();
  }

  public String getTitulo() {
    return this.janela.getTitle();
  }

  public String getComando() {
    return this.janela.getCommand();
  }

  public Rectangle getLocalizacaoETamanho() {
    return this.janela.getLocAndSize();
  }

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

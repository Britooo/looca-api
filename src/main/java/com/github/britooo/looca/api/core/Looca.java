package com.github.britooo.looca.api.core;

import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.servicos.ServicoGrupo;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.temperatura.Temperatura;

public class Looca {

  private final Sistema sistema;
  private final Memoria memoria;
  private final Processador processador;
  private final Temperatura temperatura;
  private final DiscoGrupo grupoDeDiscos;
  private final ServicoGrupo grupoDeServicos;
  private final ProcessoGrupo grupoDeProcessos;

  public Looca() {
    this.sistema = new Sistema();
    this.memoria = new Memoria();
    this.processador = new Processador();
    this.temperatura = new Temperatura();
    this.grupoDeDiscos = new DiscoGrupo();
    this.grupoDeServicos = new ServicoGrupo();
    this.grupoDeProcessos = new ProcessoGrupo();
  }

  public Sistema getSistema() {
    return sistema;
  }

  public Memoria getMemoria() {
    return memoria;
  }

  public Processador getProcessador() {
    return processador;
  }

  public Temperatura getTemperatura() {
    return temperatura;
  }

  public DiscoGrupo getGrupoDeDiscos() {
    return grupoDeDiscos;
  }

  public ServicoGrupo getGrupoDeServicos() {
    return grupoDeServicos;
  }

  public ProcessoGrupo getGrupoDeProcessos() {
    return grupoDeProcessos;
  }
}

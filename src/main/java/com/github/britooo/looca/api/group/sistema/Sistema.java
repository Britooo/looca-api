package com.github.britooo.looca.api.group.sistema;

import oshi.SystemInfo;

import java.time.Instant;

import oshi.software.os.OperatingSystem;
import com.github.britooo.looca.api.util.Conversor;

public class Sistema {

  private final OperatingSystem os;
  private final String fabricante;
  private final Integer arquitetura;
  private final String sistemaOperacional;

  public Sistema() {
    os = new SystemInfo().getOperatingSystem();
    this.arquitetura = this.os.getBitness();
    this.fabricante = this.os.getManufacturer();
    this.sistemaOperacional = this.os.getFamily();
  }

  /**
   * Retorna o <b>Sistema Operacional</b>.
   *
   * @return Sistema Operacional.
   */
  public String getSistemaOperacional() {
    return sistemaOperacional;
  }

  /**
   * Retorna a <b>empresa fabricante</b> do sistema operacional.
   *
   * @return Fabricante do sitema operacional.
   */
  public String getFabricante() {
    return fabricante;
  }

  /**
   * Retorna o número de <b>bits</b> <i>(32 ou 64)</i> do sistema operacional.
   *
   * @return Número de <b>bits</b> do sistema operacional.
   */
  public Integer getArquitetura() {
    return arquitetura;
  }

  /**
   * Retorna o <b>momento</b> em que o sistema operacional foi <b>inicializado</b>.
   *
   * @return Data aproximada da inicialização do sistema operacional.
   */
  public Instant getInicializado() {
    return Instant.ofEpochSecond(this.os.getSystemBootTime());
  }

  /**
   * Retorna o <b>tempo de funcionamento</b> do sistema <b>(tempo desde a inicialização)</b>.
   *
   * @return Quantidade de <b>segundos</b> desde a inicialização.
   */
  public Long getTempoDeAtividade() {
    return this.os.getSystemUptime();
  }

  /**
   * Retorna <b><code>True</code></b> caso o processo atual tem <b>permissões elevadas</b>, como <i>sudo/Administrador</i>.
   *
   * @return <code>True</code> se este processo tiver permissões elevadas.
   */
  public Boolean getPermissao() {
    return this.os.isElevated();
  }

  /**
   * Retorna uma <code>String</code> com todas as informações relacionadas ao <b>Sistema Operacional</b>.
   * @return <code>String</code> que contém todas as informações relacionadas ao <b>Sistema Operacional</b>.
   */
  @Override
  public String toString() {

    final StringBuilder sb = new StringBuilder();

    sb.append("Sistema operacional: ")
        .append(sistemaOperacional)
        .append("\n");

    sb.append("Fabricante: ")
        .append(fabricante)
        .append("\n");

    sb.append("Arquitetura: ")
        .append(arquitetura)
        .append("bits\n");

    sb.append("Inicializado: ")
        .append(getInicializado())
        .append("\n");

    sb.append("Tempo de atividade: ")
        .append(Conversor.formatarSegundosDecorridos(this.getTempoDeAtividade()))
        .append("\n");

    sb.append("Permissões: ")
        .append(("Executando como "))
        .append((this.getPermissao() ? "root" : "usuário padrão"))
        .append("\n");

    return sb.toString();
  }
}

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
   * Obtém o número de bits (32 ou 64) do sistema operacional.
   *
   * @return Arquitetura bits.
   */
  public String getSistemaOperacional() {
    return sistemaOperacional;
  }

  /**
   * Retorna a empresa fabricante do sistema operacional.
   *
   * @return Fabricante do sitema operacional.
   */
  public String getFabricante() {
    return fabricante;
  }

  /**
   * Retorna o número de bits (32 ou 64) do sistema operacional.
   *
   * @return Número de bits do sistema operacional.
   */
  public Integer getArquitetura() {
    return arquitetura;
  }

  /**
   * Retorna o momento em que o sistema operacional foi inicializado.
   *
   * @return Tempo aproximado de inicialização do sistema em segundos desde o início da contagem Unix em 1° de Janeiro de 1970 UTC.
   */
  public Instant getInicializado() {
    return Instant.ofEpochSecond(this.os.getSystemBootTime());
  }

  /**
   * Retorna o tempo de funcionamento do sistema (tempo desde a inicialização).
   *
   * @return Quantidade de segundos desde a inicialização.
   */
  public Long getTempoDeAtividade() {
    return this.os.getSystemUptime();
  }

  /**
   * Retorna verdadeiro caso o processo atual tem permissões elevadas, como sudo/Administrador
   *
   * @return <code>True</code> se este processo tiver permissões elevadas
   */
  public Boolean getPermissao() {
    return this.os.isElevated();
  }

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

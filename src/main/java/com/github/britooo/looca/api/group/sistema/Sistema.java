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

  public String getSistemaOperacional() {
    return sistemaOperacional;
  }

  public String getFabricante() {
    return fabricante;
  }

  public Integer getArquitetura() {
    return arquitetura;
  }

  public Instant getInicializado() {
    return Instant.ofEpochSecond(this.os.getSystemBootTime());
  }

  public Long getTempoDeAtividade() {
    return this.os.getSystemUptime();
  }

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

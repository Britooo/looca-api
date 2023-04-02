package com.github.britooo.looca.api.group.rede;

import oshi.SystemInfo;
import oshi.software.os.NetworkParams;

import java.util.Arrays;
import java.util.List;

public class RedeParametros {

  private final NetworkParams parametrosRede;

  public RedeParametros(SystemInfo si) {
    this.parametrosRede = si.getOperatingSystem().getNetworkParams();
  }

  /**
   * Retorna o <b>hostname</b> do computador.
   *
   * @return Hostname.
   */
  public String getHostName() {
    return this.parametrosRede.getHostName();
  }

  /**
   * Retorna o <b>nome de domínio</b> do computador.
   *
   * @return Nome de domínio.
   */
  public String getNomeDeDominio() {
    return this.parametrosRede.getDomainName();
  }

  /**
   * Retorna uma lista de <b>IPs</b> dos <b>servidores DNS</b> disponíveis.
   *
   * @return IPs dos servidores DNS.
   */
  public List<String> getServidoresDns() {
    return Arrays.asList(this.parametrosRede.getDnsServers());
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("\n");
    sb.append("Hostname: ").append(getHostName()).append("\n");
    sb.append("Nome de domínio: ").append(getNomeDeDominio()).append("\n");
    sb.append("Servidores DNS: ").append(getServidoresDns()).append("\n");
    return sb.toString();
  }
}

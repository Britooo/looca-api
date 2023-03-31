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

  public String getHostName() {
    return this.parametrosRede.getHostName();
  }

  public String getNomeDeDominio() {
    return this.parametrosRede.getDomainName();
  }

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

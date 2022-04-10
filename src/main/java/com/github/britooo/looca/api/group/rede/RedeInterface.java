package com.github.britooo.looca.api.group.rede;

import oshi.hardware.NetworkIF;

import java.util.Arrays;
import java.util.List;

public class RedeInterface {

  private final NetworkIF redeInterface;

  public RedeInterface(NetworkIF redeInterface) {
    this.redeInterface = redeInterface;
  }

  public static RedeInterface of(NetworkIF redeInterface) {
    if (redeInterface == null) {
      return null;
    }

    return new RedeInterface(redeInterface);
  }

  public String getNome() {
    return this.redeInterface.getName();
  }

  public String getNomeExibicao() {
    return this.redeInterface.getDisplayName();
  }

  public List<String> getEnderecoIpv4() {
    return Arrays.asList(this.redeInterface.getIPv4addr());
  }

  public List<String> getEnderecoIpv6() {
    return Arrays.asList(this.redeInterface.getIPv6addr());
  }

  public String getEnderecoMac() {
    return this.redeInterface.getMacaddr();
  }

  public Long getBytesRecebidos() {
    this.redeInterface.updateAttributes();
    return this.redeInterface.getBytesRecv();
  }

  public Long getBytesEnviados() {
    this.redeInterface.updateAttributes();
    return this.redeInterface.getBytesSent();
  }

  public Long getPacotesRecebidos() {
    return this.redeInterface.getPacketsRecv();
  }

  public Long getPacotesEnviados() {
    return this.redeInterface.getPacketsSent();
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("\n");
    sb.append("Nome: ").append(getNome()).append("\n");
    sb.append("Nome de Exibição: ").append(getNomeExibicao()).append("\n");
    sb.append("Endereço IPv4: ").append(getEnderecoIpv4()).append("\n");
    sb.append("Endereço IPv6: ").append(getEnderecoIpv6()).append("\n");
    sb.append("Endereço MAC: ").append(getEnderecoMac()).append("\n");
    sb.append("Bytes recebidos: ").append(getBytesRecebidos()).append("\n");
    sb.append("Bytes enviados: ").append(getBytesEnviados()).append("\n");
    sb.append("Pacotes recebidos: ").append(getPacotesRecebidos()).append("\n");
    sb.append("Pacotes enviados: ").append(getPacotesEnviados()).append("\n");
    return sb.toString();
  }
}

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

  /**
   * Retorna o <b>nome</b> da interface de rede.
   *
   * @return Nome da interface de rede.
   */
  public String getNome() {
    return this.redeInterface.getName();
  }

  /**
   * Retorna a <b>descrição</b> da interface de rede.
   *
   * @return Descrição da interface.
   */
  public String getNomeExibicao() {
    return this.redeInterface.getDisplayName();
  }

  /**
   * Retorna uma lista com os <b>endereços de IP (v4)</b> relacionados com essa interface de rede.
   *
   * @return Lista de endereços de IP
   */
  public List<String> getEnderecoIpv4() {
    return Arrays.asList(this.redeInterface.getIPv4addr());
  }

  /**
   * Retorna uma lista com os <b>endereços de IP (v6)</b> relacionados com essa interface de rede.
   *
   * @return Lista de endereços de IP
   */
  public List<String> getEnderecoIpv6() {
    return Arrays.asList(this.redeInterface.getIPv6addr());
  }

  /**
   * Retorna o <b>endereço MAC</b> da interface de rede.
   *
   * @return MAC address.
   */
  public String getEnderecoMac() {
    return this.redeInterface.getMacaddr();
  }

  /**
   * Retorna o total de <b>bytes recebidos</b> pela interface de rede.
   *
   * @return Total de bytes recebidos
   */
  public Long getBytesRecebidos() {
    this.redeInterface.updateAttributes();
    return this.redeInterface.getBytesRecv();
  }

  /**
   * Retorna o total de <b>bytes enviados</b> pela interface de rede.
   *
   * @return Total de bytes enviados
   */
  public Long getBytesEnviados() {
    this.redeInterface.updateAttributes();
    return this.redeInterface.getBytesSent();
  }

  /**
   * Retorna o total de <b>pacotes recebidos</b> pela interface de rede.
   *
   * @return Total de pacotes recebidos
   */
  public Long getPacotesRecebidos() {
    return this.redeInterface.getPacketsRecv();
  }

  /**
   * Retorna o total de <b>pacotes enviados</b> pela interface de rede.
   *
   * @return Total de pacotes enviados
   */
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

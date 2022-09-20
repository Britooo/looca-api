package com.github.britooo.looca.api.group.memoria;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import com.github.britooo.looca.api.util.Conversor;

public class Memoria {


    private final HardwareAbstractionLayer hardware = new SystemInfo().getHardware();

    /**
     * <b>Retorna a quantidade de memória física atualmente disponível, em bytes.</b>
     * @return Quantidade de memória física atualmente disponível, em bytes.
     */
    public Long getDisponivel() {
        return this.hardware.getMemory().getAvailable();
    }

    /**
     * <b>Retorna a quantidade de memória física real, em bytes.</b>
     * @return Quantidade de memória física real, em bytes.
     */
    public Long getTotal() {
        return this.hardware.getMemory().getTotal();
    }

    /**
     * <b>Retorna a quantidade de memória em uso, em bytes.</b>
     * @return Quantidade de memória em uso, em bytes.
     */
    public Long getEmUso() {
        return this.getTotal() - this.getDisponivel();
    }

@Override
public String toString(){

final StringBuilder sb=new StringBuilder("Memoria").append("\n");

        sb.append("Em uso: ")
        .append(Conversor.formatarBytes(getEmUso()))
        .append("\n");

        sb.append("Disponível: ")
        .append(Conversor.formatarBytes(getDisponivel()))
        .append("\n");

        sb.append("Total: ")
        .append(Conversor.formatarBytes(getTotal()))
        .append("\n");

        return sb.toString();
    }
}

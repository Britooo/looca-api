package com.github.britooo.looca.api.group.memoria;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import com.github.britooo.looca.api.util.Conversor;

public class Memoria {

    private final HardwareAbstractionLayer hardware = new SystemInfo().getHardware();

    /**
     * Retorna a quantidade de memória física atualmente disponível, em bytes.
     * @return Quantidade de memória física atualmente disponível, em bytes.
     */
    public Long getDisponivel() {
        return this.hardware.getMemory().getAvailable();
    }

    /**
     * Retorna a quantidade de memória física real, em bytes.
     * @return Quantidade de memória física real, em bytes.
     */
    public Long getTotal() {
        return this.hardware.getMemory().getTotal();
    }

    /**
     * Retorna a quantidade de memória em uso, em bytes.
     * @return Quantidade de memória em uso, em bytes.
     */
    public Long getEmUso() {
        return this.getTotal() - this.getDisponivel();
    }

    @Override
    public String toString() {
        return String.format("Memoria\nEm uso: %s\nDisponível: %s\nTotal: %s",
                Conversor.formatarBytes(getEmUso()),
                Conversor.formatarBytes(getDisponivel()),
                Conversor.formatarBytes(getTotal()));
    }
}

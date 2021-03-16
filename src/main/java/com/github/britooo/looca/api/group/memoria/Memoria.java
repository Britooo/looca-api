package com.github.britooo.looca.api.group.memoria;

import com.github.britooo.looca.api.util.Conversor;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;

/**
 *
 * @author Diego Brito <diego.lima@bandtec.com.br | @Britooo on Github>
 * @author Giuliana Miniguiti <giuliana.franca@bandtec.com.br | @Britooo on Github>
 */
public class Memoria {

    private final HardwareAbstractionLayer hardware = new SystemInfo().getHardware();

    public Long getDisponivel() {
        return this.hardware.getMemory().getAvailable();
    }

    public Long getTotal() {
        return this.hardware.getMemory().getTotal();
    }

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

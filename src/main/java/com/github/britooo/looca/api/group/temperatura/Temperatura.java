package com.github.britooo.looca.api.group.temperatura;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;

public class Temperatura {

    private final HardwareAbstractionLayer hardware = new SystemInfo().getHardware();

    public Double getTemperatura() {
        return this.hardware.getSensors().getCpuTemperature();
    }

    @Override
    public String toString() {
        return String.format("Temperatura: %.1f", getTemperatura());
    }
}

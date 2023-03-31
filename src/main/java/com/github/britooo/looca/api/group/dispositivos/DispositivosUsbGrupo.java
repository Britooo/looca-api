package com.github.britooo.looca.api.group.dispositivos;

import java.util.List;
import java.util.stream.Collectors;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.UsbDevice;

public class DispositivosUsbGrupo {

    private final HardwareAbstractionLayer hardwareAbstractionLayer = new SystemInfo().getHardware();

    public Integer getTotalDispositvosUsb() {
        return this.hardwareAbstractionLayer.getUsbDevices(false).size();
    }

    public Integer getTotalDispositvosUsbConectados() {
        return this.hardwareAbstractionLayer.getUsbDevices(true).size();
    }

    public List<DispositivoUsb> getDispositivosUsb() {
        return this.hardwareAbstractionLayer.getUsbDevices(false)
                        .stream()
                        .map(DispositivosUsbGrupo::of)
                        .collect(Collectors.toList());
    }

    public List<DispositivoUsb> getDispositivosUsbConectados() {
        return this.hardwareAbstractionLayer.getUsbDevices(true)
                        .stream()
                        .map(DispositivosUsbGrupo::of)
                        .collect(Collectors.toList());
    }
    
    private static DispositivoUsb of(UsbDevice usbDevice) {
        if (usbDevice == null) {
            return null;
        }
        
        return new DispositivoUsb(usbDevice);
    }
}


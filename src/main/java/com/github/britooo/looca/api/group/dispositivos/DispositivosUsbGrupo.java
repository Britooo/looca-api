package com.github.britooo.looca.api.group.dispositivos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.UsbDevice;

public class DispositivosUsbGrupo {

    private final HardwareAbstractionLayer hardwareAbstractionLayer = new SystemInfo().getHardware();

    /**
     * Retorna o número de <b>dispositivos usb</b>.
     *
     * @return Número de processos em execução.
     */
    public Integer getTotalDispositvosUsb() {
        return this.hardwareAbstractionLayer.getUsbDevices(false).size();
    }

    public Integer getTotalDispositvosUsbConectados() {
        int totalDispositivosConectados = 0;

        for(UsbDevice item : this.hardwareAbstractionLayer.getUsbDevices(true)) {
            totalDispositivosConectados += item.getConnectedDevices().size();
        }

        return totalDispositivosConectados;
    }

    public List<DispositivoUsb> getDispositivosUsb() {
        return this.hardwareAbstractionLayer.getUsbDevices(false)
                        .stream()
                        .map(DispositivosUsbGrupo::of)
                        .collect(Collectors.toList());
    }

    public List<DispositivoUsb> getDispositivosUsbConectados() {
        List<DispositivoUsb> dispositivoUsbList = new ArrayList<>();

        for(UsbDevice item : this.hardwareAbstractionLayer.getUsbDevices(true)) {
            for (UsbDevice usbDevice : item.getConnectedDevices()) {
                dispositivoUsbList.add(DispositivosUsbGrupo.of(usbDevice));
            }
        }

        return dispositivoUsbList;
    }
    
    private static DispositivoUsb of(UsbDevice usbDevice) {
        if (usbDevice == null) {
            return null;
        }
        
        return new DispositivoUsb(usbDevice);
    }
}


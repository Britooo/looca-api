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
     * Retorna o número de <b>dispositivos USB</b>.
     *
     * @return Número de dispositivos identificados como USB.
     */
    public Integer getTotalDispositvosUsb() {
        int totalDispositivosConectados = 0;

        for(UsbDevice item : this.hardwareAbstractionLayer.getUsbDevices(false)) {
            totalDispositivosConectados += item.getConnectedDevices().size();
        }

        return totalDispositivosConectados;
    }

    /**
     * Retorna o número de <b>dispositivos USB conectados</b>.
     *
     * @return Número de dispositivos conectados identificados como USB.
     */
    public Integer getTotalDispositvosUsbConectados() {
        int totalDispositivosConectados = 0;

        for(UsbDevice item : this.hardwareAbstractionLayer.getUsbDevices(true)) {
            totalDispositivosConectados += item.getConnectedDevices().size();
        }

        return totalDispositivosConectados;
    }

    /**
     * Retorna os <b>dispositivos USB</b>.
     *
     * @return Dispositivos identificados como USB.
     */

    public List<DispositivoUsb> getDispositivosUsb() {
        List<DispositivoUsb> dispositivoUsbList = new ArrayList<>();

        for(UsbDevice item : this.hardwareAbstractionLayer.getUsbDevices(false)) {
                dispositivoUsbList.add(DispositivosUsbGrupo.of(item));
        }

        return dispositivoUsbList;
    }

    /**
     * Retorna os <b>dispositivos USB conectados</b>.
     *
     * @return Dispositivos conectados identificados como USB.
     */
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


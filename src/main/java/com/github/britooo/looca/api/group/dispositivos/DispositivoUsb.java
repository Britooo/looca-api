package com.github.britooo.looca.api.group.dispositivos;

import oshi.hardware.UsbDevice;

public class DispositivoUsb {

    private final UsbDevice usbDevice;

    public String getNome() {
        return usbDevice.getName();
    }

    public String getIdProduto() {
        return usbDevice.getProductId();
    }

    public String getNumeroDeSerie() {
        return usbDevice.getSerialNumber();
    }

    public String getIdDispositivoUsbExclusivo() {
        return usbDevice.getUniqueDeviceId();
    }

    public String getForncecedor() {
        return usbDevice.getVendor();
    }

    public String getIdFornecedor() {
        return usbDevice.getVendorId();
    }

    public DispositivoUsb(UsbDevice usbDevice) {
        this.usbDevice = usbDevice;
    }

    @Override
    public String toString() {
        return String.format("\nNome: %s\nId produto: %s\nNúmero de série: %s\nId de dispositivo exclusivo: %s\nFornecedor: %s\nId fornecedor: %s\n",
        getNome(), getIdProduto(), getNumeroDeSerie(), getIdDispositivoUsbExclusivo(), getForncecedor(), getIdFornecedor());
    }
}

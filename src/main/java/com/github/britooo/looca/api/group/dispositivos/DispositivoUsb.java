package com.github.britooo.looca.api.group.dispositivos;

import oshi.hardware.UsbDevice;

public class DispositivoUsb {

    private final UsbDevice usbDevice;

    /**
     * Retorna o <b>nome do dispositivo</b>.
     *
     * @return Nome do dispositivo.
     */
    public String getNome() {
        return usbDevice.getName();
    }

    /**
     * Retorna o <b>identificador do produto</b>.
     *
     * @return O identificador do produto.
     */
    public String getIdProduto() {
        return usbDevice.getProductId();
    }

    /**
     * Retorna o <b>numero de serie</b>.
     *
     * @return O número de série.
     */
    public String getNumeroDeSerie() {
        return usbDevice.getSerialNumber();
    }


    /**
     * Retorna o <b>identificador exclusivo do dispositivo</b>.
     *
     * @return O identificador exclusivo do dispositivo.
     */
    public String getIdDispositivoUsbExclusivo() {
        return usbDevice.getUniqueDeviceId();
    }

    /**
     * Retorna o <b>nome do fornecedor</b> identificado no dispositivo.
     *
     * @return O nome do fornecedor.
     */
    public String getForncecedor() {
        return usbDevice.getVendor();
    }

    /**
     * Retorna o <b>identificador do fornecedor</b>.
     *
     * @return O identificador do fornecedor.
     */
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

package com.github.britooo.looca.api.group.discos;

import oshi.hardware.HWDiskStore;


/**
 *
 * @author Diego Brito diego.lima@bandtec.com.br  @Britooo on Github
 * @author Giuliana Miniguiti giuliana.franca@bandtec.com.br  @miniguiti on Github
 */
public class Disco {

    private final HWDiskStore disco;

    public Disco(HWDiskStore disco) {
        this.disco = disco;
    }

    public String getNome() {
        return disco.getName();
    }

    ;

    public String getModelo() {
        return disco.getModel();
    }

    public String getSerial() {
        return disco.getSerial();
    }

    public Long getTamanho() {
        return disco.getSize();
    }

    public Long getLeituras() {
        return disco.getReads();
    }

    public Long getBytesDeLeitura() {
        return disco.getReadBytes();
    }

    public Long getEscritas() {
        return disco.getWrites();
    }

    public Long getBytesDeEscritas() {
        return disco.getWriteBytes();
    }

    public Long getTamanhoAtualDaFila() {
        return disco.getCurrentQueueLength();
    }

    public Long getTempoDeTransferencia() {
        return disco.getTransferTime();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("\nNome: %s\n");
        str.append("Modelo: %s\n");
        str.append("Serial: %s\n");
        str.append("Tamanho: %s\n");
        str.append("Leituras: %s\n");
        str.append("BYtes de leitura: %s\n");
        str.append("Escritas: %s\n");
        str.append("Bytes de escritas: %s\n");
        str.append("Tamanho atual da fila: %s\n");
        str.append("Tempo de transferência: %s\n");

        return String.format(
                str.toString(),
                getNome(),
                getModelo(),
                getSerial(),
                getTamanho(),
                getLeituras(),
                getBytesDeLeitura(),
                getEscritas(),
                getBytesDeEscritas(),
                getTamanhoAtualDaFila(),
                getTempoDeTransferencia()
        );
    }
}

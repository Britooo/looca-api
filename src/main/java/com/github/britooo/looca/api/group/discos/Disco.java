package com.github.britooo.looca.api.group.discos;

import oshi.hardware.HWDiskStore;

public class Disco {

    private final HWDiskStore disco;

    public Disco(HWDiskStore disco) {
        this.disco = disco;
    }

    /**
     * Retorna o nome do disco.
     *
     * @return Nome do disco.
     */
    public String getNome() {
        return disco.getName();
    }

    /**
     * Retorna o modelo do disco.
     *
     * @return Modelo do disco.
     */
    public String getModelo() {
        return disco.getModel();
    }

    /**
     * Retorna o número do serial do disco, se disponível.
     *
     * @return Número serial do disco, se disponível.
     */
    public String getSerial() {
        return disco.getSerial();
    }

    /**
     * Retorna o tamanho do disco em bytes.
     *
     * @return Tamanho do disco em bytes.
     */
    public Long getTamanho() {
        return disco.getSize();
    }

    /**
     * Retorna o número de leituras do disco.
     *
     * @return Número de leituras do disco.
     */
    public Long getLeituras() {
        return disco.getReads();
    }

    /**
     * Retorna o número de bytes lidos pelo disco.
     *
     * @return Número de bytes lidos pelo disco.
     */
    public Long getBytesDeLeitura() {
        return disco.getReadBytes();
    }

    /**
     * Retorna o número de escritas no disco.
     *
     * @return Número de escritas no disco.
     */
    public Long getEscritas() {
        return disco.getWrites();
    }

    /**
     * Retorna o número de bytes escritos no disco.
     *
     * @return Número de bytes escritos no disco.
     */
    public Long getBytesDeEscritas() {
        return disco.getWriteBytes();
    }

    /**
     * Retorna o comprimento da fila de disco (E/S's em andamento).
     * Inclui solicitações de E/S que foram emitidas para o driver de dispositivo,
     * mas ainda não foram concluídas. Não compatível com macOS.
     *
     * @return Comprimento da fila de disco (E/S's em andamento).
     */
    public Long getTamanhoAtualDaFila() {
        return disco.getCurrentQueueLength();
    }

    /**
     * Retorna o tempo gasto lendo ou escrevendo no disco, em milissegundos.
     *
     * @return Tempo gasto lendo ou escrevendo no disco, em milissegundos.
     */

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

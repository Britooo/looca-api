package com.github.britooo.looca.api.group.processador;

import oshi.SystemInfo;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import oshi.hardware.CentralProcessor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ExecutionException;

public class Processador {

    private ExecutorService executor = Executors.newSingleThreadExecutor();

    private final CentralProcessor processador = new SystemInfo().getHardware().getProcessor();

    public String getFabricante() {
        return this.processador.getProcessorIdentifier().getVendor();
    }

    public String getNome() {
        return this.processador.getProcessorIdentifier().getName();
    }

    public String getId() {
        return this.processador.getProcessorIdentifier().getProcessorID();
    }

    public String getIdentificador() {
        return this.processador.getProcessorIdentifier().getIdentifier();
    }

    public String getMicroarquitetura() {
        return this.processador.getProcessorIdentifier().getMicroarchitecture();
    }

    public Long getFrequencia() {
        return this.processador.getProcessorIdentifier().getVendorFreq();
    }

    public Integer getNumeroPacotesFisicos() {
        return this.processador.getPhysicalPackageCount();
    }

    public Integer getNumeroCpusFisicas() {
        return this.processador.getPhysicalProcessorCount();
    }

    public Integer getNumeroCpusLogicas() {
        return this.processador.getLogicalProcessorCount();
    }

    public Double getUso() {

        Double resultado = 0.0;
        Future<Double> uso = getUsoOshi();

        try {

            while (!uso.isDone()) {
                System.out.println("Coletando dados do processador...");
                TimeUnit.SECONDS.sleep(2);
            }
            resultado = uso.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    private Future<Double> getUsoOshi() {
        long[] prevTicks = this.processador.getSystemCpuLoadTicks();
        return executor.submit(() -> {
            TimeUnit.SECONDS.sleep(1);
            return this.processador.getSystemCpuLoadBetweenTicks(prevTicks) * 100;
        });
    }

    @Override
    public String toString() {
        return String.format(
                "Fabricante: %s\n"
                + "Nome: %s\n"
                + "Id: %s\n"
                + "Identificador: %s\n"
                + "Microarquitetura: %s\n"
                + "Frequência: %s\n"
                + "Número de Pacotes Físicos: %s\n"
                + "Número de CPUs Fisícas: %s\n"
                + "Número de CPUs Lógicas: %S\n"
                + "Em Uso: %.1f\n",
                this.getFabricante(),
                this.getNome(),
                this.getId(),
                this.getIdentificador(),
                this.getMicroarquitetura(),
                this.getFrequencia(),
                this.getNumeroPacotesFisicos(),
                this.getNumeroCpusFisicas(),
                this.getNumeroCpusLogicas(),
                this.getUso()
        );
    }
}

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

    /**
     * Retorna o nome do Fornecedor do processador.
     * @return Nome do Fornecedor do processador.
     */
    public String getFabricante() {
        return this.processador.getProcessorIdentifier().getVendor();
    }

    /**
     * Retorna o nome do Processador (Exemplo: Name, eg. Intel(R) Core(TM)2 Duo CPU T7300 @ 2.00GHz).
     * @return Nome do Processador.
     */
    public String getNome() {
        return this.processador.getProcessorIdentifier().getName();
    }

    /**
     * Retorna o ID do processador.
     * Esta é uma String hexadecimal representando um valor de 8 bytes,
     * normalmente obtido usando o opcode CPUID com o registrador EAX definido como 1.
     * Os primeiros quatro bytes são o conteúdo resultante do registrador EAX,
     * que é a assinatura do processador, representada em legível por humanos.
     * Os quatro bytes restantes são o conteúdo do registrador EDX, contendo sinalizadores de recursos.
     * Para processadores que não suportam o opcode CPUID,
     * este campo é preenchido com uma String hexadecimal comparável.
     * Por exemplo, os processadores ARM preencherão os primeiros 32 bytes com o MIDR.
     * Os processadores AIX PowerPC retornarão o ID da máquina.
     *
     * NOTA: A ordem dos bytes retornados depende da plataforma e do software.
     * Os valores podem estar na ordem Big Endian ou Little Endian.
     *
     * NOTA: Se o Looca não conseguir determinar o ProcessorID a partir de fontes nativas,
     * ele tentará reconstruir um a partir das informações disponíveis no identificador do processador.
     * @return ID do processador.
     */
    public String getId() {
        return this.processador.getProcessorIdentifier().getProcessorID();
    }

    /**
     * Retorna o identificador, por exemplo: Família x86 6 Modelo 15 Etapa 10.
     * Para processadores diferentes de Intel ou AMD, essa String é preenchida com valores comparáveis.
     * @return Identificador.
     */
    public String getIdentificador() {
        return this.processador.getProcessorIdentifier().getIdentifier();
    }

    /**
     * Retorna a microarquitetura do processador, se conhecida.
     * Caso contrário retorna a constante: Constantes.UNKNOWN
     * @return Microarquitetura do processador.
     */
    public String getMicroarquitetura() {
        return this.processador.getProcessorIdentifier().getMicroarchitecture();
    }

    /**
     * Retorna a frequência do processador (em Hz), por exemplo.
     * Para o processador denominado Intel(R) Core(TM)2 Duo CPU T7300 @ 2,00 GHz,
     * a frequência do processador é 2000000000hz.
     * Caso a frequência do processador seja desconhecido retorna -1;
     * @return Frequência do processador.
     */
    public Long getFrequencia() {
        return this.processador.getProcessorIdentifier().getVendorFreq();
    }

    /**
     * Retorna o número de pacotes/soquetes no sistema.
     * Um único pacote pode conter vários núcleos.
     * @return Número de pacotes físicos disponíveis.
     */
    public Integer getNumeroPacotesFisicos() {
        return this.processador.getPhysicalPackageCount();
    }

    /**
     * Retorna o úmero de CPUs/núcleos físicos disponíveis para processamento.
     * @return Número de CPUs físicas disponíveis.
     */
    public Integer getNumeroCpusFisicas() {
        return this.processador.getPhysicalProcessorCount();
    }

    /**
     * Retorna o número de CPUs lógicas disponíveis para processamento.
     * Este valor pode ser maior do que CPUs físicas se o hyperthreading estiver habilitado.
     * @return Número de CPUs lógicas disponíveis.
     */
    public Integer getNumeroCpusLogicas() {
        return this.processador.getLogicalProcessorCount();
    }

    /**
     * Retorna a porcentagem de uso do processador por meio dos contadores de ticks de carga de CPU em todo o sistema.
     * por meio de  um array com oito elementos representando milissegundos gastos nos estados:
     * User (0), Nice (1), System (2), Idle (3), IOwait (4), Hardware interrupts (IRQ) (5),
     * Software interrupts/DPC (SoftIRQ) ) (6) ou Steal (7).
     * Ao medir a diferença entre os ticks em um intervalo de tempo,
     * a carga da CPU nesse intervalo pode ser calculada.
     * Observe que, embora os contadores de tiques estejam em unidades de milissegundos,
     * eles podem avançar em incrementos maiores junto com tiques de clock (dependentes da plataforma).
     * Por exemplo, por padrão, os tiques do clock do Windows são 1/64 de segundo (cerca de 15 ou 16 milissegundos) e os tiques do Linux dependem da distribuição e da configuração,
     * mas geralmente 1/100 de segundo (10 milissegundos).
     *
     * As informações de Nice e IOWait não estão disponíveis no Windows,
     * e as informações de IOwait e IRQ não estão disponíveis no macOS, portanto,
     * esses ticks sempre serão zero.
     *
     * Para calcular o tempo de inatividade geral usando esse método,
     * inclua os tiques de inatividade e IOWait. Da mesma forma, os ticks de IRQ,
     * SoftIRQ e Steal devem ser adicionados ao valor do sistema para obter o total.
     * Os tiques do sistema também incluem o tempo de execução de outros hosts virtuais (steal).
     *
     * Com isso fazemos o cálculo necessário para a medição em porcentagem do uso do processador.
     *
     * @return Valor em porcentagem de uso do processador.
     */
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

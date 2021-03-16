package com.github.britooo.looca.api.group.sistema;

import oshi.SystemInfo;
import java.time.Instant;
import oshi.software.os.OperatingSystem;
import com.github.britooo.looca.api.util.Conversor;

/**
 *
 * @author Diego Brito diego.lima@bandtec.com.br  @Britooo on Github
 * @author Giuliana Miniguiti giuliana.franca@bandtec.com.br  @miniguiti on Github
 */
public class Sistema {

    private final OperatingSystem os = new SystemInfo().getOperatingSystem();

    private final String fabricante;
    private final Integer arquitetura;
    private final String sistemaOperacional;

    public Sistema() {
        this.arquitetura = this.os.getBitness();
        this.fabricante = this.os.getManufacturer();
        this.sistemaOperacional = this.os.getFamily();
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public String getFabricante() {
        return fabricante;
    }

    public Integer getArquitetura() {
        return arquitetura;
    }

    public Instant getInicializado() {
        return Instant.ofEpochSecond(this.os.getSystemBootTime());
    }

    public Long getTempoDeAtividade() {
        return this.os.getSystemUptime();
    }

    public Boolean getPermissao() {
        return this.os.isElevated();
    }

    @Override
    public String toString() {
        return String.format("Sistema operacional: %s\nFabricante: %s\nArquitetura: %d bits.\nInicializado: %s\nTempo de atividade: %s\nPermissões:\n%s",
                this.sistemaOperacional,
                this.fabricante,
                this.arquitetura,
                this.getInicializado(),
                Conversor.formatarSegundosDecorridos(this.getTempoDeAtividade()),
                ("Executando como " + (this.getPermissao() ? "root" : "usuário padrão"))
        );
    }
}

package com.github.britooo.looca.api.group.servicos;

import java.util.List;
import java.util.Arrays;
import oshi.SystemInfo;
import java.util.stream.Collectors;
import oshi.software.os.OSService;

/**
 *
 * @author Diego Brito diego.lima@bandtec.com.br  @Britooo on Github
 * @author Giuliana Miniguiti giuliana.franca@bandtec.com.br  @miniguiti on Github
 */
public class ServicosGroup {

    static enum STATUS {
        RUNNING,
        STOPPED
    }

    private final SystemInfo sistema = new SystemInfo();

    public List<Servico> getServicos() {
        return recuperarServicosOshi().stream().map(ServicosGroup::of).collect(Collectors.toList());
    }

    public Integer getTotalDeServicos() {
        return this.getServicos().size();
    }

    public List<Servico> getServicosAtivos() {
        return this.getServicos().stream()
                .filter(servico -> servico.getEstado()
                .equals(STATUS.RUNNING.toString()))
                .collect(Collectors.toList());
    }

    public Integer getTotalServicosAtivos() {
        return this.getServicosAtivos().size();
    }

    public List<Servico> getServicosInativos() {
        return this.getServicos().stream()
                .filter(servico -> servico.getEstado()
                .equals(STATUS.STOPPED.toString()))
                .collect(Collectors.toList());
    }

    public Integer getTotalServicosInativos() {
        return this.getServicosInativos().size();
    }

    private List<OSService> recuperarServicosOshi() {
        return Arrays.asList(this.sistema.getOperatingSystem().getServices());
    }

    private static Servico of(OSService servico) {

        if (servico == null) {
            return null;
        }

        return new Servico(servico);
    }
}

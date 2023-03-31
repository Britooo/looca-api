package com.github.britooo.looca.api.core;

import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.dispositivos.DispositivosUsbGrupo;
import com.github.britooo.looca.api.group.servicos.ServicosGroup;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.temperatura.Temperatura;

public class Looca {

    private final Sistema sistema;
    private final Memoria memoria;
    private final Processador processador;
    private final Temperatura temperatura;
    private final DiscosGroup grupoDeDiscos;
    private final ServicosGroup grupoDeServicos;
    private final ProcessosGroup grupoDeProcessos;
    private final DispositivosUsbGrupo grupoDeDispositivosUsb;

    public Looca() {
        this.sistema = new Sistema();
        this.memoria = new Memoria();
        this.processador = new Processador();
        this.temperatura = new Temperatura();
        this.grupoDeDiscos = new DiscosGroup();
        this.grupoDeServicos = new ServicosGroup();
        this.grupoDeProcessos = new ProcessosGroup();
        this.grupoDeDispositivosUsb = new DispositivosUsbGrupo();
    }

    public Sistema getSistema() {
        return sistema;
    }

    public Memoria getMemoria() {
        return memoria;
    }

    public Processador getProcessador() {
        return processador;
    }

    public Temperatura getTemperatura() {
        return temperatura;
    }

    public DiscosGroup getGrupoDeDiscos() {
        return grupoDeDiscos;
    }

    public ServicosGroup getGrupoDeServicos() {
        return grupoDeServicos;
    }

    public ProcessosGroup getGrupoDeProcessos() {
        return grupoDeProcessos;
    }

    public DispositivosUsbGrupo getDispositivosUsbGrupo() {
        return grupoDeDispositivosUsb;
    }
}

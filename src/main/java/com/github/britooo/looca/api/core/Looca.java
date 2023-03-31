package com.github.britooo.looca.api.core;

import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.dispositivos.DispositivosUsbGrupo;
import com.github.britooo.looca.api.group.janelas.JanelaGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.rede.Rede;
import com.github.britooo.looca.api.group.servicos.ServicoGrupo;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import oshi.SystemInfo;

public class Looca {

    private final Sistema sistema;
    private final Memoria memoria;
    private final Processador processador;
    private final Temperatura temperatura;
    private final Rede rede;
    private final DiscoGrupo grupoDeDiscos;
    private final ServicoGrupo grupoDeServicos;
    private final ProcessoGrupo grupoDeProcessos;
    private final JanelaGrupo grupoDeJanelas;
    private final DispositivosUsbGrupo grupoDeDispositivosUsb;

    public Looca() {
        SystemInfo si = new SystemInfo();

        this.sistema = new Sistema();
        this.memoria = new Memoria();
        this.processador = new Processador();
        this.temperatura = new Temperatura();
        this.rede = new Rede(si);
        this.grupoDeDiscos = new DiscoGrupo();
        this.grupoDeServicos = new ServicoGrupo();
        this.grupoDeProcessos = new ProcessoGrupo();
        this.grupoDeJanelas = new JanelaGrupo(si);
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

    public DiscoGrupo getGrupoDeDiscos() {
        return grupoDeDiscos;
    }

    public ServicoGrupo getGrupoDeServicos() {
        return grupoDeServicos;
    }

    public ProcessoGrupo getGrupoDeProcessos() {
        return grupoDeProcessos;
    }

    public DispositivosUsbGrupo getDispositivosUsbGrupo() {
        return grupoDeDispositivosUsb;
    }
    
    public Rede getRede() {
        return rede;
    }

    public JanelaGrupo getGrupoDeJanelas() {
        return grupoDeJanelas;
    }
}

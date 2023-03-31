package com.github.britooo.looca.api.core;

import com.github.britooo.looca.api.group.janelas.JanelaGroup;
import com.github.britooo.looca.api.group.rede.Rede;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.dispositivos.DispositivosUsbGrupo;
import com.github.britooo.looca.api.group.servicos.ServicosGroup;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import oshi.SystemInfo;

public class Looca {

    private final Sistema sistema;
    private final Memoria memoria;
    private final Processador processador;
    private final Temperatura temperatura;
    private final Rede rede;
    private final DiscosGroup grupoDeDiscos;
    private final ServicosGroup grupoDeServicos;
    private final ProcessosGroup grupoDeProcessos;
    private final JanelaGroup grupoDeJanelas;
    private final DispositivosUsbGrupo grupoDeDispositivosUsb;

    public Looca() {
        SystemInfo si = new SystemInfo();

        this.sistema = new Sistema();
        this.memoria = new Memoria();
        this.processador = new Processador();
        this.temperatura = new Temperatura();
        this.rede = new Rede(si);
        this.grupoDeDiscos = new DiscosGroup();
        this.grupoDeServicos = new ServicosGroup();
        this.grupoDeProcessos = new ProcessosGroup();
        this.grupoDeJanelas = new JanelaGroup(si);
        this.grupoDeDispositivosUsb = new DispositivosUsbGrupo();
    }

    /**
     * Retorna um <b>Objeto de Sistema</b> que contém métodos relacionados a coleta de informações do <b>Sistema Operacional</b>.
     * @return Objeto Sistema.
     */
    public Sistema getSistema() {
      return sistema;
    }

    /**
     * Retorna um <b>Objeto de Memoria</b> que contém métodos relacionados a coleta de informações da <b>Memória RAM</b>.
     * @return Objeto Memoria.
     */
    public Memoria getMemoria() {
      return memoria;
    }

    /**
     * Retorna um <b>Objeto de Processador</b> que contém métodos relacionados a coleta de informações do <b>Processador</b>.
     * @return Objeto Processador.
     */
    public Processador getProcessador() {
      return processador;
    }

    /**
     * Retorna um <b>Objeto de Temperatura</b> que contém métodos relacionados a coleta de informações de <b>Temperatura</b>.
     * @return Objeto Temperatura.
     */
    public Temperatura getTemperatura() {
      return temperatura;
    }

    /**
     * Retorna um <b>Objeto de DiscoGrupo</b> que contém métodos relacionados a coleta de informações do <b>Grupo de Discos</b>.
     * @return Objeto DiscoGrupo.
     */
    public DiscoGrupo getGrupoDeDiscos() {
      return grupoDeDiscos;
    }

    /**
     * Retorna um <b>Objeto de ServicoGrupo</b> que contém métodos relacionados a coleta de informações do <b>Grupo de Serviços</b>.
     * @return Objeto ServicoGrupo.
     */
    public ServicoGrupo getGrupoDeServicos() {
      return grupoDeServicos;
    }

    /**
     * Retorna um <b>Objeto de ProcessoGrupo</b> que contém métodos relacionados a coleta de informações do <b>Grupo de Processos</b>.
     * @return Objeto ProcessoGrupo.
     */
    public ProcessoGrupo getGrupoDeProcessos() {
      return grupoDeProcessos;
    }

    public DispositivosUsbGrupo getDispositivosUsbGrupo() {
        return grupoDeDispositivosUsb;
    }
    
    public Rede getRede() {
        return rede;
    }

    public JanelaGroup getGrupoDeJanelas() {
        return grupoDeJanelas;
    }
}

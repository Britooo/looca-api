package com.github.britooo.looca.api.group.processador;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;

public class ProcessadorCacheLoader {

  private final ExecutorService executor = Executors.newSingleThreadExecutor();
  private final ListeningExecutorService lExecutor = MoreExecutors.listeningDecorator(executor);
  private final CentralProcessor processador = new SystemInfo().getHardware().getProcessor();

  private final LoadingCache<String, Double> loader;

  public ProcessadorCacheLoader() {
    loader = CacheBuilder.newBuilder()
        .maximumSize(1000)
        .refreshAfterWrite(1000, TimeUnit.MILLISECONDS)
        .build(new CacheLoader<String, Double>() {
          @Override
          public Double load(String key) throws Exception {
            return loadUso();
          }

          @Override
          public ListenableFuture<Double> reload(String key, Double oldValue) throws Exception {
            return getUsoOshi();
          }
        });
  }

  /**
   * Retorna <b>uso</b> do processador em <b>procentagem</b>.
   * @return Uso do processador em <b>procentagem</b>.
   */
  public Double getUso() {
    try {
      return loader.get("uso");
    } catch (ExecutionException e) {
      e.printStackTrace();
      return 0.0;
    }
  }

  private Double loadUso() {
    Double resultado = 0.0;
    Future<Double> uso = getUsoOshi();

    try {
      while (!uso.isDone()) {
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

  private ListenableFuture<Double> getUsoOshi() {
    long[] prevTicks = this.processador.getSystemCpuLoadTicks();

    ListenableFutureTask<Double> task = ListenableFutureTask.create(new Callable<Double>() {
      public Double call() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return processador.getSystemCpuLoadBetweenTicks(prevTicks) * 100;
      }
    });

    lExecutor.execute(task);
    return task;
  }
}

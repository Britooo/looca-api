
[![Looca API](./readme/readmes.gif)]()
# Log of Computer Activity

### **Looca** é uma API que coleta dados de maquina e foi desenvolvida para facilitar o aprendizado em contextos acadêmicos. Esse projeto visa ajudar os alunos da Faculdade [@Bandtec](https://github.com/BandTec) em projetos na disciplina de Pesquisa e Inovação.
# 

![Badge](https://img.shields.io/badge/Code-Java-F76911?&logo=java) 
![Badge](https://img.shields.io/badge/compiler-maven-4c9d1flogo=maven)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.nyholmniklas/arithmetic/badge.svg)(https://search.maven.org/artifact/com.github.britooo/looca-api)
#
## Instalação
**Adicione no pom.xml**:
```xml
<dependency>
  <groupId>com.github.britooo</groupId>
  <artifactId>looca-api</artifactId>
  <version>1.0.1</version>
</dependency>
```

**Execute no terminal (linha de comando):**
```
$ mvn install
```
#
## Uso

**Crie uma instância do objeto Looca:**
```java
Looca looca = new Looca();
```

**Esse objeto disponibiliza os seguintes recursos:**

```java
private final Sistema sistema;
private final Memoria memoria;
private final Processador processador;
private final Temperatura temperatura;
private final DiscosGroup grupoDeDiscos;
private final ServicosGroup grupoDeServicos;
private final ProcessosGroup grupoDeProcessos;
```

**Coletando dados do sistema operacional**

Para coletar os dados da máquina, devemos utilizar os **getters** disponíveis no objeto Looca, por exemplo, para coletar os dados do sistema operacional, utilizamos o **```getSistema()```**, que devolve um objeto do tipo Sistema:


```java
Sistema sistema = looca.getSistema();

```
O objeto Sistema por sua vez, também possui **getters** que devolvem informações do sistema:
```java
sistema.getPermissao();
sistema.getFabricante();
sistema.getArquitetura();
sistema.getArquitetura();
sistema.getInicializado();
sistema.getSistemaOperacional();
```

Para exibir no console as informações do sistema, basta imprimir o objeto:
```java
System.out.println(sistema);
```
Saída do console:
```
Sistema operacional: Ubuntu
Fabricante: GNU/Linux
Arquitetura: 64 bits.
Inicializado: 2021-03-13T16:07:18Z
Tempo de atividade: 3 days, 06:55:53
Permissões:
Executando como usuário padrão
```


**Trabalhando com os grupos**

Para lidar com objetos que retornam mais de uma instância (lista) da informação desejada, utilizamos os grupos, que gerenciam essas informações, para obte-los, utilizamos o **```getGrupoNomeGrupo()```** (Discos, Processos ou Servicos), exemplo:

```java
//Criação do gerenciador
DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();

//Obtendo lista de discos a partir do getter
List<Disco> discos = grupoDeDiscos.getDiscos();
```
Exibindo as informações de cada disco:

```java
for (Disco disco : discos) {
  System.out.println(disco);
}
```

## Desenvolvedores
#
- @Britoo
- @miniguiti

## Licença
#
[MIT](LICENSE) © 2021 Bandtec Digital School

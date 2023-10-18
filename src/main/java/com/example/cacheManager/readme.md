## Trabalho 3 - Arquitetura e Organização de Computadores II - Ciência da Computação - 23.2
- Manoela Resende (manoelacunha.aluno@unipampa.edu.br)

Este trabalho é propriedade de [Manoela Resende](https://github.com/manoelargc). Ele foi desenvolvido como parte do Trabalho 3 da disciplina de Arquitetura e Organização de Computadores II do 4º Semestre de Ciência da Computação - 23.2, ministrada pela Prof. Dr. Claudio Schepke.

-------
# Cache Manager Simulator - DESKTOP VERSION

![GUI](\img\image.png)

# Simulador de Cache

Este é um guia de uso e documentação para o aplicativo `CacheSimulator`, um programa de simulação de cache em Java que oferece uma interface gráfica utilizando JavaFX para interagir com dois tipos de cache: Mapeamento Direto e Totalmente Associativa.

## Visão Geral

O `CacheSimulator` é uma aplicação que simula o funcionamento de um sistema de memória cache, permitindo a visualização e interação com as operações de cache. As principais características incluem:

- Dois tipos de cache: Mapeamento Direto e Totalmente Associativa.
- Funcionalidade para inserir dados e verificar acertos ou erros no cache.
- Representação visual do cache, destacando os dados mais recentemente acessados.
- Simulação de atraso no acesso ao cache para demonstrar eventos de hit e miss.

## Componentes do Aplicativo

### Classe Principal

A classe `CacheSimulator` é o ponto de entrada do aplicativo. Ela configura a interface do usuário JavaFX e contém métodos para inicializar o cache, verificar acertos/erros e atualizar a tabela de cache.

### Classe Cache

A classe `Cache` é a base para as operações de cache. Ela inclui métodos para verificar o cache, obter e definir dados no cache, e imprimir o conteúdo do cache. Essa classe é estendida pelas classes `DirectMappedCache` e `FullyAssociativeCache`.

### Classe CacheEntry

A classe `CacheEntry` representa uma entrada no cache, contendo um índice e um valor de dados.

### Classe DirectMappedCache

A classe `DirectMappedCache` estende a classe `Cache` e implementa o comportamento de um cache de mapeamento direto. Ela trata das operações de cache específicas para esse tipo.

### Classe FullyAssociativeCache

A classe `FullyAssociativeCache` estende a classe `Cache` e simula um cache totalmente associativo. Ela trata das operações de cache para esse tipo.

## Interface do Usuário

A interface do usuário, baseada em JavaFX, inclui os seguintes elementos:

- Campo de entrada de dados para inserir dados a serem verificados no cache.
- Menu suspenso para selecionar o tipo de cache (Mapeamento Direto ou Totalmente Associativa).
- Botão "Verificar Cache" para iniciar a verificação do cache.
- Rótulo de resultados que exibe "Acerto" ou "Erro" no cache.
- Tabela que exibe o conteúdo do cache, com destaque em azul claro para os dados mais recentemente acessados.

## Uso

1. Execute o aplicativo `CacheSimulator`.
2. Escolha o tipo de cache (Mapeamento Direto ou Totalmente Associativa) no menu suspenso.
3. Insira um valor de dados no campo de entrada.
4. Clique no botão "Verificar Cache" para verificar se os dados estão no cache.
5. O rótulo de resultados indicará "Acerto" ou "Erro", e a tabela de cache se atualizará para mostrar o estado do cache.

## Observações

O aplicativo introduz um atraso simulado de 100ms no acesso ao cache para demonstrar eventos de hit e miss. O tamanho do cache é configurado com 10 posições de memória para ambos os tipos.

Aproveite a oportunidade de explorar a simulação de cache e visualizar as operações de cache com este aplicativo!

-----------
# Instruções específicas para a Execução do Projeto

# Como Executar o Aplicativo CacheSimulator no IntelliJ IDEA

Para executar o aplicativo `CacheSimulator` no IntelliJ IDEA usando JavaFX, siga estas etapas:

## 1. Configurar o Projeto

Certifique-se de que seu projeto esteja configurado corretamente para usar JavaFX no IntelliJ IDEA. Para fazer isso:

1. Abra o IntelliJ IDEA.
2. Abra o seu projeto existente ou crie um novo projeto.
3. Clique com o botão direito do mouse no diretório `src` em sua estrutura de diretórios do projeto.
4. Selecione "Mark Directory as" e escolha "Sources Root". Isso informará ao IntelliJ que essa pasta contém seu código-fonte.

## 2. Configurar o SDK do JavaFX

Certifique-se de que o SDK do JavaFX esteja configurado no IntelliJ. Se ainda não estiver, siga estas etapas:

1. No IntelliJ IDEA, vá para "File" (Arquivo) -> "Project Structure" (Estrutura do Projeto).
2. Na janela de configurações, no painel esquerdo, clique em "Project" (Projeto).
3. No campo "Project SDK", selecione a versão apropriada do JDK que você está usando.

## 3. Configurar as Opções de Execução

Agora, é hora de configurar as opções de execução para o aplicativo `CacheSimulator`:

1. No IntelliJ IDEA, abra a classe `CacheSimulator` (a classe principal) em seu projeto.
2. Certifique-se de que você tenha uma configuração de execução adequada. Caso contrário, clique com o botão direito do mouse na classe `CacheSimulator` e escolha "Create 'CacheSimulator.main()'" para criar uma configuração de execução.

## 4. Executar o Aplicativo

Depois de configurar as opções de execução, você pode executar o aplicativo:

1. Clique no ícone "Run" (Executar) no canto superior direito do IntelliJ IDEA ou use a combinação de teclas `Shift + F10` para executar o aplicativo.

A janela da interface do usuário do `CacheSimulator` deve aparecer, permitindo que você interaja com o aplicativo e simule operações de cache.

Certifique-se de ter todas as dependências e bibliotecas do JavaFX configuradas corretamente no projeto. Se você encontrar algum miss de execução ou problema, verifique as configurações do projeto e as dependências para garantir que tudo esteja configurado corretamente.

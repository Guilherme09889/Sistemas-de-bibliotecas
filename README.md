# Sistema de Biblioteca — Trabalho prático de Java POO

Trabalho prático da disciplina de **Programação Orientada a Objetos**, referente à
**Atividade 1 — Sistema de biblioteca**, com foco em herança, encapsulamento,
sobrescrita, polimorfismo e uso de listas (`ArrayList`) em Java.

## Integrantes da equipe

- [ Pedro Otávio ] _(nome 1)_
- [ Guilherme Kochhann Reisdorfer] _(nome 2)_
- [ Arthur Gabriel ALves Tomelin] _(nome 3)_
- [ Artur Henrique Gloor D Avila] _(nome 4)_
- [ Júlio Cesar Pancotte] _(nome 5)_
- [ Gabriel Leindorf Ulsenheimer ]

> Preencher com os nomes completos de todos os integrantes do grupo.

## Atividade escolhida e descrição da solução

Foi escolhida a **Atividade 1 — Sistema de biblioteca**. O problema proposto é o
controle de materiais disponíveis para consulta e empréstimo em uma biblioteca,
que inicialmente trabalha com dois tipos de material: **livros** e **revistas**.

Todos os materiais compartilham dados em comum (identificador, título e situação
de disponibilidade), mas cada tipo possui também informações específicas (autor e
número de páginas no livro; número da edição e mês de publicação na revista).

A solução foi modelada com uma superclasse abstrata `Material` e duas subclasses
que a especializam (`Livro` e `Revista`), além de uma classe de serviço
(`SalvarDados`) responsável por manter a coleção de materiais e oferecer as
operações de cadastro, remoção, busca, listagem, empréstimo e devolução. A classe
`Main` demonstra as funcionalidades por meio de um menu interativo no console.

## Instruções para executar o projeto

O projeto é um projeto Java "puro" (sem Maven/Gradle), organizado para o IntelliJ
IDEA (arquivo `Java/Java.iml`), mas pode ser compilado e executado apenas com o
JDK instalado (versão 8 ou superior).

### Opção 1 — Pelo IntelliJ IDEA

1. Abra a pasta `Java` como projeto no IntelliJ IDEA.
2. Aguarde a indexação do projeto (o módulo já está configurado em `Java.iml`).
3. Execute a classe `Main` (botão ▶ ao lado do método `main`).

### Opção 2 — Pela linha de comando (PowerShell)

```powershell
cd Java
javac -d out src\Main.java src\classes\*.java
java -cp out Main
```

Ao iniciar, o programa carrega automaticamente alguns dados de teste (3 livros e
3 revistas) e exibe um menu com as seguintes opções:

```
1 - Cadastrar Livro
2 - Cadastrar Revista
3 - Excluir Material por Id
4 - Listar Materiais
5 - Procurar Material por Título
6 - Procurar Material por Id
7 - Alterar Situação do Material por Id
8 - Emprestar Material por Id
9 - Devolver Material por Id
0 - Sair
```

## Estrutura do projeto

```
Java/
├─ src/
│  ├─ Main.java                # Classe principal (menu de demonstração)
│  └─ classes/
│     ├─ Material.java         # Superclasse abstrata
│     ├─ Livro.java            # Subclasse de Material
│     ├─ Revista.java          # Subclasse de Material
│     ├─ SalvarDados.java      # Classe de serviço (gerencia a lista de materiais)
│     └─ Utils.java            # Métodos utilitários de validação de texto
└─ documents/
   └─ diagrama de classes 02.drawio.png   # Diagrama de classes da solução
```

## Classes criadas e responsabilidades

| Classe | Responsabilidade |
|---|---|
| `Material` | Superclasse **abstrata** que concentra os dados e comportamentos comuns a todo material da biblioteca: identificador (`id`, gerado automaticamente), `titulo` e `situacao` (disponibilidade). Também define as regras de ativar/inativar, emprestar e devolver, válidas para qualquer subtipo. |
| `Livro` | Subclasse de `Material` que acrescenta os atributos específicos `autor` e `numPaginas`, além de reaproveitar (via `super`) toda a estrutura comum da superclasse. |
| `Revista` | Subclasse de `Material` que acrescenta os atributos específicos `numeroEdicao` e `mesPublicacao`. |
| `SalvarDados` | Classe de serviço/gerenciadora. Mantém a coleção `ArrayList<Material>` e expõe as operações de domínio: `salvarMaterial`, `excluirPorId`, `buscarMaterialPorId`, `buscarMaterialPorTitulo` e `listarMateriais`, além de `carregarDadosTeste` para popular a lista com dados de exemplo. |
| `Utils` | Classe utilitária com métodos estáticos de apoio (`validarString` e `padronizarString`) usados para validar e padronizar textos digitados pelo usuário. |
| `Main` | Classe de entrada da aplicação. Apresenta um menu no console que permite exercitar todas as funcionalidades implementadas (cadastro, busca, listagem, empréstimo, devolução e remoção de materiais). |

## Onde foram utilizados herança, sobrescrita e lista

**Herança**
- `Livro` e `Revista` **herdam** de `Material` (`extends Material`), reaproveitando
  os atributos `id`, `titulo` e `situacao` e os métodos `ativar()`, `inativar()`,
  `emprestar()` e `devolver()` definidos na superclasse, sem repeti-los nas
  subclasses — cada subclasse só acrescenta os campos que realmente são
  específicos do seu tipo (ver `Material.java`, `Livro.java` e `Revista.java`).

**Sobrescrita (`@Override`)**
- Tanto `Livro` quanto `Revista` sobrescrevem o método `toString()` herdado de
  `Material`, complementando a representação textual da superclasse
  (`super.toString()`) com os dados específicos de cada subtipo. Isso garante que
  `listarMateriais()` exiba, para cada objeto da lista, as informações corretas
  de acordo com o seu tipo real em tempo de execução (**polimorfismo**).

**Lista (`ArrayList`)**
- A classe `SalvarDados` mantém um único `ArrayList<Material>`, capaz de
  armazenar, ao mesmo tempo, objetos `Livro` e `Revista` — isso só é possível
  porque ambos são subtipos de `Material` (princípio de substituição de tipos).
  É sobre essa lista que ocorrem as operações de inclusão (`salvarMaterial`),
  remoção (`excluirPorId`), busca (`buscarMaterialPorId` /
  `buscarMaterialPorTitulo`) e listagem (`listarMateriais`), todas percorrendo a
  coleção com `for-each`.

**Encapsulamento e validações**
- Os atributos de todas as classes são `private`. A alteração de estado do
  `Material` (disponível/indisponível) não é feita por um *setter* público, mas
  sim pelas operações de domínio `ativar()`, `inativar()`, `emprestar()` e
  `devolver()`, que também validam a situação atual antes de permitir a
  mudança (por exemplo, impedindo o empréstimo de um material já indisponível).
- `SalvarDados.salvarMaterial` valida campos obrigatórios conforme o tipo do
  material (usando `instanceof`) e impede o cadastro de títulos duplicados.

## Relatório sobre o uso de listas em Java

1. **O que é um `ArrayList`?**
   É uma implementação da interface `List` do Java Collections Framework que
   representa um vetor de tamanho dinâmico. Ao contrário de um vetor comum, o
   `ArrayList` cresce e encolhe automaticamente conforme elementos são
   adicionados ou removidos, sem que o programador precise gerenciar esse
   redimensionamento manualmente.

2. **Diferença entre um vetor (array) e um `ArrayList`:**
   Um vetor tem tamanho fixo definido na criação e não pode ser alterado depois;
   para "crescer" é preciso criar um novo vetor e copiar os elementos. Um
   `ArrayList` já faz esse trabalho internamente, oferece métodos prontos
   (`add`, `remove`, `get`, `size`, `contains`, etc.) e só pode armazenar
   objetos (tipos primitivos são automaticamente convertidos via *autoboxing*,
   ex.: `int` → `Integer`).

3. **Como adicionar e remover elementos:**
   Adiciona-se com `lista.add(objeto)` (insere no final) ou
   `lista.add(indice, objeto)` (insere em uma posição específica). Remove-se
   com `lista.remove(objeto)` (remove a primeira ocorrência igual ao objeto,
   usando `equals`) ou `lista.remove(indice)` (remove pela posição). No projeto,
   isso é usado em `SalvarDados.salvarMaterial` (`materiais.add(material)`) e em
   `SalvarDados.excluirPorId` (`materiais.remove(m)`).

4. **Como percorrer a lista com `for` e `for-each`:**
   Com `for` tradicional, percorre-se pelo índice:
   `for (int i = 0; i < lista.size(); i++) { lista.get(i); }`.
   Com `for-each`, percorre-se diretamente pelos elementos, sem precisar de
   índice: `for (Material m : lista) { ... }` — forma usada em todo o projeto
   (por exemplo em `listarMateriais()`), por ser mais simples e menos propensa a
   erros de índice.

5. **Como verificar o tamanho da lista:**
   Com o método `size()`, que retorna a quantidade atual de elementos
   armazenados (diferente do vetor, que usa o atributo `length`).

6. **Como buscar um objeto por código ou identificador:**
   Percorre-se a lista (geralmente com `for-each`) comparando o identificador de
   cada elemento com o valor procurado, retornando o objeto assim que
   encontrado. É exatamente o que fazem `buscarMaterialPorId` e
   `buscarMaterialPorTitulo` em `SalvarDados.java`.

7. **O que ocorre ao tentar acessar uma posição inexistente:**
   O `ArrayList` lança uma exceção em tempo de execução,
   `IndexOutOfBoundsException`, quando se chama `get(indice)` com um índice
   menor que zero ou maior/igual a `size()`. Por isso, no projeto, prefere-se
   buscar por valor (id/título) em vez de acessar posições fixas, e os métodos
   de busca retornam `null` quando o item não é encontrado, em vez de lançar
   essa exceção.

8. **Por que uma lista da superclasse pode armazenar objetos de subclasses
   diferentes:**
   Por causa do **polimorfismo** e do princípio de substituição: como `Livro` e
   `Revista` são subtipos de `Material` (`extends Material`), qualquer objeto
   desses tipos *é também* um `Material`. Assim, uma lista declarada como
   `ArrayList<Material>` pode guardar, na mesma coleção, instâncias de `Livro` e
   de `Revista` simultaneamente. Ao percorrer a lista e chamar métodos
   sobrescritos (como `toString()`), o Java executa em tempo de execução a
   versão específica do método definida em cada subclasse (*dynamic binding*).

## Dificuldades encontradas e fontes pesquisadas

**Dificuldades encontradas**
- Definir como representar, de forma única, todos os tipos de material em uma
  mesma coleção sem duplicar código — resolvido migrando para uma única
  `ArrayList<Material>` compartilhada entre os subtipos, usando herança e
  polimorfismo em vez de listas separadas para livros e revistas.
- Controlar corretamente o estado de disponibilidade do material, evitando que
  um material já emprestado fosse emprestado novamente ou que um material
  disponível fosse devolvido sem nunca ter sido emprestado — tratado com
  validações dentro dos próprios métodos `ativar()`, `inativar()`,
  `emprestar()` e `devolver()`.
- Garantir que não fossem cadastrados materiais com dados essenciais ausentes
  ou títulos repetidos, exigindo validação específica por subtipo com
  `instanceof` dentro da classe de serviço.

**Fontes pesquisadas**
- Documentação oficial da Oracle — [Classe `ArrayList` (Java SE)](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)
- Documentação oficial da Oracle — [Interface `List` (Java Collections Framework)](https://docs.oracle.com/javase/tutorial/collections/interfaces/list.html)
- Documentação oficial da Oracle — [Tutorial de herança em Java](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html)
- Documentação oficial da Oracle — [Polimorfismo em Java](https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html)

## Diagrama de classes

O diagrama de classes da solução está disponível em:
[`Java/documents/diagrama de classes 02.drawio.png`](<./Java/documents/diagrama de classes 02.drawio.png>)

Ele representa a superclasse abstrata `Material`, as subclasses `Livro` e
`Revista`, e a classe de gerenciamento `Biblioteca`/`SalvarDados`, incluindo a
relação de agregação com multiplicidade `1` para `0..*` entre a classe de
serviço e os materiais.

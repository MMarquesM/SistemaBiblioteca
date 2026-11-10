# Sistema de Gerenciamento de Biblioteca

Projeto em Java para cadastrar, listar, buscar, emprestar e devolver livros.

## Organização
- `interfaces`: interface `Emprestavel`
- `model`: classe `Livro`
- `service`: regras da biblioteca e exceção personalizada
- `app`: menu interativo (`Main`)

## Requisitos
- Java JDK 17 ou superior.

## Como executar
Na pasta `SistemaBiblioteca`, compile:

```bash
javac -d out src/interfaces/Emprestavel.java src/model/Livro.java src/service/LivroNaoEncontradoException.java src/service/BibliotecaService.java src/app/Main.java
```

Depois execute:

```bash
java -cp out app.Main
```

O programa inicia com três livros cadastrados para facilitar a demonstração dos testes obrigatórios.

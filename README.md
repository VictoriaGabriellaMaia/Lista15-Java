# Lista15-Java

# Padrão de Projeto – Builder (Criação)

## 1. Análise e Referência

Analise os exemplos disponíveis no repositório abaixo:

[05-java-padrao-de-projeto-criacao-builder – GitHub](https://github.com/wdiasmaciel/05-java-padrao-de-projeto-criacao-builder)

## 2. Exercício 1 – Implementação do Builder

Uma empresa de e-commerce precisa de um módulo para gerenciar o cadastro de produtos.

Crie uma classe `Produto` com os seguintes atributos:

| Atributo | Tipo |
|---|---|
| id | Long |
| nome | String |
| descricao | String |
| preco | Double |
| categoria | String |

Implemente o padrão de projeto **Builder** para essa classe, seguindo as regras:

- **a)** A classe `Produto` deve ser imutável, utilizando atributos `final` e sem métodos setters.
- **b)** O construtor de `Produto` deve ser privado.
- **c)** Crie uma classe `Main` para instanciar um produto completo e outro parcial (apenas com id e nome), utilizando a estrutura fluente do Builder.

## 3. Exercício 2 – Implementação do Director

Aproveitando a estrutura do padrão Builder criada no Exercício 1, o sistema de e-commerce precisa automatizar a criação de dois perfis de produtos comuns, agilizando o cadastro do estoque.

Implemente uma classe `ProdutoDirector` que possua dois métodos:

**a) `construirLivroPadrao(Produto.Builder builder)`**

Define os campos para um livro genérico:

- Categoria: `"Livros"`;
- Preço: `39.90`;
- Descrição: `"Obra literária física"`.

**b) `construirEbookGratuito(Produto.Builder builder)`**

Define os campos para um livro digital gratuito:

- Categoria: `"E-books"`;
- Preço: `0.0`;
- Descrição: `"Download digital gratuito"`.

Na classe `Main`, utilize o Director para instanciar ambos os produtos e demonstre que, após a atuação do Director, o cliente ainda pode utilizar o Builder para definir o id e o nome específico de cada produto antes de chamar o método `.build()`.

## 4. Exercício 3 – Validação de Regras de Negócio

Para evitar erros no banco de dados do e-commerce, o método `build()` da classe `Produto.Builder` deve validar as regras de negócio antes de entregar o objeto pronto.

Modifique o método `build()` para lançar exceções (`IllegalArgumentException` ou `IllegalStateException`) caso alguma das seguintes regras seja violada:

- **a) Id e nome obrigatórios:** não podem ser nulos ou vazios.
- **b) Preço válido:** se informado, o preço não pode ser negativo.
- **c) Validação cruzada:** se a categoria for `"E-books"`, o preço deve ser obrigatoriamente igual a `0.0`.

Na classe `Main`, crie blocos `try-catch` para testar cada uma das três validações e comprovar que o sistema impede a criação de produtos inválidos.

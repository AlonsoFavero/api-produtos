# API de Produtos

API REST desenvolvida com **Java e Spring Boot** para gerenciamento de produtos, aplicando conceitos de desenvolvimento backend, persistência de dados, validação, paginação, filtros, DTOs, tratamento de exceções e testes automatizados.

## 🚀 Tecnologias

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* H2 Database
* Bean Validation
* Maven
* JUnit
* MockMvc

## 📋 Funcionalidades

* Cadastro de produtos
* Listagem de produtos
* Busca de produto por ID
* Atualização de produtos
* Exclusão de produtos
* Paginação
* Filtro de produtos por nome
* Filtro de produtos por faixa de preço
* Validação dos dados recebidos
* Tratamento global de exceções
* Exceção personalizada para produto não encontrado
* Testes automatizados dos endpoints

## 🏗️ Estrutura do projeto

```text
src/
├── main/
│   └── java/
│       └── com/alonso/api_produtos/
│           ├── controller/
│           ├── dto/
│           ├── exception/
│           ├── model/
│           ├── repository/
│           └── service/
│
└── test/
    └── java/
        └── com/alonso/api_produtos/
            └── controller/
```

### Organização das camadas

**Controller**
Responsável por receber as requisições HTTP e retornar as respostas da API.

**Service**
Contém as regras de negócio e faz a comunicação entre Controller e Repository.

**Repository**
Responsável pelo acesso e persistência dos dados utilizando Spring Data JPA.

**Model**
Representa a entidade `Produto` persistida no banco de dados.

**DTO**
Define os objetos utilizados para entrada e saída de dados da API.

**Exception**
Centraliza o tratamento de exceções e respostas de erro.

## 🔗 Endpoints

| Método   | Endpoint                 | Descrição                          |
| -------- | ------------------------ | ---------------------------------- |
| `POST`   | `/produtos`              | Cadastra um produto                |
| `GET`    | `/produtos`              | Lista produtos                     |
| `GET`    | `/produtos/{id}`         | Busca produto por ID               |
| `PUT`    | `/produtos/{id}`         | Atualiza um produto                |
| `DELETE` | `/produtos/{id}`         | Exclui um produto                  |
| `GET`    | `/produtos/filtro-preco` | Filtra produtos por faixa de preço |

### Filtro por nome

```text
GET /produtos?nome=mouse&page=0&size=10
```

O filtro por nome não diferencia letras maiúsculas e minúsculas.

### Filtro por preço

```text
GET /produtos/filtro-preco?precoMin=50&precoMax=200&page=0&size=10
```

O filtro considera produtos cujo preço esteja entre os valores mínimo e máximo informados.

## ▶️ Como executar

### Pré-requisitos

* Java 17 ou superior
* Git

### Executando o projeto

Clone o repositório e acesse a pasta do projeto:

```bash
git clone https://github.com/AlonsoFavero/api-produtos.git
cd api-produtos
```

Execute a aplicação com o Maven Wrapper:

```bash
./mvnw spring-boot:run
```

A API estará disponível em:

```text
http://localhost:8080
```

## 🧪 Executando os testes

Para executar a suíte de testes:

```bash
./mvnw test
```

Os testes utilizam **JUnit, Spring Boot Test e MockMvc** para validar os principais comportamentos da API.

## 🗄️ Banco de dados

O projeto utiliza o **H2 Database** em memória para persistência durante a execução da aplicação.

Por utilizar um banco em memória, os dados são reiniciados quando a aplicação é encerrada.

## 📌 Conceitos aplicados

Durante o desenvolvimento deste projeto foram aplicados conceitos importantes de desenvolvimento backend com Java e Spring Boot:

* Arquitetura em camadas
* API REST
* Injeção de dependências
* Spring Data JPA
* ORM com Hibernate
* CRUD
* DTOs
* Bean Validation
* Paginação
* Derived Query Methods
* Tratamento global de exceções
* Exceções personalizadas
* Testes de integração dos endpoints
* Git e GitHub

## 👨‍💻 Autor

**Alonso Favero Filho**

Estudante de Análise e Desenvolvimento de Sistemas e desenvolvedor Backend Java em formação.

* GitHub: [AlonsoFavero](https://github.com/AlonsoFavero)
* LinkedIn: [Alonso Favero](https://www.linkedin.com/in/alonso-favero-filho-00a7163aa/)

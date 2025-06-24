# 🛠️ Projeto Base: API RESTful com CRUD Completo

Este projeto consiste na construção de uma API RESTful utilizando **Java com Spring Boot**, **JPA** e **PostgreSQL** (PgAdmin). Ele implementa as operações completas de **CRUD (Create, Read, Update, Delete)**
em uma estrutura **MVC**, além de aplicar o padrão **DTO** para transferência de dados entre as camadas e utilizar a biblioteca **ModelMapper** para facilitar o mapeamento entre entidades e DTOs.

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL / PgAdmin
- ModelMapper
- Maven

---

## ⚙️ Como executar o projeto

1. Instale o PostgreSQL e crie um banco de dados com o nome `mercadinho`.
2. Configure o arquivo `application.properties` com os dados da sua conexão:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/mercadinho
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update


  #Teste de rotas
  POST: http://localhost:8080/api/produtos
  Body/JSON:
  {
    "nome":"Sonho de pistache",
    "quantidade": 50,
    "valor": 2.00,
    "observacao": "entrega-pago"
}
GET: http://localhost:8080/api/produtos ou http://localhost:8080/api/produtos/id
PUT: http://localhost:8080/api/produtos/id
Body/JSON:
  {
    "nome":"Sonho de creme",
    "quantidade": 50,
    "valor": 2.00,
    "observacao": "entrega-pago"}

  DELETE: http://localhost:8080/api/produtos/id


  ## ✍️ Autor

<div align="left">

**Felipe Rocha**  
<a href="https://www.linkedin.com/in/fvalboeno/" target="_blank">
  <img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" />
</a>  
<a href="mailto:felipevalboeno@hotmail.com">
  <img src="https://img.shields.io/badge/-felipevalboeno@hotmail.com-blue?style=for-the-badge&logo=gmail&logoColor=white" />
</a>

</div>

## 📦 Estrutura de Classes Java

```text
├── projetovs/
    └── ProjetovsApplication.java
    ├── handler/
        └── RestExceptionHandler.java
    ├── model/
        └── Produto.java
        ├── errorhandling/
            └── ErrorMessage.java
        ├── exception/
            └── ResourceNotFoundException.java
    ├── repository/
        └── ProdutoRepository.java
        └── ProdutoRepository_old.java
    ├── services/
        └── ProdutoService.java
        └── ProdutoService_OLD.java
    ├── shared/
        └── ProdutoDTO.java
    ├── view/
        ├── controller/
            └── ProdutoController.java
        ├── model/
            └── ProdutoRequest.java
            └── ProdutoResponse.java
├── projetovs/
    └── ProjetovsApplicationTests.java

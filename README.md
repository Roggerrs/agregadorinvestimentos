# 🚀 Microserviço de Gestão de Usuários com Spring Boot e Java

Este projeto é uma API REST desenvolvida com Java 17 e Spring Boot que oferece um CRUD completo para gestão de usuários. Ele foi construído com foco em boas práticas de arquitetura, testes unitários e documentação de endpoints.

## ✅ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot** (Web, Data JPA)
- **MySQL** (em contêiner via Docker Compose)
- **JUnit 5 + Mockito** (para testes unitários)
- **DBeaver** (inspeção e modelagem de dados)
- **Postman** (testes manuais de endpoints)
## 📌 Funcionalidades da API

* **POST /users** – Criar novo usuário
* **GET /users/{id}** – Buscar usuário por ID
* **GET /users** – Listar todos os usuários
* **PUT /users/{id}** – Atualizar usuário existente
* **DELETE /users/{id}** – Remover usuário

## ✅ Testes Unitários

A aplicação possui cobertura de testes nas seguintes operações principais:

* **CreateUserServiceTest**
* **FindUserByIdServiceTest**
* **ListUsersServiceTest**
* **DeleteUserServiceTest**

Os testes foram desenvolvidos com:

* `JUnit 5` para estrutura de testes
* `Mockito` para mock de dependências
* `@SpringBootTest` e `@WebMvcTest` (quando aplicável)

## 🐳 Banco de Dados com Docker

Para iniciar o banco localmente:

```bash
docker-compose up -d
```

Credenciais configuradas no `application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/db_users
    username: root
    password: root
```

## 🔎 Testes com Postman

Todos os endpoints foram testados manualmente e validados com o Postman. A coleção pode ser exportada futuramente neste repositório.

## 📂 Clonando o Projeto

```bash
git clone https://github.com/Roggerrs/agregadorinvestimentos.git
cd agregadorinvestimentos
./mvnw spring-boot:run
```

## 🏁 Como Executar os Testes

```bash
./mvnw test
```

---

## 🧠 Autor

Desenvolvido por **[Eduardo Zero](https://github.com/Roggerrs)**

📌 Projeto para estudos e demonstração de:

* Boas práticas em Java + Spring Boot
* Testes unitários com JUnit e Mockito
* Uso de Docker para serviços de apoio (MySQL)

---

## 📢 Tags

`#java` `#springboot` `#microservices` `#docker` `#mysql` `#tdd`

---
## 📄 Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

## ✍️ Autor
<table align="center">
<tr>
<td align="center">
<a href="https://github.com/Roggerrs">
<img src="https://avatars.githubusercontent.com/u/177704919?v=4" width="150px;" alt="Roggerrs image" />
<br />
<sub><b>Roggerrs</b></sub>
</a>
</td>
</tr>
</table>

<h4 align="center">
By<a href="https://github.com/Roggerrs" target="_blank"> Roggerrs </a>✍️

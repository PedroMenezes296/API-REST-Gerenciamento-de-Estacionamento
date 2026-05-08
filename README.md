# 🅿️ Demo Park API

API REST para gerenciamento de usuários de um sistema de estacionamento, desenvolvida com Java e Spring Boot seguindo boas práticas de arquitetura em camadas, padrão DTO e validação de dados.

---

## 🚀 Tecnologias Utilizadas

- **Java 21+**
- **Spring Boot**
- **Spring Data JPA / Hibernate**
- **MySQL**
- **Bean Validation**
- **DTO Pattern** (MapStruct / Mapper manual)
- **Maven**
- **Postman** (testes de requisição)

---

## 🏗️ Arquitetura do Projeto

```
src/main/java/com/mballem/demo_park_api/
├── config/              → Configurações da aplicação
├── entity/              → Entidades JPA (Usuario)
├── repository/          → Repositórios Spring Data JPA
├── service/             → Regras de negócio
├── web/
│   ├── controller/      → Controllers REST
│   └── dto/
│       ├── mapper/      → Mapeamento entre entidades e DTOs
│       ├── UsuarioCreateDto.java
│       ├── UsuarioResponseDto.java
│       └── UsuarioSenhaDto.java
└── DemoParkApiApplication.java
```

---

## 📋 Endpoints Disponíveis

### Usuários

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/usuarios` | Criar novo usuário |
| `GET` | `/usuarios/{id}` | Buscar usuário por ID |
| `GET` | `/usuarios` | Listar todos os usuários |
| `PATCH` | `/usuarios/{id}/senha` | Atualizar senha do usuário |

---

## ⚙️ Como Rodar o Projeto

### Pré-requisitos

- Java 21+
- Maven
- MySQL rodando localmente

### 1. Clone o repositório

```bash
git clone https://github.com/PedroMenezes296/demo-park-api.git
cd demo-park-api
```

### 2. Configure o banco de dados

No arquivo `src/main/resources/application.properties`, ajuste as credenciais do MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/demo_park
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

Crie o banco de dados no MySQL antes de rodar:

```sql
CREATE DATABASE demo_park;
```

### 3. Rode o projeto

**Pelo Maven:**
```bash
mvn spring-boot:run
```

**Pela classe principal:**

Execute a classe `DemoParkApiApplication.java` diretamente pela sua IDE (IntelliJ, Eclipse, VS Code).

A API estará disponível em: `http://localhost:8080`

---

## 🧪 Testando com Postman

Importe as requisições no Postman e teste os endpoints disponíveis. Exemplo de body para criação de usuário:

```json
{
  "username": "pedro@email.com",
  "password": "123456"
}
```

---

## 📌 Status do Projeto

🚧 **Em andamento** — novas funcionalidades sendo desenvolvidas, como gerenciamento de vagas, veículos e controle de entrada/saída.

---

## 👨‍💻 Autor

**Pedro Barañano Menezes**  
[GitHub](https://github.com/PedroMenezes296) • [LinkedIn](https://linkedin.com/in/pedro-baranano-menezes296)
